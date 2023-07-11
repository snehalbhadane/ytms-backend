package com.yash.ytms.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * this will filter out the every coming request from client side.
 * @author dheerendra.kag
 *
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	/**
	 * will inject the userDetailService dependency.
	 */
	@Autowired
	MyUserDetailService userDetailService;

	@Autowired
	JwtUtil jwtUtil;

	/**
	 * will check the authenticate token for each request.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			final String authorizationHeader = request.getHeader("Authorization");
			System.out.println("authorizationHeader"+authorizationHeader);
			String username = null;
			String jwt = null;
			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				jwt = authorizationHeader.substring(7);
				username = jwtUtil.extractUsername(jwt);
			}
			System.out.println("inside jwtRequestFilter username" + username);
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
	
				if (jwtUtil.checkToken(jwt, userDetails)) {
					System.out.println("inside checkToken userDetails" + userDetails);
	
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					System.out.println(usernamePasswordAuthenticationToken.toString());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					
				}
			}
			filterChain.doFilter(request, response);
		} catch (ExpiredJwtException e) {
            System.out.println(e.getMessage());
	    }
	}

}

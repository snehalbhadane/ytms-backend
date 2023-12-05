package com.yash.ytms.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	
	private ApiKey apiKeys() {
		
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}
	
	private List<SecurityContext> securityContext(){
		
	
		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
	}
	
	
	private List<SecurityReference> sf(){
		
		AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] {scope}));
	}

	@Bean
	public Docket apis() {
		
	
		
		return new Docket(DocumentationType.SWAGGER_2)
				.securityContexts(securityContext())
				.securitySchemes(Arrays.asList(apiKeys()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.yash.ytms")).build();
	}
	
//	http://localhost:8080/swagger-ui.html
}
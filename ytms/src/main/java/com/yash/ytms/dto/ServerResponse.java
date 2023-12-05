package com.yash.ytms.dto;

import com.yash.ytms.model.User;

/**
 * hold the generated server response.
 * @author dheerendra.kag
 *
 */
public class ServerResponse {
	private String status;
    private String message;
    private User user;
    private String authToken;
    
	public ServerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServerResponse(String status, String message, User user, String authToken) {
		super();
		this.status = status;
		this.message = message;
		this.user = user;
		this.authToken = authToken;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	@Override
	public String toString() {
		return "ServerResponse [status=" + status + ", message=" + message + ", user=" + user + ", authToken="
				+ authToken + "]";
	}

}

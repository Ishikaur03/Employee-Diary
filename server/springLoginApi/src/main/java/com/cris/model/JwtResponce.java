package com.cris.model;


public class JwtResponce {
	

	private String username;
	private String token;


	@Override
	public String toString() {
		return "JwtResponce [  token=" + token + " ]";
	}

	public JwtResponce(String token,String username) {
		super();
		
		this.username= username;
		this.token = token;
	}

	public JwtResponce() {
		super();
	}

	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
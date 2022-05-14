package com.cris.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS_ANGULAR")
public class User {
    
    
  
    
    @Column(name = "USERNAME")
    @Id
  
    private String username;
  
    @Column(name = "PASSWORD")
    private String password;
  
   
   
    
  
    public User() {
    }

    
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}


	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


    
    
    //constructor, setters and getters omitted for brevity
}

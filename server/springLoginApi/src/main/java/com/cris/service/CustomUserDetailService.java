package com.cris.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cris.repository.UserRepository;


@Service

public class CustomUserDetailService  implements UserDetailsService{

	
	@Autowired(required = true)
	  UserRepository userRepository;
	
	public List<com.cris.model.User> getAllUsers() {
        return this.userRepository.findAll();
    }
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		com.cris.model.User user=getUserDetails(userName);
		
		if(userName.equals(user.getUsername())) {
		   
		 return new User(user.getUsername(),user.getPassword(), new ArrayList<>());
		 
		}else {
			throw new UsernameNotFoundException("User Name Not found..?");
		}
		
	}
	public com.cris.model.User getUserDetails(String username) {
		
		   Optional<com.cris.model.User> user=	userRepository.findById(username);
		 
		   com.cris.model.User u=null;
		    if(user!=null) {
		    	
		    	u=user.get();
		    	
		    	System.out.println("USER IN CustomUserDetail"+user.toString());
		    	
		    }
		    
			return u;
		}
	}

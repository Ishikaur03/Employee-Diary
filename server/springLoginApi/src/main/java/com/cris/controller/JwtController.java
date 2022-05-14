package com.cris.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cris.helper.JwtUtil;
import com.cris.model.JwtRequest;
import com.cris.model.JwtResponce;

import com.cris.service.CustomUserDetailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@ResponseBody
public class JwtController {

	
	 
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailService customuserdetailsservice;

	@Autowired
	private JwtUtil jwtutil;


	
	@RequestMapping(value="/login",method =RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest ) throws Exception{
        
		
		System.out.println(jwtRequest.toString());
		try {
          
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));	
		
		}
		catch(UsernameNotFoundException user) {
			user.printStackTrace();
			throw new Exception("Invalid Username!!");
		}
		catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credential Exception");
		}

		//fine are go a head
		UserDetails userDetails	=this.customuserdetailsservice.loadUserByUsername(jwtRequest.getUsername());
		
         String token=this.jwtutil.generateToken(userDetails);
         String username =this.jwtutil.extractUsername(token);
         
         
         System.out.println("token:"+token);
         
		return ResponseEntity.ok(new JwtResponce(token,username));
	}
	
	
	
}
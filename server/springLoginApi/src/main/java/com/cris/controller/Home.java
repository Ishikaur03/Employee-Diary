package com.cris.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cris.model.User;
import com.cris.service.CustomUserDetailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Home {

	
	 @Autowired
	 CustomUserDetailService userService;
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


}
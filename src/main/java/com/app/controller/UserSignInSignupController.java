package com.app.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.Signup;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins =  "http://localhost:5173")
public class UserSignInSignupController {
	
	@Autowired
	private UserService userService; 
	
	@PostMapping("/register")
	public ResponseEntity<?> userSignup(@RequestPart("dto") @Valid Signup dto,@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("in sign up " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.userRegistration(dto, file));
	}
}

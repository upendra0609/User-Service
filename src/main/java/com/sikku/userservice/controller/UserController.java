package com.sikku.userservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sikku.userservice.model.User;
import com.sikku.userservice.services.IUserService;
import com.sikku.userservice.services.impl.JwtServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

	private final JwtServiceImpl jwtService;
	private final IUserService userService;

	@GetMapping("/profile")
	public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String jwtToken) {
		jwtToken = jwtToken.split(" ")[1].trim();
		String userName = jwtService.extractUserName(jwtToken);		
		return ResponseEntity.ok(userService.loadUserByUsername(userName));
	}
	
//	@GetMapping("/all")
//	public ResponseEntity<List<User>> getAllUsers() {
//		return ResponseEntity.ok(userService.getAllUsers());
//	}

}

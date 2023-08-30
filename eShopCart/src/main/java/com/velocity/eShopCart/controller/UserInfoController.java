package com.velocity.eShopCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velocity.eShopCart.model.AuthRequest;
import com.velocity.eShopCart.model.UserInfo;
import com.velocity.eShopCart.service.impl.JwtServiceImpl;
import com.velocity.eShopCart.service.impl.UserInfoServiceImpl;

@RestController
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoServiceImpl userInfoService;

	@Autowired
	private JwtServiceImpl jwtServiceImpl;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/add")
	public ResponseEntity<UserInfo> addUser(@RequestBody UserInfo user) {
		// TODO Auto-generated method stub
		UserInfo savedUser = this.userInfoService.addUser(user);

		return ResponseEntity.ok().body(savedUser);
	}

	@PutMapping("/modify")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<UserInfo> modifyUser(@RequestBody UserInfo user, Double id) {

		UserInfo modifiedUser = this.userInfoService.modifyUser(user);
		return ResponseEntity.ok().body(modifiedUser);
	}

	
	@GetMapping("/getById/{uid}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<UserInfo> getById(@PathVariable Long uid) {

		UserInfo user = this.userInfoService.getById(uid);
		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/getAll")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<UserInfo>> getAllUser() {

		List<UserInfo> allUsers = this.userInfoService.getAll();
		return ResponseEntity.ok().body(allUsers);
	}

	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String deletById(@PathVariable Long id) {
		this.userInfoService.deleteById(id);
		return "User deleted";
	}

	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest request) {
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		if (authenticate.isAuthenticated()) {
			return this.jwtServiceImpl.generateToken(request.getUsername());
		}

		else {
			throw new UsernameNotFoundException("User Not Found");
		}
	}

}
//code
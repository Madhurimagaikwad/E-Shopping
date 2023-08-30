package com.velocity.eShopCart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.velocity.eShopCart.model.UserInfo;
import com.velocity.eShopCart.repository.UserInfoRepository;
import com.velocity.eShopCart.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserInfo addUser(UserInfo user) {
		// TODO Auto-generated method stub
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		UserInfo savedUser = this.userInfoRepository.save(user);
		
		return savedUser;
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public UserInfo modifyUser(UserInfo user) {
		
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		UserInfo retriveduser=(UserInfo)this.userInfoRepository.getById((double) user.getId());
		
		retriveduser.setUsername(user.getUsername());
		retriveduser.setLastName(user.getFirstName());
		retriveduser.setLastName(user.getLastName());
		retriveduser.setCity(user.getCity());
		retriveduser.setMobile(user.getMobile());
		retriveduser.setRole(user.getRole());
		retriveduser.setPassword(passwordEncoder.encode(user.getPassword()));
		this.userInfoRepository.save(retriveduser);
		return retriveduser;
	
	}



	@Override
	public List<UserInfo> getAll() {

		List<UserInfo> allUsers = this.userInfoRepository.findAll();
		return allUsers;
	}


	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		this.userInfoRepository.deleteById((double) id);
		
	}


	@Override
	public UserInfo getById(long id) {
		// TODO Auto-generated method stub
		return this.userInfoRepository.getById((double) id);
	}
	
}

//code

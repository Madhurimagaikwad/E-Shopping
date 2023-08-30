package com.velocity.eShopCart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.velocity.eShopCart.model.UserInfo;
import com.velocity.eShopCart.repository.UserInfoRepository;
import com.velocity.eShopCart.service.UserInfoUserDetails;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 Optional<UserInfo> userInfo = userInfoRepository.findByUsername(username);
		 
		 return userInfo.map(UserInfoUserDetails::new)
		 		 .orElseThrow(()->new UsernameNotFoundException("User Not Found"));		
		 
		 
	}

}

package com.velocity.eShopCart.service;

import java.util.List;


import com.velocity.eShopCart.model.UserInfo;

public interface UserInfoService {

	public UserInfo addUser(UserInfo user);
	public UserInfo modifyUser(UserInfo user);
	public List<UserInfo> getAll();
	public void deleteById(long id);
	public UserInfo getById(long id);

}
//code
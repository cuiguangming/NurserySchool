package com.nursery.service;

import com.nursery.bean.User;

public interface UserService {

	public User getUserInfo(Integer id);

	/**
	 * 获取用户信息
	 * 
	 * @param phoneNo
	 * @return
	 */
	public User getUserByPhoneNo(String phoneNo);

	/**
	 * 注册账号
	 * 
	 * @param userInfo
	 * @return
	 */
	public boolean saveUserInfo(User userInfo);

}

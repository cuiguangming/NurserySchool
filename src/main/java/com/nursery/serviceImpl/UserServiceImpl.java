package com.nursery.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery.bean.User;
import com.nursery.common.util.PswdUtil;
import com.nursery.dao.UserDao;
import com.nursery.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public User getUserInfo(Integer id) {
		//
		return userDao.selectById(id);
	}

	public User getUserByPhoneNo(String phoneNo) {
		//
		return userDao.getUserByPhoneNo(phoneNo);
	}

	public boolean saveUserInfo(User userInfo) {
		String pswd = userInfo.getPswd();
		// 生成密码盐
		String generateSaltStr = PswdUtil.generateSaltStr();
		// 生成密码
		String generatePswdStr = PswdUtil.generatePswdStr(pswd, generateSaltStr);
		//
		if (userInfo.getNickName() == null) {
			userInfo.setNickName(userInfo.getName());
		}
		userInfo.setSalt(generateSaltStr);
		userInfo.setPswd(generatePswdStr);
		//
		userInfo.setFailTimes(0);
		userInfo.setLocked(false);
		//
		return userDao.saveUserInfo(userInfo) > 0;
	}

}

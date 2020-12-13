package com.nursery.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nursery.bean.User;
import com.nursery.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	UserMapper userMapper;

	public User selectById(Integer id) {
		//
		User selectById = userMapper.selectById(id);
		return selectById;
	}

	public User getUserByPhoneNo(String phoneNo) {
		//
		return userMapper.selectByPhoneNo(phoneNo);
	}

	public int saveUserInfo(User userInfo) {
		//
		return userMapper.insert(userInfo);
	}

}

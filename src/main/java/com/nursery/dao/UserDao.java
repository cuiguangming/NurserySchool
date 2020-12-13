package com.nursery.dao;

import org.springframework.stereotype.Repository;

import com.nursery.bean.User;

@Repository
public interface UserDao {

	User selectById(Integer id);

	User getUserByPhoneNo(String phoneNo);

	int saveUserInfo(User userInfo);
}

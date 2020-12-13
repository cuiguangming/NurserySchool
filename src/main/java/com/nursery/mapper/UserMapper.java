package com.nursery.mapper;

import org.apache.ibatis.annotations.Param;

import com.nursery.bean.User;

public interface UserMapper {

	User selectById(@Param("id") Integer id);

	User selectByPhoneNo(@Param("phoneNo") String phoneNo);

	int insert(User userInfo);
}

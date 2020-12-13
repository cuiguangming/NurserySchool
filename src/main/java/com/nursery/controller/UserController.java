package com.nursery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nursery.bean.User;
import com.nursery.common.model.Result;
import com.nursery.common.model.Result.Type;
import com.nursery.common.util.PswdUtil;
import com.nursery.service.UserService;

@Controller
@ResponseBody
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	UserService userService;

	// =================================================

	@RequestMapping(value = "/login/do", method = RequestMethod.POST)
	public Result<String> userLoginDo(@RequestBody User userInfo) {
		Result<String> result = new Result<String>();
		User dbUserInfo = userService.getUserByPhoneNo(userInfo.getPhoneNo());
		if (dbUserInfo != null) {
			String pswd = userInfo.getPswd();
			String generatePswdStr = PswdUtil.generatePswdStr(pswd, dbUserInfo.getSalt());
			//
			if (generatePswdStr.equals(dbUserInfo.getPswd())) {
				// TODO 登录成功， 缓存用户上下文信息
				
				result.data = "api/index/home";
			} else {
				// 登录失败
				result.type = Type.warn;
				result.message = "密码错误！";
			}
		} else {
			result.type = Type.warn;
			result.message = "该账号不存在！";
		}
		return result;
	}

	@RequestMapping(value = "/regist/do", method = RequestMethod.POST)
	public Result<User> userRegistDo(@RequestBody User userInfo) {
		Result<User> result = new Result<User>();
		String phoneNo = userInfo.getPhoneNo();
		String pswd = userInfo.getPswd();
		if (phoneNo == null || pswd == null) {
			result.type = Type.warn;
			result.message = "参数错误！";
			return result;
		}
		//
		User userByPhoneNo = userService.getUserByPhoneNo(userInfo.getPhoneNo());
		if (userByPhoneNo != null) {
			result.type = Type.warn;
			result.message = "该账号已存在！";
			return result;
		}
		//
		boolean success = userService.saveUserInfo(userInfo);
		if (success) {
			result.type = Type.info;
			result.message = "注册成功！";
		} else {
			result.type = Type.warn;
			result.message = "注册失败！";
		}
		return result;
	}

	@RequestMapping(value = "/user/info/get", method = RequestMethod.POST)
	public User getUserInfo() {
		//
		User dbUserInfo = userService.getUserByPhoneNo("123");

		return dbUserInfo;
	}

}

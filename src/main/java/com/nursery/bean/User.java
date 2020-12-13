package com.nursery.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * 
 * @author Cui
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	// 字段
	// id, phoneNo, email（不用做登录账号）, pwd, salt, nickName, name,
	// failTimes, lastFailTime, locked,
	// disabled, disabledTime, disabledCause, createrTime, ts

	/**
	 * 
	 */
	

	// 唯一键： phone
	private Integer id;

	private String name;

	private String phoneNo;

	private String pswd;

	private String salt;

	private String nickName;

	private Integer failTimes;

	private Date lastFailTime;

	private Boolean locked;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getFailTimes() {
		return failTimes;
	}

	public void setFailTimes(Integer failTimes) {
		this.failTimes = failTimes;
	}

	public Date getLastFailTime() {
		return lastFailTime;
	}

	public void setLastFailTime(Date lastFailTime) {
		this.lastFailTime = lastFailTime;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phoneNo=" + phoneNo + ", pswd=" + pswd + ", salt=" + salt
				+ ", nickName=" + nickName + ", failTimes=" + failTimes + ", lastFailTime=" + lastFailTime + ", locked="
				+ locked + "]";
	}

}

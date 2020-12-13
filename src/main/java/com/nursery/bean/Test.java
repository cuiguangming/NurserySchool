package com.nursery.bean;

import java.security.MessageDigest;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Hex;

public class Test {
	private static SecureRandom random = new SecureRandom();

	public static void main(String[] args) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bs = md5.digest("123".getBytes());

			String encodeHexString = Hex.encodeHexString(bs);
			System.out.println(encodeHexString);
		} catch (Exception e) {
		}
	}
}

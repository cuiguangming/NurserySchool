package com.nursery.common.util;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class PswdUtil {

	private static final int HASH_INTERATIONS = 1024;
	private static final int SALT_TYTES = 8;
	private static final String SHA1 = "SHA-1"; // 长度160bits=20bytes=40Hex字符

	private static SecureRandom random = new SecureRandom();

	/**
	 * 生成密码盐
	 */
	public static String generateSaltStr() {
		byte[] bytes = new byte[SALT_TYTES];
		random.nextBytes(bytes);
		// Hex编码
		return Hex.encodeHexString(bytes);
	}

	/**
	 * 生成密码
	 * 
	 * @param rawPswd
	 * @param salt
	 * @return
	 */
	public static String generatePswdStr(String rawPswd, String salt) {
		byte[] result = null;
		try {
			byte[] passwordBytes = rawPswd.getBytes();
			byte[] saltBytes = Hex.decodeHex(salt.toCharArray());
			//
			MessageDigest digest = MessageDigest.getInstance(SHA1);
			if (salt != null) {
				digest.update(saltBytes);
			}
			result = digest.digest(passwordBytes);
			//
			for (int i = 1; i < HASH_INTERATIONS; i++) {
				digest.reset();
				result = digest.digest(result);
			}
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		if (result == null) {
			return null;
		}
		return Hex.encodeHexString(result);
	}

}

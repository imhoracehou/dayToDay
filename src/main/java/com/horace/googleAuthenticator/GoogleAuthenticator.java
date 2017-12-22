package com.horace.googleAuthenticator;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;

public class GoogleAuthenticator {
	public static final int SECRET_SIZE = 10; // 生成key的长度
	public static final String SEED = "g8GjEvTbW5oVSV7avLBdwIHqGlUYNzKFI7izOF8GwLDVKs2m0QN7vxRs2im5MDaNCWGmcD2rvcZx";
	public static final String RANDOM_NUMBER_ALGORITHM = "SHA1PRNG";

	private static String USER = "Horace";
	private static String HOST = "HoraceHost";
	private static final int WINDOWS_SIZE = 15; // default 3 - max 17 (from google docs)最多可偏移的时间

	private static String SAVE_KEY = "RZ3ZSZ7KOYDKOORD";

	// 添加身份验证器：手动输入方式
	// 1、geteSecretKey()方法生成密钥(SAVE_KEY)。
	// 2、app端填写用户名(Horace)和第一步生成的密钥。
	// 3、validate()方法验证密钥与验证码是否匹配。

	// 添加身份验证器：扫描二维码方式
	// 1、geteSecretKey()方法生成密钥(SAVE_KEY)。
	// 2、getSecretImageUrl(SAVE_KEY)方法根据密钥生成二维码URL
	// 3、app端扫描二维码
	// 4、validate()方法验证密钥与验证码是否匹配。

	public static void main(String[] args) {

		// String secretKey = geteSecretKey();
		// System.out.println(secretKey);
		// String secretKeyUrl = getSecretImageUrl(secretKey);
		// System.out.println(secretKeyUrl);

		boolean b = validate("204301", SAVE_KEY);
		System.out.println(b);
	}

	/**
	 * 获取key
	 */
	public static String geteSecretKey() {
		try {
			SecureRandom sr = SecureRandom.getInstance(RANDOM_NUMBER_ALGORITHM);
			sr.setSeed(Base64.decodeBase64(SEED));
			byte[] buffer = sr.generateSeed(SECRET_SIZE);
			Base32 codec = new Base32();
			byte[] bEncodedKey = codec.encode(buffer);
			String encodedKey = new String(bEncodedKey);
			return encodedKey;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取二维码URL
	 */
	public static String getSecretImageUrl(String secretKey) {
		String format = "https://www.google.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=otpauth://totp/%s@%s%%3Fsecret%%3D%s";
		return String.format(format, USER, HOST, secretKey);
	}

	/**
	 * 验证code与key
	 */
	public static boolean validate(String code, String key) {
		try {
			Base32 codec = new Base32();
			byte[] decodedKey = codec.decode(key);
			long timeMsec = System.currentTimeMillis();
			long t = (timeMsec / 1000L) / 30L;
			for (int i = -WINDOWS_SIZE; i <= WINDOWS_SIZE; ++i) {
				long hash;
				try {
					hash = verify_code(decodedKey, t + i);
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e.getMessage());
				}
				if (hash == Long.valueOf(code)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static int verify_code(byte[] key, long t) throws NoSuchAlgorithmException, InvalidKeyException {
		byte[] data = new byte[8];
		long value = t;
		for (int i = 8; i-- > 0; value >>>= 8) {
			data[i] = (byte) value;
		}
		SecretKeySpec signKey = new SecretKeySpec(key, "HmacSHA1");
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(signKey);
		byte[] hash = mac.doFinal(data);
		int offset = hash[20 - 1] & 0xF;
		long truncatedHash = 0;
		for (int i = 0; i < 4; ++i) {
			truncatedHash <<= 8;
			truncatedHash |= (hash[offset + i] & 0xFF);
		}
		truncatedHash &= 0x7FFFFFFF;
		truncatedHash %= 1000000;
		return (int) truncatedHash;
	}

}

package ua.khpi.bibik.hospital_system.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashConverter {
	
	
	private static final String ALGORITHM_NAME = "SHA-256";

	public static String sha256 (String password) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance(ALGORITHM_NAME);
			byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
}

package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Hash {

	public static String MD5(String pw)
	{
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(pw.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}

package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64Encode {

	public static String encode(String s)
	{
		if(getByteArray(s) != null)
			return Base64.getEncoder().encodeToString(getByteArray(s));
		else
			return null;
	}
	
	public static byte[] getByteArray(String s)
	{
		Path path = Paths.get(s);
		byte[] data = null;
		try {
			data = Files.readAllBytes(path);
			return data;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}

package br.com.example.jwt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSha512 {

	public static String sign(String secret, String data) {
		try {
			Mac sha512Hmac = Mac.getInstance("HmacSHA512");
			SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA512");
			sha512Hmac.init(secretKey);
			byte[] signedBytes = sha512Hmac.doFinal(data.getBytes("UTF-8"));
			return Base64Url.encode(signedBytes);
		} catch (NoSuchAlgorithmException | InvalidKeyException | UnsupportedEncodingException e) {
			throw new RuntimeException("Error signing with HmacSHA512");
		}
	}

}

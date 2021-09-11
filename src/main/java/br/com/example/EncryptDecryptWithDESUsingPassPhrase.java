package br.com.example;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

public class EncryptDecryptWithDESUsingPassPhrase {


    private static Cipher ecipher;
    private static Cipher dcipher;
    private static final int iterationCount = 10;

    // 8-byte Salt
    private static byte[] salt = {
        (byte)0xB2, (byte)0x12, (byte)0xD5, (byte)0xB2,
        (byte)0x44, (byte)0x21, (byte)0xC3, (byte)0xC3
    };

    public static void main(String[] args) {

        try {
            String passPhrase = "password";

            // create a user-chosen password that can be used with password-based encryption (PBE)
            // provide password, salt, iteration count for generating PBEKey of fixed-key-size PBE ciphers
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);

            // create a secret (symmetric) key using PBE with MD5 and DES
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

            // construct a parameter set for password-based encryption as defined in the PKCS #5 standard
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());

            // initialize the ciphers with the given key
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
            
            // String a ser criptografada
            String s = "123456789";
            System.out.println("String: " + s);
            
            // Criptografar String
            String encrypted = encrypt(s);
            String decrypted = decrypt(encrypted);

            System.out.println("String Criptografada: " + encrypted);
            System.out.println("String descriptografada: " + decrypted);
            
            // Encode URL
            String urlEncode = URLEncoder.encode(encrypted, "UTF-8");
            String urlDecode = URLDecoder.decode(urlEncode, "UTF-8");
            
            System.out.println("String Criptografada e 'Encode' (URL): " + urlEncode);
            System.out.println("String Criptografada e 'Desencode' (URL): " + urlDecode);

        } catch (InvalidAlgorithmParameterException e) {
            System.out.println("Invalid Alogorithm Parameter:" + e.getMessage());
            return;
        } catch (InvalidKeySpecException e) {
            System.out.println("Invalid Key Spec:" + e.getMessage());
            return;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm:" + e.getMessage());
            return;
        } catch (NoSuchPaddingException e) {
            System.out.println("No Such Padding:" + e.getMessage());
            return;
        } catch (InvalidKeyException e) {
            System.out.println("Invalid Key:" + e.getMessage());
            return;
        } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    }

    public static String encrypt(String str) {
        try {
            // encode the string into a sequence of bytes using the named charset
            // storing the result into a new byte array.
            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = ecipher.doFinal(utf8);

            // encode to base64
            enc = BASE64EncoderStream.encode(enc);

            return new String(enc);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String str) {
        try {
            // decode with base64 to get bytes
            byte[] dec = BASE64DecoderStream.decode(str.getBytes());

            byte[] utf8 = dcipher.doFinal(dec);

            // create new string based on the specified charset
            return new String(utf8, "UTF8");
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }


}

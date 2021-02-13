package com.strip.test;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.strip.user.server.implementation.UserServiceImpl;

public class DES {
	
	

	
	
	public static String decrypt(String key, String ciphertext) {
        try {
        	
            byte[] cipherbytes = Base64.getDecoder().decode(ciphertext);
            byte[] initVector = Arrays.copyOfRange(cipherbytes,0,16);
            byte[] messagebytes = Arrays.copyOfRange(cipherbytes,16,cipherbytes.length);

            IvParameterSpec iv = new IvParameterSpec(initVector);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] byte_array = cipher.doFinal(messagebytes);
            
            return new String(byte_array, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
	
	
	
	
	
	  public static String encrypt(String key, String plaintext) {
	        try {
	            
	            byte initVector[] = new byte[16];
	            (new Random()).nextBytes(initVector);
	            IvParameterSpec iv = new IvParameterSpec(initVector);
	            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

	          
	            byte[] cipherbytes = cipher.doFinal(plaintext.getBytes());
	            byte[] messagebytes = new byte[initVector.length + cipherbytes.length];

	            System.arraycopy(initVector, 0, messagebytes, 0, 16);
	            System.arraycopy(cipherbytes, 0, messagebytes, 16, cipherbytes.length);

	            
	            return Base64.getEncoder().encodeToString(messagebytes);
	            
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    }
	  
	  
	  
	  
	Base64.Decoder base =Base64.getDecoder();
		
		public String generateRsakeyPair( String data) {
			String string=null;
			try {
				String key="1234567812345678";
				String vi="1234567812345678";
				
				byte []  ency=base.decode(data);
				 Cipher cipher=Cipher.getInstance("AES/CBC/NoPadding");
				 SecretKeySpec keySpec =new SecretKeySpec(key.getBytes(), "AES");
				 IvParameterSpec ivspec=new IvParameterSpec(vi.getBytes());		
				 
				 cipher.init(Cipher.DECRYPT_MODE,keySpec, ivspec);
				 
				 byte[] orginal=cipher.doFinal(ency);
				  string=new String(orginal);
				 
			}catch (Exception e) {
				System.out.println(e);
			}
			return string;


			
		}

}

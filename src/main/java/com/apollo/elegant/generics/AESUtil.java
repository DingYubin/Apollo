package com.apollo.elegant.generics;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;
import java.util.Locale;

public class AESUtil {

    //密码
    private static final String key = "1234567890abcdef";
    //iv偏移量
    private static final String iv = "groupBuyFromUser";

    public static void main(String[] args) throws Exception {
        // 原文:
        String message = "{\"userLoginName\":\"1111\",\"password\":\"2222\"}";
        System.out.println("Message: " + message);
        String encryptStr = encrypt(message, "1234567890abcdef", "groupBuyFromUser");
        System.out.println("Encrypted: " + encryptStr);
        System.out.println("Decrypted: " + decrypt("nJNASF5FmAOpzGLlolCOCYJCiyxrcY0Q74oYX2Bu+Tc7jGb0Pw2NKkvBGfTkVlT0", "1234567890abcdef", "groupBuyFromUser"));
        // 128位密钥 = 16 bytes Key:
//        byte[] key = "1234567890abcdef".getBytes(StandardCharsets.UTF_8);
        // iv 变量
//        byte[] iv = "groupBuyFromUser".getBytes(StandardCharsets.UTF_8);
//        // 加密:
//        byte[] data = message.getBytes("UTF-8");
//        byte[] encrypted = encrypt(key, data);
//        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
//        // 解密:
//        byte[] decrypted = decrypt(key, encrypted);
//        System.out.println("Decrypted: " + new String(decrypted, "UTF-8"));
    }

    public static String encrypt(String encryptStr, String key, String iv) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            /**
             * 这个地方调用BouncyCastleProvider
             *让java支持PKCS7Padding
             */
//            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);

            byte[] encrypted = cipher.doFinal(encryptStr.getBytes());

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }


    public static String decrypt(String encryptedStr, String key, String iv) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");


            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);


            byte[] decode =  Base64.getDecoder().decode(encryptedStr);
            byte[] original = cipher.doFinal(decode);

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }


    // 加密:
    public static byte[] encrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        // CBC模式需要生成一个16 bytes的initialization vector:
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] iv = sr.generateSeed(16);
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivps);
        byte[] data = cipher.doFinal(input);
        // IV不需要保密，把IV和密文一起返回:
        return join(iv, data);
    }

    // 解密:
    public static byte[] decrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        // 把input分割成IV和密文:
        byte[] iv = new byte[16];
        byte[] data = new byte[input.length - 16];
        System.arraycopy(input, 0, iv, 0, 16);
        System.arraycopy(input, 16, data, 0, data.length);
        // 解密:
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivps);
        return cipher.doFinal(data);
    }

    public static byte[] join(byte[] bs1, byte[] bs2) {
        byte[] r = new byte[bs1.length + bs2.length];
        System.arraycopy(bs1, 0, r, 0, bs1.length);
        System.arraycopy(bs2, 0, r, bs1.length, bs2.length);
        return r;
    }
}

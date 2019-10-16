package com.smt.common.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * Date: 2019/10/9
 * Author: fenghx
 * Desc:
 */
public class SymmetricEncoder {

    private static final String AESTYPE ="AES/ECB/PKCS5Padding";

    public static String AES_Encrypt(String keyStr, String plainText) {
        byte[] encrypt = null;
        try{
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypt = cipher.doFinal(plainText.getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(encrypt));
    }

    public static String AES_Decrypt(String keyStr, String encryptData) {
        byte[] decrypt = null;
        try{
            Key key = generateKey(keyStr);
            Cipher cipher = Cipher.getInstance(AESTYPE);
            cipher.init(Cipher.DECRYPT_MODE, key);
            decrypt = cipher.doFinal(Base64.decodeBase64(encryptData));
        }catch(Exception e){
            e.printStackTrace();
        }
        return new String(decrypt).trim();
    }

    private static Key generateKey(String key)throws Exception{
        try{
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            return keySpec;
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(AES_Decrypt("gz201988i1039com", "x7ugyn+LNtNbTzVbqpJJCg=="));
        //System.out.println(AES_Encrypt("12345678i1039com", "1234_ST66"));

        String keyStr = "i1039$@#admincom";
        String plainText = "4028915a5c20a9ad015c20a9adfe0000";

        String encText = AES_Encrypt(keyStr, plainText);
        String decString = AES_Decrypt(keyStr, encText);

        //System.out.println("加密后：" + encText);
        //System.out.println("解密后：" + decString);

        //加密钥匙
        //String aesKey = "i1039wwwadmincom";
        String aesKey = "12345678i1039com";
        //解密钥匙
        //String seaKey = "mocnimdawww9301i";
        //String sSrc = SerialNumber.Getnum();
        //System.out.println("中台加密前:"+plainText);
        //String ztencrypt = AES_Encrypt(aesKey, plainText);
        //System.out.println("中台加密后:"+ztencrypt);
        //String scdecrypt = AES_Decrypt(aesKey, ztencrypt);
        //System.out.println("商城解密后:"+scdecrypt);
		/*String scencrypt = AES_Encrypt(seaKey, scdecrypt);
		System.out.println("商城加密后:"+scencrypt);
		System.out.println("中台解密后:"+AES_Decrypt(seaKey, scencrypt));*/
        //	System.out.println(AES_Decrypt(aesKey, "3Uy6hAMYz+AyHp1zJ3oZaQ=="));
        //System.out.println(AES_Decrypt(aesKey, "yS40lSIpRUqaq2ye85yCYg=="));
    }

}

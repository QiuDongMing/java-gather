package com.qdm.datastruct.encry.rsa;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author qiudm
 * @date 2018/6/29 11:34
 * @desc
 */
public class RsaUtil {

    /**
     * 生成密钥对
     * @param keyLen
     * @return
     * @throws Exception
     */
    public static KeyPair genKeyPair(int keyLen) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keyLen);
        return keyPairGenerator.generateKeyPair();
    }

    /**
     * 公钥加密
     * @param content
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception {
        Cipher cipher=Cipher.getInstance("RSA");//java默认"RSA"="RSA/ECB/PKCS1Padding"
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }


    //私钥解密
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception{
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(content);
    }

    //将base64编码后的公钥字符串转成PublicKey实例
    public static PublicKey getPublicKey(String publicKey) throws Exception{
        byte[ ] keyBytes=Base64.getDecoder().decode(publicKey.getBytes());
        X509EncodedKeySpec keySpec=new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    //将base64编码后的私钥字符串转成PrivateKey实例
    public static PrivateKey getPrivateKey(String privateKey) throws Exception{
        byte[ ] keyBytes=Base64.getDecoder().decode(privateKey.getBytes());
        PKCS8EncodedKeySpec keySpec=new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }



    public static void main(String[] args) {

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCt6kvf81RcQJJEK7ADaLvEapmq40OKiGaqoaRmuCQmPHGFF68Db" +
                "iWQGuUwLN28+JU3jVqyTIbq3QgI5/FxZbvvGYfmZLCnCTOMiAJuKbqKIUTqVunRuJo+cQYppqNejqscTsRe5FkJADSTP0izN+2jo" +
                "C5iD6lG+krqNDP1EcYvRQIDAQAB";
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK3qS9/zVFxAkkQrsANou8RqmarjQ4qIZqqhpGa4" +
                "JCY8cYUXrwNuJZAa5TAs3bz4lTeNWrJMhurdCAjn8XFlu+8Zh+ZksKcJM4yIAm4puoohROpW6dG4mj5xBimmo16OqxxOxF7kWQkA" +
                "NJM/SLM37aOgLmIPqUb6Suo0M/URxi9FAgMBAAECgYAEHlhNpWWKCb1s/9vbOM+5hwy8j0U6MqC7ybgq9pFklmnZzQXH/wPEtd5X" +
                "lbhqkTh3aFGNh2JqjXFzRIrjNJWOufq+t2CS0bZig/3Xi4jGkUDpxKQcSZ+C0t3WxDRAEreHZbkXCwAwysCoo65pofCmzwuWs2/e" +
                "yEFv+IxmBi8UwQJBAN1JUv9iSRBQ+LyHET1uLdVpumybsOk5hrleX7bPQtgtbzCPHyYrgMtEM0dfvZTlbVQkUV+LRQ/VoNN3Ghrz" +
                "QSsCQQDJMpWvUfaq1K8dPMJN5RYGAPTv7vb1BO6/drHY5eCAdBcjZ+1A8YZm2BATxxfjUKp4goT47iLigSAkorLzV7lPAkBPiX9v" +
                "k+A3ISOGf/XOYr/OqYX8a6mW6rpl/mngx3Z7RTll9st3aMOOTCEyUlNOJXi6eaNV+DUGj/6Sg4i6jxypAkEAg6vxPh27+qzaNZ4v" +
                "416LfT5fDi8ru8qQnQkG91XqCObwxaEcKiZmuSOp0ee4AHIoPlncwDTI68dpy9AWoR7GDQJBAJdli85Y/T/CTXGCsDO8E4tTex6C" +
                "/88yhQIW5fQCG90AW1Yq0m0ceXkPTmEtSFz4MPFAlWJj66sj2olMlVxh1Ms=";

        try {
            /*  KeyPair keyPair = genKeyPair(1024);
            System.out.println("keyPair = " +  keyPair.getPrivate());
            System.out.println("publicKey = " +  new String(Base64.getEncoder().encode(keyPair.getPublic().getEncoded())));
            System.out.println("privateKey = " +  new String(Base64.getEncoder().encode(keyPair.getPrivate().getEncoded())));
*/
            //
            String content = "加密文字加密文字加密文字";
            PublicKey publicKey1 = getPublicKey(publicKey);
            PrivateKey privateKey1 = getPrivateKey(privateKey);

            byte[] encrypt = encrypt(content.getBytes(), publicKey1);
            System.out.println("加密后 = " + new String(encrypt));
            byte[] decrypt = decrypt(encrypt, privateKey1);
            System.out.println("解密后 = " + new String(decrypt));

            System.out.println("13 / 2 = " + 13 / 2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}

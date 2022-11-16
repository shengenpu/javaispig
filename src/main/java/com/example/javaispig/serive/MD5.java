package com.example.javaispig.serive;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5 {
    public String MD5use(String password){
        try{
            MessageDigest md5=MessageDigest.getInstance("MD5");
            Base64.Encoder base64=Base64.getEncoder();
            //给密码加盐
            return (base64.encodeToString(md5.digest(password.getBytes(StandardCharsets.UTF_8)))).replace("=","");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

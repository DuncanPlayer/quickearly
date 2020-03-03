package net.messi.early.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

public class MD5Utils{

    /**
     * @Description: 对字符串进行md5加密
     */
    public static String getMD5Str(String strValue) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String newstr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
        return newstr;
    }

    /**
     * @Description: 对字符串进行解密
     */
    public static String deCode(String deCodeStr) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.decodeBase64(md5.digest(deCodeStr.getBytes())).toString();
    }

    public static void main(String[] args) {
        try {
            String md5 = getMD5Str("123456");
            System.out.println(md5);
            String decode = deCode(md5);
            System.out.println(decode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

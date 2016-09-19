package com.ys.demo.commons;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yangshe on 2016/9/18.
 */
public class CreateToken {
    private static final CreateToken createToken = new CreateToken();

    //构造函数私有化，只能得到一个实例
    private CreateToken() {}
    public static CreateToken getCreateToken(){
        return createToken;
    }

    /**
     * 生成一个token
     * key=yangsheng
     * @return
     */
    public String makeToken() throws Exception {
        String key = "yangsheng";
        String token = System.currentTimeMillis()+key;
        //使用md5 encode这个字符串
        try {
            MessageDigest message = MessageDigest.getInstance("md5");
            byte[] digest = message.digest(token.getBytes());
            //使用base64把二进制转为字符
            BASE64Encoder base64Encoder = new BASE64Encoder();
            return base64Encoder.encode(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("生成token错误");
        }
    }

    public static boolean isRePeatSubmit(String client_token, String server_token) {
        //没有token说明用户没有通过我们的/TheDemo/indexController进入
        if(client_token==null||server_token==null){
            return true;
        }
        if(!client_token.equals(server_token)){
            return true;
        }
        //否则返回false 表示用户第一次提交
        return false;
    }
}

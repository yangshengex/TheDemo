package com.ys.demo.po;

/**
 * Created by yangshe on 2016/9/19.
 */
public class Users {
    private String stu_num;
    private String stu_name;
    private String stu_pwd;
    private String stu_email;
    private byte type;

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_pwd() {
        return stu_pwd;
    }

    public void setStu_pwd(String stu_pwd) {
        this.stu_pwd = stu_pwd;
    }

    public String getStu_email() {
        return stu_email;
    }

    public void setStu_email(String stu_email) {
        this.stu_email = stu_email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "stu_num='" + stu_num + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", stu_pwd='" + stu_pwd + '\'' +
                ", stu_email='" + stu_email + '\'' +
                ", type=" + type +
                '}';
    }
}

package com.ys.demo.service;

import com.ys.demo.po.UserInfo;
import com.ys.demo.po.Users;

/**
 * Created by yangshe on 2016/9/12.
 */
public interface UsersService {
    public UserInfo getuserService();
    public UserInfo getUserByNameAndPwd(String name,String pwd);
    //UsersMapper中dao
    public int insertUsers(Users users);
    public Users getUserByNumAndPwd(String num,String pwd);
}

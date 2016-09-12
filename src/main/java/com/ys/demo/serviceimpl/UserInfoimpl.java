package com.ys.demo.serviceimpl;

import com.ys.demo.mapper.UserInfodao;
import com.ys.demo.po.UserInfo;
import com.ys.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yangshe on 2016/9/12.
 */
@Service
public class UserInfoimpl implements UserInfoService {
    @Autowired
    private UserInfodao userInfodao;

    @Override
    public UserInfo getuserService() {
        if(userInfodao==null) {
            System.out.print("userinfoDao是空的啊");
        }
        System.out.print("userinfoDao是空的啊"+userInfodao.toString());
        UserInfo user = userInfodao.getUser();
        if(user!=null){
            return user;
        }
        return null;
    }
}

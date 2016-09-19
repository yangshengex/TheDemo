package com.ys.demo.serviceimpl;

import com.ys.demo.mapper.UserInfodao;
import com.ys.demo.mapper.UsersMapper;
import com.ys.demo.po.UserInfo;
import com.ys.demo.po.Users;
import com.ys.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangshe on 2016/9/12.
 */
@Service
public class UserInfoimpl implements UserInfoService {
    @Autowired
    private UserInfodao userInfodao;
    @Autowired
    private UsersMapper usersMapper;

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
    @Override
    public UserInfo getUserByNameAndPwd(String name,String pwd) {
        if(userInfodao==null) {
            System.out.print("userinfoDao是空的啊");
        }
        System.out.print("userinfoDao是空的啊"+userInfodao.toString());
        List<UserInfo> users = userInfodao.getUserByNameAndPwd(name, pwd);
        if(users.size()>0){
            return users.get(0);
        }
        return null;
    }
    @Override
    public int insertUsers(Users users) {
        int numLenght = users.getStu_num().length();
        return usersMapper.insertUser(users,numLenght);
    }

    @Override
    public Users getUserByNumAndPwd(String num, String pwd) {
        //只需要按num查找出学生信息，再和用户填写的密码比对，一致则登录成功

        Users user = usersMapper.getUserByNumAndPwd(num);
        if (user != null) {
            if (user.getStu_pwd().equals(pwd)) {
                return user;
            } else {
                return null;
            }
        }else {
            return null;
        }

    }


}

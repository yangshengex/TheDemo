package com.ys.demo.mapper;

import com.ys.demo.po.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yangshe on 2016/9/12.
 */
public interface UserInfodao {
    public UserInfo getUser();
    public List<UserInfo> getUserByNameAndPwd(@Param("name") String username, @Param("pwd")String userpwd);
}

package com.ys.demo.mapper;

import com.ys.demo.po.Users;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yangshe on 2016/9/19.
 */
public interface UsersMapper {
    public int insertUser(Users users);
    public Users getUserByNumAndPwd(@Param("num") String num);
}

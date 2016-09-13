package com.ys.demo.controller;

import com.ys.demo.po.UserInfo;
import com.ys.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yangshe on 2016/9/12.
 */
@Controller
public class HelloController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 这个是测试的mapping
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("helloController")
    public String hello(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("some","一些附加属性");
        if(userInfoService==null){
            System.out.println("userinfoService等于空啊啊啊啊啊");
        }
        System.out.println("userinfoService等于空啊啊啊啊啊"+userInfoService.toString());
        UserInfo getuser = userInfoService.getuserService();
        model.addAttribute("user",getuser);
        return "popvoer";
    }

    /**
     * 用户登录url，检测用户是否存在，并保存用户信息到session
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("UserLogin")
    public String Login( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("some","一些附加属性");
        if(userInfoService==null){
            System.out.println("userinfoService等于空啊啊啊啊啊");
        }
        System.out.println("userinfoService等于空啊啊啊啊啊"+userInfoService.toString());
        UserInfo getuser = userInfoService.getuserService();
        request.getSession().setAttribute("user",getuser);
        return "LoginedUI";
    }

    /**
     * 用户退出，移除session中用户信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("out_Login")
    public void OutLogin( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 这里应该做用户是否已经登录的验证 session中判断 看看是否可以使用权限验证的方法
        request.getSession().setAttribute("some","一些附加属性");
        if(userInfoService==null){
            System.out.println("userinfoService等于空啊啊啊啊啊");
        }
        System.out.println("userinfoService等于空啊啊啊啊啊"+userInfoService.toString());
        UserInfo getuser = userInfoService.getuserService();
        request.getSession().removeAttribute("user");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

}

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
    @RequestMapping("UserLogin")
    public String Login(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("some","一些附加属性");
        if(userInfoService==null){
            System.out.println("userinfoService等于空啊啊啊啊啊");
        }
        System.out.println("userinfoService等于空啊啊啊啊啊"+userInfoService.toString());
        UserInfo getuser = userInfoService.getuserService();
        request.getSession().setAttribute("user",getuser);
        return "LoginedUI";
    }
    @RequestMapping("out_Login")
    public void OutLogin( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("some","一些附加属性");
        if(userInfoService==null){
            System.out.println("userinfoService等于空啊啊啊啊啊");
        }
        System.out.println("userinfoService等于空啊啊啊啊啊"+userInfoService.toString());
        UserInfo getuser = userInfoService.getuserService();
        request.getSession().removeAttribute("user");
        request.getRequestDispatcher("popvoer.jsp").forward(request,response);
    }

}

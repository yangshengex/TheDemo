package com.ys.demo.controller;

import com.sun.net.httpserver.Authenticator;
import com.ys.demo.commons.CreateToken;
import com.ys.demo.commons.CreateVerificationCode;
import com.ys.demo.commons.RemoteValidate;
import com.ys.demo.po.UserInfo;
import com.ys.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yangshe on 2016/9/12.
 */
@Controller
@RequestMapping("user/")
public class OpenerUserController {
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
     * 程序的index方法
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("indexController")
    public String indexController(HttpServletRequest request, HttpServletResponse response) throws Exception {
       //创建一个token
        request.getSession().removeAttribute("user");
        String server_token = CreateToken.getCreateToken().makeToken();
        request.getSession().setAttribute("token",server_token);
        return "index";
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
    public String Login( HttpServletRequest request, HttpServletResponse response) throws Exception {
        String server_token = (String) request.getSession().getAttribute("token");
        String client_token = request.getParameter("token");
        if(CreateToken.isRePeatSubmit(client_token,server_token)){
            //TODO 希望服务器不做任何操作，直接停留在当前页面即可，不需要重新渲染界面
            System.out.println("用户重复或者比通过正常渠道提交的，不做任何处理...直接渲染界面");
            //直接跳转带登陆的页面，不需要进行数据库用户的验证并且把session中的错误信息移除
            //request.getSession().removeAttribute("errormessages");
            //如果session中有user属性，那说明是登陆成功之后的重复提交，那我们应该把页面导向LoginedUI
            //如果没有session中的 user属性，那说明是用户没有登陆成功的重复提交，我们需要把页面导向index
            if(request.getSession().getAttribute("user")!=null) {
                request.getRequestDispatcher("../WEB-INF/LoginedUI.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("../WEB-INF/index.jsp").forward(request, response);
            }
            System.out.println("后面还是可以运行的");
            return  null;
        }
        if(userInfoService!=null){
            String username = request.getParameter("username");
            String userpwd= request.getParameter("userpassword");

            UserInfo getuser = userInfoService.getUserByNameAndPwd(username,userpwd);
            if(getuser!=null) {
                request.getSession().setAttribute("user", getuser);
                request.removeAttribute("errormessages");
                //登陆成功后重置token，避免重复提交
                request.getSession().setAttribute("token",CreateToken.getCreateToken().makeToken());
               return "LoginedUI";
            }else {
                request.getSession().setAttribute("errormessages", "错误的用户名和密码,请属性页面之后再登陆");
                //登陆失败重置token，避免重复提交
                request.getSession().setAttribute("token",CreateToken.getCreateToken().makeToken());
                //这样的服务器跳转在用户刷新的时候还是会到这里来，之后会一个提示错误信息，我们需要把用户导向index.jsp中,这样用户刷新的时候就不会请求这样页面了
                //同时在jsp中移除这个session，这样就达到了第一次提示错误信息的效果，而用户刷新是不会再提示错误信息
                return "index";
            }
        }else {
            throw new Exception("服务器错误");
        }
    }

    /**
     * 用户退出，移除session中用户信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("out_Login")
    public String OutLogin( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 这里应该做用户是否已经登录的验证 session中判断 看看是否可以使用权限验证的方法
        request.getSession().setAttribute("some","一些附加属性");
        if(userInfoService==null){
            System.out.println("userinfoService等于空啊啊啊啊啊");
        }
        System.out.println("userinfoService等于空啊啊啊啊啊"+userInfoService.toString());
        UserInfo getuser = userInfoService.getuserService();
        request.getSession().removeAttribute("user");
        return "index";
    }

    /**
     * 获取验证码图片
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("getverifycode")
    public void getverifycode( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CreateVerificationCode verificationCode = new CreateVerificationCode();
        verificationCode.getverifyCode(request,response);
    }

    /**
     * 实时验证用户输入的验证码
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("beginverify")
    public void beginverify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RemoteValidate validate = new RemoteValidate();
        validate.beginVarlidata(request,response);
    }
}

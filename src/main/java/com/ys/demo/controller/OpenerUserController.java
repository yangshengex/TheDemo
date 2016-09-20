package com.ys.demo.controller;

import com.ys.demo.commons.CreateToken;
import com.ys.demo.commons.CreateVerificationCode;
import com.ys.demo.commons.RemoteValidate;
import com.ys.demo.commons.Results;
import com.ys.demo.po.UserInfo;
import com.ys.demo.po.Users;
import com.ys.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * @return
     */
    @RequestMapping("userRegister")
    @ResponseBody
    public Results hello(@RequestBody Users users) {
        Results results = Results.FAIL;
        System.out.println("访问到了这里。。。。。");
        System.out.println("接收到的user信息"+users.toString());
        //开始数据库操作
        int counts = userInfoService.insertUsers(users);
        if(counts>0){
            results = Results.SUCCESS;
        }
        return results;
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
//        String server_token = (String) request.getSession().getAttribute("token");
//        String client_token = request.getParameter("token");
//        System.out.println("1server_token="+server_token+" ****client_token="+client_token);
//        if(CreateToken.isRePeatSubmit(client_token,server_token)){
//            //TODO 希望服务器不做任何操作，直接停留在当前页面即可，不需要重新渲染界面
//            System.out.println("用户重复或者比通过正常渠道提交的，不做任何处理...直接渲染界面");
//            //直接跳转带登陆的页面，不需要进行数据库用户的验证并且把session中的错误信息移除
//            //request.getSession().removeAttribute("errormessages");
//            //如果session中有user属性，那说明是登陆成功之后的重复提交，那我们应该把页面导向LoginedUI
//            //如果没有session中的 user属性，那说明是用户没有登陆成功的重复提交，我们需要把页面导向index
//            if(request.getSession().getAttribute("user")!=null) {
//                 server_token = (String) request.getSession().getAttribute("token");
//                 client_token = request.getParameter("token");
//                System.out.println("2server_token="+server_token+" ****client_token="+client_token);
//                request.getRequestDispatcher("../WEB-INF/LoginedUI.jsp").forward(request, response);
//            }else {
//                 server_token = (String) request.getSession().getAttribute("token");
//                 client_token = request.getParameter("token");
//                System.out.println("3server_token="+server_token+" ****client_token="+client_token);
//                request.getRequestDispatcher("../WEB-INF/index.jsp").forward(request, response);
//            }
//            return  null;
//        }
        if(request.getSession().getAttribute("user")==null){
            //重置token使得退出后不用转到indexController页面刷新token登录
            request.getSession().setAttribute("token",CreateToken.getCreateToken().makeToken());
        }
            String username = request.getParameter("username");
            String userpwd = request.getParameter("userpassword");
            System.out.println("username=" + username + "*********userpwd=" + userpwd);
            if (userInfoService != null && username != null && userpwd != null) {
                Users getuser = userInfoService.getUserByNumAndPwd(username, userpwd);
                if (getuser != null) {
                    request.getSession().setAttribute("user", getuser);
                    request.removeAttribute("errormessages");
                    //登陆成功后重置token，避免重复提交
                    System.out.println("************************************************");
                    //设置的是登陆的token
                    request.getSession().setAttribute("token", CreateToken.getCreateToken().makeToken());
                    //设置addbook的token
                    //request.getSession().setAttribute("addbook_token", CreateToken.getCreateToken().makeToken());
                    return "LoginedUI";
                } else {
                    request.getSession().setAttribute("messages", "错误的用户名和密码...");
                    //登陆失败重置token，避免重复提交
                    //request.getSession().setAttribute("token",CreateToken.getCreateToken().makeToken());
                    String server_token = (String) request.getSession().getAttribute("token");
                    String client_token = request.getParameter("token");
                    System.out.println("4server_token=" + server_token + " ****client_token=" + client_token);
                    //这样的服务器跳转在用户刷新的时候还是会到这里来，之后会一个提示错误信息，我们需要把用户导向index.jsp中,这样用户刷新的时候就不会请求这样页面了
                    //同时在jsp中移除这个session，这样就达到了第一次提示错误信息的效果，而用户刷新是不会再提示错误信息
                    //this.indexController(request,response);
                    return "index";
                }
            } else {
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
    public String OutLogin( HttpServletRequest request, HttpServletResponse response) throws Exception {
        //重置token使得退出后不用转到indexController页面刷新token登录
        request.getSession().setAttribute("token",CreateToken.getCreateToken().makeToken());
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

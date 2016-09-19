package com.ys.demo.interceptors;

import com.ys.demo.commons.CreateToken;
import com.ys.demo.controller.OpenerUserController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yangshe on 2016/9/18.
 */

/**
 * preHandle 预处理回调方法，实现处理器的预处理（如登录检查）返回值：true表示继续流程（如调用下一个拦截器或处理器）；
 *false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
 *
 * postHandle：后处理回调方法，实现处理器的后处理（但在渲染视图之前），
 * 此时我们可以通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理
 *
 *
 * afterCompletion：整个请求处理完毕回调方法，即在视图渲染完毕时回调，
 * 如性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理，
 *
 *
 *
 */
public class UserInterCeptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //我们先得到token，判断用户是否是重复提交
        System.out.println("进入到拦截器............");
        String server_token = (String) request.getSession().getAttribute("token");
        String client_token = request.getParameter("token");
        System.out.println("1server_token="+server_token+" ****client_token="+client_token);
        if(CreateToken.isRePeatSubmit(client_token,server_token)){
            //TODO 希望服务器不做任何操作，直接停留在当前页面即可，不需要重新渲染界面
            System.out.println("用户重复或者比通过正常渠道提交的，不做任何处理...直接渲染界面");
            //直接跳转带登陆的页面，不需要进行数据库用户的验证并且把session中的错误信息移除
            //request.getSession().removeAttribute("errormessages");
            //如果session中有user属性，那说明是登陆成功之后的重复提交，那我们应该把页面导向LoginedUI
            //如果没有session中的 user属性，那说明是用户没有登陆成功的重复提交，我们需要把页面导向index
            if(request.getSession().getAttribute("user")!=null) {
                server_token = (String) request.getSession().getAttribute("token");
                client_token = request.getParameter("token");
                System.out.println("2server_token="+server_token+" ****client_token="+client_token);
                request.getRequestDispatcher("../WEB-INF/LoginedUI.jsp").forward(request, response);
            }else {
                server_token = (String) request.getSession().getAttribute("token");
                client_token = request.getParameter("token");
                System.out.println("3server_token="+server_token+" ****client_token="+client_token);
                request.getRequestDispatcher("../WEB-INF/index.jsp").forward(request, response);
            }
            //在第一次请求并渲染了界面之后我们重置server_token,使得client_token和Server_token不一样
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

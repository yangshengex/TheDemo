package com.ys.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoteValidate
 */
@WebServlet("/RemoteValidate")
public class RemoteValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoteValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String verifyCoade = (String) request.getSession().getAttribute("rand");
		String param = request.getParameter("userVerifyCode");
		System.out.println("用户的验证码："+param+"系统的真确的验证码："+verifyCoade);
		if(verifyCoade.equalsIgnoreCase(param)){
			response.getWriter().write("success");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String verifyCoade = (String) request.getSession().getAttribute("rand");
		String param = request.getParameter("pwd");
		System.out.println("用户的验证码："+param+"系统的真确的验证码："+verifyCoade);
		if(verifyCoade.equalsIgnoreCase(param)){
			response.getWriter().write("true");
		}
	}

}

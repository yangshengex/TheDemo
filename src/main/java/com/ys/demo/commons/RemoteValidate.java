package com.ys.demo.commons;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoteValidate  {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String verifyCoade = (String) request.getSession().getAttribute("rand");
		String param = request.getParameter("userVerifyCode");
		System.out.println("用户的验证码："+param+"系统的真确的验证码："+verifyCoade);
		if(verifyCoade.equalsIgnoreCase(param)){
			response.getWriter().write("success");
		}
	}

	public void beginVarlidata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String verifyCoade = (String) request.getSession().getAttribute("sessionverify");
		String param = request.getParameter("verifyvalue");
		System.out.println("用户的验证码："+param+"系统的真确的验证码："+verifyCoade);
		if(verifyCoade.equalsIgnoreCase(param)){
			response.getWriter().write("true");
		}
	}

}

package com.ys.demo.controller;

import com.ys.demo.po.UserInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
//标注子包类是应该切面  定义好的切面要交给spring管理
@Aspect @Service 
public class Myinstance {
	//标注切入点                 
	@Pointcut("execution (* com.ys.demo.serviceimpl.*(..))")
	//定义切入点的名称
	private void anyMethod() {}
	
	//拦截到对应的方法的前置通知
	@Before("anyMethod() && args(int)" )
	public void doAccessCheck(int id){
		System.out.println("前置通知*********"+id);
	}
	//后置通知
	@AfterReturning(pointcut="anyMethod()",returning="rest" )
	public void doAfterReturning(UserInfo rest){
		System.out.println("后置通知*********"+rest);
	}
	//最终通知
	@After("anyMethod()")
	public void doAfter(){
		System.out.println("最终通知*********");
	}
	//异常通知
	@AfterThrowing("anyMethod()")
	public void doAfterhrowing(){
		System.out.println("异常通知*********");
	}
	//环绕通知
	@Around("anyMethod()")
	public UserInfo doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
		//这里可以做权限的判断
		System.out.println("进入方法");
		Object obj = pjp.proceed();
		System.out.println("退出方法");
		return (UserInfo) obj;
	}
}

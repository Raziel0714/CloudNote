package cn.tedu.cloudnote.aop;

import java.io.Serializable;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component //将当前类纳入容器管理
@Aspect //Aspect 切面(儿), 声明当前的bean是
// 一个切面(儿)组件!
public class DemoAspect implements Serializable{
	//@Before 在方法执行之前执行
	//userService 的所有方法
	//@Before("bean(userService)")
	//@AfterReturning("bean(userService)")
	//@AfterThrowing("bean(userService)")
	@After("bean(userService)")
	public void test(){
		System.out.println("Hello World!");
	}

}







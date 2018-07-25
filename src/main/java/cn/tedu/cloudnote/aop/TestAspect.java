package cn.tedu.cloudnote.aop;

import java.io.Serializable;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect implements Serializable{
	@Before("bean(userService)")
	public void before() {
		System.out.println("before()");
	}
	@AfterReturning("bean(userService)")
	public void afterReturning(){
		System.out.println("afterReturning");
	}
	@AfterThrowing("bean(userService)")
	public void afterThrowing(){
		System.out.println("afterThrowing");
	}
	@After("bean(userService)")
	public void after(){
		System.out.println("after");
	}

}









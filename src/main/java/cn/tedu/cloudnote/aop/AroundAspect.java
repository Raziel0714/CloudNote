package cn.tedu.cloudnote.aop;

import java.io.Serializable;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect 
	implements Serializable{
	//环绕通知, test 方法将代理业务方法
	//Object 返回代表业务方法的返回值
	//Throwable 是业务方法执行期间的异常
	@Around("bean(userService)")
	public Object test(
			ProceedingJoinPoint joinPoint) 
		throws Throwable{
		System.out.println("执行业务之前!");
		//调用业务方法
		try{
			//@Before
			Object obj=joinPoint.proceed();
			System.out.println("抓到:"+obj);
			//@ArterReturning
			return obj;
		}catch(Throwable e){
			//@AfterThrowing
			throw e;
		}finally{
			System.out.println("执行业务之后!");
			//@Arfter
		}
	}
}













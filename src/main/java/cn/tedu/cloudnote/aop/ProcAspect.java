package cn.tedu.cloudnote.aop;

import java.io.Serializable;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Component;

//性能审计 AOP
@Component
@Aspect
public class ProcAspect 
	implements Serializable{
	
	@Around("execution(* cn.tedu.cloudnote.service.UserService.login(..))")
	public Object test(
		ProceedingJoinPoint joinPoint)
		throws Throwable{
		long t1 = System.nanoTime();
		//调用业务方法
		Object obj=joinPoint.proceed();
		Signature s=joinPoint.getSignature();
		//Signature 签名: 这里是方法签名(方法名+参数类型列表)
		long t2 = System.nanoTime();
		System.out.println(s+"执行时间:"+(t2-t1)); 
		return obj;
	}
}













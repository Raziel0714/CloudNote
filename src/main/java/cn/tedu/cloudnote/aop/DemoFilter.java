package cn.tedu.cloudnote.aop;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter implements Filter {
	public void init(FilterConfig cfg) 
			throws ServletException {
	}
	public void doFilter(ServletRequest req,
			ServletResponse res, 
			FilterChain chain)
			throws IOException, ServletException {
		//chain//链条, 指方法调用链条
		System.out.println("调用Servlet");
		chain.doFilter(req, res); 
		//执行了后续的Servlet, 处理后续的请求
		System.out.println("执行结束Servlet");
	}
	public void destroy() {
	}
}

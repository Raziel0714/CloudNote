package cn.tedu.cloudnote.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloudnote.dao.UserDao;
import cn.tedu.cloudnote.entity.User;

public class TestUserDao {
	//@Test
	public void testFindUserByName(){
		ApplicationContext ctx
			=new ClassPathXmlApplicationContext(
				 "conf/spring-mybatis.xml");
		UserDao dao=ctx.getBean(
				"userDao", UserDao.class);
		User user=dao.findUserByName("demo");
		if(user!=null){
			System.out.println("用户名存在");
		}else{
			System.out.println("用户不存在");
		}
	}
	@Test
	public void testAddUser(){
		ApplicationContext ctx
			=new ClassPathXmlApplicationContext(
					"conf/spring-mybatis.xml");
		UserDao dao
			=ctx.getBean("userDao", UserDao.class);
		User user
			=new User("123456","带你飞","123456","","老司机");
		dao.addUser(user);
	}
}













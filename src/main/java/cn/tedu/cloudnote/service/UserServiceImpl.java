package cn.tedu.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloudnote.dao.UserDao;
import cn.tedu.cloudnote.entity.User;
import cn.tedu.cloudnote.util.NoteUtil;
@Service("userService")
public class UserServiceImpl 
				implements UserService{
	@Resource
	private UserDao userDao;
	
	@Transactional
	public User login(String name, String password) 
			throws NameException, PasswordException {
		//参数格式校验
		if(name==null || name.trim().isEmpty()){
			throw new NameException("用户名不能为空");
		}
		if(password==null || password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		//密码检验
		User user
			=userDao.findUserByName(name);
		if(user==null){
			throw new NameException("用户名错误");
		}
		
		//Thread t = Thread.currentThread();
		//System.out.println(t); 
		
		//String s = null;
		//s.length();
		
		String md5Password=NoteUtil.md5(password);
		if(user.getPassword().equals(md5Password)){
			return user;
		}else{
			throw new PasswordException("密码错误");
		}
	}
	public User regist(String name, String password, String nick) throws NameException, PasswordException {
		//检测用户名是否存在
		User user
			=userDao.findUserByName(name);
		if(user!=null){
			throw new NameException("用户名被占用");
		}
		//生成ID
		String id=NoteUtil.createId();
		
		if(nick==null || nick.trim().isEmpty()){
			nick=name;
		}
		String token="";
		password=NoteUtil.md5(password);
		user=new User(id,name,password,token,nick);
		userDao.addUser(user);
		return user;
	}
}










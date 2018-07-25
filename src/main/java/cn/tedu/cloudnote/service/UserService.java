package cn.tedu.cloudnote.service;

import cn.tedu.cloudnote.entity.User;

public interface UserService {
	User login(String name,String password)
			throws NameException,PasswordException;
	User regist(String name,String password,String nick)
			throws NameException,PasswordException;
}











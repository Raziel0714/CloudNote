package cn.tedu.cloudnote.dao;

import java.util.List;

import cn.tedu.cloudnote.entity.Book;
import cn.tedu.cloudnote.entity.User;

public interface RelationDao {
	User findUserAndBooks(String userId);
	User findUserAndBooks1(String userId);
	List<Book> findBookAndUser();
	List<Book> findBookAndUser1();
}

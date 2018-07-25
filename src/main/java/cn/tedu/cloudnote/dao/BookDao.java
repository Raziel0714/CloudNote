package cn.tedu.cloudnote.dao;

import java.util.List;

import cn.tedu.cloudnote.entity.Book;

public interface BookDao {
	List<Book> findByUserId(String userId);
	Book findByBookId(String bookId);
	void save(Book book);
}










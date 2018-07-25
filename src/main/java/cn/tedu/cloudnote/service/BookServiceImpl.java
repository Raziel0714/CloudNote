package cn.tedu.cloudnote.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloudnote.dao.BookDao;
import cn.tedu.cloudnote.dao.UserDao;
import cn.tedu.cloudnote.entity.Book;
import cn.tedu.cloudnote.entity.User;
import cn.tedu.cloudnote.util.NoteUtil;
@Service("bookService")
public class BookServiceImpl 
			implements BookService{
	@Resource
	private UserDao userDao;
	@Resource
	private BookDao bookDao;
	
	public List<Book> listBooks(String userId) throws UserNotFoundException {
		if(userId==null || userId.trim().isEmpty()){
			throw new UserNotFoundException(
						"User ID不能为空");
		}
		User user
				=userDao.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException(
						"用户不存在");
		}
		List<Book> list
			=bookDao.findByUserId(userId);
		
		return list;
	}

	public Book addBook(String userId, String bookName) throws UserNotFoundException {
		if(userId==null || userId.trim().isEmpty()){
			throw new UserNotFoundException("User ID不能为空");
		}
		User user
				=userDao.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("用户不存在");
		}
		Book book=new Book();
		String bookId=NoteUtil.createId();
		Timestamp time
				=new Timestamp(System.currentTimeMillis());
		book.setId(bookId);
		book.setUserId(userId);
		book.setName(bookName);
		book.setCreateTime(time);
		book.setTypeId("5");
		book.setDesc("");
		bookDao.save(book);
		return book;
	}
}







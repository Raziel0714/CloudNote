package cn.tedu.cloudnote.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloudnote.entity.Book;
import cn.tedu.cloudnote.service.BookService;
import cn.tedu.cloudnote.util.JsonResult;

@Controller
@RequestMapping("/book")
public class BookController 
				extends ExceptionController{
	@Resource
	private BookService bookService;
	@RequestMapping("/loadBooks.do")
	@ResponseBody
	public JsonResult listBooks(String userId){
		List<Book> result
				=bookService.listBooks(userId);
		return new JsonResult(result);
	}
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult addBook(
			String userId,String bookName){
		Book book
			=bookService.addBook(userId, bookName);
		return new JsonResult(book);
	}
}










package cn.tedu.cloudnote.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloudnote.entity.Note;
import cn.tedu.cloudnote.service.NoteService;
import cn.tedu.cloudnote.util.JsonResult;

@Controller
@RequestMapping("/note")
public class NoteController 
		extends ExceptionController{
	@Resource
	private NoteService noteService;
	@RequestMapping("/list.do")
	@ResponseBody
	public JsonResult listNotes(String bookId){
		
		List<Map<String,Object>> list
				=noteService.listNotes(bookId);
		
		return new JsonResult(list);	
	}
	@RequestMapping("/add.do")
	@ResponseBody
	public JsonResult addNote(
			String userId,
			String bookId,
			String noteTitle){
		Note note=noteService.addNote(userId, bookId, noteTitle);
		return new JsonResult(note);
	}
	@RequestMapping("/delete.do")
	@ResponseBody
	public JsonResult delNote(String noteId){
		int rows=noteService.delNote(noteId);
		return new JsonResult(rows);
	}
	@ResponseBody
	@RequestMapping("/manage.do")
	public JsonResult find(String title, String status, String begin, String end, String userId){
		List<Note> list
				=noteService.find(title, status, begin, end, userId);
		
		return new JsonResult(list);
	}
	
	
}









package cn.tedu.cloudnote.service;

import java.util.List;
import java.util.Map;

import cn.tedu.cloudnote.entity.Note;

public interface NoteService {
	List<Map<String,Object>> listNotes(String bookId)
						throws NoteBookNotFoundException;
	Note addNote(String userId,String bookId,String noteTitle);
	//删除笔记方法
	int delNote(String noteId);
	//批量删除笔记
	int delNotes(String...ids);
	
	int deleteNotes(String... ids);
	
	List<Note> find(String title,String status,String begin,String end,String userId);
}









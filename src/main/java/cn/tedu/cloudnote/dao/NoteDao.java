package cn.tedu.cloudnote.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.cloudnote.entity.Note;

public interface NoteDao {
	List<Map<String,Object>> findByBookId(String bookId);
	int save(Note note);
	Note findByNoteId(String noteId);
	//删除笔记方法
	int updateStatus(String noteId);
	//批量删除笔记
	int deleteNoteById(String... ids);
	
	int deleteNoteById2(String id);
	
	List<Note> findNotes(Map params);
}









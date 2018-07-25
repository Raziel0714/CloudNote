package cn.tedu.cloudnote.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.dao.NoteDao;
import cn.tedu.cloudnote.entity.Note;

public class TestNoteDao extends TestBase{
	private NoteDao noteDao;
	@Before
	public void init(){
	noteDao
	=super.getContext().getBean(
			"noteDao", NoteDao.class);
	}
	//@Test
	public void test(){
		List<Map<String,Object>> list
		=noteDao.findByBookId(
				"1db556b9-d1dc-4ed9-8274-45cf0afbe859");
		for(Map note:list){
			//System.out.println(note.get("id")+","+note.get("title"));
			System.out.println(note);
		}
	}
	@Test
	public void testFindNotes(){
		Map params=new HashMap();
		params.put("userId","48595f52-b22c-4485-9244-f4004255b972");
		params.put("title", "测试笔记——1");
		List<Note> list
				=noteDao.findNotes(params);
		System.out.println(list);
	}
}















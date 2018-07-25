package cn.tedu.cloudnote.test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.service.NoteService;

public class TestNoteService extends TestBase{
	private NoteService noteService;
	@Before
	public void init(){
		noteService=super.getContext().getBean(
				"noteService", NoteService.class);
	}
	//@Test
	public void test(){
		
		List<Map<String,Object>> list
				=noteService.listNotes(
				 "1db556b9-d1dc-4ed9-8274-45cf0afbe859");
		for(Map<String,Object> map:list){
			System.out.println(map);
		}
	}
	@Test
	public void testDelNotes(){
		String id1="3febebb3-a1b7-45ac-83ba-50cdb41e5fc1";
		String id2="1ec185d6-554a-481b-b322-b562485bb8e8";
		String id3="9187ffd3-4c1e-4768-9f2f-c600e835b823";
		noteService.delNotes(id1,id2,id3);			
	}
	
	@Test
	public void testDeleteNotes(){
		// 84b2d98b-af39-4655-8aa8-d8869d043cca
		// c347f832-e2b2-4cb7-af6f-6710241bcdf6
		// 07305c91-d9fa-420d-af09-c3ff209608ff
		// 5565bda4-ddee-4f87-844e-2ba83aa4925f
		String id1="84b2d98b-af39-4655-8aa8-d8869d043cca";
		String id2="c347f832-e2b2-4cb7-af6f-6710241bcdf6";
		String id3="07305c91-d9fa-420d-af09-c3ff209608ff";
		String id4="5565bda4-ddee-4f87-844e-2ba83aa4925f";
		noteService.deleteNotes(id1,id2,id3,id4);			
	}
	

	
}








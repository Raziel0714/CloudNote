package cn.tedu.cloudnote.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloudnote.dao.NoteDao;
import cn.tedu.cloudnote.dao.ShareDao;
import cn.tedu.cloudnote.entity.Share;
import cn.tedu.cloudnote.util.NoteUtil;

public class TestShareDao extends TestBase{
	private NoteDao noteDao;
	private ShareDao shareDao;
	@Before
	public void init(){
		shareDao=super.getContext().getBean(
				"shareDao", ShareDao.class);
		noteDao=super.getContext().getBean(
				"noteDao", NoteDao.class);
	}
	//@Test
	public void testSave(){
		Share share=new Share();
		String shareId=NoteUtil.createId();
		share.setCn_share_id(shareId);
		share.setCn_share_title("TESTSHARE");
		share.setCn_share_body("share...");
		share.setCn_note_id("123456");
		
		shareDao.save(share);
	}
//	@Test
//	public void testFindByTitle(){
//		String title="测试笔记——1";
//		List<Share> list
//				=shareDao.findLikeTitle(title);
//		for(Share s:list){
//			System.out.println(
//						s.getCn_note_id()
//						+","+ s.getCn_share_title());
//		}
//	}
}










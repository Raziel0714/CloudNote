package cn.tedu.cloudnote.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloudnote.dao.BookDao;
import cn.tedu.cloudnote.dao.NoteDao;
import cn.tedu.cloudnote.entity.Book;
import cn.tedu.cloudnote.entity.Note;
import cn.tedu.cloudnote.util.NoteUtil;
@Service("noteService")
public class NoteServiceImpl 
				implements NoteService{
	@Resource
	private BookDao bookDao;
	@Resource
	private NoteDao noteDao;
	
	public List<Map<String, Object>> listNotes(String bookId) throws NoteBookNotFoundException {
		if(bookId==null
			||bookId.trim().isEmpty()){
			throw new NoteBookNotFoundException(
					"Book ID不能为空");
		}
		//判断bookId是否有效
		Book book
				=bookDao.findByBookId(bookId);
		if(book==null){
			throw new NoteBookNotFoundException(
					"笔记本不存在");
		}
		List<Map<String,Object>> list
				=noteDao.findByBookId(bookId);
		
		return list;
	}

	public Note addNote(String userId, String bookId, String noteTitle) {
		String id=NoteUtil.createId();
		long now=System.currentTimeMillis();
		String statusId="1";
		String typeId="1";
		String body="";
		Note note
			=new Note(id,bookId,userId,statusId,typeId,noteTitle,body,now,now);
		noteDao.save(note);
		return note;
	}

	public int delNote(String noteId) {
		//更新笔记状态
		int rows=noteDao.updateStatus(noteId);
		return rows;
	}

	public int delNotes(String... ids) {
		int n=noteDao.deleteNoteById(ids);
		if(n!=ids.length){
			throw new NoteBookNotFoundException("ID不存在");
		}
		return n;
	}

	public List<Note> find(String title, String status, String begin, String end, String userId) {
		Map<String,Object> params
				=new HashMap<String,Object>();
		params.put("userId",userId);
		//判断标题条件,不为空时有效
		if(title!=null && !"".equals(title)){
			params.put("title","%"+title+"%");
		}
		//判断状态条件,不为"全部"时有效
		if(status!=null && !"0".equals(status)){
			params.put("status",status);
		}
		//判断开始日期,不为空有效
		if(begin!=null && !"".equals(begin)){
			//将输入的日期字符串转成long类型数据
			Date beginDate=Date.valueOf(begin);
			params.put("begin",beginDate.getTime());
		}
		//判断结束日期,不为空有效
		if(end!=null && !"".equals(end)){
			Date endDate=Date.valueOf(end);
			params.put("end",endDate.getTime());
		}
		List<Note> list
				=noteDao.findNotes(params);
		return list;
	}
	
	@Transactional
	public int deleteNotes(String... ids) {
		int n = 0;
		for (String id : ids) {
			int i=noteDao.deleteNoteById2(id);
			if(i==0){
				throw new RuntimeException(
					"id是错误的"+id);
			}
			n+=i;
		}
		return n;
	}

}





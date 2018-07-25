package cn.tedu.cloudnote.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloudnote.dao.NoteDao;
import cn.tedu.cloudnote.dao.ShareDao;
import cn.tedu.cloudnote.entity.Note;
import cn.tedu.cloudnote.entity.Share;
import cn.tedu.cloudnote.util.NoteUtil;

@Service("shareService")
public class ShareServiceImpl implements ShareService{
	@Resource
	private ShareDao shareDao;
	@Resource
	private NoteDao noteDao;
	public void shareNote(String noteId){
		//获取分享笔记的数据
		Share share=new Share();
		String id=NoteUtil.createId();
		share.setCn_share_id(id);
		Note note
			=noteDao.findByNoteId(noteId);
		share.setCn_note_id(noteId);
		share.setCn_share_title(note.getTitle());
		share.setCn_share_body(note.getBody());
		//保存分享记录
		shareDao.save(share);
		System.out.println(share);
	}
	public List<Share> searchNote(String keyword,int page) {
		String title="%";
		if(keyword!=null && !"".equals(keyword)){
			title="%"+keyword.trim()+"%";
		}
		//计算抓取记录的起点
		int begin=(page-1)*3;
		Map<String,Object> params
				=new HashMap();
		params.put("title", title);//对应#{title}
		params.put("begin", begin);//对应#{begin}
		List<Share> list
				=shareDao.findLikeTitle(params);
		return list;
	}
}








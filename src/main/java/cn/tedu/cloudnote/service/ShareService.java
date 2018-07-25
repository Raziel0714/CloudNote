package cn.tedu.cloudnote.service;

import java.util.List;

import cn.tedu.cloudnote.entity.Share;

public interface ShareService {
	void shareNote(String noteId);
	List<Share> searchNote(String keyword,int page);
}

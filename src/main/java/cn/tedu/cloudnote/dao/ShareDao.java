package cn.tedu.cloudnote.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.cloudnote.entity.Share;

public interface ShareDao {
	void save(Share share);
	List<Share> findLikeTitle(Map params);
}

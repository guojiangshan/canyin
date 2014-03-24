package cn.canyin.dao;

import cn.canyin.model.Shangdian;

public interface ShangdianDao {
	public Shangdian findById(long ID) throws Exception;
	
	public Shangdian findByWeixinId(String wxid) throws Exception;
	
	// return id;
	public long add(Shangdian sd) throws Exception;
		
}

package cn.canyin.dao;

import cn.canyin.model.Restaurant;

public interface RestaurantDao {
	public Restaurant findByRId(long ID) throws Exception;
	
	public Restaurant findByWechatId(String wxid) throws Exception;
	
	// return id;
	public long add(Restaurant sd) throws Exception;
		
}

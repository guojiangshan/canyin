package cn.canyin.service;

import java.util.List;

import cn.canyin.model.Menu;

public interface MenuService extends Service {
	
	public List<Menu> getByRestaurantId(long r_id) throws Exception;
	
	public Menu getById(long r_id, long m_id) throws Exception;
	
	public long addMenu(Menu menu) throws Exception;
}

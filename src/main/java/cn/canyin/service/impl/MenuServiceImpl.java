package cn.canyin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.canyin.dao.MenuDao;
import cn.canyin.model.Menu;
import cn.canyin.service.MenuService;

public class MenuServiceImpl implements MenuService {

	private static Logger logger =  Logger.getLogger(MenuServiceImpl.class);
	
	@Autowired
	private MenuDao menudao; 
	
	@Override
	public List<Menu> getByRestaurantId(long r_id) throws Exception {
		return menudao.getByRestaurantId(r_id);
	}

	@Override
	public Menu getById(long r_id, long m_id) throws Exception {
		// TODO Auto-generated method stub
		return menudao.getById(r_id, m_id);
	}

	@Override
	public long addMenu(Menu menu) throws Exception {
		// TODO Auto-generated method stub
		return menudao.addMenu(menu);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

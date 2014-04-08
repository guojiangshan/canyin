package cn.canyin.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.canyin.dao.BaseDao;
import cn.canyin.dao.MenuDao;
import cn.canyin.model.Menu;
import cn.canyin.service.impl.RedisClient;



public class MenuDaoImpl extends BaseDao implements MenuDao {

	private static Logger logger = Logger.getLogger(MenuDaoImpl.class);
	private RedisClient redisClient;

	@Override
	public List<Menu> getByRestaurantId(long r_id) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSessionRead().selectList("cn.canyin.model.Menu.queryByRId", r_id);
	}

	@Override
	public Menu getById(long r_id, long m_id) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Long> _query = new HashMap<String, Long>();
		_query.put("r_id", r_id);
		_query.put("m_id", m_id);
		return this.getSqlSessionRead().selectOne("cn.canyin.model.Menu.queryById", _query);
	}

	@Override
	public long addMenu(Menu menu) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSessionWriter().insert("cn.canyin.model.Menu.insertMenu", menu);
	}

}

package cn.canyin.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.canyin.dao.BaseDao;
import cn.canyin.dao.OrderDao;
import cn.canyin.model.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	
	
	@Override
	public List<Order> getROrderByOrderStatus(long rid, int statu)
			throws Exception {
		// TODO Auto-generated method stub
		Map<String, Number> map=new HashMap<String, Number>();
		map.put("rid", rid);
		map.put("statu", statu);
		return this.getSqlSessionRead().selectList("cn.canyin.model.Order.queryByOrderStatus", map);
	}

	@Override
	public List<Order> getROrderByRestaurantId(long rid) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSessionRead().selectList("cn.canyin.model.Order.queryByRestaurantId", rid);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Order getOrderById(long oid) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSessionRead().selectOne("cn.canyin.model.Order.queryByOId", oid);
	}

	@Override
	public long addOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSessionWriter().insert("cn.canyin.model.Order.insertOrder", order);
	}

}

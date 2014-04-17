package cn.canyin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.canyin.dao.OrderDao;
import cn.canyin.model.Order;
import cn.canyin.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private static Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public List<Order> getROrderByOrderStatus(long rid, int statu)
			throws Exception {
		// TODO Auto-generated method stub
		return orderDao.getROrderByOrderStatus(rid, statu);
	}

	@Override
	public List<Order> getROrderByRestaurantId(long rid) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.getROrderByRestaurantId(rid);
	}


	@Override
	public Order getOrderById(long oid) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.getOrderById(oid);
	}

	@Override
	public long addOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.addOrder(order);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

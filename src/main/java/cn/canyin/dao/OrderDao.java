package cn.canyin.dao;

import java.util.List;

import cn.canyin.model.Order;

public interface OrderDao extends Dao{
	
	public List<Order> getROrderByOrderStatus(long rid, int statu) throws Exception;
	
	public List<Order> getROrderByRestaurantId(long rid) throws Exception;
	
	public Order getOrderById(long oid) throws Exception;
	
	public long addOrder(Order order) throws Exception;
}

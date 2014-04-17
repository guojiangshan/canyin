package cn.canyin.service;

import java.util.List;
import cn.canyin.model.Order;

public interface OrderService extends Service{
	/**
	 * get the order for one restaurant
	 * */
	public List<Order> getROrderByOrderStatus(long rid, int statu) throws Exception;
	
	public List<Order> getROrderByRestaurantId(long rid) throws Exception;
	
	public Order getOrderById(long oid) throws Exception;
	
	public long addOrder(Order order) throws Exception; 
}

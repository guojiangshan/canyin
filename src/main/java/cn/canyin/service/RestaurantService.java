package cn.canyin.service;


import cn.canyin.model.Restaurant;

public interface RestaurantService {
	//private static Logger logger = Logger.getLogger(Shan);
	public Restaurant getRestaurantByRID(Long r_id) throws Exception;
	public Restaurant getRestaurantBySDWXID(String r_wxid) throws Exception;
	public Long addRestaurant(Restaurant restaurant) throws Exception;
}

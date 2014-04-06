package cn.canyin.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.canyin.dao.RestaurantDao;
import cn.canyin.model.Restaurant;
import cn.canyin.service.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {

	private static Logger logger = Logger.getLogger(RestaurantServiceImpl.class);
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Override
	public Restaurant getRestaurantByRID(Long r_id) throws Exception {
		// TODO Auto-generated method stub
		return restaurantDao.findByRId(r_id);
	}

	@Override
	public Restaurant getRestaurantBySDWXID(String r_wxid) throws Exception {
		// TODO Auto-generated method stub
		return restaurantDao.findByWechatId(r_wxid);
	}

	@Override
	public Long addRestaurant(Restaurant restaurant) throws Exception {
		// TODO Auto-generated method stub
		return restaurantDao.add(restaurant);
	}
	
	
	
}

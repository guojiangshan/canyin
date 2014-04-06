package cn.canyin.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.canyin.dao.BaseDao;
import cn.canyin.dao.RestaurantDao;
import cn.canyin.model.Restaurant;
import cn.canyin.service.impl.RedisClient;


public class RestaurantDaoImpl extends BaseDao implements RestaurantDao {

	private static Logger logger = Logger.getLogger(RestaurantDaoImpl.class);
	private RedisClient redisClient;
	
	@Override
	public Restaurant findByRId(long r_id) throws Exception {
		// TODO Auto-generated method stub
		
		return (Restaurant)this.getSqlSessionWriter().selectOne("cn.canyin.model.Restaurant.queryByRId", r_id);
	}

	

	@Override
	public Restaurant findByWechatId(String r_wechatid) throws Exception {
		// TODO Auto-generated method stub
		return (Restaurant)this.getSqlSessionWriter().selectOne("cn.canyin.model.Restaurant.queryByWechatId", r_wechatid);
	}

	@Override
	public long add(Restaurant sd) throws Exception {
		// TODO Auto-generated method stub
		try{
			 return this.getSqlSessionWriter().insert("cn.canyin.model.Restaurant.insertRestaurant", sd);
		}catch(Exception e){
			logger.error(e);
			throw e;
		}
	}

	
	public RedisClient getRedisClient() {
		return redisClient;
	}

	public void setRedisClient(RedisClient redisClient) {
		this.redisClient = redisClient;
	}
}

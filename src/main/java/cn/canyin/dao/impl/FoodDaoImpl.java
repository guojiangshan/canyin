package cn.canyin.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.canyin.dao.BaseDao;
import cn.canyin.dao.FoodDao;
import cn.canyin.dao.MenuDao;
import cn.canyin.model.Food;
import cn.canyin.model.Menu;
import cn.canyin.service.impl.RedisClient;



public class FoodDaoImpl extends BaseDao implements FoodDao {

	private static Logger logger = Logger.getLogger(FoodDaoImpl.class);
	private RedisClient redisClient;
	@Override
	public Food getByFID(long fid) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSessionRead().selectOne("cn.canyin.model.Food.queryByFId", fid);
	}
	@Override
	public List<Food> getByFoodName(String fname) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSessionRead().selectList("cn.canyin.model.Food.queryByFName", fname);
	}
	
	@Override
	public long addFood(Food food) throws Exception {
		// TODO Auto-generated method stub
		return this.getSqlSessionWriter().insert("cn.canyin.model.Food.insertFood", food);
	}


}

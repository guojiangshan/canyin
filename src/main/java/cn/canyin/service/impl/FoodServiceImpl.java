package cn.canyin.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import cn.canyin.dao.FoodDao;
import cn.canyin.model.Food;
import cn.canyin.service.FoodService;

public class FoodServiceImpl implements FoodService {
	
	private static Logger logger = Logger.getLogger(FoodServiceImpl.class);
	
	@Autowired
	private FoodDao foodDao;

	@Override
	public Food getByFID(long fid) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Enter FoodServiceImpl.getByFID method");
		return foodDao.getByFID(fid);
	}

	@Override
	public List<Food> getByFoodName(String fname) throws Exception {
		// TODO Auto-generated method stub
		return foodDao.getByFoodName(fname);
	}

	@Override
	public long addFood(Food food) throws Exception {
		// TODO Auto-generated method stub
		return foodDao.addFood(food);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

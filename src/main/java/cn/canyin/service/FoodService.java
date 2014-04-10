package cn.canyin.service;

import java.util.List;

import cn.canyin.model.Food;

public interface FoodService extends Service {

	public Food getByFID(long fid) throws Exception;
	
	public List<Food> getByFoodName(String fname) throws Exception;
	
	public long addFood(Food food) throws Exception;

}

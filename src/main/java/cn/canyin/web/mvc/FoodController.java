package cn.canyin.web.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.canyin.model.Food;
import cn.canyin.service.FoodService;
import cn.canyin.service.impl.RedisClient;

@Controller
@RequestMapping(value = "/Food")
public class FoodController {
	public static Logger logger = Logger.getLogger(RestaurantController.class);
	@Autowired
	private RedisClient redisClient;
	
	@Autowired
	private FoodService foodService;
	/**
	 * @param args
	 */
	
	@RequestMapping(value="/getByFID", method=RequestMethod.POST)
	public ModelAndView getByFID(@RequestParam(value="f_id", required=true)long f_id,
			ModelMap modelMap, HttpServletRequest req, HttpServletResponse response){
		ModelMap mp = new ModelMap();
		Food food = null;
		Object object = redisClient.get(String.valueOf(f_id));
		if(object == null){
			try {
				food = foodService.getByFID(f_id);
				redisClient.put("fid:"+f_id, food);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("get food by id:"+f_id +" failed!",  e);
				mp.addAttribute("result", "get food by id:"+f_id +" failed!");
				return new ModelAndView("/food/error",mp);
				
			}
		}else{
			food = (Food) object;
		}
		mp.addAttribute("food", food);
		return new ModelAndView("/food/showfood",mp);
	}
	
	@RequestMapping(value="/getByFName")
	public ModelAndView getByFName(@RequestParam(value="f_name", required=true)String f_name,
			ModelMap modelMap, HttpServletRequest req, HttpServletResponse response){
		ModelMap mp = new ModelMap();
		
		List list = null;
		Object object = redisClient.get("f_name:"+f_name);
		
		if(object==null){
			try {
				list = foodService.getByFoodName(f_name);
				redisClient.put("f_name:"+f_name, list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("get by food name:"+ f_name +" failed!", e);
				mp.addAttribute("result", "get by food name:"+ f_name +" failed!");
				return new ModelAndView("/food/error",mp);
			}
			
		} else {
			list = (List) object;
		}
		
		mp.addAttribute("foods", list);
		
		return new ModelAndView("/food/showfoods",mp );
	}
	
	@RequestMapping(value="/addFood")
	public ModelAndView addFood(@RequestParam(value="f_name", required=true)String f_name,
			@RequestParam(value="f_kind", required=true)String f_kind,
			@RequestParam(value = "createtime", required = false)String createtime,
			@RequestParam(value = "updatetime", required = false)String updatetime,
			@RequestParam(value = "r_id", required = false)long r_id,
			ModelMap modelMap, HttpServletRequest req, HttpServletResponse response){
		long f_id = 0L; 
		ModelMap mp = new ModelMap();
		Food food = new Food();
		food.setF_kind(f_kind);
		food.setF_name(f_name);
		food.setR_id(r_id);
		//food.setCreatetime(createtime);
		//food.setUpdatetime(updatetime);
		try {
			f_id = foodService.addFood(food);
			food.setF_id(f_id);
			redisClient.put("f_id:"+f_id, food);
			mp.addAttribute("food", food);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("add food failed", e);
			mp.addAttribute("result", "add food failed");
			return new ModelAndView("/food/error",mp);
		}
		
		
		return new ModelAndView("/food/index",mp);
	}
	
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(){
		return "/food/index";
	}
	
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String showfood(){
		return "/food/addfood";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

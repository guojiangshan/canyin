package cn.canyin.web.mvc;

import javax.servlet.http.HttpServletRequest;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import cn.canyin.model.Restaurant;
import cn.canyin.service.RestaurantService;
import cn.canyin.service.impl.RedisClient;


@Controller
@RequestMapping(value = "/Restaurant")
public class RestaurantController {
	public static Logger logger = Logger.getLogger(RestaurantController.class);
	@Autowired
	private RedisClient redisClient;

	@Autowired
	private RestaurantService restaurantService;
	


	/**
	 * 注册成功页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getbyrid" , method = RequestMethod.POST)
	public String showRestaurant(
			@RequestParam(value = "r_id", required = false)long r_id,
			HttpServletRequest req) {
		//Long sd_id = Long.parseLong(CookieUtil.getCookieByName(req, "sd_id"));
		System.out.println("1234");
		try {
			Restaurant restaurant = restaurantService.getRestaurantByRID(r_id);
			req.setAttribute("restaurant", restaurant);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "/restaurant/showrestaurant";
	}
	
	@RequestMapping(value = "/index")
	public String index(
			HttpServletRequest req) {
		//Long sd_id = Long.parseLong(CookieUtil.getCookieByName(req, "sd_id"));
		System.out.println("index");
		
		return "/restaurant/index";
	}
}

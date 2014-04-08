package cn.canyin.web.mvc;

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
		Restaurant restaurant=null;
		Object object;
		object = redisClient.get("restaurant:"+r_id);
		if(null==object){
			try {
				restaurant = restaurantService.getRestaurantByRID(r_id);
				if(null==restaurant) return "/restaurant/error";
				//req.setAttribute("restaurant", restaurant);
				redisClient.put("restaurant:"+r_id, restaurant);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				return "/restaurant/error";
			}
		} else{
			restaurant = (Restaurant) object;
		}
		req.setAttribute("restaurant", restaurant);
		;
		return "/restaurant/showrestaurant";
	}

	
	@RequestMapping(value = "/addrestaurant" , method = RequestMethod.POST)
	public ModelAndView addRestaurant(
			@RequestParam(value = "r_name", required = false)String r_name,
			@RequestParam(value = "r_totseatnum", required = false)int r_totseatnum,
			@RequestParam(value = "r_adress", required = false)String r_adress,
			@RequestParam(value = "r_post", required = false)String r_post,
			@RequestParam(value = "r_phone", required = false)String r_phone,
			@RequestParam(value = "r_wechatid", required = false)String r_wechatid,
			@RequestParam(value = "r_mail", required = false)String r_mail,
			@RequestParam(value = "create_time", required = false)String create_time,
			@RequestParam(value = "update_time", required = false)String update_time,
			@RequestParam(value = "r_owner", required = false)String r_owner,
			@RequestParam(value = "r_status", required = false)String r_status,
			ModelMap modelMap, HttpServletRequest req, HttpServletResponse response
			){
		Restaurant rtrt = new Restaurant();
		long r_id = 0;
		rtrt.setR_name(r_name);
		rtrt.setR_totseatnum(r_totseatnum);
		rtrt.setR_adress(r_adress);
		rtrt.setR_post(r_post);
		rtrt.setR_phone(r_phone);
		rtrt.setR_wechatid(r_wechatid);
		rtrt.setR_mail(r_mail);
		//rtrt.setCreatetime(create_time);
		//rtrt.setUpdatetime(updatetime);
		rtrt.setR_owner(r_owner);
		rtrt.getR_status();
		
		try {
			r_id = restaurantService.addRestaurant(rtrt);
			logger.info("新添加的饭店 id 是： "+ r_id);
			redisClient.put("restaurant:"+r_id, rtrt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(), e);
			modelMap.addAttribute("resultMsg", "没有添加成功！");
			return new ModelAndView("redirect:/Restaurant/addrestaurant", modelMap);
		}
		modelMap.addAttribute("resultMsg", "添加成功！");
		return new ModelAndView("redirect:/Restaurant/index",modelMap);
	}
	
	
	@RequestMapping(value = "/index")
	public String index(
			HttpServletRequest req) {
		//Long sd_id = Long.parseLong(CookieUtil.getCookieByName(req, "sd_id"));
		System.out.println("index");
		
		return "/restaurant/index";
	}
	
	@RequestMapping(value = "/add")
	public String add(
			HttpServletRequest req) {
		//Long sd_id = Long.parseLong(CookieUtil.getCookieByName(req, "sd_id"));
		System.out.println("add");
		
		return "/restaurant/addrestaurant";
	}
}

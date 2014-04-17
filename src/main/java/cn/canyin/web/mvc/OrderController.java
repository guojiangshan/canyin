package cn.canyin.web.mvc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.canyin.model.Order;
import cn.canyin.service.MenuService;
import cn.canyin.service.OrderService;
import cn.canyin.service.impl.RedisClient;

@Controller
@RequestMapping(value = "/Order")
public class OrderController {

	
	public static Logger logger = Logger.getLogger(OrderController.class);
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	RedisClient redisClient;
	
	@RequestMapping(value="/getOrderById", method=RequestMethod.POST)
	public ModelAndView getOrderById(@RequestParam(value="o_id",required=true)long o_id){
		logger.info("enter the show Order by id method");
		Object object = redisClient.get("o_id:"+o_id);
		ModelMap mp = new ModelMap();
		Order order = null;
		if(object==null){
			try {
				order = orderService.getOrderById(o_id);
				mp.put("order", order);
				redisClient.put("o_id:"+o_id, order);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mp.put("resuleMsg", "get order by id"+o_id+" failed");
				logger.error("get order by id"+o_id+" failed", e);
				return new ModelAndView("/order/error", mp);
			}
		}else{
			order = (Order) object;
			mp.put("order", order);
		}

		return new ModelAndView("/order/showOrder", mp);
	}
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("/Order/index");
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add(){
		return new ModelAndView("/Order/addOrder");
	}
	
	
	//getOrder
	//generate order
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

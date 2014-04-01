package cn.canyin.web.mvc;

import javax.servlet.http.HttpServletRequest;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import cn.canyin.model.Shangdian;
import cn.canyin.service.ShangdianService;
import cn.canyin.service.impl.RedisClient;


@Controller
@RequestMapping("/shop")
public class ShangdianController {
	public static Logger logger = Logger.getLogger(ShangdianController.class);
	@Autowired
	private RedisClient redisClient;

	@Autowired
	private ShangdianService shangdianService;
	


	/**
	 * 注册成功页面
	 * 
	 * @return
	 */
	@RequestMapping("/getbysdid")
	public String showShangdian(
			@RequestParam(value = "sd_id", required = false)long sd_id,
			HttpServletRequest req) {
		//Long sd_id = Long.parseLong(CookieUtil.getCookieByName(req, "sd_id"));
		try {
			Shangdian shangdian = shangdianService.getShagndianBySdID(sd_id);
			req.setAttribute("shangdian", shangdian);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "/shop/showshangdian";
	}
}

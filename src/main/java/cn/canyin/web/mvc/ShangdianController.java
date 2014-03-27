package cn.canyin.web.mvc;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.msgpack.rpc.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.canyin.model.Shangdian;
import cn.canyin.service.ShangdianService;
import cn.canyin.service.impl.RedisClient;
import cn.canyin.util.CookieUtil;

@Controller
@RequestMapping("/shangdian")
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
		return "/shangdian/showshangdian";
	}
}

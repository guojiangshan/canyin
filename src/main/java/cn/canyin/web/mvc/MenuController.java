package cn.canyin.web.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.apache.log4j.Logger;

import cn.canyin.model.Menu;
import cn.canyin.service.MenuService;
import cn.canyin.service.impl.RedisClient;

@Controller
@RequestMapping(value = "/Menu")
public class MenuController {
	
	public static Logger logger = Logger.getLogger(MenuController.class);
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	RedisClient redisClient;
	//show menu
	@RequestMapping(value="/getbyrid", method=RequestMethod.POST)
	public ModelAndView showRestaurantMenus(
			@RequestParam(value="r_id", required=true)long r_id,
			ModelMap modelMap, HttpServletRequest req, HttpServletResponse response
			){
		List list;
		Object object = null; //list
		object = redisClient.get("menuList:"+r_id);
		if(null==object){
			try {
				list = menuService.getByRestaurantId(r_id);
				redisClient.put("menuList"+r_id, list);
				//modelMap.addAttribute("menuList"+r_id, list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage(), e);
				modelMap.addAttribute("resultMsg", "显示失败！");
				return new ModelAndView("/menu/showmenu",modelMap);
			}
			
		}else{
			list = (List) object;
			//modelMap.addAttribute("menuList"+r_id, list);
		}
		modelMap.addAttribute("menuList"+r_id, list);
		return new ModelAndView("/menu/showmenu",modelMap);
		//return "/menu/showmenu";
	}
	//generate menu
	

	@RequestMapping(value="/getbyid", method=RequestMethod.POST)
	public ModelAndView showMenu(@RequestParam(value="m_id", required=true)long m_id,
			@RequestParam(value="r_id", required=true)long r_id,
			ModelMap modelMap, HttpServletRequest req, HttpServletResponse response
			){
		Menu menu;
		Object object = null; //list
		object = redisClient.get("menu rid:"+r_id+",m_id:"+m_id);
		if(null==object){
			try {
				menu = (Menu) menuService.getById(r_id, m_id);
				redisClient.put("menu rid:"+r_id+",m_id:"+m_id, menu);
				//modelMap.addAttribute("menuList"+r_id, list);
				if(null==menu) return new ModelAndView("/menu/error");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e.getMessage(), e);
				modelMap.addAttribute("resultMsg", "显示失败！");
				return new ModelAndView("/menu/showmenu",modelMap);
			}
		}else{
			menu = (Menu) object;
			//modelMap.addAttribute("menuList"+r_id, list);
		}
		//modelMap.addAttribute("menu rid:"+r_id+",m_id:"+m_id, menu);
		modelMap.addAttribute("menu", menu);
		modelMap.addAttribute("r_id", r_id);
		modelMap.addAttribute("m_id", m_id);
		return new ModelAndView("/menu/showmenu",modelMap);
		//return "/menu/showmenu";
	}
	
	
	@RequestMapping(value="/addmenu", method=RequestMethod.POST)
	public ModelAndView addMenu(
			//@RequestParam(value = "m_id", required = false)long m_id,
			@RequestParam(value = "m_name", required = false)String m_name,
			@RequestParam(value = "createtime", required = false)String createtime,
			@RequestParam(value = "updatetime", required = false)String updatetime,
			@RequestParam(value = "r_id", required = false)long r_id,
			ModelMap modelMap, HttpServletRequest req, HttpServletResponse response
			){
		
		Menu menu = new Menu();
		long menuid = 0;
		//menu.setCreatetime(createtime)
		//menu.setM_id(m_id);
		menu.setM_name(m_name);
		menu.setR_id(r_id);
		
		//menu.setUpdatetime(updatetime);
		
		try {
			menuid = menuService.addMenu(menu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("resultMsg", e);
			return new ModelAndView("/menu/error");
		}
		redisClient.put("menu:"+menuid, menu);
		
		return new ModelAndView("/menu/index");
	}
	
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String showIndex(){
		
		return "/menu/index";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String showAdd(){
		
		return "/menu/addmenu";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

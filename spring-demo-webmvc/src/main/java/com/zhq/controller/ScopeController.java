package com.zhq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author ZHQ
 * @date 2022/06/13 20:33
 */
@Controller
@RequestMapping("/scope")
public class ScopeController {

	/**
	 * 通过servlet原生api将数据共享到request域中
	 */
	@RequestMapping("/servletAPI")
	public String servletAPI(HttpServletRequest request){
		request.setAttribute("success", "成功");

		return "success";
	}

	/**
	 * ModelAndView作为返回值
	 * 通过返回ModelAndView对象，将数据共享到request作用域
	 */
	@RequestMapping("/modelAndView")
	public ModelAndView modelAndView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("success", "成功");

		modelAndView.setViewName("success");

		return modelAndView;
	}

	/**
	 * 通过Model对象，将数据共享到request作用域
	 */
	@RequestMapping("/model")
	public String model(Model model){
		model.addAttribute("success", "成功");

		return "success";
	}

	/**
	 * 通过Map对象，将数据共享到request作用域
	 */
	@RequestMapping("/map")
	public String map(Map<String, Object> map){
		map.put("success", "成功");

		return "success";
	}

	/**
	 * 通过ModelMap对象，将数据共享到request作用域
	 */
	@RequestMapping("/modelMap")
	public String modelMap(ModelMap modelMap){
		modelMap.addAttribute("success", "成功");

		return "success";
	}

	//Model、ModelMap和Map本质上都是通过BindingAwareModelMap类型

	/**
	 * 通过原生HttpSession将数据共享到session作用域
	 */
	@RequestMapping("/session")
	public String session(HttpSession session){
		session.setAttribute("success", "成功");

		return "success";
	}

	/**
	 * 通过原生HttpSession获取ServletContext对象，在将数据共享到ServletContext作用域
	 */
	@RequestMapping("/application")
	public String application(HttpSession session){
		ServletContext servletContext = session.getServletContext();
		servletContext.setAttribute("success", "成功");

		return "success";
	}
}

package com.zhq.controller;

import com.zhq.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ZHQ
 * @date 2022/06/13 16:27
 */
@Controller
@RequestMapping("returnValue")
public class ReturnValueController {

	/**
	 * ModelAndView对象，处理器方法中所有的返回值最后都会封装为ModelAndView对象
	 * Model表示数据，会将数据存在到request作用域中
	 * View表示视图，相当于转发操作
	 */
	@RequestMapping("/modelAndView")
	public ModelAndView modelAndView(){
		ModelAndView modelAndView = new ModelAndView();
		//添加数据
		modelAndView.addObject("success", "成功");
		//设置视图，相当于转发，因为声明了视图解析器可以直接写逻辑名称
		modelAndView.setViewName("success");

		return modelAndView;
	}

	/**
	 * String表示视图，相当于转发操作
	 * 要想想request作用域中添加参数，需要额外使用形参
	 */
	@RequestMapping("/string")
	public String string(){
		return "success";
	}

	/**
	 * String联合ResponseBody注解表示数据(text格式，并非json格式)，存储在request作用域中
	 * 要想实现转发操作需要使用HttpServletRequest参数实现原生的转发操作
	 */
	@ResponseBody
	@RequestMapping("/stringBody")
	public String stringBody(){
		return "success";
	}

	/**
	 * void既不表示视图，也不表示数据
	 * 可以使用原生的HttpServletResponse参数实现原生的Ajax操作
	 */
	@RequestMapping("/voidTest")
	public void voidTest(){

	}

	/**
	 * Object表示数据，要和@ResponseBody注解连用，表示返回的json数据
	 * 需要在配置文件中配置注解驱动 <mvc:annotation-driven/> 完成对象到json格式的转换
	 */
	@ResponseBody
	@RequestMapping("/object")
	public User object(){
		User user = new User();
		user.setUsername("张贺强");
		return user;
	}

}

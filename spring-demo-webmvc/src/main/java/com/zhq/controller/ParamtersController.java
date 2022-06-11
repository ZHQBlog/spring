package com.zhq.controller;

import com.zhq.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZHQ
 * @date 2022/06/13 17:16
 */
@Controller
@RequestMapping("/paramters")
public class ParamtersController {

	/**
	 * 将HttpServletRequest作为请求参数，获取参数值
	 * @param request
	 * @return
	 */
	@RequestMapping("/servletAPI")
	public String servletAPI(HttpServletRequest request){
		String username = request.getParameter("username");
		System.out.println(username);

		return "success";
	}

	/**
	 * 通过控制器方法的形参获取数据（形参名和参数名保持一致）
	 * 获取的参数能够自动进行类型转换
	 */
	@RequestMapping("/controllerParame")
	public String controllerParame(String username){
		System.out.println(username);

		return "success";
	}

	/**
	 * @RequestParam将请求的参数和控制器方法的形参形成映射
	 * value：请求的参数名
	 * required：是否必须存在传入该参数
	 * defaultValue：当没有获取到参数时设置默认值
	 */
	@RequestMapping("/requestParame")
	public String requestParame(@RequestParam(value = "username", required = true,
			defaultValue = "zhq") String name){
		System.out.println(name);

		return "success";
	}

	/**
	 * @RequestHeader将请求头信息和控制器方法的形参形成映射
	 * value：请求头信息的key
	 * required：是否必须存在传入该参数
	 * defaultValue：当没有获取到参数时设置默认值
	 */
	@RequestMapping("/requestHeader")
	public String requestHeader(@RequestHeader(value = "Host", required = true,
								defaultValue = "null") String host){
		System.out.println(host);

		return "success";
	}

	/**
	 * @CookieValue将cookie中的数据和控制器方法的形参形成映射
	 * value：cookie的key
	 * required：是否必须存在传入该参数
	 * defaultValue：当没有获取到参数时设置默认值
	 */
	@RequestMapping("/cookieValue")
	public String cookieValue(@CookieValue(value = "username", required = false,
			defaultValue = "null") String name){
		System.out.println(name);

		return "success";
	}

	/**
	 * 通过对象将获取的参数进行自动封装
	 * 对象中要存在get和set方法
	 * 参数名和对象的属性名相同
	 */
	@RequestMapping("/pojo")
	public String pojo(User user){
		System.out.println(user);

		return "success";
	}
}

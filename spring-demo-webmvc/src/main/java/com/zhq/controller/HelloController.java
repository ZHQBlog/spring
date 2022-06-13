package com.zhq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ZHQ
 * @date 2022/06/12 17:43
 */
@Controller //标记一个类为控制器
@RequestMapping("/hello")  //作用在类上，指定请求的公共路径
public class HelloController {

	/**
	 * @RequestMapping：作用在方法上，指定请求路径，将请求和方法进行映射
	 * value属性：指定请求的地址(/开头)，数组类型（可以指定多个请求路径） 支持Ant风格(?, *, **)
	 * method属性：指定请求的方法类型（不指定所有请求类型均可）
	 * params属性：指定请求的参数的规则（是否携带，携带什么值）
	 * headers属性：指定请求的请求头信息的规则（是否携带，携带的请求头）
	 */
	@RequestMapping(value = {"/hello1", "test"})
	public String hello1(){
		return "success";
	}

	@RequestMapping(value = {"/hello2"}, method = {RequestMethod.POST, RequestMethod.GET})
	public String hello2(){
		return "success";
	}

	//必须存在username参数，不存在password参数
	@RequestMapping(value = {"/hello3"}, params = {"username", "!password"})
	public String hello3(){
		return "success";
	}

	//必须存在username参数并且参数值必须是zhq
	@RequestMapping(value = {"/hello4"}, params = {"username=zhq"})
	public String hello4(){
		return "success";
	}

	//必须携带host请求头信息
	@RequestMapping(value = {"/hello5"}, headers = {"host"})
	public String hello5(){
		return "success";
	}

}

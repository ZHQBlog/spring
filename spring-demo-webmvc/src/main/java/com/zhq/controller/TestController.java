package com.zhq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author ZHQ
 * @date 2022/06/13 21:01
 */
@Controller
public class TestController {

	@PutMapping("/test01")
	public String test01(){

		return "success";
	}
}

package com.zhq.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author ZHQ
 * @date 2022/06/13 21:41
 */

//异常处理器类
@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler()
	public String handleArithmeticException(Exception ex, Model model){
		model.addAttribute("ex", ex);

		return "error";
	}
}

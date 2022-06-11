package com.zhq.annotationaspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author ZHQ
 * @date 2022/06/10 20:34
 */
@Component
@Aspect //设置为切面类
public class UserProxy {

	//前置通知
	@Before("execution(* com.zhq.annotationaspectj.User.add(..))")
	public void before(){
		System.out.println("UserProxy--before");
	}
}

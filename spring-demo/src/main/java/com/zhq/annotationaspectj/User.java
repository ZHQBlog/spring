package com.zhq.annotationaspectj;

import org.springframework.stereotype.Component;

/**
 * @author ZHQ
 * @date 2022/06/10 22:05
 */
@Component
public class User {

	public String add(){
		System.out.println("User--add");
		//int a = 10/0;
		return "val";
	}
}

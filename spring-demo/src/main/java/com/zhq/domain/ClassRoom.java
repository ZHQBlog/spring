package com.zhq.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Objects;

/**
 * @author ZHQ
 * @date 2022/06/10 09:25
 */
public class ClassRoom implements BeanNameAware, ApplicationContextAware,
		BeanPostProcessor {
	private String id;
	private String name;
	private ApplicationContext applicationContext;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClassRoom{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", applicationContext=" + applicationContext +
				'}';
	}

	//获取bean的id
	@Override
	public void setBeanName(String name) {
		this.id = name;
	}

	//获取ApplicationContext
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization()方法");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization()方法");
		return bean;
	}

	public void init(){
		System.out.println("初始化方法");
	}

	public void destroy(){
		System.out.println("销毁方法");
	}
}

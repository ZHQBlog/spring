package com.zhq;


import com.zhq.domain.ClassRoom;
import com.zhq.domain.CollectionTest;
import com.zhq.domain.CollectionUser;

import com.zhq.tx.User;
import com.zhq.tx.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Spring框架的优点：
 * 1.轻量级的开源框架，可以集成各种框架
 * 2.封装了很多API，简化了开发，比如JDBCTemplate
 * 3.AOP面向切面编程，通过代理对方法进行增强，可以把应用业务逻辑和系统服务分开
 * 4.IOC控制反转，实现了松散耦合，对象的创建和调用过程都通过容器进行管理；DI依赖注入就是IOC容器的实现
 * 5.支持声明式事务，只需要配置就可以对事务进行管理
 * 6.封装了异常处理机制
 */

/**
 * Spring框架中的设计模式：
 * 工厂模式：BeanFactory、ApplicationContext创建对象
 * 代理模式：Spring的AOP（静态代理，动态代理）
 * 单例模式：默认Bean是单例的
 * 模板方法：比如JdbcTemplate
 * 装饰器模式：
 * 观察者模式：事件驱动
 * 适配器模式：AOP中的通知，SpringMVC中的Controller
 */

/**
 * TODO 循环依赖
 */
public class SpringApplication {
	public static void main(String[] args) {
		/**
		 * 获取IOC容器：
		 * BeanFactory：IOC容器的根接口，对象懒加载，加载配置文件时不创建对象
		 * ApplicationContext：BeanFactory的子接口，对象即时加载，加载配置文件时创建所有对象，实现了更强大的功能（支持基于依赖的注解）
		 * ClassPathXMLApplicationContext：ApplicationContext的子类，相对路径加载配置文件（src路径）
		 *
		 * DI依赖注入：
		 * 由容器动态的将依赖关系注入到组件中，不需要知道资源来自哪里
		 */

		/*AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		User user = (User) applicationContext.getBean("userAuto");
		System.out.println(user);
		CollectionTest collectionList = (CollectionTest) applicationContext.getBean("collectionList");
		System.out.println(collectionList);
		CollectionUser collectionUser = (CollectionUser) applicationContext.getBean("collectionUser");
		System.out.println(collectionUser);
		ClassRoom classRoomScope1 = (ClassRoom) applicationContext.getBean("classRoomScope");
		ClassRoom classRoomScope2 = (ClassRoom) applicationContext.getBean("classRoomScope");
		System.out.println(classRoomScope1.equals(classRoomScope2));

		ClassRoom classRoomScope = (ClassRoom) applicationContext.getBean("classRoomScope");
		System.out.println(classRoomScope);
		applicationContext.close();*/

		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotationBean.xml");
		User user = (User) applicationContext.getBean("user");
		System.out.println(user);*/

		//speing源码使用aspectj，要设置使用aspect编辑器（Ajc）

		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aspectj.xml");
		User user = (User) applicationContext.getBean("user");
		user.add();*/

		/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotationAspectj.xml");
		User user = (User) applicationContext.getBean("user");
		user.add();*/

		/**
		 * 事务是数据库操作的基本单位，要么同时成功，要么同时失败
		 * 事务的四个特征：原子性，一致性，隔离性，持久性
		 * 实现方式：编程式，声明式
		 */
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tx.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		//userService.add(new User("haha", "123"));
		//userService.update();
		/*List<User> users = userService.queryUsers();
		for (User user : users) {
			System.out.println(user);
		}*/
		userService.test(new User("狗子", "123"), 1, new User("狗蛋", "1234"), 2);
	}
}

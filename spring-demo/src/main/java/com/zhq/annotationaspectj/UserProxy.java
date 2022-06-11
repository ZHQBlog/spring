package com.zhq.annotationaspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ZHQ
 * @date 2022/06/10 20:34
 */
@Component
@Aspect //设置为切面类
@Order(1) //来设置增强类的优先级，数字越小优先级越高
public class UserProxy {

	//抽取切入点
	@Pointcut("execution(* com.zhq.annotationaspectj.User.add(..))")
	public void point(){}

	//前置通知，方法执行之前执行
	@Before("point()")
	public void before(JoinPoint joinPoint){
		System.out.println("前置通知");
		System.out.println("切点应用的目标"+joinPoint.getSignature());
	}

	//后置通知，方法执行之后执行，returning属性获取方法的返回值并封装到形参
	@AfterReturning(value = "point()", returning = "resultValue")
	public void afterReturning(JoinPoint joinPoint, String resultValue){
		System.out.println("后置通知");
		System.out.println("切点应用的目标"+joinPoint.getSignature());
		System.out.println("方法返回值："+resultValue);
	}

	//环绕通知，方法执行前后都会执行，形参添加ProceedingJoinPoint用来调用原方法
	@Around(value = "point()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("环绕通知，前");
		//执行原方法
		Object proceed = null;
		try {
			proceed = proceedingJoinPoint.proceed();
			System.out.println("环绕通知，后");

			return proceed;
		} catch (Throwable e) {
			e.printStackTrace();
			return proceed;
		}
	}

	//最终通知，无论有没有异常都在方法执行之后执行
	@After(value = "point()")
	public void after(JoinPoint joinPoint){
		System.out.println("最终通知");
		System.out.println("切点应用的目标"+joinPoint.getSignature());
	}

	//异常通知，方法出现异常时执行，throwing属性获取方法出现异常并封装到形参
	@AfterThrowing(value = "point()", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Throwable exception){
		System.out.println("异常通知");
		System.out.println("切点应用的目标"+joinPoint.getSignature());
		System.out.println("异常：" + exception);
	}
}

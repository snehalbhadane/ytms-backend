package com.yash.ytms.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * This class will declare and define the aspect for TRFServiceImpl 
 * @author dheerendra.kag
 *
 */
@Aspect
@Component
public class TRFServiceAspect {

	/**
	 * 
	 * @param joinPoint a point in Spring AOP during the execution of a program, such as updateTRF,getTRFById method in this case
	 * @param ex is an exception
	 */
	@AfterThrowing(value="execution(* com.yash.ytms.serviceImpl.TRFServiceImpl.*(..))", throwing = "ex")
	public void afterThrowingAdviceForTRF(JoinPoint joinPoint, Exception ex) {
		System.out.println("After throwing exception in method:"+joinPoint.getSignature());
		System.out.println("Exception is:"+ex.getMessage());
	}
}

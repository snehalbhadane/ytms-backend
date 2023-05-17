package com.yash.ytms.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.yash.ytms.config.LoggerConfiguration;

/**
 * This class will declare and define the aspect for TRFServiceImpl 
 * @author dheerendra.kag
 *
 */
@Aspect
@Component
public class TRFServiceAspect {

	private Logger logger = LoggerConfiguration.getLogger(TRFServiceAspect.class);
	
	/**
	 * 
	 * @param joinPoint a point in Spring AOP during the execution of a program, such as updateTRF,getTRFById method in this case
	 * @param ex is an exception
	 */
	@AfterThrowing(value="execution(* com.yash.ytms.serviceImpl.TRFServiceImpl.*(..))", throwing = "ex")
	public void afterThrowingAdviceForTRF(JoinPoint joinPoint, Exception ex) {
		logger.info("After throwing exception in method - {} "+joinPoint.getSignature());
		logger.info("Exception is - {} "+ex.getMessage());
	}
}

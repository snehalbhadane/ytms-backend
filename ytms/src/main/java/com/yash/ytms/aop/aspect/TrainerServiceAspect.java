package com.yash.ytms.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.yash.ytms.config.LoggerConfiguration;

/**
 * This class will declare and define the aspect for TrainerServiceImpl 
 * @author Mohammad.Sadav.Khan
 *
 */
@Aspect
@Component
public class TrainerServiceAspect {
	
	private Logger logger = LoggerConfiguration.getLogger(TrainerServiceAspect.class);

	/**
	 * @param Joinpoint is a point of execution of the program, such as executing a method or handling an exception. 
	 * @param ex is an exception.
	 * Method is applicable only for TrainerServiceImpl class methods.
	 */
	@AfterThrowing(value = "execution(* com.yash.ytms.serviceImpl.TrainerServiceImpl.*(..))", throwing = "ex")
	public void afterThrowingAdviceForTrainer(JoinPoint joinPoint, Exception ex) {
		logger.info("Method will call after throwing exception :" + joinPoint.getSignature());
		logger.info("Excetion Message :" + ex.getMessage());
		logger.info("Exception Code : "+HttpStatus.NOT_FOUND);
	}
}
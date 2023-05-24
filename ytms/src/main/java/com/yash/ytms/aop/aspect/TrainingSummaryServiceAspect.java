package com.yash.ytms.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.yash.ytms.config.LoggerConfiguration;


@Aspect
@Component
public class TrainingSummaryServiceAspect {

	private Logger logger=LoggerConfiguration.getLogger(TrainingSummaryServiceAspect.class);
	
	@AfterThrowing(value = "execution(* com.yash.ytms.serviceImpl.TrainingSummaryServiceImpl.*(..))", throwing = "ex")
	public void afterThrowingAdviceForTrainer(JoinPoint joinPoint, Exception ex) {
		logger.info("Method will call after throwing exception :" + joinPoint.getSignature());
		logger.info("Excetion Message :" + ex.getMessage());
		logger.info("Exception Code : "+HttpStatus.NOT_FOUND);
	}
}

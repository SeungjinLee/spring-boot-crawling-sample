package com.crawling.app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class ExecutionTimeAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("@annotation(ExecutionTime)")
	public Object executionTimeAround(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - start;
		logger.info(String.format("[METHOD - executionTimeAround EXECUTION_TIME : %s - %sms ",  joinPoint.getSignature(), executionTime));
		return proceed;
	}

}

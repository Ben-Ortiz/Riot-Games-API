package com.ben.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("within(com.ben.service.*)")
	public void logWithinServicePackage() {}
	
	@Before("logWithinServicePackage()")
	public void logBefore(JoinPoint jp) {
		logger.info("work " + jp.getSignature().getName());
	}

}

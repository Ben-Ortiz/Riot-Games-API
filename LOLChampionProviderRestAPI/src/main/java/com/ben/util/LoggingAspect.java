package com.ben.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * this class enables logging to happen without adding log statements all throughout the program but in one central file.
 * @author benor
 *
 */
@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("within(com.ben.service.*)")
	public void logWithinServicePackage() {}
	
	@Before("logWithinServicePackage()")
	public void logBefore(JoinPoint jp) {
		logger.info("RestProviderService1 before service package " + jp.getSignature().getName());
	}

}

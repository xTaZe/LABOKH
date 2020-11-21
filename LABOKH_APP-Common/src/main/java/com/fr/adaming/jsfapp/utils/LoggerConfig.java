package com.fr.adaming.jsfapp.utils;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class LoggerConfig {

	private static final Logger logger = Logger.getLogger(LoggerConfig.class);

	public void logEntry(JoinPoint joinPoint) {
		log("Entering " + joinPoint.getTarget().getClass().getSimpleName() + " : "
				+ joinPoint.getSignature().getName());

	}

	public void logExit(JoinPoint joinPoint, Object result) {
		if (!(result instanceof List || result instanceof Map)) {
			log("Return value :" + result);
		}

		log("Exiting  " + joinPoint.getTarget().getClass().getSimpleName() + " : "
				+ joinPoint.getSignature().getName());

	}

	public void logAfterThrowsAdvice(JoinPoint joinPoint, Throwable e) {
		logError("Exception " + joinPoint.getTarget().getClass().getSimpleName() + " : "
				+ joinPoint.getSignature().getName());
		logError("Cause :" + e.getMessage());

	}

	public static void log(String LogMessage) {
		logger.debug(LogMessage);
	}

	public static void logError(String LogMessage) {
		logger.error(LogMessage);
	}
}

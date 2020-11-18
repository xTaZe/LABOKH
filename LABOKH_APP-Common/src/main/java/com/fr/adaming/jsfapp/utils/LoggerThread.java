package com.fr.adaming.jsfapp.utils;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class LoggerThread {

	private static final Logger logger = Logger.getLogger(LoggerThread.class);

	public void logThreadEntry(JoinPoint joinPoint) {
		logError("Thread started " + joinPoint.getTarget().getClass().getSimpleName());

	}

	public void logThreadExit(JoinPoint joinPoint) {
		logError("Thread finished " + joinPoint.getTarget().getClass().getSimpleName());

	}

	public void logThreadAfterThrowsAdvice(JoinPoint joinPoint, Throwable e) {
		logError("Exception in thread " + joinPoint.getTarget().getClass().getSimpleName());
		logError("Cause :" + e.getMessage());

	}

	public static void log(String LogMessage) {
		logger.info(LogMessage);
	}

	public static void logError(String LogMessage) {
		logger.error(LogMessage);
	}
}

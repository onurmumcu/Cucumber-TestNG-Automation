package com.app.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	public static final Logger logger=LogManager.getLogger();
public static void main(String[] args) {
	
	logger.info("this is info log step");
	logger.warn("a warning");
	logger.debug("debug");
	logger.error("error logging");
	
}
}

package com.stc.log;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4jTest {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(Log4jTest.class);
		
		System.out.println("Start Logging");
		logger.debug("This is DEBUG");
		logger.error("This is ERROR");
		logger.warn("This is WARNING");
		logger.fatal("This is FATAL");
		logger.info("This is INFO");
		System.out.println("..........Complete..........");

	}

}

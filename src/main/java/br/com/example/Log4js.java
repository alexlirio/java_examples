package br.com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4js {

	static final Logger logger = LogManager.getLogger(Log4js.class.getName());

//	public static void main(String[] args) {
//		logger.trace("trace");
//		logger.debug("debug");
//		logger.info("info");
//		logger.warn("warn");
//		logger.error("error");
//		logger.fatal("fatal");
//	}
	
    public static void main(String[] args) {
    	int i = 1;
    	while (true) {
    		logger.trace("Trace XXX - " + i);
    		logger.debug("Debug XXX - " + i);
    		logger.info("Info XXX - " + i);
    		logger.warn("Warn XXX - " + i);
    		logger.error("Error XXX - " + i);
    		logger.fatal("Fatal XXX - " + i);
    		i++;
		}
	}

}

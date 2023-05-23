package com.myfirstproject.day15;

import com.myfirstproject.utilities.LoggerUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day15_Log4J2 {
    private static Logger logger = LogManager.getLogger(Day15_Log4J2.class.getName());
    @Test
    public void loggerTest01(){
        logger.fatal("Fatal log ....");
        logger.error("Error log ....");
        logger.warn("Warning log ....");
        logger.debug("Debug log ....");
        logger.info("Info log ....");

    }
        @Test
    public void loggerTest02(){
        LoggerUtils.warn("Warning log ...");
        LoggerUtils.debug("Debug log ...");
        LoggerUtils.info("Info log ...");
        LoggerUtils.fatal("Fatal log ...");
        LoggerUtils.error("error log ...");
        }
}

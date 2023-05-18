package homeworks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C02_Log4J {

            private static Logger logger = LogManager.getLogger(C02_Log4J.class.getName());
            @Test
            public void log4JTest(){
                // By using logger object, we can do print function
                logger.fatal("Fatal Log!");
                logger.error("Error Log!");
                logger.warn("Warning Log!");
                logger.debug("Debug Log!");
                logger.info("Info Log!");
            }


    }

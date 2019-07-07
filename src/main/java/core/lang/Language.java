package core.lang;

import org.apache.log4j.Logger;

public interface Language {
    Logger logger = Logger.getRootLogger();

    String getGreeting();

    String getBye();

    default void log(String msg) {
        logger.info(msg);
    }
}

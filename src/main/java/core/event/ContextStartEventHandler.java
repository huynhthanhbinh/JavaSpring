package core.event;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class ContextStartEventHandler
        implements ApplicationListener<ContextStartedEvent> {

    private final Logger logger = Logger.getRootLogger();

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        logger.info("\n<<<  Received Context Started Event  >>>\n");
    }
}

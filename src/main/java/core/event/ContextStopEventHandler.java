package core.event;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class ContextStopEventHandler
        implements ApplicationListener<ContextStoppedEvent> {

    private final Logger logger = Logger.getRootLogger();

    @Override
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
        logger.info("\n<<<  Received Context Stopped Event  >>>\n");
    }
}

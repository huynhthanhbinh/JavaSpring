package core.bean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    private final Logger logger = Logger.getRootLogger();

    @Autowired
    private MyRepository repository;

    public MyComponent(MyRepository repository) {
        this.repository = repository;
    }

    public void showAppInfo() {
        logger.info("Now is        : " + repository.getSystemDateTime());
        logger.info("App name      : " + repository.getAppName());
    }
}

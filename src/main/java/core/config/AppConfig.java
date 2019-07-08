package core.config;

import core.bean.GreetingService;
import core.event.ContextStartEventHandler;
import core.event.ContextStopEventHandler;
import core.lang.Language;
import org.springframework.context.annotation.*;


@Configuration
@Import(LangConfig.class)
@ComponentScan({"core/bean"}) // auto-generated: greetingService, byeService, myComponent
public class AppConfig {

    // Auto config field language by bean("language") definition in import class !
    private Language language;

    // Another way to define service
    @Bean
    public GreetingService greetingService() {
        return new GreetingService();
    }

    @Bean("contextStartEventHandler")
    public ContextStartEventHandler contextStartEventHandler() {
        return new ContextStartEventHandler();
    }

    @Bean("contextStopEventHandler")
    public ContextStopEventHandler contextStopEventHandler() {
        return new ContextStopEventHandler();
    }
}

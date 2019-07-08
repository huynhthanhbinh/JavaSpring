package core.config;

import core.bean.GreetingService;
import core.lang.Language;
import org.springframework.context.annotation.*;


@Configuration
@Import(LangConfig.class)
@ComponentScan({"core/bean"}) // auto-generated: greetingService, byeService, myComponent
public class AppConfig {

    // Auto config field language by bean("language") definition in import class !
    private Language language;

    @Bean
    public GreetingService greetingService() {
        return new GreetingService(language);
    }
}

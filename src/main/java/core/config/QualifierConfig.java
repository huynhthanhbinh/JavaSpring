package core.config;

import core.bean.ByeService;
import core.bean.GreetingService;
import core.lang.Language;
import core.lang.implement.English;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"core/bean"})
@ComponentScan({"core/lang"})
public class QualifierConfig {

    @Bean
    public GreetingService greetingService() {
        return new GreetingService();
    }

    @Bean
    public ByeService byeService() {
        return new ByeService();
    }

    @Bean
    public Language language() {
        return new English(); // POJO class ! Eg. English, Vietnamese
    }
}

package core.config;

import core.lang.Language;
import core.lang.implement.English;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;

@Configuration
public class LangConfig {

    //@Bean(name = "beanName", initMethod = "init", destroyMethod = "destroy")
    @Bean(name = "language")
    @Scope("prototype")
    @Description("Declare a bean of language")
    public Language language() {
        return new English(); // POJO class ! Eg. English, Vietnamese
    }
}

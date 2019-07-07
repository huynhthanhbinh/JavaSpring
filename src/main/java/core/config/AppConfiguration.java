package core.config;

import core.lang.Language;
import core.lang.implement.English;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
@ComponentScan({"core/bean"}) // auto-generated: greetingService, byeService, myComponent
public class AppConfiguration {
    @Bean(name = "language")
    @Description("Declare a core.bean of language")
    public Language language() {
        return new English(); // POJO class ! Eg. English, Vietnamese
    }
}

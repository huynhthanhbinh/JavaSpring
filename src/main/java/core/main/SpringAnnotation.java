package core.main;

import core.bean.ByeService;
import core.bean.GreetingService;
import core.bean.MyComponent;
import core.config.AppConfiguration;
import core.lang.Language;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotation {
    private static final String SEPARATE = "--------------------------------------------------";

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(SpringAnnotation.class.getName());

        // Application context load beans definitions and wire them together
        ApplicationContext context = new
                AnnotationConfigApplicationContext(AppConfiguration.class);

        logger.info("Spring configure with Annotation");
        logger.info(SEPARATE);

        Language language = (Language) context.getBean("language");
        language.log("Bean Language : " + language);
        language.log("How to greet  : " + language.getGreeting());
        language.log("How to say bye: " + language.getBye());


        logger.info(SEPARATE);
        GreetingService greetingService = (GreetingService) context
                .getBean("greetingService"); // auto-generated

        greetingService.sayGreeting();


        ByeService byeService = (ByeService) context
                .getBean("byeService"); // auto-generated

        byeService.sayBye();


        logger.info(SEPARATE);
        MyComponent myComponent = (MyComponent) context.getBean("myComponent");

        myComponent.showAppInfo();
    }
}

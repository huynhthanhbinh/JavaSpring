package core.bean;

import core.lang.Language;
import org.springframework.beans.factory.annotation.Autowired;

//Alternative way of declaring service
//@Service - see more in ByeService
public class GreetingService {

    @Autowired
    //@Qualifier("chinese") // uncomment this line to run SpringQualifier
    private Language language;

    public GreetingService() {}

    // For xml-config
    public GreetingService(Language language) {
        this.language = language;
    }

    public void sayGreeting() {
        String greeting = language.getGreeting();
        language.log("Greeting      : " + greeting);
    }
}

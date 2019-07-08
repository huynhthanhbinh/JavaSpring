package core.bean;

import core.lang.Language;
import org.springframework.beans.factory.annotation.Autowired;

//Alternative way of declaring service
//@Service - see more in ByeService
public class GreetingService {

    @Autowired
    private Language language;


    public GreetingService(Language language) {
        this.language = language;
    }

    public void sayGreeting() {
        String greeting = language.getGreeting();
        language.log("Greeting      : " + greeting);
    }
}

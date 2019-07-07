package core.bean;

import core.lang.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

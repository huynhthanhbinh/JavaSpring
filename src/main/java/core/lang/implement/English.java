package core.lang.implement;

import core.lang.Language;
import org.springframework.stereotype.Component;

// POJO class - Plain Old Java Object
@Component("english")
public class English implements Language {
    @Override
    public String getGreeting() {
        return "Hello";
    }

    @Override
    public String getBye() {
        return "Goodbye";
    }
}

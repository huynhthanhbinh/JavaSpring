package core.lang.implement;

import core.lang.Language;
import org.springframework.stereotype.Component;

// POJO class - Plain Old Java Object
@Component("vietnamese")
public class Vietnamese implements Language {
    @Override
    public String getGreeting() {
        return "Xin chào";
    }

    @Override
    public String getBye() {
        return "Tạm biệt";
    }
}

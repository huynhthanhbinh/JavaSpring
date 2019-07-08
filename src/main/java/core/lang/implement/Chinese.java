package core.lang.implement;

import core.lang.Language;
import org.springframework.stereotype.Component;

// POJO class - Plain Old Java Object
@Component("chinese")
public class Chinese implements Language {
    @Override
    public String getGreeting() {
        return "你好";
    }

    @Override
    public String getBye() {
        return "再見";
    }
}

package core.lang.implement;

import core.lang.Language;

// POJO class - Plain Old Java Object
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

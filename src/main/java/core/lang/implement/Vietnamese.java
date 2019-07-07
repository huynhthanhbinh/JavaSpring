package core.lang.implement;

import core.lang.Language;

// POJO class - Plain Old Java Object
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

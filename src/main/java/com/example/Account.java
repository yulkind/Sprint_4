package com.example;

import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name == null) {
            return false;
        }
        String regexp = "(?=^.{3,19}$)(^(\\S+)\\s(\\S+)$)";
        return Pattern.matches(regexp, name);
    }

}
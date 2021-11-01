package by.grsu.сourse.task2.entity.impl;

import by.grsu.сourse.task2.entity.Component;

public enum PunctuationMarkEnum implements Component {
    COMMA(","),
    POINT("."),
    QUESTION("?"),
    EXCLAMATORY("!");

    private String value;

    PunctuationMarkEnum() {
    }

    PunctuationMarkEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String print() {
        return value;
    }

}

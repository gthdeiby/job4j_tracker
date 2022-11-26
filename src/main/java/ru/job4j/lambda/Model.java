package ru.job4j.lambda;

public class Model {
    private String name;

    Model() {
    }

    Model(String str) {
        name = str;
    }

    String getName() {
        return name;
    }
}
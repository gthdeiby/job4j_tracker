package ru.job4j.oop;

public class Fix {
    private String desc;

    public Fix(String desc) {
        this.desc = "Fix.";
    }

    public static void main(String[] args) {
        Fix item = new Fix("Do not fix");
    }
}

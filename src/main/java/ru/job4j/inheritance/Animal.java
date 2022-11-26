package ru.job4j.inheritance;

public class Animal {
    public void instanceInvoke() {
        System.out.println("Вызов метода экземпляра Animal");
    }

    public static void staticInvoke() {
        System.out.println("Вызов статического метода Animal");
    }
}

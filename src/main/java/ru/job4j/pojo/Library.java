package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book war = new Book("War", 2000);
        Book peace = new Book("Peace", 1000);
        Book gita = new Book("Gita", 500);
        Book clean = new Book("Clean Code", 0);
        Book[] array = new Book[4];
        array[0] = war;
        array[1] = peace;
        array[2] = gita;
        array[3] = clean;
        System.out.println("Simple output.");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName() + " - " + array[i].getQuantity());
        }
        Book temp = array[0];
        array[0] = array[3];
        array[3] = temp;
        System.out.println("Replace 0 to 3.");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName() + " - " + array[i].getQuantity());
        }
        System.out.println("Clean Code only.");
        for (int i = 0; i < array.length; i++) {
            if (array[i].getName().equals("Clean Code"))
            System.out.println(array[i].getName() + " - " + array[i].getQuantity());
        }
    }
}

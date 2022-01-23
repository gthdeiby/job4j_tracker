package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private int category;

    public Surgeon(String name,
                   String surname,
                   String education,
                   String birthday,
                   String address,
                   int category) {
        super(name, surname, education, birthday, address);
        this.category = category;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean makeOperations(int category) {
        return (category < 5);
    }
}

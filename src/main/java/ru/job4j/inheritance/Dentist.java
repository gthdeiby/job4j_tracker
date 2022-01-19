package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private boolean time;

    public Dentist() {
    }

    public Dentist(String name,
                   String surname,
                   String education,
                   String birthday,
                   String address,
                   boolean time) {
        super(name, surname, education, birthday, address);
        this.time = time;
    }

    public boolean isTime() {
        return time;
    }

    public void setTime(boolean time) {
        this.time = time;
    }

    public void insertTooth(boolean time, Pacient pacient) {
        if (time && pacient.isMoney()) {
            System.out.println("Вставить зуб");
        } else {
            System.out.println("Пусть ходят без зубов");
        }
    }
}

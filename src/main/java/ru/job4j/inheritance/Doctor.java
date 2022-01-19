package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String city;

    public Doctor() {
    }

    public Doctor(String name,
                  String surname,
                  String education,
                  String birthday,
                  String address) {
        super(name, surname, education, birthday);
        this.city = address;
    }

    public String getAddress() {
        return city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean heal(Pacient pacient) {
        return pacient.getAddress().equals(this.city);
    }
}

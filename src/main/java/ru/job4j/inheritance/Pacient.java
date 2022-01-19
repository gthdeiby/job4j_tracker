package ru.job4j.inheritance;

public class Pacient {

    private String address;
    private boolean money;

    public Pacient(boolean money) {
        this.money = money;
    }

    public Pacient(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isMoney() {
        return money;
    }

    public void setMoney(boolean money) {
        this.money = money;
    }
}

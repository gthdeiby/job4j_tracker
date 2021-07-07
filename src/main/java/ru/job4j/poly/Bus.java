package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Ехать");
    }

    @Override
    public void passengers(int quantity) {
        System.out.println("Едет" + quantity + "парссажира(ов)");
    }

    @Override
    public double refuel(double fuelAmount) {
        return fuelAmount * 300;
    }
}

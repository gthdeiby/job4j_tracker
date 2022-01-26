package ru.job4j.ex;

public class FindMaxLength {

    public static void main(String[] args) {
        String[] shops = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (String el : shops) {
            if (el != null && el.length() > max) {
                max = el.length();
            }
        }
        System.out.println("Max length : " + max);
    }
}

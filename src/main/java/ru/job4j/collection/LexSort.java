package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int leftTaskNumber = Integer.parseInt(left.split("\\.")[0]);
        int rightTaskNumber = Integer.parseInt(right.split("\\.")[0]);
        return Integer.compare(leftTaskNumber, rightTaskNumber);
    }
}
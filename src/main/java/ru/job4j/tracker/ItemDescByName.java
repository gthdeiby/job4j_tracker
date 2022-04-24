package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o2.getName().compareTo(o1.getName());
    }
}

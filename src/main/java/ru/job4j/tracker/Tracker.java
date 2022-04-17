package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> itemsByName = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                itemsByName.add(item);
            }
        }
        return itemsByName;
    }

    public Item findById(int id) {
        int index = indexOfItem(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOfItem(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = items.indexOf(item);
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOfItem(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    public boolean delete(int id) {
        int index = indexOfItem(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Tracker{"
                + "items=" + items
                + ", ids=" + ids
                + '}';
    }
}
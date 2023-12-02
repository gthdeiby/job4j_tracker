package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;

import java.util.List;
import java.util.stream.Collectors;

public class DeleteItems implements UserAction {
    private final Output out;

    public DeleteItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete all items ===");
        List<Item> allItems = tracker.findAll();
        List<Integer> collect = allItems.stream()
                .map(Item::getId).collect(Collectors.toList());
        for (Integer integer : collect) {
            tracker.delete(integer);
        }
        out.println("=== Все заявки удалены ===");
        return true;
    }
}

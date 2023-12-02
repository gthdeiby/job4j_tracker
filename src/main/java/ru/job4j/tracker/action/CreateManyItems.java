package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;

public class CreateManyItems implements UserAction {
    private final Output out;

    public CreateManyItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create many items ===");
        int count = input.askInt("Введите кол-во заявок: ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Заявка № " + i));
        }
        out.println("Добавлено заявок: " + count);
        return true;
    }
}

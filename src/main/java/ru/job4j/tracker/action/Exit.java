package ru.job4j.tracker.action;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;

public class Exit implements UserAction {
    private final Output out;

    public Exit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Exit Program ===");
        return false;
    }
}

package ru.job4j.tracker;

public class CreateManyItemsAction implements UserAction {
    private final Output out;

    public CreateManyItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add 10.000 Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create 10.000 new Items ===");
        for (int i = 0; i < 10_000; i++) {
            tracker.add(new Item("Item " + i));
        }
        return true;
    }
}

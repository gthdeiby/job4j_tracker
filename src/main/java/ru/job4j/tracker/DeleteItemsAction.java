package ru.job4j.tracker;

public class DeleteItemsAction implements UserAction {
    private final Output out;

    public DeleteItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete All Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete All Items ===");
        tracker.clear();
        return true;
    }
}

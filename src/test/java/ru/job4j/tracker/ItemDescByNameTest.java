package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void compare() {
        List<Item> items = Arrays.asList(
                new Item(2, "2"),
                new Item(1, "1"),
                new Item(8, "8"),
                new Item(3, "3")
        );
        List<Item> expected = Arrays.asList(
                new Item(8, "8"),
                new Item(3, "3"),
                new Item(2, "2"),
                new Item(1, "1")
        );
        Collections.sort(items, new ItemDescByName()
        );
        assertEquals(items, expected);
    }
}
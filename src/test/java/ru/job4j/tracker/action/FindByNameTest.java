package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class FindByNameTest {

    @Test
    public void whenItemWasFindByNameSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        String findName = "FindByName item";
        Item item = new Item(findName);
        tracker.add(item);
        UserAction findByNameAction = new FindByName(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(findName);

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenItemWasFindByNameError() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("FindByName item"));
        UserAction findByNameAction = new FindByName(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("WrongName");

        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Заявки с именем: WrongName не найдены." + ln
        );
    }
}
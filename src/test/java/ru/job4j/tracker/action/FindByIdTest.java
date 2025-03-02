package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class FindByIdTest {

    @Test
    public void whenItemWasFindByIdSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("FindById item");
        tracker.add(item);
        UserAction findByIdAction = new FindById(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenItemWasFindByIdError() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("FindById item"));
        UserAction findByIdAction = new FindById(output);

        Input input = mock(Input.class);

        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                        "=== Find item by id ===" + ln
                        + "Заявка с введенным id: 0 не найдена." + ln
        );
    }
}
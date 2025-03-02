package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class DeleteTest {

    @Test
    public void whenItemWasDeletedSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        UserAction deleteAction = new Delete(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete item ===" + ln
                        + "Заявка удалена успешно." + ln
        );
    }

    @Test
    public void whenItemWasDeletedError() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        UserAction deleteAction = new Delete(output);

        Input input = mock(Input.class);

        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Delete item ===" + ln
                        + "Ошибка удаления заявки." + ln
        );
    }
}
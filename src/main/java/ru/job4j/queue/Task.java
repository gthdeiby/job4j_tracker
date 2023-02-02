package ru.job4j.queue;

public record Task(Position position,
                   String description,
                   int urgency) {
}

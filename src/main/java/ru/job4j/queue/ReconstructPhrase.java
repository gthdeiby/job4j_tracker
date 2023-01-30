package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder even = new StringBuilder();
        int count = evenElements.size();
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                even.append(evenElements.peekFirst());
            }
            evenElements.pollFirst();
        }
        return even.toString();
    }

    private String getDescendingElements() {
        StringBuilder descending = new StringBuilder();
        int count = descendingElements.size();
        for (int i = 0; i < count; i++) {
            descending.append(descendingElements.pollLast());
        }
        return descending.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
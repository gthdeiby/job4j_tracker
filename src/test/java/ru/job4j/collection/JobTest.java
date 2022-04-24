package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorAscByNameThenPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorAscByPriorityThenName() {
        Comparator<Job> cmpPriorityName = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmpPriorityName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByNameThenPriority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByPriorityThenName() {
        Comparator<Job> cmpPriorityName =
                new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpPriorityName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("B", 2),
                new Job("A", 1),
                new Job("C", 3)
        );
        List<Job> expected = Arrays.asList(
                new Job("A", 1),
                new Job("B", 2),
                new Job("C", 3)
        );
        Collections.sort(jobs, new JobAscByName());
        assertEquals(jobs, expected);
    }

    @Test
    public void whenComparatorAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("B", 2),
                new Job("A", 1),
                new Job("C", 3)
        );
        List<Job> expected = Arrays.asList(
                new Job("A", 1),
                new Job("B", 2),
                new Job("C", 3)
        );
        Collections.sort(jobs, new JobAscByPriority());
        assertEquals(jobs, expected);
    }

    @Test
    public void whenComparatorDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("B", 2),
                new Job("A", 1),
                new Job("C", 3)
        );
        List<Job> expected = Arrays.asList(
                new Job("C", 3),
                new Job("B", 2),
                new Job("A", 1)
        );
        Collections.sort(jobs, new JobDescByName());
        assertEquals(jobs, expected);
    }

    @Test
    public void whenComparatorDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("B", 2),
                new Job("A", 1),
                new Job("C", 3)
        );
        List<Job> expected = Arrays.asList(
                new Job("C", 3),
                new Job("B", 2),
                new Job("A", 1)
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertEquals(jobs, expected);
    }
}
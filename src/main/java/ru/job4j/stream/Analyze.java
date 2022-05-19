package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
    Метод averageScore вычисляет общий средний балл.
    */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
     Возвращает список из объекта Tuple (имя ученика и средний балл).
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.getName(), p.getSubjects()
                    .stream()
                    .mapToInt(Subject::getScore)
                    .average()
                    .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     Метод averageScoreByPupil вычисляет средний балл
     по всем предметам для каждого ученика.
     Возвращает список из объекта Tuple (название предмета и средний балл).
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .collect(Collectors.toList());
    }

    /**
     Метод bestStudent - возвращает лучшего ученика.
     Лучшим считается ученик с наибольшим баллом по всем предметам.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.getName(), p.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                    .max(Comparator.comparingDouble(Tuple::getScore))
                    .orElse(null);
    }

    /**
     Метод averageScoreByPupil вычисляет средний балл п
     о всем предметам для каждого ученика.
     Возвращает список из объекта Tuple (название предмета и средний балл).
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(s -> new Tuple(s.getKey(), s.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("qwerty@mail.ru", "Иосиф Виссарионович Сталин");
        map.put("don123don@mail.ru", "Кадыров Рамзан Ахматович");
        map.put("qwerty@mail.ru", "Джейсон Васильевич Стетхем");
        map.put("asdfg@mail.ru", "Владимир Вольфович Жириновский");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}

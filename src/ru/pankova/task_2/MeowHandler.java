package ru.pankova.task_2;

import java.util.List;

public class MeowHandler {
    // Метод принимает список мяукающих объектов и подсчитывает количество их мяуканий
    public static int handleMeowing(List<Meowable> meowables) {
        Count counter = new Count();

        for (Meowable meowable : meowables) {
            meowable.meow();
            counter.count();
        }
        return counter.getCount();
    }
}
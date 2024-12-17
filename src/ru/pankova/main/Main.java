package ru.pankova.main;
import ru.pankova.task_1.CachedFraction;
import ru.pankova.task_2.Cat;
import ru.pankova.task_2.MeowHandler;
import ru.pankova.task_2.Meowable;
import ru.pankova.task_3.ListReplacer;
import ru.pankova.task_4.Information;
import ru.pankova.task_5.ReadFileUtil;
import ru.pankova.task_7.number1.Point;
import ru.pankova.task_7.number1.PolyLine;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static ru.pankova.task_4.Results.findMaxScore;
import static ru.pankova.task_4.Results.readInformation;

public class Main {
    public static void main(String[] args) {
        // Задание 1.1. В класс Дробь, добавить интерфейс на два метода: получение вещественного значения, установка
        //числителя и установка знаменателя. Сгенерировать такую версию дроби, которая будет кэшировать
        // вычисление вещественного значения.
        out.println("Задание 1.1.");
        // Создание дробей
        CachedFraction fraction1 = new CachedFraction(3, 4);
        CachedFraction fraction2 = new CachedFraction(7, 8);

        // Вывод дробей
        out.println("Дробь 1: " + fraction1);
        out.println("Дробь 2: " + fraction2);

        // Получение вещественного значения
        out.println("Вещественное значение Дроби 1: " + fraction1.getValue());
        out.println("Вещественное значение Дроби 2: " + fraction2.getValue());

        // Сравнение дробей
        out.println("Дробь 1 равна Дроби 2: " + fraction1.equals(fraction2));

        // Арифметическая операция (сложение)
        CachedFraction sum = new CachedFraction(fraction1.summa(fraction2).getChis(), fraction1.summa(fraction2).getZnam());
        out.println("Сумма Дроби 1 и Дроби 2: " + sum);
        out.println("Вещественное значение суммы: " + sum.getValue());

        // Установка отрицательного знаменателя
        fraction1.setZnam(-4);
        out.println("Дробь 1 после установки отрицательного знаменателя: " + fraction1);
        out.println("Вещественное значение Дроби 1 после установки отрицательного знаменателя: " + fraction1.getValue());

        // Задание 2.1. Количество мяуканий.
        //Необходимо воспользоваться классом Кот и методом принимающим всех мяукающих из задачи 2.5.4.
        //Необходимо таким образом передать кота в указанный метод, что бы после окончания его работы
        //узнать сколько раз мяукал кот за время его работы. На рисунке показан пример работы. Перед вызовом
        //метода создаем кота, отправляем ссылку на кота в метод, после окончания его работы выводим
        //количество мяуканий на экран. Кота изменять нельзя.
        out.println("Задание 2.1.");

        Cat cat1 = new Cat("Олег");

        // Передаем кота в метод handleMeowing
        List<Meowable> meowables = new ArrayList<>();
        meowables.add(cat1);
        meowables.add(cat1);
        meowables.add(cat1);

        // Вызываем метод, обрабатывающий мяуканья
        int count = MeowHandler.handleMeowing(meowables);

        out.println("Количество мяуканий: " + count);

        // Задание 3.2. Составить программу, которая в списке L заменяет первое вхождение списка L1 (если такое есть)
        //на список L2.
        out.println("Задание 3.2.");
        out.println("Если список L1 есть в L: ");
        List<Integer> L = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> L1 = new ArrayList<>(List.of(3, 4, 5));
        List<Integer> L2 = new ArrayList<>(List.of(10, 11, 12, 14));

        List<Integer> result1 = ListReplacer.replace(L, L1, L2);

        out.println("Список L: " + L);
        out.println("Список L1: " + L1);
        out.println("Список L2: " + L2);
        out.println("Измененный список L: " + result1);

        out.println("Если списка L1 нет в L: ");
        List<Integer> L0 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> L11 = new ArrayList<>(List.of(31, 41, 51));
        List<Integer> L22 = new ArrayList<>(List.of(10, 11, 12));

        List<Integer> result2 = ListReplacer.replace(L0, L11, L22);

        out.println("Список L: " + L0);
        out.println("Список L1: " + L11);
        out.println("Список L2: " + L22);
        out.println("Измененный список L: " + result2);

        // Задание 4.2. Напишите программу, которая будет выводить на экран фамилию и имя участника, набравшего
        //максимальное количество баллов. Если среди остальных участников есть ученики, набравшие
        //такое же количество баллов, то их фамилии и имена также следует вывести. При этом имена и
        //фамилии можно выводить в произвольном порядке.
        out.println("Задание 4.2.");
        String filePath = "данные4.txt";
        out.println("Участник(и), набравший(ие) максимальное количество баллов: ");
        Map<Information, Integer> participantMap = readInformation(filePath);
        if (!participantMap.isEmpty()) {
            List<Information> maxScore = findMaxScore(participantMap);
            for (Information inf : maxScore) {
                out.println(inf);
            }
        }

        // Задание 5.2. Файл содержит текст на русском языке. Напечатать в алфавитном порядке все глухие согласные
        //буквы, которые не входят ни в одно слово.
        out.println("Задание 5.2.");
        String file = "данные5.txt";
        ReadFileUtil readFile = new ReadFileUtil();
        try {
            String text = ReadFileUtil.readFile(file);
            String[] words = text.split("\\s+");
            Set<Character> glukhiyLetters = new HashSet<>(Arrays.asList('к', 'п', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'));

            Set<Character> usedLetters = new HashSet<>();

            for (String word : words) {
                for (char c : word.toLowerCase().toCharArray()) {
                    if (glukhiyLetters.contains(c)) {
                        usedLetters.add(c);
                    }
                }
            }

            glukhiyLetters.removeAll(usedLetters);
            List<Character> sortedResult = new ArrayList<>(glukhiyLetters);
            Collections.sort(sortedResult);

            out.println("Глухие согласные буквы, которые не входят ни в одно слово: ");
            for (char c : sortedResult) {
                out.print(c + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println();

        // Задание 7.1. Дан набор объектов типа Point, необходимо взять все Point в разных координатах, убрать с
        //одинаковыми X,Y, отсортировать по X, отрицательные Y сделать положительными и собрать это
        //все в ломаную (объект типа Polyline)
        out.println("Задание 7.1. ");
        List<Point> points = Arrays.asList(
                new Point(1,1),
                new Point(3,3),
                new Point(-5,-4),
                new Point(1,9),
                new Point(9,1));

        out.println("Исходные точки: ");
        for (Point point : points) {
            out.println(point.getPointString());
        }

        List<Point> result  = points.stream()
                .filter(p -> p.getX() != p.getY()) // фильтруем по x = y
                .sorted(Comparator.comparingDouble(Point::getX)) // сортировка по X
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .collect(Collectors.toList());

        PolyLine polyLine = createPolyne(result);
        out.println("Точки в ломанной: " + polyLine);
    }

    private static PolyLine createPolyne(List<Point> points){
        PolyLine polyline = new PolyLine();
        for (Point point : points){
            polyline.addPoint(point);
        }
        return polyline;
    }
}
package org.algorithms;

import java.util.Arrays;

public class Launcher {
    public static void main(String[] args) {

        Person[] people = {
                new Person(150, 39, 13),
                new Person(170, 55, 16),
                new Person(161, 50, 15),
                new Person(190, 75, 19),
                new Person(145, 35, 12),
                new Person(171, 55, 16),
                new Person(163, 55, 16),
                new Person(188, 69, 20),
                new Person(164, 55, 16),
                new Person(132, 32, 10),
                new Person(156, 45, 13),
                new Person(145, 38, 11),
                new Person(159, 45, 13),
                new Person(170, 55, 16),
                new Person(175, 59, 16),
                new Person(161, 51, 17),
                new Person(156, 45, 13),
                new Person(170, 55, 16),
                new Person(156, 45, 13)
        };


        PersonArrays.sort(people, PersonArrays.SortingTypes.BY_AGE);
        System.out.println(Arrays.toString(people));

        PersonArrays.sort(people, PersonArrays.SortingTypes.BY_HEIGHT);
        System.out.println(Arrays.toString(people));

        PersonArrays.sort(people, PersonArrays.SortingTypes.BY_WEIGHT);
        System.out.println(Arrays.toString(people));

        long startTime = System.nanoTime();

        System.out.println(PersonArrays.countSameWeightDifHeight(people));

        long endTime = System.nanoTime();

        System.out.printf("Функція виконується %f мілісекунд", (endTime - startTime) / Math.pow(10, 6));

        /*Для поточного набору даних програма виконується доволі швидко, проте
        алгоритм роботи є доволі громіздким та має квадратичну складність. Передбачається,
        що для великим об'ємів даних час виконання суттєво зростатиме. Подивимось, чи можна
        спростити алгоритм роботи
        * */

    }
}

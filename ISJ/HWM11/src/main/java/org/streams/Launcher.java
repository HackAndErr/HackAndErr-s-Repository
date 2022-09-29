package org.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Launcher {
    public static void main(String[] args) {
        String[] namesArr = {"1. John", "2. Jack", "3. Ben", "4. Jake", "5. Andrew", "6. Alex", "7. Sam"};
        List<String> namesList = Arrays.asList(namesArr);

        System.out.println(Tasks.getOddIndexesOnly(namesList));
        System.out.println(Tasks.reverseUppercaseSort(namesList));

        String[] numsArr = {"1, 2, 0", "4, 5"};

        System.out.println(Tasks.getSortNumbers(numsArr));

        System.out.println(Tasks.makeRandomGenerator(0,25214903917l, 11, Tasks.TWO_POWER_48).limit(20).max((l1, l2) -> (int) (l1-l2)));

        Stream<Integer> l1 = Arrays.asList(1, 3, 5, 7, 9).stream();
        Stream<Integer> l2 = Arrays.asList(2, 4, 6, 8, 10, 12, 14).stream();

        System.out.println(Tasks.zip(l1,l2).collect(Collectors.toList()));
    }
}

package org.streams;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tasks {
    public final static long TWO_POWER_48 = (long) Math.pow(2, 48);
    public static String getOddIndexesOnly(List<String> list){
        return list.stream()
                .filter(s -> s.charAt(0) % 2 == 1)
                .collect(Collectors.joining(", "));
    }

    public static List<String> reverseUppercaseSort(List<String> list){
        Comparator<String> comparator = (s1, s2) -> s2.charAt(3) - s1.charAt(3);
        return list.stream()
                .sorted(comparator)
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
    }

    public static String getSortNumbers(String[] arr){
        return Arrays.stream(arr).flatMap(i -> Arrays.stream(i.split(", ")))
                .sorted()
                .collect(Collectors.joining(", "));
    }

    public static Stream<Long> makeRandomGenerator(long seed, long a, long c, long m){
        return Stream.iterate(seed, n -> (a*n + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Iterator<T> i1 = first.iterator();
        Iterator<T> i2 = second.iterator();


        List<T> zippedList = new ArrayList<>();

        while(true){
            if(!i1.hasNext()) break;
            zippedList.add(i1.next());

            if(!i2.hasNext()) break;
            zippedList.add(i2.next());
        }

        return zippedList.stream();
    }
}

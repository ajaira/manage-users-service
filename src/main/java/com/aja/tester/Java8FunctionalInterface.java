package com.aja.tester;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Java8FunctionalInterface {

    public static void main(String[] args) {

        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true
        System.out.println("Print all numbers");
        eval(myList, a -> true);

        // Predicate<Integer> predicate = n -> n%2==0
        System.out.println("Print even numbers");
        eval(myList, a -> a % 2 == 0);

        // Predicate<Integer> predicate = n -> n>3
        System.out.println("Print  numbers greater than");
        eval(myList, a -> a > 3);

    }

    private static void eval(List<Integer> myList, Predicate<Integer> predicate) {
        myList.forEach(n -> {
            if (predicate.test(n)) {
                System.out.println(n);
            }
        });
    }


}

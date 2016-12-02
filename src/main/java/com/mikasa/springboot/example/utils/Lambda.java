package com.mikasa.springboot.example.utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sherlock on 2016/11/7.
 */
public class Lambda {

    public static void main(String[] args){
        new Thread(
                () -> System.out.println("Hello from thread")
        ).start();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(n -> System.out.println(n));
        list.forEach(System.out::println);
    }

    public int compare(String first, String second) {
        return Integer.compare(first.length(), second.length());
    }

}

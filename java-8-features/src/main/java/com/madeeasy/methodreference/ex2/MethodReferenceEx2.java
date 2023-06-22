package com.madeeasy.methodreference.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceEx2 {
    public static void main(String[] args) {
        // Example: Reference to a static method
        Function<Integer, Double> converter1 = i -> {
            return Double.valueOf(Integer.valueOf(i));
        };
        Function<Integer, Double> converter2 = Double::valueOf;

        Double intValue1 = converter1.apply(Integer.valueOf("123"));
        Double intValue2 = converter2.apply(Integer.valueOf("123"));

        // Example: Reference to an instance method of a particular object
        String str = "Hello, World!";
        Predicate<String> predicate = str::startsWith;
        boolean result = predicate.test("Hello");

        // Example: Reference to a constructor
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> newList = listSupplier.get();

    }
}

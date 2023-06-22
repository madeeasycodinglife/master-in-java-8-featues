package com.madeeasy.functionalinterface;

import java.util.function.*;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Predicate - checks if a number is even
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 5 even? " + isEven.test(5));
        System.out.println("Is 10 even? " + isEven.test(10));

        // Consumer - prints the given message
        Consumer<String> printMessage = message -> System.out.println(message);
        printMessage.accept("Hello, world!");

        // Function - converts Fahrenheit to Celsius
        Function<Double, Double> fahrenheitToCelsius = fahrenheit -> (fahrenheit - 32) * 5 / 9;
        double celsiusTemp = fahrenheitToCelsius.apply(98.6);
        System.out.println("98.6°F is approximately " + celsiusTemp + "°C");

        // Supplier - generates a random number
        Supplier<Integer> randomNumber = () -> (int) (Math.random() * 100);
        System.out.println("Random number: " + randomNumber.get());

        // UnaryOperator - squares a number
        UnaryOperator<Integer> square = num -> num * num;
        int result = square.apply(5);
        System.out.println("Square of 5 is " + result);

        // BinaryOperator - performs arithmetic addition
        BinaryOperator<Integer> addition = (num1, num2) -> num1 + num2;
        int sum = addition.apply(5, 3);
        System.out.println("Sum of 5 and 3 is " + sum);
    }
}


package com.madeeasy.methodreference.ex1;

import java.util.Arrays;
import java.util.function.Supplier;

public class MethodReferenceExample {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Pabitra"),
                new Person("Kartik"),
                new Person("Ganesh")
        };

        // Reference to a static method
        Arrays.stream(people)
                .forEach(Person::printNameStatic);

        // Reference to an instance method of a particular object
        Person person = new Person("Pabitra");
        Arrays.stream(people)
                .forEach(person::printNameInstance);

        // Reference to an instance method of an arbitrary object of a particular type
        Arrays.stream(people)
                .map(Person::getName)
                .forEach(System.out::println);

        // Reference to a constructor
        Supplier<Person> personSupplier = Person::new;
        Person personReferenceToConstructor = personSupplier.get();
        personReferenceToConstructor.setName("Pabitra Bera");
        System.out.println("Person name: " + person.getName());
    }
}

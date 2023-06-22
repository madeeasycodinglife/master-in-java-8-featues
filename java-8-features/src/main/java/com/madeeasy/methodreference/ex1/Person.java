package com.madeeasy.methodreference.ex1;

import java.util.Arrays;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {

    }

    public static void printNameStatic(Person person) {
        System.out.println("printNameStatic "+person.getName());
    }

    public String getName() {
        return name;
    }

    public void printNameInstance(Person person) {
        System.out.println("printNameInstance = " + person);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}



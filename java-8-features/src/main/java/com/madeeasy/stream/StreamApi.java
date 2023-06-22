package com.madeeasy.stream;

import com.madeeasy.stream.model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        List<User> list = List.of(
                new User("hello", "123", 1),
                new User("world", "1234", 2),
                new User("hi", "123", 3)
        );

        list.forEach(System.out::println);
        list.stream()
                .map(User::getName)
                .filter(name -> name.startsWith("h"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        Optional<String> matchedName = list.stream()
                .map(User::getName)
                .filter(name -> name.equals("world"))
                .findFirst();


        @SuppressWarnings("OptionalGetWithoutIsPresent")
        String nameGet = matchedName.get();
        System.out.println("nameGet = " + nameGet);

        String nameOrElse = matchedName.orElse("No name found"); // use instead of get()


        System.out.println("nameOrElse = " + nameOrElse);

        // ifPresent() used for printing ,logging, or modifying external state based on the presence of a value in the Optional.
        matchedName.ifPresent(System.out::println);

        List<User> collected = list.stream()
                .map(user -> {
                    if (user.getName().equals("world")) {
                        return new User(user.getName(), "0000", user.getAge());
                    }
                    return user;
                })
                .toList();
        System.out.println("collected = " + collected);


        //  we're using the noneMatch() method to check if there is no user in the list with the name "world".
        boolean noneMatchFound = list.stream()
                .noneMatch(user -> user.getName().equals("world"));
        System.out.println("noneMatchFound = " + noneMatchFound);


        list.stream()
                .filter(user -> user.getName().equals("world"))
                .findFirst()
                .ifPresent(System.out::println);

/**
 * By using flatMap(), you can transform a stream of objects into a stream of values extracted from
 * those objects, enabling more streamlined data processing and transformation operations.
 */
        List<String> passwordList = list.stream()
                .flatMap(user -> Stream.of(user.getPassword()))
                .collect(Collectors.toList());

        List<String> nameList = list.stream()
                .filter(user -> passwordList.contains(user.getPassword()))
                .map(User::getName)
                .toList();
        System.out.println("name = " + nameList);
        System.out.println(passwordList);

        IntStream userIdStream = list.stream()
                .flatMapToInt(user -> IntStream.of(user.getAge()));
        userIdStream.forEach(System.out::println);

        System.out.println("----------------------------------------------------------------");

        IntStream passwordLengths = list.stream()
                .flatMapToInt(user -> user.getPassword().chars())
                .map(Character::getNumericValue);

        passwordLengths.forEach(System.out::println);

        long count = list.size();
        System.out.println("count = " + count);

        boolean anyMatchFound = list.stream()
                .anyMatch(user -> user.getName().equals("world"));

        boolean allMatchFound = list.stream()
                .allMatch(user -> user.getPassword().length() > 2);

        System.out.println("anyMatchFound = " + anyMatchFound);
        System.out.println("allMatchFound = " + allMatchFound);
    }

    /**
     * Here is a list of all the intermediate operations and terminal methods provided by the Java Stream API:
     *
     * Intermediate Operations:
     * 1. `filter(Predicate<T>)`: Returns a stream consisting of elements that satisfy the given predicate.
     * 2. `map(Function<T, R>)`: Returns a stream consisting of the results of applying the given function to the elements.
     * 3. `flatMap(Function<T, Stream<R>>)` : Returns a stream consisting of the results of replacing each element with the contents of the mapped stream.
     * 4. `distinct()`: Returns a stream with distinct elements (removes duplicates).
     * 5. `sorted()`: Returns a stream with sorted elements based on their natural order.
     * 6. `sorted(Comparator<T>)`: Returns a stream with sorted elements based on the provided comparator.
     * 7. `limit(long)`: Returns a stream consisting of the first `n` elements.
     * 8. `skip(long)`: Returns a stream after skipping the first `n` elements.
     *
     * Terminal Operations:
     * 1. `forEach(Consumer<T>)`: Performs an action for each element in the stream.
     * 2. `toArray()`: Collects the elements of the stream into an array.
     * 3. `collect(Collector<T, A, R>)`: Performs a mutable reduction operation on the elements using a Collector.
     * 4. `reduce(BinaryOperator<T>)`: Performs a reduction on the elements using the provided binary operator.
     * 5. `min(Comparator<T>)`: Returns the minimum element based on the provided comparator.
     * 6. `max(Comparator<T>)`: Returns the maximum element based on the provided comparator.
     * 7. `count()`: Returns the count of elements in the stream.
     * 8. `anyMatch(Predicate<T>)`: Returns true if any element satisfies the given predicate.
     * 9. `allMatch(Predicate<T>)`: Returns true if all elements satisfy the given predicate.
     * 10. `noneMatch(Predicate<T>)`: Returns true if no elements satisfy the given predicate.
     * 11. `findFirst()`: Returns the first element in the stream.
     * 12. `findAny()`: Returns any element in the stream.
     *
     * Please note that this is an exhaustive list of the most commonly used intermediate operations and terminal methods
     * in the Java Stream API. Some additional methods may exist in specialized stream classes or variations of streams,
     * but this list covers the core functionality.
     */
}

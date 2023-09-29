package com.madeeasy.stream;

import com.madeeasy.stream.model.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {

    /**
         * **Java Stream API**
         *
         * **Introduction:**
         * - The Java Stream API was introduced in Java 8 to simplify and enhance working with sequences of data,
         * such as collections or arrays.
         * - It provides a declarative and functional approach to perform operations on data, making code more
         * concise and readable.
         *
         * **Key Concepts:**
         *
         * 1. **Stream**: A stream is a sequence of elements that can be processed in a functional style.
         *
         * 2. **Intermediate Operations**: These operations are applied to a stream and return a new stream. Examples
         * include `filter`, `map`, `flatMap`, `distinct`, `sorted`, `peek`, `limit`, and `skip`.
         *
         * 3. **Terminal Operations**: These operations produce a result or side-effect. Examples include `forEach`,
         * `toArray`, `reduce`, `collect`, `min`, `max`, `count`, `anyMatch`, `allMatch`, `noneMatch`, `findFirst`,
         * and `findAny`.
         *
         * **Use Cases:**
         *
         * 1. **Data Transformation**: Stream API is useful for transforming and filtering data. You can easily
         * filter elements, transform them, and remove duplicates.
         *
         * 2. **Parallelism**: Stream API can leverage multicore processors by performing operations in parallel.
         * This can significantly improve performance for large datasets.
         *
         * 3. **Declarative Code**: Stream operations enable you to write code in a more declarative and readable
         * style, reducing the need for loops and mutable variables.
         * 
         * **Conclusion:**
         *
         * The Java Stream API provides a powerful and expressive way to work with collections of data. It promotes
         * functional programming concepts and can significantly improve code readability and performance, especially
         * when dealing with large datasets. It is widely used in industry-level Java development for data processing
         * and manipulation.
         */
    
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

         List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Intermediate Operations:

        // 1. filter(Predicate<T> predicate)
        Stream<Integer> filtered = numbers.stream()
            .filter(num -> num % 2 == 0);

        // 2. map(Function<T, R> mapper)
        Stream<String> mapped = numbers.stream()
            .map(Object::toString);

        // 3. flatMap(Function<T, Stream<R>> mapper)
        Stream<Integer> flatMapped = numbers.stream()
            .flatMap(num -> Stream.of(num, num * 2));

        // 4. distinct()
        Stream<Integer> distinct = numbers.stream()
            .distinct();

        // 5. sorted()
        Stream<Integer> sorted = numbers.stream()
            .sorted();

        // 6. sorted(Comparator<T> comparator)
        Stream<Integer> customSorted = numbers.stream()
            .sorted(Comparator.reverseOrder());

        // 7. peek(Consumer<T> action)
        Stream<Integer> peeked = numbers.stream()
            .peek(System.out::println);

        // 8. limit(long maxSize)
        Stream<Integer> limited = numbers.stream()
            .limit(3);

        // 9. skip(long n)
        Stream<Integer> skipped = numbers.stream()
            .skip(2);


        // Terminal Operations:

        // 10. forEach(Consumer<T> action)
        numbers.forEach(System.out::println);

        // 11. toArray()
        Integer[] array = numbers.stream()
            .toArray(Integer[]::new);

        // 12. reduce(T identity, BinaryOperator<T> accumulator)
        Optional<Integer> sum = numbers.stream()
            .reduce((a, b) -> a + b);

        // 13. collect(Collector<T, A, R> collector)
        List<Integer> collected = numbers.stream()
            .collect(Collectors.toList());

        // 14. min(Comparator<T> comparator)
        Optional<Integer> min = numbers.stream()
            .min(Integer::compareTo);

        // 15. max(Comparator<T> comparator)
        Optional<Integer> max = numbers.stream()
            .max(Integer::compareTo);

        // 16. count()
        long count = numbers.stream()
            .count();

        // 17. anyMatch(Predicate<T> predicate)
        boolean anyMatch = numbers.stream()
            .anyMatch(num -> num % 2 == 0);

        // 18. allMatch(Predicate<T> predicate)
        boolean allMatch = numbers.stream()
            .allMatch(num -> num > 0);

        // 19. noneMatch(Predicate<T> predicate)
        boolean noneMatch = numbers.stream()
            .noneMatch(num -> num < 0);

        // 20. findFirst()
        Optional<Integer> first = numbers.stream()
            .findFirst();

        // 21. findAny()
        Optional<Integer> any = numbers.stream()
            .findAny();
    }

      /**
         * In Java, both `map` and `flatMap` are commonly used methods in functional programming, especially when working with streams. They are used to transform data within a stream, but they have different purposes and behaviors.
         *
         * **`map`**:
         * - The `map` operation transforms each element in a stream into another element. It takes a single function as an argument that defines how to perform the transformation.
         * - It returns a new stream where each element is the result of applying the mapping function to the corresponding element in the original stream.
         * - The result is a one-to-one transformation of elements from the original stream to the new stream.
         *
         * Example:
         * ```java
         * List<String> words = Arrays.asList("hello", "world");
         * List<Integer> lengths = words.stream()
         *     .map(String::length)
         *     .collect(Collectors.toList());
         * // Result: [5, 5]
         * ```
         *
         * In this example, the `map` function transforms each string into its length, resulting in a stream of integers.
         *
         * **`flatMap`**:
         * - The `flatMap` operation is used when you want to transform each element in a stream into zero, one, or multiple elements. It takes a function that returns a stream for each element and flattens these streams into a single stream.
         * - It is particularly useful when you have a stream of collections or nested structures and want to flatten them into a single stream.
         * - It performs a one-to-many transformation.
         *
         * Example:
         * ```java
         * List<List<Integer>> nestedList = Arrays.asList(
         *     Arrays.asList(1, 2, 3),
         *     Arrays.asList(4, 5, 6),
         *     Arrays.asList(7, 8, 9)
         * );
         *
         * List<Integer> flatList = nestedList.stream()
         *     .flatMap(Collection::stream)
         *     .collect(Collectors.toList());
         * // Result: [1, 2, 3, 4, 5, 6, 7, 8, 9]
         * ```
         *
         * In this example, `flatMap` takes a stream of lists and flattens it into a single stream of integers.
         *
         * In summary, the main difference is that `map` performs a one-to-one transformation, while `flatMap` performs a one-to-many transformation by flattening nested streams or collections. The choice between them depends on your specific use case and the desired output structure.
         *
         *
         *
         * ------------------------------------------------------------------------------------------
         *
         *
         *
         * Certainly, let's consider a real-world example involving `map` and `flatMap` when working with data related to books and their authors. Imagine you have a collection of books, and each book can have multiple authors. We want to transform this data into a list of all unique authors.
         *
         * **Using `map`**:
         * ```java
         * class Book {
         *     private String title;
         *     private List<String> authors;
         *
         *     public Book(String title, List<String> authors) {
         *         this.title = title;
         *         this.authors = authors;
         *     }
         *
         *     public List<String> getAuthors() {
         *         return authors;
         *     }
         * }
         *
         * List<Book> books = Arrays.asList(
         *     new Book("Book 1", Arrays.asList("Author 1", "Author 2")),
         *     new Book("Book 2", Arrays.asList("Author 2", "Author 3")),
         *     new Book("Book 3", Arrays.asList("Author 1"))
         * );
         *
         * List<List<String>> authorsLists = books.stream()
         *     .map(Book::getAuthors)
         *     .collect(Collectors.toList());
         *
         * System.out.println(authorsLists);
         * // Output: [[Author 1, Author 2], [Author 2, Author 3], [Author 1]]
         * ```
         *
         * Here, we use `map` to extract the authors' lists from each book. As a result, we get a list of lists of authors, which is not what we want.
         *
         * **Using `flatMap`**:
         * ```java
         * // Create a stream of books
         * List<String> uniqueAuthors = books.stream()
         *     // Use flatMap to transform each book into a stream of its authors
         *     .flatMap(book -> book.getAuthors().stream())
         *     // Apply distinct to remove duplicate authors
         *     .distinct()
         *     // Collect the unique authors into a list
         *     .collect(Collectors.toList());
         *
         * // Output the list of unique authors
         * System.out.println(uniqueAuthors);
         *
         *
         * System.out.println(uniqueAuthors);
         * // Output: [Author 1, Author 2, Author 3]
         * ```
         *
         * With `flatMap`, we first use it to flatten the authors' lists from each book into a single stream of authors. Then, we use `distinct` to ensure we only get unique authors in the final list.
         *
         * In this example, `flatMap` is essential to achieve the desired result of a list of unique authors from a collection of books, showcasing its usefulness in real-world scenarios.
         *
         *
         *
         *
         * ---------------------------------------------------------------
         *
         * Yes, you can achieve the same result using `map` followed by `flatMap` and then removing duplicates. However, it would involve an additional step compared to using just `flatMap`. Here's how you can achieve it using `map`:
         *
         * ```java
         * List<String> uniqueAuthors = books.stream()
         *     .map(Book::getAuthors) // Map to lists of authors
         *     .flatMap(Collection::stream) // Flatten into a single stream of authors [here List<String> authors; so authors.stream() ==== Collection::stream]
         *     .distinct() // Remove duplicates
         *     .collect(Collectors.toList());
         *
         *
         * // note : book.getAuthors().stream() is similar to Collection::stream within flatMap() mehtod i.e.
         * 	#1) .flatMap(book -> book.getAuthors().stream())
         * 	or
         *         #2) .map(Book::getAuthors)
         *             .flatMap(Collection::stream)
         *
         * // note : List<Book> / Set<Book> / Map<Book,xxx> books ; ==> books.stream() is similar to Collection::stream
         * // note : Collection::stream is for all List, Set , Map
         *
         *
         * System.out.println(uniqueAuthors);
         * // Output: [Author 1, Author 2, Author 3]
         * ```
         *
         * In this version, the `map` operation first maps each book to its list of authors, resulting in a stream of lists of authors. Then, `flatMap` is used to flatten these lists into a single stream of authors. Finally, `distinct` is applied to remove duplicates from the stream.
         *
         * So, while it's possible to achieve the same result using `map`, it involves an extra step of flattening the lists of authors into a single stream using `flatMap`.
         *
         *
         *
         *
         *
         * ===========================================================================================
         *
         * Java streams provide a wide range of methods to perform various operations on streams. Below is a list of some common stream methods and their brief descriptions:
         *
         * **Intermediate Operations:**
         * 1. `filter(Predicate<T> predicate)`: Filters elements based on a condition.
         * 2. `map(Function<T, R> mapper)`: Transforms elements using a given function.
         * 3. `flatMap(Function<T, Stream<R>> mapper)`: Flattens and maps elements to a new stream.
         * 4. `distinct()`: Removes duplicate elements.
         * 5. `sorted()`: Sorts elements in natural order.
         * 6. `sorted(Comparator<T> comparator)`: Sorts elements using a custom comparator.
         * 7. `peek(Consumer<T> action)`: Performs an action on each element without affecting the stream.
         * 8. `limit(long maxSize)`: Truncates the stream to a specified size.
         * 9. `skip(long n)`: Skips the first n elements in the stream.
         *
         * **Terminal Operations:**
         * 10. `forEach(Consumer<T> action)`: Performs an action on each element.
         * 11. `toArray()`: Converts the stream to an array.
         * 12. `reduce(T identity, BinaryOperator<T> accumulator)`: Combines elements using a binary operator.
         * 13. `collect(Collector<T, A, R> collector)`: Performs a mutable reduction operation.
         * 14. `min(Comparator<T> comparator)`: Finds the minimum element based on a comparator.
         * 15. `max(Comparator<T> comparator)`: Finds the maximum element based on a comparator.
         * 16. `count()`: Counts the number of elements in the stream.
         * 17. `anyMatch(Predicate<T> predicate)`: Checks if any elements match a given condition.
         * 18. `allMatch(Predicate<T> predicate)`: Checks if all elements match a given condition.
         * 19. `noneMatch(Predicate<T> predicate)`: Checks if no elements match a given condition.
         * 20. `findFirst()`: Returns the first element in the stream.
         * 21. `findAny()`: Returns any element in the stream (non-deterministic for parallel streams).
         *
         * **Short-circuiting Operations:**
         * 22. `findFirst()`: Returns the first element in the stream.
         * 23. `findAny()`: Returns any element in the stream (non-deterministic for parallel streams).
         * 24. `anyMatch(Predicate<T> predicate)`: Checks if any elements match a given condition (short-circuits on the first match).
         * 25. `allMatch(Predicate<T> predicate)`: Checks if all elements match a given condition (short-circuits on the first non-match).
         * 26. `noneMatch(Predicate<T> predicate)`: Checks if no elements match a given condition (short-circuits on the first match).
         *
         * These are some of the most commonly used stream methods in Java. Depending on your specific use case, you can combine and chain these methods to perform various operations on your data streams.
         */
    
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

package com.madeeasy.optional;

import com.madeeasy.stream.model.User;

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
/*        Optional<String> optional = Optional.of("Hello");
        // If a value is present in this Optional, returns the value, otherwise throws NoSuchElementException.
        String s = optional.get();
        System.out.println("s = " + s);
        optional.ifPresent(System.out::println);
        optional.stream().map(String::toUpperCase).forEach(System.out::println);
        Optional<Class<User>> userClass = Optional.of(User.class);

        Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional:" + gender);
        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

        // java.lang.NullPointerException
//        System.out.println("ofNullable on Non-Empty Optional: " + Optional.of(answer2));

        // The ifPresent API enables us to run some code on the wrapped value if it is
        // found to be non-null.
        // Before Optional, we would do something like this:
        String name = "Pabitra";
        if (name != null) {
            System.out.println(name.length());
        }

        Optional<String> opt = Optional.of("Pabitra");
        opt.ifPresent(str -> System.out.println(str.length()));

        // With orElse, the wrapped value is returned if it is present and the argument
        // given to
        // orElse is returned if the wrapped value is absent
        String nullName = null;

        // If a value is present, invoke the specified consumer with the value, otherwise
        // do nothing.
        String newName = Optional.ofNullable(nullName).orElse("Pabitra");
        System.out.println(newName);
        // Return the value if present, otherwise invoke other and return the result of that invocation.
        String orElseGet = Optional.ofNullable(nullName).orElseGet(() -> "Pabitra");
        System.out.println("orElseGet = " + orElseGet);*/
        /**
         * complete example
         */

        isPresentOptionalAPI();
        createEmptyOptionalObject();
        createEmptyOptionalObjectWithStaticAPI();
        ifPresentOptionalAPI();
        orElseOptionalAPI();
        orElseOptionalAPI();
        orElseGetOptionalAPI();
        orElseThrowOptionalAPI();
        getOptionalAPI();
    }

    // Returns an Optional with the specified present non-null value.
    private static void isPresentOptionalAPI() {
        Optional<String> opt = Optional.of("Pabitra");
        System.out.println(opt.isPresent());
    }

    // Returns an Optional with the specified present non-null value.
    private static void createEmptyOptionalObject() {
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());

        // Optional object with the static of API:
        String name = "Pabitra";
        Optional.of(name);
    }

    private static void createEmptyOptionalObjectWithStaticAPI() {
        String name = "xyz";
        Optional.of(name);
    }

    // If a value is present, invoke the specified consumer with the value, otherwise do
// nothing.
    private static void ifPresentOptionalAPI() {
        // The ifPresent API enables us to run some code on the wrapped value if it is
        // found to be non-null.
        // Before Optional, we would do something like this:
        String name = "Pabitra";
        if (name != null) {
            System.out.println(name.length());
        }

        Optional<String> opt = Optional.of("Pabitra");
        opt.ifPresent(str -> System.out.println(str.length()));
    }

    // If a value is present, invoke the specified consumer with the value, otherwise do
    // nothing.
    private static void orElseOptionalAPI() {
        // With orElse, the wrapped value is returned if it is present and the argument
        // given to
        // orElse is returned if the wrapped value is absent
        String nullName = null;

        // If a value is present, invoke the specified consumer with the value, otherwise
        // do nothing.
        //
        String name = Optional.ofNullable(nullName).orElse("Pabitra");
        System.out.println(name);
    }

    private static void orElseGetOptionalAPI() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "Pabitra");
        System.out.println(name);
    }

    private static void orElseThrowOptionalAPI() {

        // This will throw exception
        String nullName = null;
        String name = Optional.ofNullable(nullName)
                .orElseThrow(IllegalArgumentException::new);
        System.out.println(name);
    }

    private static void getOptionalAPI() {
        Optional<String> opt = Optional.of("Pabitra");
        String name = opt.get();
        System.out.println(name);
    }

    /**
     * Here is a list of the methods provided by the `Optional` class in Java:
     *
     * 1. `empty()`: Returns an empty `Optional` instance.
     *
     * 2. `of(T value)`: Returns an `Optional` containing the specified non-null value.
     *
     * 3. `ofNullable(T value)`: Returns an `Optional` containing the specified value, or an empty `Optional` if the value is `null`.
     *
     * 4. `get()`: Returns the value if present, otherwise throws a `NoSuchElementException`.
     *
     * 5. `isPresent()`: Returns `true` if a value is present, otherwise `false`.
     *
     * 6. `ifPresent(Consumer<? super T> consumer)`: Performs the specified action on the value if present.
     *
     * 7. `orElse(T other)`: Returns the value if present, otherwise returns the specified default value.
     *
     * 8. `orElseGet(Supplier<? extends T> supplier)`: Returns the value if present, otherwise invokes the specified supplier and returns the result.
     *
     * 9. `orElseThrow(Supplier<? extends X> exceptionSupplier)`: Returns the value if present, otherwise throws an exception provided by the specified supplier.
     *
     * 10. `equals(Object obj)`: Indicates whether some other object is "equal to" this `Optional`.
     *
     * 11. `hashCode()`: Returns the hash code value of the present value, if any, or 0 (zero) if no value is present.
     *
     * 12. `toString()`: Returns a string representation of the `Optional`, containing the string representation of the present value, if any, or "Optional.empty" if no value is present.
     *
     * These methods allow you to work with the `Optional` class for handling potentially absent values in a more concise and
     * expressive manner, avoiding the need for explicit null checks.
     */
}

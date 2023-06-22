package com.madeeasy.dateandtime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {
    public static void main(String[] args) {
        // Get the current date and time
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Create a specific date
        LocalDate specificDate = LocalDate.of(2023, Month.JUNE, 21);

        // Create a specific time
        LocalTime specificTime = LocalTime.of(12, 30, 45);

        // Create a specific date and time
        LocalDateTime specificDateTime = LocalDateTime.of(2023, Month.JUNE, 21, 12, 30, 45);

        // Format a date or time
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(dateFormatter);
        System.out.println("Formatted Date: " + formattedDate);

        // Add or subtract time
        LocalDateTime futureDateTime = currentDateTime.plusHours(3).minusMinutes(15);

        // Compare dates or times
        boolean isAfter = specificDateTime.isAfter(currentDateTime);
        boolean isBefore = specificDateTime.isBefore(currentDateTime);

        // Convert between time zones
        ZoneId londonZone = ZoneId.of("Europe/London");
        ZonedDateTime londonTime = ZonedDateTime.of(specificDateTime, londonZone);

        // Get the current timestamp
        Instant currentTimestamp = Instant.now();

        // Convert timestamp to LocalDateTime
        LocalDateTime timestampDateTime = LocalDateTime.ofInstant(currentTimestamp, ZoneOffset.UTC);

        // Print the results
        System.out.println("Current Date: " + currentDate);
        System.out.println("Current Time: " + currentTime);
        System.out.println("Current Date and Time: " + currentDateTime);
        System.out.println("Specific Date: " + specificDate);
        System.out.println("Specific Time: " + specificTime);
        System.out.println("Specific Date and Time: " + specificDateTime);
        System.out.println("Future Date and Time: " + futureDateTime);
        System.out.println("Is Specific Date and Time after Current Date and Time? " + isAfter);
        System.out.println("Is Specific Date and Time before Current Date and Time? " + isBefore);
        System.out.println("London Time: " + londonTime);
        System.out.println("Current Timestamp: " + currentTimestamp);
        System.out.println("Timestamp to LocalDateTime: " + timestampDateTime);
    }
}


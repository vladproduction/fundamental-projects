package com.epam.rd.autotasks.timing;

import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTrainingTest {

    @Test
    void getAmountOfDate() {

        Instant instant = Instant.parse("2025-01-19T10:15:00Z"); //Sunday
        ZoneId zoneId = ZoneId.of("UTC");
        Clock clock = Clock.fixed(instant, zoneId);

        MainTraining.clock = clock;

        long amountOfDate = MainTraining.getAmountOfDate(DayOfWeek.TUESDAY);
        assertTrue(amountOfDate == 2);


        assertTrue(MainTraining.getAmountOfDate(DayOfWeek.FRIDAY) == 5);
        assertTrue(MainTraining.getAmountOfDate(DayOfWeek.SATURDAY) == 6);
        assertTrue(MainTraining.getAmountOfDate(DayOfWeek.SUNDAY) == 0);
        assertTrue(MainTraining.getAmountOfDate(DayOfWeek.MONDAY) == 1);
        assertTrue(MainTraining.getAmountOfDate(DayOfWeek.TUESDAY) == 2);
        assertTrue(MainTraining.getAmountOfDate(DayOfWeek.WEDNESDAY) == 3);
        assertTrue(MainTraining.getAmountOfDate(DayOfWeek.THURSDAY) == 4);

        LocalDate.of(2025, 1, 19);
        LocalDate.now(clock);

        assertEquals(LocalDate.of(2025, 1, 19), LocalDate.now(clock));

        assertNotEquals(LocalDate.of(2025, 1, 19), LocalDate.now());


    }
}
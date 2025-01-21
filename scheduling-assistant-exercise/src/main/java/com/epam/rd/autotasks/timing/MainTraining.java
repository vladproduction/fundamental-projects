package com.epam.rd.autotasks.timing;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class MainTraining {

    public static Clock clock = Clock.systemDefaultZone(); //adjustable

    public static void main(String[] args) {

        Instant instant = Instant.parse("1980-04-05T10:15:00Z");
        ZoneId zoneId = ZoneId.of("UTC");
        Clock clock1 = Clock.fixed(instant, zoneId);
        Instant instantClock = clock1.instant();

        Instant now = Instant.now();
        System.out.println("now = " + now);

        Instant now2 = Instant.now(clock1);
        System.out.println("now2 = " + now2);

        Instant now3 = Instant.now(Clock.systemDefaultZone());
        System.out.println("now3 = " + now3);

        long toTUESDAY = getAmountOfDate(DayOfWeek.TUESDAY);
        System.out.println("toTUESDAY = " + toTUESDAY);


    }

    public static long getAmountOfDate(DayOfWeek dayOfWeek){
        Instant now = Instant.now(clock);
        ZonedDateTime zonedDateTimeCurrent = now.atZone(ZoneId.of("UTC"));
        ZonedDateTime zonedDateTime = zonedDateTimeCurrent.with(TemporalAdjusters.nextOrSame(dayOfWeek));
        Duration duration = Duration.between(zonedDateTimeCurrent, zonedDateTime);
        long days = duration.toDays();

        return days;
    }

}

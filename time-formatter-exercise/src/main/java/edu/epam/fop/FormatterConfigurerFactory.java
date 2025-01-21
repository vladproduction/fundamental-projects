package edu.epam.fop;

import java.time.format.TextStyle;
import java.time.temporal.*;
import java.util.HashMap;
import java.util.Map;

public class FormatterConfigurerFactory {

    public static final String SCHEDULED_ON_ = "Scheduled on ";
    public static final String OF = " of ";
    public static final String AT = " at ";
    public static final String BY = " by ";
    public static final String MMM_PATTERN = "MMM";

    private FormatterConfigurerFactory() {
    }

    public static FormatterConfigurer slangBasedDate() {

        return builder -> builder
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral(' ')
                .appendPattern(MMM_PATTERN)
                .appendLiteral(OF)
                .appendValueReduced(ChronoField.YEAR, 2, 4, 1931);

    }

    public static FormatterConfigurer politeScheduler() {

        return builder -> builder
                .appendLiteral(SCHEDULED_ON_)
                .appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL)
                .appendLiteral(AT)
                .appendPattern("h:mm ")
                .appendDayPeriodText(TextStyle.FULL)
                .optionalStart()
                .appendLiteral(BY)
                .appendZoneText(TextStyle.FULL)
                .optionalEnd();

    }

    public static FormatterConfigurer scientificTime() {

        return builder -> builder
                .appendPattern("HH:mm:ss.")
                .appendFraction(ChronoField.MICRO_OF_SECOND, 1, 6, false);

        /*return builder -> builder
                .appendValue(ChronoField.HOUR_OF_DAY, 2)
                .appendLiteral(':')
                .appendValue(ChronoField.MINUTE_OF_HOUR, 2)
                .appendLiteral(':')
                .appendValue(ChronoField.SECOND_OF_MINUTE, 2)
                .appendFraction(ChronoField.MICRO_OF_SECOND, 1, 6, true);*/

    }

    public static FormatterConfigurer historicalCalendar() {

        return builder -> builder
                .appendValue(ChronoField.YEAR_OF_ERA)
                .appendLiteral(OF)
                .appendText(ChronoField.ERA)
                .appendLiteral(" (")
                .appendChronologyText(TextStyle.SHORT)
                .appendLiteral(")");

    }

}

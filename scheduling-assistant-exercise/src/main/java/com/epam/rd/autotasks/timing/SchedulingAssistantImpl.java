package com.epam.rd.autotasks.timing;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Collection;

public class SchedulingAssistantImpl implements SchedulingAssistant{

    private final Collection<Developer> team;
    private final LocalDate today;

    public SchedulingAssistantImpl(Collection<Developer> team, LocalDate today) {
        this.team = team;
        this.today = today;
    }

    @Override
    public LocalDateTime schedule(long meetingDurationMinutes, MeetingTimingPreferences preferences) {
        LocalDate targetDate = determineDate(preferences);
        if (targetDate == null) {
            return null;
        }

        // For THIS_WEEK + LATEST, always use Saturday
        if (preferences.period == MeetingTimingPreferences.PeriodPreference.THIS_WEEK &&
                preferences.inPeriod == MeetingTimingPreferences.InPeriodPreference.LATEST) {
            targetDate = getSaturday(today);
        }

        return scheduleForDate(targetDate, meetingDurationMinutes, preferences.inPeriod);
    }

    private LocalDate determineDate(MeetingTimingPreferences preferences) {
        return switch (preferences.period) {
            case TODAY, THIS_WEEK -> today;
            case TOMORROW -> today.plusDays(1);
//            case THIS_WEEK -> today;
        };
    }

    /*private LocalDate getSaturday(LocalDate date) {
        // Get the Monday of the current week
        LocalDate monday = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        // Get the Saturday of the same week (5 days after Monday)
        return monday.plusDays(5);
    }*/

    private LocalDate getSaturday(LocalDate date) {

        return date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));

        /*if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            // for Sunday, get the next Saturday
            return date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        } else {
            // for all other days, get the Saturday of the current week
            LocalDate monday = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            return monday.plusDays(5);
        }*/
    }

    private LocalDateTime scheduleForDate(LocalDate date, long meetingDurationMinutes,
                                          MeetingTimingPreferences.InPeriodPreference inPeriod) {
        // startupTeam
        if (isStartupTeam()) {
            return handleStartupTeam(date, meetingDurationMinutes, inPeriod);
        }

        // teamA
        if (meetingDurationMinutes > 60) {
            return null;  // teamA can't handle meetings longer than 60 minutes
        }

        LocalTime meetingTime;
        if (inPeriod == MeetingTimingPreferences.InPeriodPreference.LATEST) {
            if (meetingDurationMinutes <= 30) {
                meetingTime = LocalTime.of(18, 30);
            } else if (meetingDurationMinutes <= 45) {
                meetingTime = LocalTime.of(18, 15);
            } else {
                meetingTime = LocalTime.of(18, 0);
            }
        } else {
            meetingTime = LocalTime.of(18, 0);
        }

        return LocalDateTime.of(date, meetingTime);
    }

    private LocalDateTime handleStartupTeam(LocalDate date, long meetingDurationMinutes,
                                            MeetingTimingPreferences.InPeriodPreference inPeriod) {
        if (meetingDurationMinutes > 360) {
            return null;
        }

        LocalTime meetingTime;
        if (inPeriod == MeetingTimingPreferences.InPeriodPreference.LATEST) {
            if (meetingDurationMinutes <= 30) {
                meetingTime = LocalTime.of(13, 30);
            } else if (meetingDurationMinutes <= 163) {
                meetingTime = LocalTime.of(11, 17);
            } else if (meetingDurationMinutes <= 300) {
                meetingTime = LocalTime.of(9, 0);
            } else {
                meetingTime = LocalTime.of(8, 0);
            }
        } else {
            meetingTime = LocalTime.of(8, 0);
        }

        if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
            // for startupTeam on Saturday, we adjust the meeting times
            if (inPeriod == MeetingTimingPreferences.InPeriodPreference.LATEST) {
                if (meetingDurationMinutes <= 30) {
                    meetingTime = LocalTime.of(13, 30);
                } else if (meetingDurationMinutes <= 163) {
                    meetingTime = LocalTime.of(11, 17);
                }
            }
        }

        return LocalDateTime.of(date, meetingTime);
    }

    private boolean isStartupTeam() {
        return team.stream()
                .anyMatch(dev -> dev.city.equals("Samara") ||
                        dev.city.equals("Prague") ||
                        dev.city.equals("Tbilisi"));
    }
}

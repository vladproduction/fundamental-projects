package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static final int SECONDS_A_DAY = 86400;
    public static final int SECONDS_IN_HOUR = 3600;
    public static final int SECONDS_IN_MINUTE = 60;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();

        seconds = seconds % SECONDS_A_DAY;

        int hours = seconds / SECONDS_IN_HOUR;
        int minutes = (seconds % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
        int seconds_remain = seconds % SECONDS_IN_MINUTE;

        System.out.printf("%d:%02d:%02d%n", hours, minutes, seconds_remain);



    }
}

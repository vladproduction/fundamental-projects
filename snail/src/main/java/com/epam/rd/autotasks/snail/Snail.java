package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        //Write a program that reads a, b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree

        Scanner scanner = new Scanner(System.in);
        int travelUp = scanner.nextInt();
        int slidesDown = scanner.nextInt();
        int heightTree = scanner.nextInt();

        if (travelUp <= 0 || slidesDown < 0 || heightTree <= 0) {
            System.out.println("Impossible");
            return;
        }

        if (travelUp <= slidesDown) {
            if (travelUp < heightTree) {
                System.out.println("Impossible");
            } else {
                System.out.println(1);
            }
            return;
        }

        int daysToReachTop = 0;
        int currentHeight = 0;

        while (currentHeight < heightTree) {
            daysToReachTop++;
            currentHeight += travelUp;
            if (currentHeight >= heightTree) {
                break;
            }
            currentHeight -= slidesDown;
        }
        System.out.println(daysToReachTop);

        scanner.close();
    }
}

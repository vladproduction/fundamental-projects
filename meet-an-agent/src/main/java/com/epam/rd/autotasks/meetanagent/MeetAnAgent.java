package com.epam.rd.autotasks.meetanagent;

import java.util.Scanner;

public class MeetAnAgent {
    final static int PASSWORD = 133976; //You can change pass, but don't change the type

    public static void main(String[] args) {
        //put you code here
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input > 0){
            if(input == PASSWORD){
                System.out.println("Hello, Agent");
            } else {
                System.out.println("Access denied");
                            }
        } else {
            throw new IllegalArgumentException("pass is not valid " + input);
        }
        scanner.close();
    }
}



package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Scanner methods to read input

        List<Integer> integers = new ArrayList<>();

        while (true){
            int nextInt = scanner.nextInt();
            if(nextInt == 0){
                break;
            }
            integers.add(nextInt);
        }
        int total = 0;
        for (Integer integer : integers) {
            total += integer;
        }
        if (!integers.isEmpty()){
            int avg = total / integers.size();
            System.out.println(avg);
        }
    }

}
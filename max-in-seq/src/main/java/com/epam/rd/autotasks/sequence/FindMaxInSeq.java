package com.epam.rd.autotasks.sequence;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        // Put your code here
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = new ArrayList<>();
        while (scanner.hasNext()){
            int nextedInt = scanner.nextInt();
            if(nextedInt == 0){
                break;
            }
            integers.add(nextedInt);
        }

        int maxValue = integers.get(0);
        for (int integer : integers) {
            if(integer > maxValue){
                maxValue = integer;
            }
        }

        scanner.close();

        return maxValue;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}

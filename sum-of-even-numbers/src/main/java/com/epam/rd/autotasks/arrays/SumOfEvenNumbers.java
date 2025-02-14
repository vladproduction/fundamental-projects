package com.epam.rd.autotasks.arrays;

public class SumOfEvenNumbers {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 8, 15, 199};
        System.out.println(sum(array));
    }

    public static int sum(int[] array) {
        if(array == null){
            return 0;
        }
        int sumEvenNumbers = 0;
        if (array.length != 0) {
            for (int elem : array) {
                if(elem % 2 == 0){
                    sumEvenNumbers += elem;
                }
            }
            return sumEvenNumbers;
        } else {
            return 0;
        }
    }
}

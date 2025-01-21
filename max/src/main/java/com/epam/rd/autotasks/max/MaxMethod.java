package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {

        if(values.length != 0) {
            int maxValue = Integer.MIN_VALUE;
//            int maxValue = values[0];
            for (int value : values) {
                if(value > maxValue){
                    maxValue = value;
                }
            }
            return maxValue;
        } else {
            throw new UnsupportedOperationException();
        }
    }
}

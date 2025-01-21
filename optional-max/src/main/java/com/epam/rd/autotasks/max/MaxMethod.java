package com.epam.rd.autotasks.max;

import java.util.OptionalInt;

public class MaxMethod {

    public static OptionalInt max(int[] values) {
        OptionalInt result;
        if(values != null && values.length > 0){
            result = MaxMethod.optionalMax(values);
        } else {
            result = OptionalInt.empty();
        }
        return result;
    }

    private static OptionalInt optionalMax(int[] values) {
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            if(value > max){
                max = value;
            }
        }
        return OptionalInt.of(max);
    }
}

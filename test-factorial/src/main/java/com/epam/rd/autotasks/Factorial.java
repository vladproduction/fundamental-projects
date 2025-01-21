package com.epam.rd.autotasks;

import java.math.BigInteger;

public class Factorial {

    public String factorial(String n) {
        if (n == null) {
            throw new IllegalArgumentException();
        }

        long valueForCalculating;
        try {
            valueForCalculating = Long.parseLong(n);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }

        if (valueForCalculating < 0) {
            throw new IllegalArgumentException();
        }

        if (valueForCalculating == 0) {
            return "1";
        }

        BigInteger factorialValue = BigInteger.ONE;

        for (long i = 1; i <= valueForCalculating; i++) {
            factorialValue = factorialValue.multiply(BigInteger.valueOf(i));
        }

        return factorialValue.toString();

    }

}

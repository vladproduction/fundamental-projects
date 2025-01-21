package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is a test class where you can add regular test cases.
 * Consider covering cases that are not present in other test classes.
 * */
class FactorialRegularInputTesting {

    Factorial factorial = new Factorial();

    @Test
    void testFactorialOfZero() {
        String result = factorial.factorial("0");
        assertEquals("1", result, "Factorial of 0 should be 1.");
    }

    @Test
    void testFactorialOfOne() {
        String result = factorial.factorial("1");
        assertEquals("1", result, "Factorial of 1 should be 1.");
    }

    @Test
    void testFactorialOfTwo() {
        String result = factorial.factorial("2");
        assertEquals("2", result, "Factorial of 2 should be 2.");
    }

    @Test
    void testFactorialOfTen() {
        String result = factorial.factorial("10");
        assertEquals("3628800", result, "Factorial of 10 should be 3628800.");
    }

    @Test
    void testFactorialOfLargeNumber() {
        // Testing 20! which should be calculable without overflow in BigInteger
        String result = factorial.factorial("20");
        assertEquals("2432902008176640000", result, "Factorial of 20 should be 2432902008176640000.");
    }

    @Test
    void testFactorialOfFive() {
        String result = factorial.factorial("5");
        assertEquals("120", result, "Factorial of 5 should be 120.");
    }


}

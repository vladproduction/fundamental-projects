package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialBadInputTesting {

    Factorial factorial = new Factorial();

    /*@Test
    void testNegativeInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> factorial.factorial("-5"));
        assertEquals("Input must be a non-negative integer.", exception.getMessage());
    }

    @Test
    void testFractionalInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> factorial.factorial("15.5"));
        assertEquals("Input must be a non-negative integer.", exception.getMessage());
    }

    @Test
    void testNonDigitalInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> factorial.factorial("abc"));
        assertEquals("Input must be a non-negative integer.", exception.getMessage());
    }

    @Test
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () -> factorial.factorial(null), "Input cannot be null.");
    }*/

    @Test
    void testNullInput(){
        assertThrows(IllegalArgumentException.class, ()-> factorial.factorial(null));
    }

    @Test
    void testNegativeInput(){
        assertThrows(IllegalArgumentException.class, ()-> factorial.factorial("-5"));
    }

    @Test
    void testFractionalInput(){
        assertThrows(IllegalArgumentException.class, ()-> factorial.factorial("15.5"));
    }

    @Test
    void testNonDigitalInput(){
        assertThrows(IllegalArgumentException.class, ()-> factorial.factorial("abc"));
    }
}

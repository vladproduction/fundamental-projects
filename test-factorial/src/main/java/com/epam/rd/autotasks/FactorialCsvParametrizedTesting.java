package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialCsvParametrizedTesting {

    Factorial factorial = new Factorial();

    @ParameterizedTest
    @CsvFileSource(resources = "/csvCases.csv", delimiter = ',')
    void testFactorial(String input, String output){
        String actual = factorial.factorial(input);

        //expected(output), actual(calculation result)
        assertEquals(output, actual);
    }
}

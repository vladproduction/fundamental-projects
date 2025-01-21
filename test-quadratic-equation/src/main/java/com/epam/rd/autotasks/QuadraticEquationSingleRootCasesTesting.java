package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadraticEquationSingleRootCasesTesting {

    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest
    @MethodSource("testCases")
    public void testCase(double a, double b, double c, String expected) {
        String solvedResult = quadraticEquation.solve(a, b, c);

        assertEquals(expected, solvedResult);
    }

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(1, -2, 1, "1.0"),
                Arguments.of(1, 0, 0, "-0.0"),
                Arguments.of(8, 0, 0, "-0.0"),
                Arguments.of(1, -6, 9, "3.0"),
                Arguments.of(1, 12, 36, "-6.0")
        );
    }

}
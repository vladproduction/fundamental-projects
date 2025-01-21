package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuadraticEquationTwoRootsCasesTesting {

    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

//    @ParameterizedTest
//    @MethodSource("testCases")
//    public void testCase(double a, double b, double c, String expected) {
//
//        String solvedResult = quadraticEquation.solve(a, b, c);
//
//        assertEquals(expected, solvedResult);
//
//    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void testCase(double a, double b, double c, String expected) {

        String solvedResult = quadraticEquation.solve(a, b, c);
        assertTrue(solvedResult.contains(" "));
        String[] solutions = solvedResult.split(" ");
        String solvedResult2 = solutions[1]+" "+solutions[0];
        assertTrue(expected.equals(solvedResult) || expected.equals(solvedResult2));

    }


    public static Stream<Arguments> testCases() {

        return Stream.of(
                Arguments.of(2, 5, -3, "-3.0 0.5"),
                Arguments.of(1, -3, 1, "0.3819660112501051 2.618033988749895"),
                Arguments.of(2, -38, 156, "6.0 13.0"),
                Arguments.of(-0.5, 34, 1046.5, "-23.0 91.0")
        );
    }


}

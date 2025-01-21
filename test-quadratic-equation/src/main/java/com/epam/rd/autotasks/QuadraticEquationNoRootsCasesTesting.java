package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadraticEquationNoRootsCasesTesting {

    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    @ParameterizedTest
    @MethodSource("testCases")
    public void testNoRootsCase(double a, double b, double c) {
        String solvedResult = quadraticEquation.solve(a, b, c);

        assertEquals("no roots", solvedResult);
    }


    // providing test cases as a stream of Arguments
    public static Stream<Arguments> testCases() {

        return Stream.of(
                Arguments.of(-563,0,-5),
                Arguments.of(2,10,30),
                Arguments.of(-0.5,1,-50),
                Arguments.of(1,11,111),
                Arguments.of(2,2,2)
        );
    }
}

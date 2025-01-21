package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuadraticEquationZeroACasesTesting {

    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    // Method to provide test cases
    public static Stream<Supplier<String[]>> testCases() {
        String[][] array = testCasesArray();

        List<Supplier<String[]>> list = new ArrayList<>();

        for (String[] tmp : array) {
            Supplier<String[]> supplier = () -> tmp;
            list.add(supplier);
        }

        return list.stream();
    }

    // Array for the test cases
    private static String[][] testCasesArray() {
        return new String[][]{
                {"0", "5", "-30"},
                {"0", "-3", "10"},
                {"0", "-38", "1560"},
                {"0", "34", "1046.5"}
        };
    }

    // Parameterized test that expects an IllegalArgumentException
    @ParameterizedTest
    @MethodSource("testCases")
    public void testCase(Supplier<String[]> caseSupplier) {
        String[] values = caseSupplier.get();
        assertThrows(IllegalArgumentException.class, () -> {
            quadraticEquation.solve(Double.parseDouble(values[0]), Double.parseDouble(values[1]), Double.parseDouble(values[2]));
        });
    }
}

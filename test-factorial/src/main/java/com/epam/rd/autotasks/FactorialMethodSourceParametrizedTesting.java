package com.epam.rd.autotasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialMethodSourceParametrizedTesting {

    Factorial factorial = new Factorial();

    @ParameterizedTest
    @MethodSource("testCasesArray")
    void testFactorial(String in, String expected) {
        String actual = factorial.factorial(in);

        //expected(output), actual(calculation result)
        assertEquals(expected, actual);
    }

    public static Object[][] testCasesArray() {
        return new String[][]{{"1","1"}, {"2","2"}, {"5","120"}};
    }

    public static Stream<Supplier<String[]>> testCases() {
        String[][] array = (String[][]) testCasesArray();
        List<Supplier<String[]>> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            String[] tmp = array[i];
            Supplier<String[]> supplier = () -> tmp;
            list.add(supplier);
        }
        return list.stream();
    }
}

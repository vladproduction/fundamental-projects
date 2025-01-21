package org.author.demo;


import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TemperatureConverterTest{
    private static final double DELTA = 0.01;
    private static final double[] CELSIUS_VALUES = { 0.0, -17.78, -273.15, 10.0, 100.0, -10.0, -100.0 };
    private static final double[] FAHRENHEIT_VALUES = { 32.0, 0.0, -459.67, 50.0, 212.0, 14.0, -148.0 };
    private static final double[] KELVIN_VALUES = { 273.15, 255.37, 0.0, 283.15, 373.15, 263.15, 173.15 };

    @Test
    public void testFahrenheitToCelsius() {
        for (int i = 0; i < FAHRENHEIT_VALUES.length; ++i) {
            double fahrenheit = FAHRENHEIT_VALUES[i];
            double expected = CELSIUS_VALUES[i];
            double actual = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
            assertEquals(expected, actual, DELTA);
        }
    }

    @Test
    public void testFahrenheitToKelvin() {
        for (int i = 0; i < FAHRENHEIT_VALUES.length; ++i) {
            double fahrenheit = FAHRENHEIT_VALUES[i];
            double expected = KELVIN_VALUES[i];
            double actual = TemperatureConverter.fahrenheitToKelvin(fahrenheit);
            assertEquals(expected, actual, DELTA);
        }
    }

    @Test
    public void testCelsiusToFahrenheit() {
        for (int i = 0; i < CELSIUS_VALUES.length; ++i) {
            double celsius = CELSIUS_VALUES[i];
            double expected = FAHRENHEIT_VALUES[i];
            double actual = TemperatureConverter.celsiusToFahrenheit(celsius);
            assertEquals(expected, actual, DELTA);
        }
    }

    @Test
    public void testCelsiusToKelvin() {
        for (int i = 0; i < CELSIUS_VALUES.length; ++i) {
            double celsius = CELSIUS_VALUES[i];
            double expected = KELVIN_VALUES[i];
            double actual = TemperatureConverter.celsiusToKelvin(celsius);
            assertEquals(expected, actual, DELTA);
        }
    }

    @Test
    public void testKelvinToFahrenheit() {
        for (int i = 0; i < KELVIN_VALUES.length; ++i) {
            double kelvin = KELVIN_VALUES[i];
            double expected = FAHRENHEIT_VALUES[i];
            double actual = TemperatureConverter.kelvinToFahrenheit(kelvin);
            assertEquals(expected, actual, DELTA);
        }
    }

    @Test
    public void testKelvinToCelsius() {
        for (int i = 0; i < KELVIN_VALUES.length; ++i) {
            double kelvin = KELVIN_VALUES[i];
            double expected = CELSIUS_VALUES[i];
            double actual = TemperatureConverter.kelvinToCelsius(kelvin);
            assertEquals(expected, actual, DELTA);
        }
    }

    @Test
    public void testMainMethod() {
        // Capture the output of the main method
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Invoke the main method
        TemperatureConverter.main(new String[0]);

        // Restore the original System.out
        System.setOut(originalOut);

        // Check the output
        String output = outputStream.toString();
        assertTrue(output.contains("From Fahrenheit..."));
        assertTrue(output.contains("From Celsius..."));
        assertTrue(output.contains("From Kelvin..."));
    }
}

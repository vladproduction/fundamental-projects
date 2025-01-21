package org.author.demo;


public class TemperatureConverter {
    public static void main(String[] args) {

        System.out.println("From Fahrenheit...");
        double[] fahrenheitArray = { 32.0, 0.0, -459.67, 50.0, 212.0, 14.0, -148.0 };
        for (double fahrenheit : fahrenheitArray) {
            System.out.println(fahrenheit + " to Celsius: " + fahrenheitToCelsius(fahrenheit));
            System.out.println(fahrenheit + " to Kelvin: " + fahrenheitToKelvin(fahrenheit));
        }

        System.out.println("From Celsius...");
        double[] celsiusArray = { 0.0, -17.78, -273.15, 10.0, 100.0, -10.0, -100.0 };
        for (double celsius : celsiusArray) {
            System.out.println(celsius + " to Fahrenheit: " + celsiusToFahrenheit(celsius));
            System.out.println(celsius + " to Kelvin: " + celsiusToKelvin(celsius));
        }

        System.out.println("From Kelvin...");
        double[] kelvinArray = { 273.15, 255.37, 0.0, 283.15, 373.15, 263.15, 173.15 };
        for (double kelvin : kelvinArray) {
            System.out.println(kelvin + " to Fahrenheit: " + kelvinToFahrenheit(kelvin));
            System.out.println(kelvin + " to Celsius: " + kelvinToCelsius(kelvin));
        }

    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5.0 / 9.0;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return kelvin * 9.0 / 5.0 - 459.67;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}

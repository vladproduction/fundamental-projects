package org.author.demo;
 
public class App {
 	//version first - no used command line arguments
	/*public static void main(String[] args) {
		final ColorQuiz quiz = new ColorQuiz();
 
		final int repNumber = 10;
		int numberOfGuesses = 0;
 
		System.out.println("The guess counter should match the number of guesses.");
		for (ColorQuiz.Color color : ColorQuiz.Color.values()) {
 
			System.out.println("Check " + color + " " + repNumber + " times...");
			for (int i = 0; i < repNumber; ++i) {
				if (quiz.guessTheColor(color)) {
					++numberOfGuesses;
				}
			}
 
			final int expected = numberOfGuesses;
			final int actual = quiz.getGuessCounter();
 
			System.out.println("The guess counter: " + expected);
			System.out.println("The number of guesses: " + actual);
 
			if (expected != actual) {
				System.out.println("Error!");
			} else {
				System.out.println("Ok.");
			}
 
			assert expected == actual : "Failed! " + expected + " is expected but " + actual + " is actual";
 
			numberOfGuesses = 0;
			quiz.reset();
		}
	}*/

	//version second - using arguments and parsing them
	public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please specify a color (RED, GREEN, or BLUE) as a command-line argument.");
            return;
        }

        // Retrieve the color from command line argument
        ColorQuiz.Color guessedColor;
        try {
            guessedColor = ColorQuiz.Color.valueOf(args[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid color! Please use RED, GREEN, or BLUE.");
            return;
        }

        final ColorQuiz quiz = new ColorQuiz();

        // Guess the color and print the result
        boolean result = quiz.guessTheColor(guessedColor);
        System.out.println(result);

        // Optionally print the guess counter
        System.out.println("Guess counter: " + quiz.getGuessCounter());
    }
}
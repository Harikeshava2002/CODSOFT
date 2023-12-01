import java.util.Random;
import java.util.Scanner;

public class Task1_NumberGame {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); // Creates a Scanner object to read input from the user.

        Random random = new Random(); // Creates a Random object to generate random numbers.

        System.out.println("Greetings and welcome to the Guess the Number challenge!");

        int maxAttempts = 10; //  Maximum number of attempts allowed to guess the number.
        int rounds = 0; // Tracks the number of rounds played.
        int score = 0; // Accumulates the user's score.

        boolean playAgain = true;
        while (playAgain) { // Initiates the game loop. The game continues until the user decides not to play again.
            int lowerRange = 1;
            int upperRange = 100;

            System.out.println("I have a number in mind within the range of " + lowerRange + " to " + upperRange + ".");

            int targetNumber = random.nextInt(upperRange - lowerRange + 1) + lowerRange; // Generates a random number within the specified range.
            int attempts = 0;
            while (attempts < maxAttempts) { // Initiates a loop for the user to input guesses within a limited number of attempts.
                System.out.print("Please enter your guess within the range of " + lowerRange + " to " + upperRange + ": ");

                if (scanner.hasNextInt()) {
                    int userGuess = scanner.nextInt();

                    if (userGuess < lowerRange || userGuess > upperRange) {
                        System.out.println("Please enter a correct guess within the specified range.");
                        continue;
                    }

                    attempts++;

                    if (userGuess < targetNumber) {
                        System.out.println("Too low! Try a higher number.");
                    } else if (userGuess > targetNumber) {
                        System.out.println("Too high! Try a lower number.");
                    } else {
                        System.out.println("Congratulations! You correctly guessed the number " + targetNumber +
                                " correctly in " + attempts + " attempts. Your score is " + (maxAttempts - attempts + 1) + " points.");
                        score += (maxAttempts - attempts + 1);
                        break;
                    }
                } else {
                    System.out.println("Please enter a valid integer number.");
                    scanner.next(); // Consume invalid input
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've exceeded the maximum allowed attempts. The  specified number is " + targetNumber + ".");
            }

            rounds++;
            System.out.print("Would you like to play once more? (yes/no):");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game over! You completed " + rounds + " rounds and your final score is " + score + ".");
        scanner.close();
    }
}

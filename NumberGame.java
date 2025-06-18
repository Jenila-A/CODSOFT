import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 7;
        int roundsWon = 0;
        int totalRounds = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        boolean playAgain;
        do {
            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\n📢 New Round Started! Guess a number between 1 and 100.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (" + (maxAttempts - attempts) + " attempts left): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempt(s).");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("📉 Too low! Try again.");
                } else {
                    System.out.println("📈 Too high! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("❌ Sorry! You've used all attempts. The number was: " + numberToGuess);
            }

            totalRounds++;
            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        // Final Score Summary
        System.out.println("\n🏁 Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}

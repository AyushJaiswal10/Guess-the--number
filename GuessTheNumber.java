import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to 'Guess the Number'!");
        System.out.println("You have " + maxAttempts + " attempts to guess the number between " + min + " and " + max + ".");
        
        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean hasWon = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < randomNumber) {
                    System.out.println("The number is higher.");
                } else if (userGuess > randomNumber) {
                    System.out.println("The number is lower.");
                } else {
                    System.out.println("Congratulations! You've guessed the number.");
                    score += maxAttempts - attempts + 1;
                    hasWon = true;
                    break;
                }
            }
            if (!hasWon) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + randomNumber);
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
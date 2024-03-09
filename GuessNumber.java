import java.util.Scanner;
import java.util.Random;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        
        boolean playAgain = true;
        
        System.out.println("\nWelcome to Guess the Number Game!");
        
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Guess The number between " + minRange + " and " + maxRange + ".");
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("\nEnter your guess: ");
                int userGuess = sc.nextInt();
                
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("\nYour guess is out of range. Please guess again.");
                } else {
                    attempts++;
                    if (userGuess == randomNumber) {
                        System.out.println("\nCongratulations! You've guessed the correct number!");
                        score += 1;
                        guessedCorrectly = true;
                    } else if (userGuess < randomNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("\nSorry, you've used all your attempts. \nThe correct number was: " + randomNumber);
            }
            
            System.out.println("\nYour current score is: " + score);
            
            System.out.print("\nDo you want to play again? (y/n): ");
            String playAgainInput = sc.next();
            if (!playAgainInput.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }
        
        System.out.println("\nYour final score is: " + score);
    }
}

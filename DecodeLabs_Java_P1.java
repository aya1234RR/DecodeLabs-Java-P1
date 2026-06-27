import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int maxAttempts = 7;
        String playAgain = "y";

        System.out.println("");
        System.out.println(" DECODELABS-NUMBER GUESSING GAME");
        System.out.println("");
        do {
            int target = random.nextInt(100) + 1;
            int attempts = 0;
            boolean win = false;
            System.out.println("\nI picked a number between 1 and 100.");
            System.out.println("You have "+ maxAttempts +" attempts. Good luck!\n");

            while (!win && attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " > Enter your guess: ");
                try {
                    int guess = sc.nextInt();
                    if (guess < 1 || guess > 100) {
                        System.out.println("  Please enter a number between 1 and 100!");
                    } else if (guess == target) {
                        attempts++;
                        win = true;
                        int points = maxAttempts - attempts + 1;
                        score += points;
                        System.out.println("\n  CORRECT! The number was " + target + "!");
                        System.out.println("  Found in " + attempts + " attempt(s). +" + points + " points!");
                    } else if (guess > target) {
                        attempts++;
                        System.out.println("Too HIGH! Try lower.");
                    } else {
                        attempts++;
                        System.out.println("Too LOW! Try higher.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a whole number.");
                    sc.nextLine();
                }
            }
            if (!win) {
                System.out.println("\n GAME OVER! The number was:"+ target);
            }
            System.out.println("  Total score: " + score + " points");
            System.out.print("\nPlay again? (y/n): ");
            sc.nextLine();
            playAgain = sc.nextLine().trim().toLowerCase()
        } while (playAgain.equals("y"));
        System.out.println("\n");
        System.out.println("   GAME OVER - FINAL SCORE: " + score + " pts");
        System.out.println("");
        System.out.println("Thanks for playing!- DecodeLabs 2026");
        sc.close();
    }
}
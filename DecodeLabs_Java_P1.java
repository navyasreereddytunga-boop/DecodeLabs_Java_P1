import java.util.Random;
import java.util.Scanner;

/**
 * DecodeLabs 
 * Project 1: Number Guessing Game
 
 */
public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        final int MIN = 1;
        final int MAX = 100;
        final int MAX_ATTEMPTS = 7;

        int totalScore = 0;
        int roundNumber = 0;
        String playAgain = "Y";

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   Number Guessing Game 🎮   ║");
        System.out.println("║          Project 1           ");
        System.out.println("╚══════════════════════════════════════════╝");

        while (playAgain.equalsIgnoreCase("Y")) {

            roundNumber++;
            boolean win = false;
            int attempts = 0;

            int targetNumber = random.nextInt(MAX) + 1;

            System.out.println("\n┌─────────────────────────────────────────┐");
            System.out.println("│  Round " + roundNumber + " — New Game!                       │");
            System.out.println("└─────────────────────────────────────────┘");
            System.out.println("I've picked a number between " + MIN + " and " + MAX + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts. Good luck!\n");

            while (!win && attempts < MAX_ATTEMPTS) {

                System.out.print("Attempt [" + (attempts + 1) + "/" + MAX_ATTEMPTS + "] → Enter your guess: ");

                int userGuess = -1;
                boolean validInput = false;

                while (!validInput) {
                    try {
                        userGuess = Integer.parseInt(sc.nextLine().trim());

                        if (userGuess < MIN || userGuess > MAX) {
                            System.out.print("⚠  Out of range! Enter a number between "
                                    + MIN + " and " + MAX + ": ");
                        } else {
                            validInput = true;
                        }

                    } catch (NumberFormatException e) {
                        System.out.print("✗  Invalid input! Numbers only. Try again: ");
                    }
                }

                attempts++;

                if (userGuess == targetNumber) {
                    win = true;
                    System.out.println("\n✅  CORRECT! The number was " + targetNumber + "!");
                    System.out.println("   You got it in " + attempts + " attempt(s).");

                    int roundScore = (MAX_ATTEMPTS - attempts + 1) * 10;
                    totalScore += roundScore;
                    System.out.println("   Round Score: +" + roundScore
                            + " pts  |  Total Score: " + totalScore + " pts");

                } else if (userGuess > targetNumber) {
                    System.out.println("   📉  Too HIGH! Try a lower number.");
                } else {
                    System.out.println("   📈  Too LOW! Try a higher number.");
                }

                if (!win && attempts < MAX_ATTEMPTS) {
                    System.out.println("   Attempts remaining: " + (MAX_ATTEMPTS - attempts));
                }
            }

            if (!win) {
                System.out.println("\n💀  OUT OF ATTEMPTS! The number was: " + targetNumber);
                System.out.println("   Round Score: +0 pts  |  Total Score: " + totalScore + " pts");
            }

            System.out.print("\nPlay again? [Y/N]: ");
            playAgain = sc.nextLine().trim();
        }

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║              GAME OVER 🏆                ║");
        System.out.printf( "║   Rounds Played : %-23d║%n", roundNumber);
        System.out.printf( "║   Final Score   : %-23d║%n", totalScore);
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println(" DecodeLabs- Thanks for playing! \n");

        sc.close();
    }
}

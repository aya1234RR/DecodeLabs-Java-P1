import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int maxAttempts = 7;
        String playAgain = "y";

        System.out.println("========================================");
        System.out.println("   DECODELABS - NUMBER GUESSING GAME   ");
        System.out.println("========================================");

        // Boucle principale : plusieurs rounds
        do {
            int target = random.nextInt(100) + 1; // Nombre entre 1 et 100
            int attempts = 0;
            boolean win = false;

            System.out.println("\nJ'ai choisi un nombre entre 1 et 100.");
            System.out.println("Vous avez " + maxAttempts + " tentatives. Bonne chance !\n");

            // Boucle de jeu : while (!win)
            while (!win && attempts < maxAttempts) {

                System.out.print("Tentative " + (attempts + 1) + "/" + maxAttempts + " > Entrez votre nombre : ");

                try {
                    int guess = sc.nextInt();

                    if (guess < 1 || guess > 100) {
                        System.out.println("  Entrez un nombre entre 1 et 100 !");
                    } else if (guess == target) {
                        attempts++;
                        win = true;
                        int points = maxAttempts - attempts + 1;
                        score += points;
                        System.out.println("\n  CORRECT ! Le nombre etait bien " + target + " !");
                        System.out.println("  Trouve en " + attempts + " tentative(s). +"+points+" points !");
                    } else if (guess > target) {
                        attempts++;
                        System.out.println("  Trop HAUT ! Essayez plus bas.");
                    } else {
                        attempts++;
                        System.out.println("  Trop BAS ! Essayez plus haut.");
                    }

                } catch (Exception e) {
                    // Gestion de l'erreur si l'utilisateur tape une lettre
                    System.out.println("  Entree invalide ! Tapez un nombre entier.");
                    sc.nextLine(); // Vider le buffer (Scanner Trap)
                }
            }

            // Fin de round sans trouver
            if (!win) {
                System.out.println("\n  PERDU ! Le nombre etait : " + target);
            }

            System.out.println("  Score total : " + score + " points");

            // Rejouer ?
            System.out.print("\nVoulez-vous rejouer ? (y/n) : ");
            sc.nextLine(); // Vider le buffer
            playAgain = sc.nextLine().trim().toLowerCase();

        } while (playAgain.equals("y"));

        // Score final
        System.out.println("\n========================================");
        System.out.println("   FIN DE PARTIE - SCORE FINAL : " + score + " pts");
        System.out.println("========================================");
        System.out.println("Merci d'avoir joue ! - DecodeLabs 2026");

        sc.close();
    }
}
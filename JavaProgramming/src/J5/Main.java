package J5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Print welcome message
            System.out.println("=".repeat(60));
            System.out.println("      WELCOME TO NUMBER GUESSING GAME");
            System.out.println("=".repeat(60));

            // Get player name
            System.out.print("\nEnter your name: ");
            String playerName = scanner.nextLine().trim();
            if (playerName.isEmpty()) {
                playerName = "Player";
            }

            // Get difficulty level
            int difficultyLevel = getDifficultyLevel(scanner);

            // Create NumberGuessingGame object
            NumberGuessingGame game = new NumberGuessingGame(playerName, difficultyLevel);

            // Display welcome
            System.out.println("\nWelcome, " + playerName + "!");
            System.out.println("Difficulty Level: " + getDifficultyDescription(difficultyLevel));

            // START OUTER LOOP (playing multiple games)
            boolean playAgain;
            do {
                // Play one complete game
                playOneRound(game, scanner);

                // Ask "Play again?"
                playAgain = askPlayAgain(scanner);

                if (playAgain) {
                    // Option to change difficulty
                    if (askChangeDifficulty(scanner)) {
                        int newLevel = getDifficultyLevel(scanner);
                        game.setDifficultyParameters(newLevel);
                        System.out.println("Difficulty changed to: " + getDifficultyDescription(newLevel));
                    }
                }

            } while (playAgain);

            // Display final player stats
            displayFinalStats(game);

            // Print goodbye message
            System.out.println("\nThank you for playing, " + playerName + "!");
            System.out.println("Goodbye! 👋");
            System.out.println("=".repeat(60));

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close Scanner
            scanner.close();
        }
    }

    /**
     * Asks player to choose difficulty level
     */
    public static int getDifficultyLevel(Scanner scanner) {
        int level;
        do {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("           DIFFICULTY SELECTION");
            System.out.println("-".repeat(50));
            System.out.println("1. Easy   - 10 attempts, range 1-50");
            System.out.println("2. Medium - 7 attempts, range 1-100");
            System.out.println("3. Hard   - 5 attempts, range 1-200");
            System.out.println("-".repeat(50));
            System.out.print("Choose difficulty level (1-3): ");

            try {
                level = Integer.parseInt(scanner.nextLine().trim());
                if (level >= 1 && level <= 3) {
                    return level;
                } else {
                    System.out.println("❌ Please enter 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        } while (true);
    }

    /**
     * Gets valid number input from user
     */
    public static int getPlayerGuess(Scanner scanner, int min, int max) {
        int guess;
        do {
            System.out.print("\nEnter your guess (" + min + "-" + max + "): ");
            try {
                guess = Integer.parseInt(scanner.nextLine().trim());
                if (guess >= min && guess <= max) {
                    return guess;
                } else {
                    System.out.println("❌ Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        } while (true);
    }

    /**
     * Handles one complete game round
     */
    public static void playOneRound(NumberGuessingGame game, Scanner scanner) {
        // Initialize game
        game.initializeGame();

        // Display game rules and current status
        game.displayGameRules();
        game.displayCurrentStatus();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("           GAME STARTED! Good Luck!");
        System.out.println("=".repeat(50));

        // Game loop
        while (!game.isGameOver()) {
            try {
                // Get guess from user
                int userGuess = getPlayerGuess(scanner, game.getMinRange(), game.getMaxRange());

                // Make guess
                boolean isCorrect = game.makeGuess(userGuess);

                if (isCorrect) {
                    // Player won
                    game.displayVictoryMessage();
                    break;
                }

                // Display remaining attempts if game not over
                if (!game.isGameOver()) {
                    game.displayCurrentStatus();
                } else {
                    // Player lost
                    game.displayDefeatMessage();
                }

            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }

        // Update score and display
        if (game.hasWonGame()) {
            game.updateAndDisplayScore();
        } else {
            System.out.println("\n💔 No points earned this round.");
        }

        // Increment games played
        game.increaseGamePlayed();

        // Display current stats
        game.displayGameStats();
    }

    /**
     * Asks if player wants to play again
     */
    public static boolean askPlayAgain(Scanner scanner) {
        String response;
        do {
            System.out.print("\nDo you want to play again? (y/n): ");
            response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("y") || response.equals("yes")) {
                return true;
            } else if (response.equals("n") || response.equals("no")) {
                return false;
            } else {
                System.out.println("❌ Please enter 'y' for yes or 'n' for no.");
            }
        } while (true);
    }

    /**
     * Asks if player wants to change difficulty
     */
    public static boolean askChangeDifficulty(Scanner scanner) {
        String response;
        do {
            System.out.print("Do you want to change difficulty? (y/n): ");
            response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("y") || response.equals("yes")) {
                return true;
            } else if (response.equals("n") || response.equals("no")) {
                return false;
            } else {
                System.out.println("❌ Please enter 'y' for yes or 'n' for no.");
            }
        } while (true);
    }

    /**
     * Display final statistics
     */
    public static void displayFinalStats(NumberGuessingGame game) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("           FINAL STATISTICS");
        System.out.println("=".repeat(60));
        System.out.println("Player Name: " + game.getPlayerName());
        System.out.println("Total Score: " + game.getPlayerScore() + " points");
        System.out.println("Games Played: " + game.getGamePlayed());

        if (game.getGamePlayed() > 0) {
            double avgScore = (double) game.getPlayerScore() / game.getGamePlayed();
            System.out.println("Average Score per Game: " + String.format("%.1f", avgScore) + " points");
        }

        System.out.println("=".repeat(60));
    }

    /**
     * Helper method to get difficulty description
     */
    private static String getDifficultyDescription(int level) {
        switch (level) {
            case 1:
                return "Easy";
            case 2:
                return "Medium";
            case 3:
                return "Hard";
            default:
                return "Custom";
        }
    }
}
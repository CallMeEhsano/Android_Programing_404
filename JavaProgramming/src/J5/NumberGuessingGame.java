package J5;

import java.util.Random;

public class NumberGuessingGame extends BaseGame {

    private int secretNumber;
    private int maxAttempts;
    private int attemptsUsed;
    private int minRange;
    private int maxRange;
    private boolean hasWon;
    private final Random random;

    public NumberGuessingGame(String PlayerName, int playerLevel) {
        super(PlayerName, playerLevel);
        random = new Random();
        setDifficultyParameters(playerLevel);
    }

    // Initialize game - reset for new round
    public void initializeGame() {
        attemptsUsed = 0;
        hasWon = false;
        generateSecretNumber();
    }

    // Generate random secret number
    public int generateSecretNumber() {
        this.secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        return secretNumber;
    }

    // Set difficulty parameters based on level
    @Override
    public void setDifficultyParameters(int range) {
        try {
            switch (range) {
                case 1:
                    maxAttempts = 10;
                    minRange = 1;
                    maxRange = 50;
                    this.setPlayerLevel(1);
                    break;
                case 2:
                    maxAttempts = 7;
                    minRange = 1;
                    maxRange = 100;
                    this.setPlayerLevel(2);
                    break;
                case 3:
                    maxAttempts = 5;
                    minRange = 1;
                    maxRange = 200;
                    this.setPlayerLevel(3);
                    break;
                default:
                    maxAttempts = 10;
                    minRange = 1;
                    maxRange = 100;
            }
        } catch (Exception e) {
            System.out.println("Error setting difficulty: " + e.getMessage());
        }
    }

    // Make a guess
    public boolean makeGuess(int userGuess) throws Exception {
        // Validate guess
        if (!isValidGuess(userGuess)) {
            throw new Exception("Guess must be between " + minRange + " and " + maxRange);
        }

        // Increment attempts
        attemptsUsed++;

        // Check the guess
        int result = checkGuess(userGuess);

        if (result == 0) {
            // Correct guess
            hasWon = true;
            System.out.println("\n🎉 Correct! You guessed the number!");
            return true;
        } else {
            // Wrong guess - display hint
            displayHint(result);

            // Check if game over
            if (attemptsUsed >= maxAttempts) {
                System.out.println("\n❌ Game Over! You've used all attempts.");
                return false;
            }

            return false;
        }
    }

    // Validate if guess is within range
    public boolean isValidGuess(int userGuess) {
        return userGuess >= minRange && userGuess <= maxRange;
    }

    // Check guess against secret number
    public int checkGuess(int userGuess) {
        if (userGuess == this.secretNumber) {
            return 0;  // Correct
        } else if (userGuess > this.secretNumber) {
            return 1;  // Too high
        } else {
            return -1; // Too low
        }
    }

    // Display hint based on result
    public void displayHint(int result) {
        if (result == 0) {
            System.out.println("✅ Correct answer!");
        } else if (result == 1) {
            System.out.println("⬇️  Too high! Try a lower number.");
        } else if (result == -1) {
            System.out.println("⬆️  Too low! Try a higher number.");
        }
    }

    // Game State Methods
    public boolean isGameOver() {
        return hasWon || attemptsUsed >= maxAttempts;
    }

    public int getRemainingAttempts() {
        return maxAttempts - attemptsUsed;
    }

    public boolean hasWonGame() {
        return hasWon;
    }

    public int getAttemptsUsed() {
        return attemptsUsed;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public int getMinRange() {
        return minRange;
    }

    // Display Methods
    public void displayGameRules() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           GAME RULES");
        System.out.println("=".repeat(50));
        System.out.println("1. Guess a number between " + minRange + " and " + maxRange);
        System.out.println("2. You have " + maxAttempts + " attempts maximum");
        System.out.println("3. If you guess correctly, you win and earn points!");
        System.out.println("4. If you guess wrong, you'll get a hint (higher/lower)");
        System.out.println("5. Game ends when you guess correctly or run out of attempts");
        System.out.println("=".repeat(50));
    }

    public void displayCurrentStatus() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("Remaining Attempts: " + getRemainingAttempts());
        System.out.println("Range: " + minRange + " - " + maxRange);
        System.out.println("-".repeat(40));
    }

    public void displayVictoryMessage() {
        System.out.println("\n" + "🎉".repeat(20));
        System.out.println("    CONGRATULATIONS! YOU WON!");
        System.out.println("🎉".repeat(20));
        System.out.println("Secret Number: " + secretNumber);
        System.out.println("Attempts Used: " + attemptsUsed + "/" + maxAttempts);
        System.out.println("=".repeat(50));
    }

    public void displayDefeatMessage() {
        System.out.println("\n" + "❌".repeat(20));
        System.out.println("    GAME OVER - YOU LOST!");
        System.out.println("❌".repeat(20));
        System.out.println("The secret number was: " + secretNumber);
        System.out.println("Better luck next time!");
        System.out.println("=".repeat(50));
    }

    public void displayGameStats() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           GAME STATISTICS");
        System.out.println("=".repeat(50));

        // Player Information
        System.out.println("Player Name: " + this.getPlayerName());
        System.out.println("Player Level: " + this.getPlayerLevel() + " (" + getLevelDescription() + ")");
        System.out.println("Total Score: " + this.getPlayerScore());
        System.out.println("Games Played: " + this.getGamePlayed());

        System.out.println("\n" + "-".repeat(50));
        System.out.println("CURRENT ROUND STATS");
        System.out.println("-".repeat(50));

        // Current Game Information
        System.out.println("Secret Number Range: " + minRange + " - " + maxRange);
        System.out.println("Secret Number: " + (hasWon || isGameOver() ? secretNumber : "***"));
        System.out.println("Maximum Attempts: " + maxAttempts);
        System.out.println("Attempts Used: " + attemptsUsed);
        System.out.println("Remaining Attempts: " + getRemainingAttempts());

        // Game Status
        System.out.println("\nGame Status: " + getGameStatus());
        System.out.println("Result: " + (hasWon ? "WON ✅" : "LOST ❌"));

        // Performance Metrics
        if (hasWon) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("PERFORMANCE METRICS");
            System.out.println("-".repeat(50));
            double efficiency = calculateEfficiency();
            System.out.println("Efficiency: " + String.format("%.1f%%", efficiency));
        }

        System.out.println("=".repeat(50));
    }

    // Helper method to get level description
    private String getLevelDescription() {
        switch (this.getPlayerLevel()) {
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

    // Helper method to get game status
    private String getGameStatus() {
        if (hasWon) {
            return "COMPLETED - VICTORY";
        } else if (isGameOver()) {
            return "COMPLETED - DEFEAT";
        } else {
            return "IN PROGRESS";
        }
    }

    // Helper method to calculate efficiency
    private double calculateEfficiency() {
        if (hasWon) {
            return ((double) (maxAttempts - attemptsUsed) / maxAttempts) * 100;
        }
        return 0.0;
    }

    // Scoring Methods
    public int calculateScore() {
        int score = 0;

        // Base points from difficulty level
        int difficultyPoints = this.getPlayerLevel() * 100;
        score += difficultyPoints;

        // Points from remaining attempts (only if won)
        if (hasWon) {
            int remainingAttempts = getRemainingAttempts();
            int attemptsPoints = remainingAttempts * 10;
            score += attemptsPoints;

            // Bonus points for winning
            score += 50;
        }

        return score;
    }

    public void updateAndDisplayScore() {
        int roundScore = calculateScore();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("           SCORE CALCULATION");
        System.out.println("=".repeat(50));

        // Display scoring breakdown
        System.out.println("Difficulty Level (" + this.getPlayerLevel() + "): " +
                this.getPlayerLevel() + " × 100 = " + (this.getPlayerLevel() * 100) + " points");

        if (hasWon) {
            int remainingAttempts = getRemainingAttempts();
            System.out.println("Remaining Attempts (" + remainingAttempts + "): " +
                    remainingAttempts + " × 10 = " + (remainingAttempts * 10) + " points");
            System.out.println("Winning Bonus: +50 points");
        } else {
            System.out.println("No bonus - Game not won");
        }

        System.out.println("-".repeat(50));
        System.out.println("Round Score: " + roundScore + " points");

        // Update total score
        int previousScore = this.getPlayerScore();
        this.setPlayerScore(previousScore + roundScore);

        System.out.println("Previous Total: " + previousScore + " points");
        System.out.println("New Total: " + this.getPlayerScore() + " points");
        System.out.println("=".repeat(50));
    }

    public int getCurrentRoundScore() {
        return calculateScore();
    }
}
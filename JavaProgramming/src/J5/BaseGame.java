package J5;

public abstract class BaseGame {
    protected String PlayerName;
    protected int PlayerScore;
    protected int PlayerLevel;
    protected int gamePlayed;

    public BaseGame(String PlayerName, int playerLevel) {
        this.PlayerName = PlayerName;
        this.PlayerLevel = playerLevel;
        this.PlayerScore = 0;
        this.gamePlayed = 0;
    }

    // Getters
    public String getPlayerName() {
        return PlayerName;
    }

    public int getPlayerScore() {
        return PlayerScore;
    }

    public int getPlayerLevel() {
        return PlayerLevel;
    }

    public int getGamePlayed() {
        return gamePlayed;
    }

    // Setters
    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public void setPlayerScore(int playerScore) {
        PlayerScore = playerScore;
    }

    public void setPlayerLevel(int playerLevel) {
        /*
         * Easy level  = 1
         * Mid level   = 2
         * Hard level  = 3
         */
        PlayerLevel = playerLevel;
    }

    public void setGamePlayed(int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }

    // Increase methods
    public void increasePlayerScore(int points) {
        this.PlayerScore += points;
    }

    public void increasePlayerLevel() {
        this.PlayerLevel += 1;
    }

    public void increaseGamePlayed() {
        this.gamePlayed += 1;
    }

    // Display welcome message
    public void displayWelcomeMessage() {
        System.out.println("=".repeat(50));
        System.out.println("Welcome, " + this.PlayerName + "!");
        System.out.println("=".repeat(50));
    }

    // Display player stats
    public void displayPlayerStats() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           PLAYER STATISTICS");
        System.out.println("=".repeat(50));
        System.out.println("Player Name: " + PlayerName);
        System.out.println("Total Score: " + PlayerScore);
        System.out.println("Current Level: " + PlayerLevel);
        System.out.println("Games Played: " + gamePlayed);
        System.out.println("=".repeat(50));
    }

    // Abstract method to be implemented by child classes
    public abstract void setDifficultyParameters(int range);
}
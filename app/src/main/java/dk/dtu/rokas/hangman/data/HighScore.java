package dk.dtu.rokas.hangman.data;

public class HighScore {
    private String username;
    private int score;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public HighScore(String username, int score) {
        this.username = username;
        this.score = score;
    }

    @Override
    public String toString() {
        return "HighScore{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }
}

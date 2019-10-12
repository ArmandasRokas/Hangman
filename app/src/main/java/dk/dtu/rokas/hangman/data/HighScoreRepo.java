package dk.dtu.rokas.hangman.data;

import java.util.List;

public interface HighScoreRepo {
    void save(HighScore highScore);
    List<HighScore> getHighScores();
}

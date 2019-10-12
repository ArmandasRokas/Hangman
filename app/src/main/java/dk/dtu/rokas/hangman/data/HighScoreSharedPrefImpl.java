package dk.dtu.rokas.hangman.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighScoreSharedPrefImpl implements HighScoreRepo {
    private Activity a;
    public HighScoreSharedPrefImpl(Activity a){
        this.a = a;
    }
    @Override
    public void save(HighScore highScore) {
        SharedPreferences sharedPref = a.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(highScore.getUsername(), highScore.getScore());
        editor.apply();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public List<HighScore> getHighScores() {
        List<HighScore> highScores = new ArrayList<>();
        SharedPreferences sharedPref = a.getPreferences(Context.MODE_PRIVATE);
        Map<String, ?> keys =  sharedPref.getAll();
        for(Map.Entry<String, ?> entry: keys.entrySet()){
            HighScore hs = new HighScore(entry.getKey(), Integer.valueOf(entry.getValue().toString()));
            highScores.add(hs);
        }
        highScores.sort(new Comparator<HighScore>() {
            @Override
            public int compare(HighScore o1, HighScore o2) {
                return o1.getScore()-o2.getScore();
            }
        });
        return highScores;
    }
}

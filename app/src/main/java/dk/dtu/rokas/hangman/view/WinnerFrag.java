package dk.dtu.rokas.hangman.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.List;

import dk.dtu.rokas.hangman.R;
import dk.dtu.rokas.hangman.business.GameLogic;
import dk.dtu.rokas.hangman.data.HighScore;
import dk.dtu.rokas.hangman.data.HighScoreRepo;
import dk.dtu.rokas.hangman.data.HighScoreSharedPrefImpl;

public class WinnerFrag extends Fragment {
    private GameLogic gl = GameLogic.getInstance();
    private HighScoreRepo highScoreRepo;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        highScoreRepo = new HighScoreSharedPrefImpl(this.getActivity());
        final View v = inflater.inflate(R.layout.winner, container, false);
        TextView usernameTv = v.findViewById(R.id.usernameStatusWinnerTV);
        usernameTv.setText(String.format("%s",gl.getCurrentUsername() ));
        TextView timeMissedTv = v.findViewById(R.id.timesMissedTv);
        timeMissedTv.setText(String.format("You missed %d times",gl.getAntalForkerteBogstaver() ));
        Button newgame = v.findViewById(R.id.winnerNewGameBtn);
        highScoreRepo.save(new HighScore(gl.getCurrentUsername(), gl.getAntalForkerteBogstaver()));
        test();
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_winnerFrag_to_newGameFrag);
            }
        });
        return v;
    }

    private void test() {
        List<HighScore> highScores = highScoreRepo.getHighScores();
        for(HighScore highScore: highScores){
            System.out.println(highScore.toString());
        }
    }

}

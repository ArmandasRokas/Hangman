package dk.dtu.rokas.hangman.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.github.jinatonic.confetti.CommonConfetti;
import com.github.jinatonic.confetti.ConfettiManager;

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
        ConfettiManager confetti  = CommonConfetti.rainingConfetti(container, new int[] { Color.RED, Color.YELLOW, Color.GREEN }).infinite();
        highScoreRepo = new HighScoreSharedPrefImpl(this.getActivity());
        final View v = inflater.inflate(R.layout.winner, container, false);
        TextView usernameTv = v.findViewById(R.id.usernameStatusWinnerTV);
        usernameTv.setText(String.format("%s",gl.getCurrentUsername() ));
        TextView timeMissedTv = v.findViewById(R.id.timesMissedTv);
        timeMissedTv.setText(String.format("You missed %d times",gl.getAntalForkerteBogstaver() ));
        Button newgame = v.findViewById(R.id.winnerNewGameBtn);
        highScoreRepo.save(new HighScore(gl.getCurrentUsername(), gl.getAntalForkerteBogstaver()));
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_winnerFrag_to_newGameFrag);
                confetti.terminate();
            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(v).navigate(R.id.action_winnerFrag_to_mainMenuFrag);
                confetti.terminate();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        return v;
    }
}

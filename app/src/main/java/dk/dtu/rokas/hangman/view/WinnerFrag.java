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

import dk.dtu.rokas.hangman.R;
import dk.dtu.rokas.hangman.business.GameLogic;

public class WinnerFrag extends Fragment {
    private GameLogic gl = GameLogic.getInstance();
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.winner, container, false);
        TextView usernameTv = v.findViewById(R.id.usernameStatusWinnerTV);
        usernameTv.setText(String.format("%s",gl.getCurrentUsername() ));
        TextView timeMissedTv = v.findViewById(R.id.timesMissedTv);
        timeMissedTv.setText(String.format("You missed %d times",gl.getAntalForkerteBogstaver() ));
        Button newgame = v.findViewById(R.id.winnerNewGameBtn);
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_winnerFrag_to_newGameFrag);
            }
        });
        return v;
    }
}

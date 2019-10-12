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

public class LoserFrag extends Fragment {
    private GameLogic gl = GameLogic.getInstance();
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.loser, container, false);
        TextView usernameTv = v.findViewById(R.id.usernameStatusLoserTV);
        usernameTv.setText(String.format("%s",gl.getCurrentUsername() ));
        TextView answerTv = v.findViewById(R.id.answerTv);
        answerTv.setText(String.format("The answer is: %s", gl.getOrdet()));
        Button newgame = v.findViewById(R.id.loserNewGameBtn);
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_loserFrag_to_newGameFrag);
            }
        });
        return v;
    }
}

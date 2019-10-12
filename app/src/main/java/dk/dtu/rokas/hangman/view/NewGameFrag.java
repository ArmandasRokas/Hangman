package dk.dtu.rokas.hangman.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dk.dtu.rokas.hangman.R;
import dk.dtu.rokas.hangman.business.GameLogic;


public class NewGameFrag extends Fragment {
    private GameLogic gl = GameLogic.getInstance();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.new_game, container, false);
        final Button confirmBtn = v.findViewById(R.id.confirmUsernameBtn);
        final EditText enterUsernameET = v.findViewById(R.id.usernameET);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = enterUsernameET.getText().toString();
                gl.setCurrentUsername(username);
            }
        });

        // Clears the initial text in the input field

        enterUsernameET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FIXME requires two clicks in order to clear the text
                enterUsernameET.getText().clear();
            }
        });

        return v ;
    }

}

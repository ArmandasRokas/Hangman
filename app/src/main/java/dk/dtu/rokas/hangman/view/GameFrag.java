package dk.dtu.rokas.hangman.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dk.dtu.rokas.hangman.R;
import dk.dtu.rokas.hangman.business.GameLogic;

public class GameFrag extends Fragment {
    private GameLogic gl = GameLogic.getInstance();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.game, container, false);
        TextView usernameTv = v.findViewById(R.id.usernameStatusTV);
        usernameTv.setText(String.format("%s",gl.getCurrentUsername() ));

        return v;
    }
}

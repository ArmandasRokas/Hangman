package dk.dtu.rokas.hangman.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

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

        enterUsernameET.setText(gl.getCurrentUsername());

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = enterUsernameET.getText().toString();
                gl.setCurrentUsername(username);
                gl.nulstil();
                Navigation.findNavController(v).navigate(R.id.action_newGameFrag_to_gameFrag);
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

        new AsyncTask() {
            @Override
            protected Object doInBackground(Object... arg0) {
                try {
                    gl.hentOrdFraDr();
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return e;
                }
            }

            @Override
            protected void onPostExecute(Object titler) {
                System.out.println("Succeed");
            }
        }.execute();

        return v ;
    }

}

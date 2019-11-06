package dk.dtu.rokas.hangman.view;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import dk.dtu.rokas.hangman.MainActivity;
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
        ProgressBar progressBar = v.findViewById(R.id.indeterminateBar);


        enterUsernameET.setText(gl.getCurrentUsername());

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = enterUsernameET.getText().toString();
                if(username.length() < 1) {
                    CharSequence text = "Please enter username";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(v.getContext(), text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    gl.setCurrentUsername(username);
                    gl.nulstil();
                    Navigation.findNavController(v).navigate(R.id.action_newGameFrag_to_gameFrag);
                }
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
            protected void onPreExecute() {
                progressBar.setVisibility(View.VISIBLE);
                confirmBtn.setEnabled(false);
            }
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
                progressBar.setVisibility(View.INVISIBLE);
                confirmBtn.setEnabled(true);
            }
        }.execute();

        return v ;
    }

}

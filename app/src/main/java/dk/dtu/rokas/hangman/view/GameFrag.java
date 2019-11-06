package dk.dtu.rokas.hangman.view;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import dk.dtu.rokas.hangman.R;
import dk.dtu.rokas.hangman.business.GameLogic;

public class GameFrag extends Fragment {
    private GameLogic gl = GameLogic.getInstance();
    private Button  a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, ae, oe, aa;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.game, container, false);
        TextView usernameTv = v.findViewById(R.id.usernameStatusTV);
        usernameTv.setText(String.format("%s",gl.getCurrentUsername() ));
        updateImage(v); //FIXME does not work when screen rotates
        initializeBtns(v);
        updateButtons(v);
        //final TextView currLetters = v.findViewById(R.id.currLetters);
        //currLetters.setText(gl.getSynligtOrd());
        //final EditText guess = v.findViewById(R.id.guessET);
        /*guess.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode==KeyEvent.KEYCODE_ENTER){
                    confirmLetter(guess, currLetters, v);
                    return true;
                }
                return false;
            }
        });


        Button confirmLetterBtn = v.findViewById(R.id.confirmLetterBtn);
        confirmLetterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmLetter(guess, currLetters, v);
            }
        });*/

        return v;
    }

    private void initializeBtns(View v) {
        a = v.findViewById(R.id.aBtn);
        a.setOnClickListener(v1 -> {
            confirmLetter("a", v);
        });
    }

    private void confirmLetter(String letter, View v){
        gl.gætBogstav(letter);
        if(gl.erSpilletTabt()){
            Navigation.findNavController(v).navigate(R.id.action_gameFrag_to_loserFrag2);
        }
        if(gl.erSpilletVundet()){
            Navigation.findNavController(v).navigate(R.id.action_gameFrag_to_winnerFrag);
        }
        showToaster();
        updateImage(v);
        updateButtons(v);
    }

    private void showToaster() {
        CharSequence text;
        int duration = Toast.LENGTH_SHORT;
        if(gl.erSidsteBogstavKorrekt()){
            text = "Good job!";
        } else{
            text = "Watch out!";
        }
        Toast toast = Toast.makeText(this.getContext(), text, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

/*
    private void confirmLetter(EditText guess, TextView currLetters, View v) {
        gl.gætBogstav(guess.getText().toString());
        guess.getText().clear();
        currLetters.setText(gl.getSynligtOrd());
        updateImage(v);
        TextView usedLettersTv = v.findViewById(R.id.usedLattersTv);
        usedLettersTv.setText(String.format("Guessed letters: %s",gl.getBrugteBogstaver().toString() ));

    }*/
    /*
        confirmLetter
    - gl.gætBostav
    - updateImage(v)
    - update buttons
            if(gl.erSpilletTabt()){
            Navigation.findNavController(v).navigate(R.id.action_gameFrag_to_loserFrag2);
        }
        if(gl.erSpilletVundet()){
            Navigation.findNavController(v).navigate(R.id.action_gameFrag_to_winnerFrag);
        }
     */

    private void updateImage(View v) {
        ImageView imageView = v.findViewById(R.id.hangman);
        switch (gl.getAntalForkerteBogstaver()){
            case 0:
                imageView.setImageResource(R.mipmap.hang);
                break;
            case 1:
                imageView.setImageResource(R.mipmap.one_mistake);
                break;
            case 2:
                imageView.setImageResource(R.mipmap.two_mistakes);
                break;
            case 3:
                imageView.setImageResource(R.mipmap.three_mistakes);
                break;
            case 4:
                imageView.setImageResource(R.mipmap.four_mistakes);
                break;
            case 5:
                imageView.setImageResource(R.mipmap.five_mistakes);
                break;
        }
    }

    private void updateButtons(View v){

        if(gl.getBrugteBogstaver().contains("a")){
            a.setBackgroundColor(getResources().getColor(R.color.colorGray));
            a.setEnabled(false);
        }
        //char aChar = a.getText().charAt(0);
        //

    }

}

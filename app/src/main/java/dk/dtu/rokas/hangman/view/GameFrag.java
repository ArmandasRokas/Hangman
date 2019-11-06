package dk.dtu.rokas.hangman.view;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private Button  a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, vBtn, w, x, y, z, ae, oe, aa;
    private TextView currLetters;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.game, container, false);
        TextView usernameTv = v.findViewById(R.id.usernameStatusTV);
        usernameTv.setText(String.format("%s",gl.getCurrentUsername() ));
        updateImage(v); //FIXME does not work when screen rotates
        initializeBtns(v);
        updateButtons(v);
        currLetters = v.findViewById(R.id.currLetters);
        currLetters.setText(gl.getSynligtOrd());
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
        b = v.findViewById(R.id.bBtn);
        b.setOnClickListener(v1 -> {
            confirmLetter("b", v);
        });
        c = v.findViewById(R.id.cBtn);
        c.setOnClickListener(v1 -> {
            confirmLetter("c", v);
        });
        d = v.findViewById(R.id.dBtn);
        d.setOnClickListener(v1 -> {
            confirmLetter("d", v);
        });
        e = v.findViewById(R.id.eBtn);
        e.setOnClickListener(v1 -> {
            confirmLetter("e", v);
        });
        f = v.findViewById(R.id.fBtn);
        f.setOnClickListener(v1 -> {
            confirmLetter("f", v);
        });
        g = v.findViewById(R.id.gBtn);
        g.setOnClickListener(v1 -> {
            confirmLetter("g", v);
        });
        h = v.findViewById(R.id.hBtn);
        h.setOnClickListener(v1 -> {
            confirmLetter("h", v);
        });
        i = v.findViewById(R.id.iBtn);
        i.setOnClickListener(v1 -> {
            confirmLetter("i", v);
        });
        j = v.findViewById(R.id.jBtn);
        j.setOnClickListener(v1 -> {
            confirmLetter("j", v);
        });
        k = v.findViewById(R.id.kBtn);
        k.setOnClickListener(v1 -> {
            confirmLetter("k", v);
        });
        l = v.findViewById(R.id.lBtn);
        l.setOnClickListener(v1 -> {
            confirmLetter("l", v);
        });
        m = v.findViewById(R.id.mBtn);
        m.setOnClickListener(v1 -> {
            confirmLetter("m", v);
        });
        n = v.findViewById(R.id.nBtn);
        n.setOnClickListener(v1 -> {
            confirmLetter("n", v);
        });
        o = v.findViewById(R.id.oBtn);
        o.setOnClickListener(v1 -> {
            confirmLetter("o", v);
        });
        p = v.findViewById(R.id.pBtn);
        p.setOnClickListener(v1 -> {
            confirmLetter("p", v);
        });
        q = v.findViewById(R.id.qBtn);
        q.setOnClickListener(v1 -> {
            confirmLetter("q", v);
        });
        r = v.findViewById(R.id.rBtn);
        r.setOnClickListener(v1 -> {
            confirmLetter("r", v);
        });
        s = v.findViewById(R.id.sBtn);
        s.setOnClickListener(v1 -> {
            confirmLetter("s", v);
        });
        t = v.findViewById(R.id.tBtn);
        t.setOnClickListener(v1 -> {
            confirmLetter("t", v);
        });
        u = v.findViewById(R.id.uBtn);
        u.setOnClickListener(v1 -> {
            confirmLetter("u", v);
        });
        vBtn = v.findViewById(R.id.vBtn);
        vBtn.setOnClickListener(v1 -> {
            confirmLetter("v", v);
        });
        w = v.findViewById(R.id.wBtn);
        w.setOnClickListener(v1 -> {
            confirmLetter("w", v);
        });
        x = v.findViewById(R.id.xBtn);
        x.setOnClickListener(v1 -> {
            confirmLetter("x", v);
        });
        y = v.findViewById(R.id.yBtn);
        y.setOnClickListener(v1 -> {
            confirmLetter("y", v);
        });
        z = v.findViewById(R.id.zBtn);
        z.setOnClickListener(v1 -> {
            confirmLetter("z", v);
        });
        ae = v.findViewById(R.id.aeBtn);
        ae.setOnClickListener(v1 -> {
            confirmLetter("æ", v);
        });
        oe = v.findViewById(R.id.oeBtn);
        oe.setOnClickListener(v1 -> {
            confirmLetter("ø", v);
        });
        aa = v.findViewById(R.id.aaBtn);
        aa.setOnClickListener(v1 -> {
            confirmLetter("å", v);
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
        currLetters.setText(gl.getSynligtOrd());
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
        if(gl.getBrugteBogstaver().contains("b")){
            b.setBackgroundColor(getResources().getColor(R.color.colorGray));
            b.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("c")){
            c.setBackgroundColor(getResources().getColor(R.color.colorGray));
            c.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("d")){
            d.setBackgroundColor(getResources().getColor(R.color.colorGray));
            d.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("e")){
            e.setBackgroundColor(getResources().getColor(R.color.colorGray));
            e.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("f")){
            f.setBackgroundColor(getResources().getColor(R.color.colorGray));
            f.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("g")){
            g.setBackgroundColor(getResources().getColor(R.color.colorGray));
            g.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("h")){
            h.setBackgroundColor(getResources().getColor(R.color.colorGray));
            h.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("i")){
            i.setBackgroundColor(getResources().getColor(R.color.colorGray));
            i.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("j")){
            j.setBackgroundColor(getResources().getColor(R.color.colorGray));
            j.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("k")){
            k.setBackgroundColor(getResources().getColor(R.color.colorGray));
            k.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("l")){
            l.setBackgroundColor(getResources().getColor(R.color.colorGray));
            l.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("m")){
            m.setBackgroundColor(getResources().getColor(R.color.colorGray));
            m.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("n")){
            n.setBackgroundColor(getResources().getColor(R.color.colorGray));
            n.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("o")){
            o.setBackgroundColor(getResources().getColor(R.color.colorGray));
            o.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("p")){
            p.setBackgroundColor(getResources().getColor(R.color.colorGray));
            p.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("q")){
            q.setBackgroundColor(getResources().getColor(R.color.colorGray));
            q.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("r")){
            r.setBackgroundColor(getResources().getColor(R.color.colorGray));
            r.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("s")){
            s.setBackgroundColor(getResources().getColor(R.color.colorGray));
            s.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("t")){
            t.setBackgroundColor(getResources().getColor(R.color.colorGray));
            t.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("u")){
            u.setBackgroundColor(getResources().getColor(R.color.colorGray));
            u.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("v")){
            vBtn.setBackgroundColor(getResources().getColor(R.color.colorGray));
            vBtn.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("w")){
            w.setBackgroundColor(getResources().getColor(R.color.colorGray));
            w.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("x")){
            x.setBackgroundColor(getResources().getColor(R.color.colorGray));
            x.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("y")){
            y.setBackgroundColor(getResources().getColor(R.color.colorGray));
            y.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("z")){
            z.setBackgroundColor(getResources().getColor(R.color.colorGray));
            z.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("æ")){
            ae.setBackgroundColor(getResources().getColor(R.color.colorGray));
            ae.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("ø")){
            oe.setBackgroundColor(getResources().getColor(R.color.colorGray));
            oe.setEnabled(false);
        }
        if(gl.getBrugteBogstaver().contains("å")){
            aa.setBackgroundColor(getResources().getColor(R.color.colorGray));
            aa.setEnabled(false);
        }

    }

}

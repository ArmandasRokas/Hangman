package dk.dtu.rokas.hangman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;

import dk.dtu.rokas.hangman.business.GameLogic;

import static dk.dtu.rokas.hangman.business.GameLogic.hentUrl;

public class MainActivity extends AppCompatActivity {

    GameLogic gl = GameLogic.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Sets logo on the action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // brugeren vil navigere op i hierakiet
        }
        return super.onOptionsItemSelected(item);
    }
}

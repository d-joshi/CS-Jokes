package edu.psu.jjb24.csjokes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements DisplaySetupDialog.SetupDialogListener,  DisplayPunchlineDialog.PunchLineDialogListener {
    String[] joke_title;
    String[] joke_setup;
    String[] joke_punchline;
    int currentJoke = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the action bar
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        joke_title = getResources().getStringArray(R.array.JokeTitle);
        joke_setup = getResources().getStringArray(R.array.JokeSetup);
        joke_punchline = getResources().getStringArray(R.array.JokePunchline);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_joke:
                currentJoke = new Random().nextInt(joke_title.length);
                String JokeTitle = joke_title[currentJoke];
                String JokeSetup = joke_setup[currentJoke];
                String JokePunchline = joke_punchline[currentJoke];
                displayPunchlineDialog(JokeTitle, JokeSetup, JokePunchline);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void displaySetupDialog(String title, String setup, String punchline) {
        DisplaySetupDialog setupDialog = new DisplaySetupDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("setup", setup);
        args.putString("punchline", punchline);
        setupDialog.setArguments(args);
        setupDialog.show(getSupportFragmentManager(), "setupdialog");
    }

    @Override
    public void displayPunchlineDialog(String title, String setup, String punchline) {
        DisplayPunchlineDialog punchlineDialog = new DisplayPunchlineDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("setup", setup);
        args.putString("punchline", punchline);
        punchlineDialog.setArguments(args);
        punchlineDialog.show(getSupportFragmentManager(), "punchlinedialog");
    }


}
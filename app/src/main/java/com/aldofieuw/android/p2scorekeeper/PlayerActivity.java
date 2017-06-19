package com.aldofieuw.android.p2scorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        makeSpinner();
        buttonsOnclick();
    }

    private void buttonsOnclick() {
        final Intent intent = new Intent(PlayerActivity.this, MainActivity.class);
        Button button1 = (Button) findViewById(R.id.player1);
        Button button2 = (Button) findViewById(R.id.player2);
        Button button3 = (Button) findViewById(R.id.player3);
        Button button4 = (Button) findViewById(R.id.player4);


        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("language", language);
                intent.putExtra("players", 1);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("language", language);
                intent.putExtra("players", 2);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("language", language);
                intent.putExtra("players", 3);
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("language", language);
                intent.putExtra("players", 4);
                startActivity(intent);
            }
        });
    }

    private void makeSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.language_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.language_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        language = parent.getItemAtPosition(pos).toString();
        if (pos != 0) {
            showPlayers(language);
        }
    }

    private void showPlayers(String language) {
        TextView players = (TextView) findViewById(R.id.players);
        TextView chooseLanguage = (TextView) findViewById(R.id.chooseLanguage);

        switch (language) {
            case "Nederlands":
                players.setText("Hoeveel spelers?");
                chooseLanguage.setText("Kies je taal");
                break;
            case "Français":
                players.setText("Combien de joueurs?");
                chooseLanguage.setText("Choisissez votre langue");
                break;
            case "English":
                players.setText("How many players?");
                chooseLanguage.setText("Choose your language");
                break;
        }
        ((LinearLayout) findViewById(R.id.players_buttons)).setVisibility(View.VISIBLE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("language", language);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        language = savedInstanceState.getString("laguage");
    }
}
package com.aldofieuw.android.p2scorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ScoreActivity extends AppCompatActivity {

    private int players;
    private String language;
    private ArrayList<Integer> score;
    private Map<String, Integer> playerAndScore = new HashMap<>();
    private Map<String, Integer> playerAndScoreSorted;

    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order) {
        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        fillAttributes();
        playerAndScoreSorted = sortByComparator(playerAndScore, false);
        showWinner();
        switch (language) {
            case "Nederlands":
                ((Button) findViewById(R.id.newGame)).setText("Nieuw spel");
                break;
            case "Français":
                ((Button) findViewById(R.id.newGame)).setText("Nouveau jeu");
                break;
            case "English":
                ((Button) findViewById(R.id.newGame)).setText("New game");
                break;
        }
    }

    private void fillAttributes() {
        language = getIntent().getStringExtra("language");
        score = getIntent().getIntegerArrayListExtra("playerScore");
        players = getIntent().getIntExtra("players", 1);
        for (int i = 1; i < players + 1; i++) {
            switch (language) {
                case "Nederlands":
                    playerAndScore.put("Speler  " + i, score.get(i - 1));
                    break;
                case "Français":
                    playerAndScore.put("Joueur " + i, score.get(i - 1));
                    break;
                case "English":
                    playerAndScore.put("Player " + i, score.get(i - 1));
                    break;
            }

        }
    }

    private void showWinner() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.winner);
        for (Entry<String, Integer> entry : playerAndScoreSorted.entrySet()) {
            LinearLayout scorePlayer = new LinearLayout(this);
            scorePlayer.setOrientation(LinearLayout.HORIZONTAL);
            TextView player = new TextView(this);
            player.setText(entry.getKey());
            player.setLayoutParams(new LinearLayout.LayoutParams(0, 120, 1));
            player.setGravity(Gravity.CENTER_HORIZONTAL);
            TextView score = new TextView(this);
            score.setText(entry.getValue().toString());
            score.setLayoutParams(new LinearLayout.LayoutParams(0, 120, 1));
            score.setGravity(Gravity.CENTER_HORIZONTAL);
            scorePlayer.addView(player);
            scorePlayer.addView(score);
            linearLayout.addView(scorePlayer);
        }

    }

    public void newGame(View view) {
        startActivity(new Intent(ScoreActivity.this, PlayerActivity.class));
    }
}

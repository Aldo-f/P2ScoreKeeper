package com.aldofieuw.android.p2scorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String language;
    private int players;

    private int doubleWord = 0;
    private int tripleWord = 0;
    private int bonusWord = 0;

    private ArrayList<Integer> spelers = new ArrayList<>(4);
    private ArrayList<Character> alphabetList = new ArrayList<>(26);
    private ArrayList<Integer> scoreList;
    private ArrayList<Integer> scoreNL = new ArrayList<>(26);
    private ArrayList<Integer> scoreFR = new ArrayList<>(26);
    private ArrayList<Integer> scoreEN = new ArrayList<>(26);
    private ArrayList<Integer> score = new ArrayList<>();
    private char[] letters;
    private String word;
    private int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillLists();
        fillScoreAndPlayerList();
        setContentView(R.layout.activity_main);
        changeTextToLanguage();
    }

    private void changeTextToLanguage() {
        TextView word = (TextView) findViewById(R.id.typeWord);
        TextView addScoreTo = (TextView) findViewById(R.id.addScoreTo);
        TextView scorePlayer1 = (TextView) findViewById(R.id.scorePlayer1);
        TextView scorePlayer2 = (TextView) findViewById(R.id.scorePlayer2);
        TextView scorePlayer3 = (TextView) findViewById(R.id.scorePlayer3);
        TextView scorePlayer4 = (TextView) findViewById(R.id.scorePlayer4);
        Button player1 = (Button) findViewById(R.id.addToPlayer1);
        Button player2 = (Button) findViewById(R.id.addToPlayer2);
        Button player3 = (Button) findViewById(R.id.addToPlayer3);
        Button player4 = (Button) findViewById(R.id.addToPlayer4);
        Button calculate = (Button) findViewById(R.id.calculate);
        Button endGame = (Button) findViewById(R.id.endGame);

        switch (language) {
            case "Nederlands":
                word.setText("Geef je woord in");
                addScoreTo.setText("Voeg score toe aan:");
                player1.setText("Speler 1");
                player2.setText("Speler 2");
                player3.setText("Speler 3");
                player4.setText("Speler 4");
                calculate.setText("bereken");
                endGame.setText("Einde spel");
                break;
            case "Français":
                word.setText("Donnez votre mot");
                addScoreTo.setText("Ajouter à:");
                player1.setText("Joueur 1");
                player2.setText("Joueur 2");
                player3.setText("Joueur 3");
                player4.setText("Joueur 4");
                calculate.setText("Calculer");
                endGame.setText("Fin du jeu");
                break;
            case "English":
                word.setText("Type your word");
                addScoreTo.setText("Add score to:");
                break;
        }

        switch (players) {
            case 1:
                player1.setVisibility(View.VISIBLE);
                scorePlayer1.setVisibility(View.VISIBLE);
                break;
            case 2:
                player1.setVisibility(View.VISIBLE);
                player2.setVisibility(View.VISIBLE);
                scorePlayer1.setVisibility(View.VISIBLE);
                scorePlayer2.setVisibility(View.VISIBLE);
                break;
            case 3:
                player1.setVisibility(View.VISIBLE);
                player2.setVisibility(View.VISIBLE);
                player3.setVisibility(View.VISIBLE);
                scorePlayer1.setVisibility(View.VISIBLE);
                scorePlayer2.setVisibility(View.VISIBLE);
                scorePlayer3.setVisibility(View.VISIBLE);
                break;
            case 4:
                player1.setVisibility(View.VISIBLE);
                player2.setVisibility(View.VISIBLE);
                player3.setVisibility(View.VISIBLE);
                player4.setVisibility(View.VISIBLE);
                scorePlayer1.setVisibility(View.VISIBLE);
                scorePlayer2.setVisibility(View.VISIBLE);
                scorePlayer3.setVisibility(View.VISIBLE);
                scorePlayer4.setVisibility(View.VISIBLE);
                break;
        }


    }

    private void fillScoreAndPlayerList() {
        language = getIntent().getStringExtra("language");
        players = getIntent().getIntExtra("players", 1);

        for (int i = 0; i < players; i++) {
            spelers.add(0);
        }
        switch (language) {
            case "Nederlands":
                scoreList = new ArrayList<>(scoreNL);
                break;
            case "Français":
                scoreList = new ArrayList<>(scoreFR);
                break;
            case "English":
                scoreList = new ArrayList<>(scoreEN);
                break;
        }
    }

    private void fillLists() {
        alphabetList.add('a');
        alphabetList.add('b');
        alphabetList.add('c');
        alphabetList.add('d');
        alphabetList.add('e');
        alphabetList.add('f');
        alphabetList.add('g');
        alphabetList.add('h');
        alphabetList.add('i');
        alphabetList.add('j');
        alphabetList.add('k');
        alphabetList.add('l');
        alphabetList.add('m');
        alphabetList.add('n');
        alphabetList.add('o');
        alphabetList.add('p');
        alphabetList.add('q');
        alphabetList.add('r');
        alphabetList.add('s');
        alphabetList.add('t');
        alphabetList.add('u');
        alphabetList.add('v');
        alphabetList.add('w');
        alphabetList.add('x');
        alphabetList.add('y');
        alphabetList.add('z');

        scoreNL.add(1);
        scoreNL.add(3);
        scoreNL.add(5);
        scoreNL.add(2);
        scoreNL.add(1);
        scoreNL.add(4);
        scoreNL.add(3);
        scoreNL.add(4);
        scoreNL.add(1);
        scoreNL.add(4);
        scoreNL.add(3);
        scoreNL.add(3);
        scoreNL.add(3);
        scoreNL.add(1);
        scoreNL.add(1);
        scoreNL.add(3);
        scoreNL.add(10);
        scoreNL.add(2);
        scoreNL.add(2);
        scoreNL.add(2);
        scoreNL.add(4);
        scoreNL.add(4);
        scoreNL.add(5);
        scoreNL.add(8);
        scoreNL.add(8);
        scoreNL.add(4);

        scoreFR.add(1);
        scoreFR.add(3);
        scoreFR.add(3);
        scoreFR.add(2);
        scoreFR.add(1);
        scoreFR.add(4);
        scoreFR.add(2);
        scoreFR.add(4);
        scoreFR.add(1);
        scoreFR.add(8);
        scoreFR.add(10);
        scoreFR.add(1);
        scoreFR.add(2);
        scoreFR.add(1);
        scoreFR.add(1);
        scoreFR.add(3);
        scoreFR.add(8);
        scoreFR.add(1);
        scoreFR.add(1);
        scoreFR.add(1);
        scoreFR.add(1);
        scoreFR.add(4);
        scoreFR.add(10);
        scoreFR.add(10);
        scoreFR.add(10);
        scoreFR.add(10);

        scoreEN.add(1);
        scoreEN.add(3);
        scoreEN.add(3);
        scoreEN.add(2);
        scoreEN.add(1);
        scoreEN.add(4);
        scoreEN.add(2);
        scoreEN.add(4);
        scoreEN.add(1);
        scoreEN.add(8);
        scoreEN.add(5);
        scoreEN.add(1);
        scoreEN.add(3);
        scoreEN.add(1);
        scoreEN.add(1);
        scoreEN.add(3);
        scoreEN.add(10);
        scoreEN.add(1);
        scoreEN.add(1);
        scoreEN.add(1);
        scoreEN.add(1);
        scoreEN.add(4);
        scoreEN.add(4);
        scoreEN.add(8);
        scoreEN.add(4);
        scoreEN.add(10);
    }

    private ArrayList<Integer> calculateSingleScore() {
        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            int index = alphabetList.indexOf(letter);
            if (score.size() < letters.length) {
                score.add(i, scoreList.get(index));
            } else {
                return score;
            }

        }
        return score;
    }

    public void submitWord(View view) {
        EditText wordField = (EditText) findViewById(R.id.word_field);
        Editable wordEditable = wordField.getText();
        word = wordEditable.toString();
        if (word.length() == 0) {
            switch (language) {
                case "Nederlands":
                    wordField.setError("Mag niet leeg zijn.");
                    break;
                case "Français":
                    wordField.setError("Ne peux pas être vide.");
                    break;
                case "English":
                    wordField.setError("Cannot be empty.");
                    break;
            }

            return;
        }
        if (letters != null) {
            score.clear();
            doubleWord = 0;
            tripleWord = 0;
            bonusWord = 0;
            displayTriplePoints(tripleWord);
            displayDoublePoints(doubleWord);
            displayBonusPoints(bonusWord);
        }
        letters = word.trim().toLowerCase().toCharArray();
        for (char c : letters) {
            if (!alphabetList.contains(c)) {
                switch (language) {
                    case "Nederlands":
                        wordField.setError("Ongeldige invoer.");
                        break;
                    case "Français":
                        wordField.setError("Entrée invalide.");
                        break;
                    case "English":
                        wordField.setError("Invalid input.");
                        break;
                }
                return;
            }
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.letterScore);
        if ((linearLayout).getChildCount() > 0)
            (linearLayout).removeAllViews();
        showWord();
        linearLayout.setVisibility(View.VISIBLE);
        ((Button) findViewById(R.id.calculate)).setVisibility(View.GONE);
        ((LinearLayout) findViewById(R.id.wordValues)).setVisibility(View.GONE);
        score = calculateSingleScore();
        calculate(view);
    }

    public void calculate(View view) {

        finalScore = 0;
        for (int punt : score) {
            finalScore += punt;
        }
        if (doubleWord != 0) {
            for (int i = 0; i < doubleWord; i++) {
                finalScore *= 2;
                for (int j = 0; j < score.size(); j++) {
                    score.set(j, score.get(j) * 2);
                }
            }
            doubleWord = 0;
            displayDoublePoints(doubleWord);
        }
        if (tripleWord != 0) {
            for (int i = 0; i < tripleWord; i++) {
                finalScore *= 3;
                for (int j = 0; j < score.size(); j++) {
                    score.set(j, score.get(j) * 3);
                }
            }
            tripleWord = 0;
            displayTriplePoints(tripleWord);
        }
        if (bonusWord == 1) {
            finalScore += 50;
            score.add(score.size(), 50);
            bonusWord = 0;
            displayBonusPoints(bonusWord);
        }

        ((TextView) findViewById(R.id.score)).setText(String.valueOf(finalScore));
    }

    private void showWord() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.letterScore);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < letters.length; i++) {
            LinearLayout box = new LinearLayout(this);
            box.setPadding(20, 20, 20, 20);
            box.setGravity(Gravity.CENTER_HORIZONTAL);
            box.setId(i);
            TextView textView = new TextView(this);
            textView.setId(i);
            textView.setLayoutParams(new LinearLayout.LayoutParams(150, 150));
            textView.setTextSize(20f);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setText(Character.toString(letters[i]).toUpperCase() + " " + scoreList.get(alphabetList.indexOf(letters[i])));
            box.addView(textView, 0);

            final Button button1 = new Button(this);
            final Button button2 = new Button(this);
            final Button button3 = new Button(this);

            button1.setText("x2");
            button1.setId(i);
            button1.setTextSize(12.0f);
            button1.setLayoutParams(new LinearLayout.LayoutParams(120, 120));
            button1.setOnClickListener(handleOnClick(button1, button2, button3, 2));


            button2.setText("x3");
            button2.setId(i);
            button2.setTextSize(12.0f);
            button2.setLayoutParams(new LinearLayout.LayoutParams(120, 120));
            button2.setOnClickListener(handleOnClick(button2, button1, button3, 3));

            button3.setText("x0");
            button3.setId(i);
            button3.setTextSize(12.0f);
            button3.setLayoutParams(new LinearLayout.LayoutParams(120, 120));
            button3.setOnClickListener(handleOnClick(button3, button1, button2, 0));

            box.addView(button1, 1);
            box.addView(button2, 2);
            box.addView(button3, 3);

            linearLayout.addView(box);
        }
        Button ok = (Button) findViewById(R.id.ok);
        switch (language) {
            case "Nederlands":
                ok.setText("meer".toUpperCase());
                break;
            case "Français":
                ok.setText("plus".toUpperCase());
                break;
            case "English":
                ok.setText("more".toUpperCase());
                break;
        }

        ok.setVisibility(View.VISIBLE);
        ok.setOnClickListener(handleOk(ok));
    }

    public View.OnClickListener handleOnClick(final Button button, final Button button1, final Button button2, final int amount) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                score.set(button.getId(), (score.get(button.getId()) * amount));
                button.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                button.setClickable(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                calculate(v);
            }
        };
    }

    public View.OnClickListener handleOk(final Button button) {
        return new View.OnClickListener() {
            public void onClick(View v) {
                calculate(v);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.letterScore);
                linearLayout.setVisibility(View.GONE);
                Button button2 = (Button) findViewById(R.id.calculate);
                button2.setVisibility(View.GONE);
                ((Button) findViewById(R.id.ok)).setVisibility(View.GONE);
                linearLayout = (LinearLayout) findViewById(R.id.wordValues);
                linearLayout.setVisibility(View.VISIBLE);
                button2 = (Button) findViewById(R.id.calculate);
                button2.setVisibility(View.VISIBLE);
                if (letters.length >= 7) {
                    linearLayout = (LinearLayout) findViewById(R.id.bonus);
                    linearLayout.setVisibility(View.VISIBLE);
                }
            }
        };
    }


    // Double
    public void doublePlus(View view) {
        // Not more than 10 (if more than 10 --> just return)
        if (doubleWord == 10) {
            return;
        }
        doubleWord += 1;
        displayDoublePoints(doubleWord);
    }

    private void displayDoublePoints(int amount) {
        TextView quantityTextView = (TextView) findViewById(R.id.doublePoints);
        quantityTextView.setText("" + amount);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void doubleMinus(View view) {
        // Not less than 0 (if less than 0 --> return)
        if (doubleWord == 0) {
            return;
        }
        doubleWord -= 1;
        displayDoublePoints(doubleWord);
    }


    // Triple
    public void triplePlus(View view) {
        // Not more than 10 (if more than 10 --> just return)
        if (tripleWord == 10) {
            return;
        }
        tripleWord += 1;
        displayTriplePoints(tripleWord);
    }

    private void displayTriplePoints(int amount) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.triplePoints);
        quantityTextView.setText("" + amount);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void tripleMinus(View view) {
        // Not less than 0 (if less than 0 --> return)
        if (tripleWord == 0) {
            return;
        }
        tripleWord -= 1;
        displayTriplePoints(tripleWord);
    }


    // Bonus
    public void bonusPlus(View view) {
        // Not more than 1 (if more than 1 --> just return)
        if (bonusWord == 1) {
            return;
        }
        bonusWord += 1;
        ((Button) findViewById(R.id.bonusPlus)).setClickable(false);
        displayBonusPoints(bonusWord);
    }

    private void displayBonusPoints(int amount) {
        ((TextView) findViewById(R.id.bonusPoints)).setText("" + amount);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void bonusMinus(View view) {
        // Not less than 0 (if less than 0 --> return)
        if (bonusWord == 0) {
            return;
        }
        bonusWord -= 1;
        displayBonusPoints(bonusWord);
    }

    public void addScoreToPlayer1(View view) {
        spelers.set(0, spelers.get(0) + finalScore);

        ((TextView) findViewById(R.id.scorePlayer1)).setText(spelers.get(0).toString());
        finalScore = 0;
        ((TextView) findViewById(R.id.score)).setText(String.valueOf(0));
        ((LinearLayout) findViewById(R.id.wordValues)).setVisibility(View.GONE);
        ((LinearLayout) findViewById(R.id.letterScore)).setVisibility(View.GONE);
        ((Button) findViewById(R.id.calculate)).setVisibility(View.GONE);
        ((Button) findViewById(R.id.ok)).setVisibility(View.GONE);
        ((EditText) findViewById(R.id.word_field)).getText().clear();
    }

    public void addScoreToPlayer2(View view) {
        spelers.set(1, spelers.get(1) + finalScore);

        ((TextView) findViewById(R.id.scorePlayer2)).setText(spelers.get(1).toString());
        finalScore = 0;
        ((TextView) findViewById(R.id.score)).setText(String.valueOf(0));
        ((LinearLayout) findViewById(R.id.wordValues)).setVisibility(View.GONE);
        ((LinearLayout) findViewById(R.id.letterScore)).setVisibility(View.GONE);
        ((Button) findViewById(R.id.calculate)).setVisibility(View.GONE);
        ((Button) findViewById(R.id.ok)).setVisibility(View.GONE);
        ((EditText) findViewById(R.id.word_field)).getText().clear();
    }

    public void addScoreToPlayer3(View view) {
        spelers.set(2, spelers.get(2) + finalScore);

        ((TextView) findViewById(R.id.scorePlayer3)).setText(spelers.get(2).toString());
        finalScore = 0;
        ((TextView) findViewById(R.id.score)).setText(String.valueOf(0));
        ((LinearLayout) findViewById(R.id.wordValues)).setVisibility(View.GONE);
        ((LinearLayout) findViewById(R.id.letterScore)).setVisibility(View.GONE);
        ((Button) findViewById(R.id.calculate)).setVisibility(View.GONE);
        ((Button) findViewById(R.id.ok)).setVisibility(View.GONE);
        ((EditText) findViewById(R.id.word_field)).getText().clear();
    }

    public void addScoreToPlayer4(View view) {
        spelers.set(3, spelers.get(3) + finalScore);

        ((TextView) findViewById(R.id.scorePlayer4)).setText(spelers.get(3).toString());
        finalScore = 0;
        ((TextView) findViewById(R.id.score)).setText(String.valueOf(0));
        ((LinearLayout) findViewById(R.id.wordValues)).setVisibility(View.GONE);
        ((LinearLayout) findViewById(R.id.letterScore)).setVisibility(View.GONE);
        ((Button) findViewById(R.id.calculate)).setVisibility(View.GONE);
        ((Button) findViewById(R.id.ok)).setVisibility(View.GONE);
        ((EditText) findViewById(R.id.word_field)).getText().clear();
    }

    public void endGame(View view) {
        Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
        intent.putExtra("language", language);
        intent.putExtra("spelers", spelers);
        intent.putExtra("players", players);
        startActivity(intent);

    }


}

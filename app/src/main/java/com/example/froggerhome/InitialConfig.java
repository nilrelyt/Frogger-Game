package com.example.froggerhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.Button;

public class InitialConfig extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {
    private static String difficulty;
    private String lives;
    private String character;
    private String playerName;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_config);

        Spinner spinnerDifficulties = findViewById(R.id.difficulty_dropdown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.difficulty, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulties.setAdapter(adapter);
        spinnerDifficulties.setOnItemSelectedListener(this);

        Button char1;
        Button char2;
        Button char3;
        char1 = (Button) findViewById(R.id.char_1);
        char1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character = "1";
                openGame();
            }
        });

        char2 = (Button) findViewById(R.id.char_2);
        char2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character = "2";
                openGame();
            }
        });

        char3 = (Button) findViewById(R.id.char_3);
        char3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                character = "3";
                openGame();
            }
        });
    }

    public void openGame() {
        EditText name = (EditText) findViewById(R.id.editPersonName);
        playerName = name.getText().toString().trim();
        if (isNameValid(playerName)) {
            Toast.makeText(getApplicationContext(), "Enter Valid Player Name",
                    Toast.LENGTH_SHORT).show();
        } else {
            player = new Player(playerName, lives, character);
            Intent intent = new Intent(this, GameScreen.class);
            intent.putExtra("playerName", player.getPlayerName());
            intent.putExtra("playerLives", player.getLives());
            intent.putExtra("playerChar", player.getCharacter());
            startActivity(intent);
        }
    }

    public boolean isNameValid(String name) {
        if (name == null) {
            return false;
        }
        return name.trim().equalsIgnoreCase("");
    }

    public static String getDifficulty() {
        return difficulty;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        difficulty = adapterView.getItemAtPosition(i).toString();

        Toast.makeText(adapterView.getContext(), difficulty, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

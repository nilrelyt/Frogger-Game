package com.example.froggerhome;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndGame extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_end_game);
        super.onCreate(savedInstanceState);

        TextView score = findViewById(R.id.score);
        score.setText("Score");
        TextView finalScore = findViewById(R.id.endScore);
        finalScore.setText(Integer.toString(GameScreen.getFinalScore()));

        Button restartGame = findViewById(R.id.restartGameButton);
        Button exitGame = findViewById(R.id.exitGameButton);

        restartGame.setOnClickListener(v -> restart());

        exitGame.setOnClickListener(v -> end());
    }
    public void restart() {
        Intent intent = new Intent(this, InitialConfig.class);
        startActivity(intent);
    }

    public void end() {
        finishAffinity();
    }
}

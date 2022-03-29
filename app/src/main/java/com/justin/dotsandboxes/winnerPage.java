package com.justin.dotsandboxes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class winnerPage extends AppCompatActivity {
    ImageView home_button;
    ImageView help_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner_page);
        getSupportActionBar().hide();

        home_button = findViewById(R.id.home_button);
        help_button = findViewById(R.id.help_button);

        home_button.setOnClickListener(view -> {
            Intent intent = new Intent(winnerPage.this, MainActivity.class);
            startActivity(intent);
        });

        help_button.setOnClickListener(view -> {
            Intent intent = new Intent(winnerPage.this, Help.class);
            startActivity(intent);
        });

        Button play_againButton = findViewById(R.id.play_againButton);
        play_againButton.setOnClickListener(view -> {
            Intent intent = new Intent(winnerPage.this, GameSetUpPage.class);
            startActivity(intent);
        });
        Button home = findViewById(R.id.home);
        home.setOnClickListener(view -> {
            Intent intent = new Intent(winnerPage.this, MainActivity.class);
            startActivity(intent);
        });
    }
}

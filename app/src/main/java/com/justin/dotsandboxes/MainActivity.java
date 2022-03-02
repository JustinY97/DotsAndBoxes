package com.justin.dotsandboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView help_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = findViewById(R.id.startButton);

        startBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GameBoard.class);
            startActivity(intent);
        });

        help_button = findViewById(R.id.help_button);
        help_button.setOnClickListener(view -> {
            Intent intent = new Intent( MainActivity.this, Help.class);
            startActivity(intent);
        });


    }
}
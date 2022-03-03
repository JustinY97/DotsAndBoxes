package com.justin.dotsandboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView home_button;
    ImageView help_button;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);


        startBtn = findViewById(R.id.playButton);
        home_button = findViewById(R.id.home_button);
        help_button = findViewById(R.id.help_button);


        startBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GameSetUpPage.class);
            startActivity(intent);
        });

        home_button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        });

        help_button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Help.class);
            startActivity(intent);
        });

    }
}
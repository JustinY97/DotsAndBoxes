package com.justin.dotsandboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Help extends AppCompatActivity {
    ImageView home_button;
    ImageView help_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        home_button = findViewById(R.id.home_button);
        help_button = findViewById(R.id.help_button);

        home_button.setOnClickListener(view -> {
            Intent intent = new Intent(Help.this, MainActivity.class);
            startActivity(intent);
        });
        help_button.setOnClickListener(view -> {
            Intent intent = new Intent(Help.this, Help.class);
        });
    }
}
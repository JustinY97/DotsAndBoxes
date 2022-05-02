package com.justin.dotsandboxes;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.app.Activity;

public class Pause_6x6 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9), (int)(height*.6));

        Button resume_button = findViewById(R.id.resume_button);
        resume_button.setOnClickListener(view -> {
            Intent intent = new Intent(Pause_6x6.this, Board_6x6.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityIfNeeded(intent, 0);
        });

        Button restart_button = findViewById(R.id.restart_button);
        restart_button.setOnClickListener(view -> {
            Intent intent = new Intent(Pause_6x6.this, GameSetUpPage.class);
            startActivity(intent);
        });
        Button quit_button = findViewById(R.id.quit_button);
        quit_button.setOnClickListener(view -> {
            Intent intent = new Intent(Pause_6x6.this, MainActivity.class);
            startActivity(intent);
        });
    }
}

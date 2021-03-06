package com.justin.dotsandboxes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.ImageView;

public class Pop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9), (int)(height*.3));

        Button yes_button = findViewById(R.id.yes_button);
        yes_button.setOnClickListener(view -> {
            Intent intent = new Intent(Pop.this, MainActivity.class);
            startActivity(intent);
        });
        Button no_button = findViewById(R.id.no_button);
        no_button.setOnClickListener(view -> {
            Intent intent = new Intent(Pop.this, Help.class);
            startActivity(intent);
        });
    }
}

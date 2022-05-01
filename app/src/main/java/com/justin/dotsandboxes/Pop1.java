package com.justin.dotsandboxes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;

public class Pop1  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .9), (int) (height * .3));

        Bundle getBoardSize = getIntent().getExtras();
        String boardSize = getBoardSize.getString("boardSize");

        Button yes_button = findViewById(R.id.yes_button);
        yes_button.setOnClickListener(view -> {
            Intent intent = new Intent(Pop1.this, GameSetUpPage.class);
            startActivity(intent);
        });
        Button no_button = findViewById(R.id.no_button);
        no_button.setOnClickListener(view -> {
            if (boardSize.equals("4 x 4")) {
                Intent intent = new Intent(Pop1.this, Board_4x4.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(intent, 0);
            }
            if (boardSize.equals("6 x 6")) {
                Intent intent = new Intent(Pop1.this, Board_6x6.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(intent, 0);
            }

        });
    }
}

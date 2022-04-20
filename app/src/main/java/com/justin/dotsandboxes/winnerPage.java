package com.justin.dotsandboxes;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class winnerPage extends AppCompatActivity {
    ImageView home_button;
    ImageView help_button;
    TextView winnerName;
    TextView winnerScore;
    View winnerColor;
    String passedWinnerName;
    String winnerNameDisplay;
    String winnerScoreDisplay;
    int passedWinnerColor;
    int passedWinnerScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner_page);
        getSupportActionBar().hide();
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        //get the sent winner information from game screens
        Bundle winnerInfo = getIntent().getExtras();
        passedWinnerName = winnerInfo.getString("winnersName");
        passedWinnerScore = winnerInfo.getInt("winnersScore");
        passedWinnerColor = winnerInfo.getInt("winnersColor");


        //get the name textview
        winnerName = findViewById(R.id.nameDisplay);
            winnerNameDisplay = passedWinnerName + " Wins!";
            winnerName.setText(winnerNameDisplay);

        //get the color view
        winnerColor = findViewById(R.id.winnerColor);
            winnerColor.setBackgroundColor(passedWinnerColor);

        //get the score textview
        winnerScore = findViewById(R.id.scoreDisplay);
            winnerScoreDisplay = "Score: " + passedWinnerScore;
            winnerScore.setText(winnerScoreDisplay);

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

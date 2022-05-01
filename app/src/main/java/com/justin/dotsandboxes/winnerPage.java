package com.justin.dotsandboxes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import java.util.ArrayList;
import java.util.Objects;

public class winnerPage extends AppCompatActivity {
    ImageView home_button;
    ImageView help_button;
    TextView winnerName;
    TextView winnerScore;
    View winnerColor;
    View winnerColor2PlayerTieTop;
    View winnerColor2PlayerTieBottom;
    View winnerColor3PlayerTieTopL;
    View winnerColor3PlayerTieTopR;
    View winnerColor3PlayerTieBottom;
    View winnerColor4PlayerTieTopL;
    View winnerColor4PlayerTieTopR;
    View winnerColor4PlayerTieBottomL;
    View winnerColor4PlayerTieBottomR;
    String passedWinnerName;
    String winnerNameDisplay;
    String winnerScoreDisplay;
    ArrayList<Integer> passedTieWinnerColors = new ArrayList<>();
    int passedWinnerColor;
    int passedWinnerScore;
    int numOfWinners;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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
        numOfWinners = winnerInfo.getInt("numWinners");
        Log.e("MyTAG", "PASSED: Number of winners " + numOfWinners);
        passedWinnerName = winnerInfo.getString("winnersName");
        passedWinnerScore = winnerInfo.getInt("winnersScore");
        passedWinnerColor = winnerInfo.getInt("winnersColor");
        Log.e("MyTAG", "PASSED: Winner Color " + passedWinnerColor);
        passedTieWinnerColors = winnerInfo.getIntegerArrayList("winnerTieColors");

        //TIE COLORS
        //1 Winner
        winnerColor = findViewById(R.id.winnerColor);
        winnerColor.setVisibility(View.GONE);

        //2 Winners
        winnerColor2PlayerTieTop = findViewById(R.id.winnerColor2PlayerTieTop);
        winnerColor2PlayerTieTop.setVisibility(View.GONE);
        winnerColor2PlayerTieBottom = findViewById(R.id.winnerColor2PlayerTieBottom);
        winnerColor2PlayerTieBottom.setVisibility(View.GONE);

        //3 Winners
        winnerColor3PlayerTieTopL = findViewById(R.id.winnerColor3PlayerTieTopL);
        winnerColor3PlayerTieTopL.setVisibility(View.GONE);
        winnerColor3PlayerTieTopR = findViewById(R.id.winnerColor3PlayerTieTopR);
        winnerColor3PlayerTieTopR.setVisibility(View.GONE);
        winnerColor3PlayerTieBottom = findViewById(R.id.winnerColor3PlayerTieBottom);
        winnerColor3PlayerTieBottom.setVisibility(View.GONE);

        //4 Winners
        winnerColor4PlayerTieTopL = findViewById(R.id.winnerColor4PlayerTieTopL);
        winnerColor4PlayerTieTopL.setVisibility(View.GONE);
        winnerColor4PlayerTieTopR = findViewById(R.id.winnerColor4PlayerTieTopR);
        winnerColor4PlayerTieTopR.setVisibility(View.GONE);
        winnerColor4PlayerTieBottomL = findViewById(R.id.winnerColor4PlayerTieBottomL);
        winnerColor4PlayerTieBottomL.setVisibility(View.GONE);
        winnerColor4PlayerTieBottomR = findViewById(R.id.winnerColor4PlayerTieBottomR);
        winnerColor4PlayerTieBottomR.setVisibility(View.GONE);

        //get the name textview
        winnerName = findViewById(R.id.nameDisplay);
            winnerNameDisplay = passedWinnerName + " Wins!";
            winnerName.setText(winnerNameDisplay);

        //get the colors view
        if (numOfWinners == 1) {
            winnerColor.setVisibility(View.VISIBLE);
            winnerColor.setBackgroundColor(passedWinnerColor);
        }
        if (numOfWinners == 2) {

            winnerColor2PlayerTieTop.setVisibility(View.VISIBLE);
            LayerDrawable top = (LayerDrawable)winnerColor2PlayerTieTop.getBackground();
            top.setTint(passedTieWinnerColors.get(0));

            winnerColor2PlayerTieBottom.setVisibility(View.VISIBLE);
            LayerDrawable bottom = (LayerDrawable)winnerColor2PlayerTieBottom.getBackground();
            bottom.setTint(passedTieWinnerColors.get(1));
        }
        if (numOfWinners == 3) {

            winnerColor3PlayerTieTopL.setVisibility(View.VISIBLE);
            LayerDrawable topLeft = (LayerDrawable)winnerColor3PlayerTieTopL.getBackground();
            topLeft.setTint(passedTieWinnerColors.get(0));

            winnerColor3PlayerTieTopR.setVisibility(View.VISIBLE);
            LayerDrawable topRight = (LayerDrawable)winnerColor3PlayerTieTopR.getBackground();
            topRight.setTint(passedTieWinnerColors.get(1));

            winnerColor3PlayerTieBottom.setVisibility(View.VISIBLE);
            LayerDrawable bottom = (LayerDrawable)winnerColor3PlayerTieBottom.getBackground();
            bottom.setTint(passedTieWinnerColors.get(2));
        }
        if (numOfWinners == 4) {

            winnerColor4PlayerTieTopL.setVisibility(View.VISIBLE);
            winnerColor4PlayerTieTopL.setBackgroundColor(passedTieWinnerColors.get(0));

            winnerColor4PlayerTieTopR.setVisibility(View.VISIBLE);
            winnerColor4PlayerTieTopR.setBackgroundColor(passedTieWinnerColors.get(1));

            winnerColor4PlayerTieBottomL.setVisibility(View.VISIBLE);
            winnerColor4PlayerTieBottomL.setBackgroundColor(passedTieWinnerColors.get(2));

            winnerColor4PlayerTieBottomR.setVisibility(View.VISIBLE);
            winnerColor4PlayerTieBottomR.setBackgroundColor(passedTieWinnerColors.get(3));
        }

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

        //resend the player information
        Button play_againButton = findViewById(R.id.play_againButton);
        play_againButton.setOnClickListener(view -> {

            //get passed board size
            String playAgainBoard = winnerInfo.getString("boardSize");
            //get number of players
            String playAgainNumPlayers = winnerInfo.getString("playerNumber");


            if (playAgainBoard.equals("4 x 4")) {
                Intent intent = new Intent(winnerPage.this, Board_4x4.class);

                intent.putExtra("playerNumber", playAgainNumPlayers);

                if (playAgainNumPlayers.equals("2")){
                    String player1N = winnerInfo.getString("player1InputtedName");
                    int player1C = winnerInfo.getInt("sendPlayer1Color");
                    String player2N = winnerInfo.getString("player2InputtedName");
                    int player2C = winnerInfo.getInt("sendPlayer2Color");

                    intent.putExtra("player1InputtedName", player1N);
                    intent.putExtra("sendPlayer1Color", player1C);
                    intent.putExtra("player2InputtedName", player2N);
                    intent.putExtra("sendPlayer2Color", player2C);
                }
                if (playAgainNumPlayers.equals("3")){
                    String player1N = winnerInfo.getString("player1InputtedName");
                    int player1C = winnerInfo.getInt("sendPlayer1Color");
                    String player2N = winnerInfo.getString("player2InputtedName");
                    int player2C = winnerInfo.getInt("sendPlayer2Color");
                    String player3N = winnerInfo.getString("player3InputtedName");
                    int player3C = winnerInfo.getInt("sendPlayer3Color");

                    intent.putExtra("player1InputtedName", player1N);
                    intent.putExtra("sendPlayer1Color", player1C);
                    intent.putExtra("player2InputtedName", player2N);
                    intent.putExtra("sendPlayer2Color", player2C);
                    intent.putExtra("player3InputtedName", player3N);
                    intent.putExtra("sendPlayer3Color", player3C);
                }
                if (playAgainNumPlayers.equals("4")){
                    String player1N = winnerInfo.getString("player1InputtedName");
                    int player1C = winnerInfo.getInt("sendPlayer1Color");
                    String player2N = winnerInfo.getString("player2InputtedName");
                    int player2C = winnerInfo.getInt("sendPlayer2Color");
                    String player3N = winnerInfo.getString("player3InputtedName");
                    int player3C = winnerInfo.getInt("sendPlayer3Color");
                    String player4N = winnerInfo.getString("player4InputtedName");
                    int player4C = winnerInfo.getInt("sendPlayer4Color");

                    intent.putExtra("player1InputtedName", player1N);
                    intent.putExtra("sendPlayer1Color", player1C);
                    intent.putExtra("player2InputtedName", player2N);
                    intent.putExtra("sendPlayer2Color", player2C);
                    intent.putExtra("player3InputtedName", player3N);
                    intent.putExtra("sendPlayer3Color", player3C);
                    intent.putExtra("player4InputtedName", player4N);
                    intent.putExtra("sendPlayer4Color", player4C);
                }
                startActivity(intent);
            }

            if (playAgainBoard.equals("6 x 6")) {
                Intent intent = new Intent(winnerPage.this, Board_6x6.class);

                intent.putExtra("playerNumber", playAgainNumPlayers);

                if (playAgainNumPlayers.equals("2")){
                    String player1N = winnerInfo.getString("player1InputtedName");
                    int player1C = winnerInfo.getInt("sendPlayer1Color");
                    String player2N = winnerInfo.getString("player2InputtedName");
                    int player2C = winnerInfo.getInt("sendPlayer2Color");

                    intent.putExtra("player1InputtedName", player1N);
                    intent.putExtra("sendPlayer1Color", player1C);
                    intent.putExtra("player2InputtedName", player2N);
                    intent.putExtra("sendPlayer2Color", player2C);
                }
                if (playAgainNumPlayers.equals("3")){
                    String player1N = winnerInfo.getString("player1InputtedName");
                    int player1C = winnerInfo.getInt("sendPlayer1Color");
                    String player2N = winnerInfo.getString("player2InputtedName");
                    int player2C = winnerInfo.getInt("sendPlayer2Color");
                    String player3N = winnerInfo.getString("player3InputtedName");
                    int player3C = winnerInfo.getInt("sendPlayer3Color");

                    intent.putExtra("player1InputtedName", player1N);
                    intent.putExtra("sendPlayer1Color", player1C);
                    intent.putExtra("player2InputtedName", player2N);
                    intent.putExtra("sendPlayer2Color", player2C);
                    intent.putExtra("player3InputtedName", player3N);
                    intent.putExtra("sendPlayer3Color", player3C);
                }
                if (playAgainNumPlayers.equals("4")){
                    String player1N = winnerInfo.getString("player1InputtedName");
                    int player1C = winnerInfo.getInt("sendPlayer1Color");
                    String player2N = winnerInfo.getString("player2InputtedName");
                    int player2C = winnerInfo.getInt("sendPlayer2Color");
                    String player3N = winnerInfo.getString("player3InputtedName");
                    int player3C = winnerInfo.getInt("sendPlayer3Color");
                    String player4N = winnerInfo.getString("player4InputtedName");
                    int player4C = winnerInfo.getInt("sendPlayer4Color");

                    intent.putExtra("player1InputtedName", player1N);
                    intent.putExtra("sendPlayer1Color", player1C);
                    intent.putExtra("player2InputtedName", player2N);
                    intent.putExtra("sendPlayer2Color", player2C);
                    intent.putExtra("player3InputtedName", player3N);
                    intent.putExtra("sendPlayer3Color", player3C);
                    intent.putExtra("player4InputtedName", player4N);
                    intent.putExtra("sendPlayer4Color", player4C);
                }
                startActivity(intent);
            }
        });

        //go to game set up
        Button home = findViewById(R.id.home);
        home.setOnClickListener(view -> {
            Intent intent = new Intent(winnerPage.this, GameSetUpPage.class);
            startActivity(intent);
        });
    }
}

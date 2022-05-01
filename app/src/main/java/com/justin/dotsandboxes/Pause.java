package com.justin.dotsandboxes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;

public class Pause extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pause_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9), (int)(height*.6));

        //get the sent winner information from game screens
        Bundle resetPlayerInfo = getIntent().getExtras();

        //get passed board size
        String playAgainBoard = resetPlayerInfo.getString("boardSize");
        //get number of players
        String playAgainNumPlayers = resetPlayerInfo.getString("playerNumber");

        Button resume_button = findViewById(R.id.resume_button);
        resume_button.setOnClickListener(view -> {

            if (playAgainBoard.equals("4 x 4")) {

                Intent intent = new Intent(Pause.this, Board_4x4.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(intent, 0);
            }
            if (playAgainBoard.equals("6 x 6")) {

                Intent intent = new Intent(Pause.this, Board_6x6.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivityIfNeeded(intent, 0);
            }
        });

        Button restart_button = findViewById(R.id.restart_button);
        restart_button.setOnClickListener(view -> {

            if (playAgainBoard.equals("4 x 4")) {
                Intent intent = new Intent(Pause.this, Board_4x4.class);

                intent.putExtra("playerNumber", playAgainNumPlayers);

                if (playAgainNumPlayers.equals("2")){
                    String player1N = resetPlayerInfo.getString("player1InputtedName");
                    int player1C = resetPlayerInfo.getInt("sendPlayer1Color");
                    String player2N = resetPlayerInfo.getString("player2InputtedName");
                    int player2C = resetPlayerInfo.getInt("sendPlayer2Color");

                    intent.putExtra("player1InputtedName", player1N);
                    intent.putExtra("sendPlayer1Color", player1C);
                    intent.putExtra("player2InputtedName", player2N);
                    intent.putExtra("sendPlayer2Color", player2C);
                }
                if (playAgainNumPlayers.equals("3")){
                    String player1N = resetPlayerInfo.getString("player1InputtedName");
                    int player1C = resetPlayerInfo.getInt("sendPlayer1Color");
                    String player2N = resetPlayerInfo.getString("player2InputtedName");
                    int player2C = resetPlayerInfo.getInt("sendPlayer2Color");
                    String player3N = resetPlayerInfo.getString("player3InputtedName");
                    int player3C = resetPlayerInfo.getInt("sendPlayer3Color");

                    intent.putExtra("player1InputtedName", player1N);
                    intent.putExtra("sendPlayer1Color", player1C);
                    intent.putExtra("player2InputtedName", player2N);
                    intent.putExtra("sendPlayer2Color", player2C);
                    intent.putExtra("player3InputtedName", player3N);
                    intent.putExtra("sendPlayer3Color", player3C);
                }
                if (playAgainNumPlayers.equals("4")){
                    String player1N = resetPlayerInfo.getString("player1InputtedName");
                    int player1C = resetPlayerInfo.getInt("sendPlayer1Color");
                    String player2N = resetPlayerInfo.getString("player2InputtedName");
                    int player2C = resetPlayerInfo.getInt("sendPlayer2Color");
                    String player3N = resetPlayerInfo.getString("player3InputtedName");
                    int player3C = resetPlayerInfo.getInt("sendPlayer3Color");
                    String player4N = resetPlayerInfo.getString("player4InputtedName");
                    int player4C = resetPlayerInfo.getInt("sendPlayer4Color");

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
                Intent intent = new Intent(Pause.this, Board_6x6.class);

                intent.putExtra("playerNumber", playAgainNumPlayers);

                if (playAgainNumPlayers.equals("2")){
                    String player1N = resetPlayerInfo.getString("player1InputtedName");
                    int player1C = resetPlayerInfo.getInt("sendPlayer1Color");
                    String player2N = resetPlayerInfo.getString("player2InputtedName");
                    int player2C = resetPlayerInfo.getInt("sendPlayer2Color");

                    intent.putExtra("player1InputtedName", player1N);
                    intent.putExtra("sendPlayer1Color", player1C);
                    intent.putExtra("player2InputtedName", player2N);
                    intent.putExtra("sendPlayer2Color", player2C);
                }
                if (playAgainNumPlayers.equals("3")){
                    String player1N = resetPlayerInfo.getString("player1InputtedName");
                    int player1C = resetPlayerInfo.getInt("sendPlayer1Color");
                    String player2N = resetPlayerInfo.getString("player2InputtedName");
                    int player2C = resetPlayerInfo.getInt("sendPlayer2Color");
                    String player3N = resetPlayerInfo.getString("player3InputtedName");
                    int player3C = resetPlayerInfo.getInt("sendPlayer3Color");

                    intent.putExtra("player1InputtedName", player1N);
                    intent.putExtra("sendPlayer1Color", player1C);
                    intent.putExtra("player2InputtedName", player2N);
                    intent.putExtra("sendPlayer2Color", player2C);
                    intent.putExtra("player3InputtedName", player3N);
                    intent.putExtra("sendPlayer3Color", player3C);
                }
                if (playAgainNumPlayers.equals("4")){
                    String player1N = resetPlayerInfo.getString("player1InputtedName");
                    int player1C = resetPlayerInfo.getInt("sendPlayer1Color");
                    String player2N = resetPlayerInfo.getString("player2InputtedName");
                    int player2C = resetPlayerInfo.getInt("sendPlayer2Color");
                    String player3N = resetPlayerInfo.getString("player3InputtedName");
                    int player3C = resetPlayerInfo.getInt("sendPlayer3Color");
                    String player4N = resetPlayerInfo.getString("player4InputtedName");
                    int player4C = resetPlayerInfo.getInt("sendPlayer4Color");

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
        Button quit_button = findViewById(R.id.quit_button);
        quit_button.setOnClickListener(view -> {
            Intent intent = new Intent(Pause.this, GameSetUpPage.class);
            startActivity(intent);
        });
    }
}

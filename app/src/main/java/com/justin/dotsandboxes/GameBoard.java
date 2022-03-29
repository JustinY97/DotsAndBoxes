package com.justin.dotsandboxes;
import android.annotation.SuppressLint;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class GameBoard extends AppCompatActivity {

    int rows;
    int columns;
    String passedNumber;
    String passedPlayer1Name;
    int passedPlayer1Color;
    String passedPlayer2Name;
    int passedPlayer2Color;
    String passedPlayer3Name;
    int passedPlayer3Color;
    String passedPlayer4Name;
    int passedPlayer4Color;
    TextView player1Name;
    TextView player2Name;
    TextView player3Name;
    TextView player4Name;
    String passedSize;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.game_board);

        //get the textviews and set their visibility default to GONE
        player1Name = findViewById(R.id.player1);
        player1Name.setVisibility(View.GONE);

        player2Name = findViewById(R.id.player2);
        player2Name.setVisibility(View.GONE);

        player3Name = findViewById(R.id.player3);
        player3Name.setVisibility(View.GONE);

        player4Name = findViewById(R.id.player4);
        player4Name.setVisibility(View.GONE);

        //get the passed in values
        Bundle setupInfo = getIntent().getExtras();

        if (setupInfo != null) {
            //game board
            passedSize = setupInfo.getString("boardSize");
            rows = Integer.parseInt(String.valueOf(passedSize.charAt(0))) + 1;
            columns = Integer.parseInt(String.valueOf(passedSize.charAt(4))) + 1;

            //number of players
            passedNumber = setupInfo.getString("playerNumber");

            if (passedNumber.equals("2")) {

                passedPlayer1Name = setupInfo.getString("player1InputtedName");
                    player1Name.setVisibility(View.VISIBLE);
                    player1Name.setText(passedPlayer1Name);
                passedPlayer1Color = setupInfo.getInt("sendPlayer1Color");
                player1Name.setTextColor(passedPlayer1Color);

                passedPlayer2Name = setupInfo.getString("player2InputtedName");
                    player2Name.setVisibility(View.VISIBLE);
                    player2Name.setText(passedPlayer2Name);
                passedPlayer2Color = setupInfo.getInt("sendPlayer2Color");
                player2Name.setTextColor(passedPlayer2Color);

            } else if (passedNumber.equals("3")) {
                passedPlayer1Name = setupInfo.getString("player1InputtedName");
                    player1Name.setVisibility(View.VISIBLE);
                    player1Name.setText(passedPlayer1Name);
                passedPlayer1Color = setupInfo.getInt("sendPlayer1Color");
                player1Name.setTextColor(passedPlayer1Color);

                passedPlayer2Name = setupInfo.getString("player2InputtedName");
                    player2Name.setVisibility(View.VISIBLE);
                    player2Name.setText(passedPlayer2Name);
                passedPlayer2Color = setupInfo.getInt("sendPlayer2Color");
                player2Name.setTextColor(passedPlayer2Color);

                passedPlayer3Name = setupInfo.getString("player3InputtedName");
                    player3Name.setVisibility(View.VISIBLE);
                    player3Name.setText(passedPlayer3Name);
                passedPlayer3Color = setupInfo.getInt("sendPlayer3Color");
                player3Name.setTextColor(passedPlayer3Color);

            } else {
                passedPlayer1Name = setupInfo.getString("player1InputtedName");
                    player1Name.setVisibility(View.VISIBLE);
                    player1Name.setText(passedPlayer1Name);
                passedPlayer1Color = setupInfo.getInt("sendPlayer1Color");
                player1Name.setTextColor(passedPlayer1Color);

                passedPlayer2Name = setupInfo.getString("player2InputtedName");
                    player2Name.setVisibility(View.VISIBLE);
                    player2Name.setText(passedPlayer2Name);
                passedPlayer2Color = setupInfo.getInt("sendPlayer2Color");
                player2Name.setTextColor(passedPlayer2Color);

                passedPlayer3Name = setupInfo.getString("player3InputtedName");
                    player3Name.setVisibility(View.VISIBLE);
                    player3Name.setText(passedPlayer3Name);
                passedPlayer3Color = setupInfo.getInt("sendPlayer3Color");
                player3Name.setTextColor(passedPlayer3Color);

                passedPlayer4Name = setupInfo.getString("player4InputtedName");
                    player4Name.setVisibility(View.VISIBLE);
                    player4Name.setText(passedPlayer4Name);
                passedPlayer4Color = setupInfo.getInt("sendPlayer4Color");
                player4Name.setTextColor(passedPlayer4Color);
            }
        }


        LinearLayout layout = findViewById(R.id.base_screen);

        TextView player1NamePlacement = new TextView(this);
        player1NamePlacement.setText(passedPlayer1Name);
        TextView player2NamePlacement = new TextView(this);
        player2NamePlacement.setText(passedPlayer2Name);
        TextView player3NamePlacement = new TextView(this);
        player3NamePlacement.setText(passedPlayer3Name);
        TextView player4NamePlacement = new TextView(this);
        player4NamePlacement.setText(passedPlayer4Name);


        TableLayout game_board = findViewById(R.id.board);

        int[] nodes = {rows * columns + 1, rows * columns + 1};
        for(int i = 0; i < rows; i++){
            LinearLayout tableRow = new LinearLayout(this);
            for(int j = 0; j < columns; j++){
                ImageView node = new ImageView(this);
                node.setImageResource(R.drawable.board_node);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(50, 50);
                lp.setMargins(20, 20, 20, 20);
                node.setLayoutParams(lp);
                node.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(70, 70);
                        lp2.setMargins(10, 10, 10, 10);
                        node.setLayoutParams(lp2);
                        if(nodes[0] == rows * columns + 1){
                            nodes[0] = node.getId();
                            node.setColorFilter(Color.BLUE);
                        } else {
                            nodes[1] = node.getId();
                            node.setColorFilter(Color.RED);
                            nodes[0] = rows * columns + 1;
                        }
                    }
                });

                tableRow.addView(node);

            }
            game_board.addView(tableRow);
        }
        /*layout.addView(player1NamePlacement);
        layout.addView(player2NamePlacement);
        layout.addView(player3NamePlacement);
        layout.addView(player4NamePlacement);
        layout.addView(game_board);
        */
   }
}
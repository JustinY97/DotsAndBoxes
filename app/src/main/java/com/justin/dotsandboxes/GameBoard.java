package com.justin.dotsandboxes;
import android.annotation.SuppressLint;

import android.os.Bundle;
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
    String passedPlayer2Name;
    String passedPlayer3Name;
    String passedPlayer4Name;
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

                passedPlayer2Name = setupInfo.getString("player2InputtedName");
                    player2Name.setVisibility(View.VISIBLE);
                    player2Name.setText(passedPlayer2Name);

            } else if (passedNumber.equals("3")) {
                passedPlayer1Name = setupInfo.getString("player1InputtedName");
                    player1Name.setVisibility(View.VISIBLE);
                    player1Name.setText(passedPlayer1Name);

                passedPlayer2Name = setupInfo.getString("player2InputtedName");
                    player2Name.setVisibility(View.VISIBLE);
                    player2Name.setText(passedPlayer2Name);

                passedPlayer3Name = setupInfo.getString("player3InputtedName");
                    player3Name.setVisibility(View.VISIBLE);
                    player3Name.setText(passedPlayer3Name);
            } else {
                passedPlayer1Name = setupInfo.getString("player1InputtedName");
                    player1Name.setVisibility(View.VISIBLE);
                    player1Name.setText(passedPlayer1Name);
                passedPlayer2Name = setupInfo.getString("player2InputtedName");
                    player2Name.setVisibility(View.VISIBLE);
                    player2Name.setText(passedPlayer2Name);
                passedPlayer3Name = setupInfo.getString("player3InputtedName");
                    player3Name.setVisibility(View.VISIBLE);
                    player3Name.setText(passedPlayer3Name);
                passedPlayer4Name = setupInfo.getString("player4InputtedName");
                    player4Name.setVisibility(View.VISIBLE);
                    player4Name.setText(passedPlayer4Name);
            }
        }


        LinearLayout layout = new LinearLayout(this);

        layout.setOrientation(LinearLayout.VERTICAL);

        TextView player1NamePlacement = new TextView(this);
        player1NamePlacement.setText(passedPlayer1Name);
        TextView player2NamePlacement = new TextView(this);
        player2NamePlacement.setText(passedPlayer2Name);
        TextView player3NamePlacement = new TextView(this);
        player3NamePlacement.setText(passedPlayer3Name);
        TextView player4NamePlacement = new TextView(this);
        player4NamePlacement.setText(passedPlayer4Name);


        TableLayout game_board = new TableLayout(this);
        ImageView[] nodes = {null, null};
        for(int i = 0; i < rows; i++){
            LinearLayout tableRow = new LinearLayout(this);
            for(int j = 0; j < columns; j++){
                ImageView node = new ImageView(this);
                node.setImageResource(R.drawable.board_node);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(50, 50);
                lp.setMargins(20, 20, 20, 20);
                node.setLayoutParams(lp);
                node.setOnTouchListener((view, motionEvent) -> {
                    if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        lp.width = 70;
                        lp.height = 70;
                        lp.setMargins(10, 10, 10, 10);
                        node.setLayoutParams(lp);
                        if (nodes[0] == null) {
                            nodes[0] = node;
                        } else {
                            nodes[1] = node;
                        }
                    }
                    else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                        lp.width = 50;
                        lp.height = 50;
                        lp.setMargins(20, 20, 20, 20);
                        node.setLayoutParams(lp);
                    }
                    return  true;
                });

                tableRow.addView(node);

            }
            game_board.addView(tableRow);
        }
        layout.addView(player1NamePlacement);
        layout.addView(player2NamePlacement);
        layout.addView(player3NamePlacement);
        layout.addView(player4NamePlacement);
        layout.addView(game_board);
        setContentView(layout);

   }
}
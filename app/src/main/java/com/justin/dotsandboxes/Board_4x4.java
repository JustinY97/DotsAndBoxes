package com.justin.dotsandboxes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class Board_4x4 extends AppCompatActivity {

    HashMap<View, View[]> blocks = new HashMap<>();
    TextView player1Name;
    String passedPlayer1Name;
    int passedPlayer1Color;

    TextView player2Name;
    String passedPlayer2Name;
    int passedPlayer2Color;

    TextView player3Name;
    String passedPlayer3Name;
    int passedPlayer3Color;

    TextView player4Name;
    String passedPlayer4Name;
    int passedPlayer4Color;
    String passedNumber;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board4x4);

        //Player Name Section -- Hide them
        //Player 1
        player1Name = findViewById(R.id.Player1Name);
        player1Name.setVisibility(View.GONE);

        //Player 2
        player2Name = findViewById(R.id.Player2Name);
        player2Name.setVisibility(View.GONE);

        //Player 3
        player3Name = findViewById(R.id.Player3Name);
        player3Name.setVisibility(View.GONE);

        //Player 4
        player4Name = findViewById(R.id.Player4Name);
        player4Name.setVisibility(View.GONE);

        //Get the intent data from Game Set Up Page
        //get the passed in values
        Bundle setupInfo = getIntent().getExtras();

        if (setupInfo != null) {
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

        View h1 = findViewById(R.id.h1);
        View h2 = findViewById(R.id.h2);
        View h3 = findViewById(R.id.h3);
        View h4 = findViewById(R.id.h4);
        View h5 = findViewById(R.id.h5);
        View h6 = findViewById(R.id.h6);
        View h7 = findViewById(R.id.h7);
        View h8 = findViewById(R.id.h8);
        View h9 = findViewById(R.id.h9);
        View h10 = findViewById(R.id.h10);
        View h11 = findViewById(R.id.h11);
        View h12 = findViewById(R.id.h12);
        View h13 = findViewById(R.id.h13);
        View h14 = findViewById(R.id.h14);
        View h15 = findViewById(R.id.h15);
        View h16 = findViewById(R.id.h16);
        View h17 = findViewById(R.id.h17);
        View h18 = findViewById(R.id.h18);
        View h19 = findViewById(R.id.h19);
        View h20 = findViewById(R.id.h20);

        View[] horizontals = {h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14, h15, h16, h17, h18, h19, h20};

        View v1 = findViewById(R.id.v1);
        View v2 = findViewById(R.id.v2);
        View v3 = findViewById(R.id.v3);
        View v4 = findViewById(R.id.v4);
        View v5 = findViewById(R.id.v5);
        View v6 = findViewById(R.id.v6);
        View v7 = findViewById(R.id.v7);
        View v8 = findViewById(R.id.v8);
        View v9 = findViewById(R.id.v9);
        View v10 = findViewById(R.id.v10);
        View v11 = findViewById(R.id.v11);
        View v12 = findViewById(R.id.v12);
        View v13 = findViewById(R.id.v13);
        View v14 = findViewById(R.id.v14);
        View v15 = findViewById(R.id.v15);
        View v16 = findViewById(R.id.v16);
        View v17 = findViewById(R.id.v17);
        View v18 = findViewById(R.id.v18);
        View v19 = findViewById(R.id.v19);
        View v20 = findViewById(R.id.v20);

        View[] verticals = {v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20};

        View sq1 = findViewById(R.id.sq1);
        View sq2 = findViewById(R.id.sq2);
        View sq3 = findViewById(R.id.sq3);
        View sq4 = findViewById(R.id.sq4);
        View sq5 = findViewById(R.id.sq5);
        View sq6 = findViewById(R.id.sq6);
        View sq7 = findViewById(R.id.sq7);
        View sq8 = findViewById(R.id.sq8);
        View sq9 = findViewById(R.id.sq9);
        View sq10 = findViewById(R.id.sq10);
        View sq11 = findViewById(R.id.sq11);
        View sq12 = findViewById(R.id.sq12);
        View sq13 = findViewById(R.id.sq13);
        View sq14 = findViewById(R.id.sq14);
        View sq15 = findViewById(R.id.sq15);
        View sq16 = findViewById(R.id.sq16);

        View[] squares = {sq1, sq2, sq3, sq4, sq5, sq6, sq7, sq8, sq9, sq10, sq11, sq12, sq13, sq14, sq15, sq16};


        // Adding game blocks to blocks Map. Add on click listener to each line to check if the other lines in each square are filled in.
        blocks.put(squares[0], new View[]{horizontals[0], horizontals[4], verticals[0], verticals[1]});
        blocks.put(squares[1], new View[]{horizontals[1], horizontals[5], verticals[1], verticals[2]});
        blocks.put(squares[2], new View[]{horizontals[2], horizontals[6], verticals[2], verticals[3]});
        blocks.put(squares[3], new View[]{horizontals[3], horizontals[7], verticals[3], verticals[4]});
        blocks.put(squares[4], new View[]{horizontals[4], horizontals[8], verticals[5], verticals[6]});
        blocks.put(squares[5], new View[]{horizontals[5], horizontals[9], verticals[6], verticals[7]});
        blocks.put(squares[6], new View[]{horizontals[6], horizontals[10], verticals[7], verticals[8]});
        blocks.put(squares[7], new View[]{horizontals[7], horizontals[11], verticals[8], verticals[9]});
        blocks.put(squares[8], new View[]{horizontals[8], horizontals[12], verticals[10], verticals[11]});
        blocks.put(squares[9], new View[]{horizontals[9], horizontals[13], verticals[11], verticals[12]});
        blocks.put(squares[10], new View[]{horizontals[10], horizontals[14], verticals[12], verticals[13]});
        blocks.put(squares[11], new View[]{horizontals[11], horizontals[15], verticals[13], verticals[14]});
        blocks.put(squares[12], new View[]{horizontals[12], horizontals[16], verticals[15], verticals[16]});
        blocks.put(squares[13], new View[]{horizontals[13], horizontals[17], verticals[16], verticals[17]});
        blocks.put(squares[14], new View[]{horizontals[14], horizontals[18], verticals[17], verticals[18]});
        blocks.put(squares[15], new View[]{horizontals[15], horizontals[19], verticals[18], verticals[19]});

        Drawable board_line = (Drawable) getDrawable(R.drawable.board_line);
        for(View vertical : verticals) {
            vertical.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkLines(view);
                }
            });
        }

        for(View horizontal : horizontals) {
            horizontal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkLines(view);
                }
            });
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void checkLines(View view){
        view.setBackgroundResource(R.drawable.clicked_line);
        //boolean current_square = false;
        //boolean has_unclicked_edge = false;
        for(Map.Entry block : blocks.entrySet()){
            View[] sides = (View[]) block.getValue();
            for(View side : sides){
                //has_unclicked_edge = false;
                if(side == view){
                    // This is the square we want to be in
                    //current_square = true;
                    int count = 0;
                    for(View temp : sides){

                        if(temp.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.clicked_line).getConstantState())){
                            count++;
                        }
                        if(count == 4){
                            View current = (View) block.getKey();
                            current.setBackgroundColor(Color.RED);
                        }
                    }
                }
            }
        }
    }
}
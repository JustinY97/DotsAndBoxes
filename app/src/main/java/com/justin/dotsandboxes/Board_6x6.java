package com.justin.dotsandboxes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board_6x6  extends AppCompatActivity {

    HashMap<View, View[]> blocks = new HashMap<>();

    Button pauseBtn;
    ImageView home_button;
    ImageView help_button;

    String passedPlayer1Name;
    int passedPlayer1Color;

    String passedPlayer2Name;
    int passedPlayer2Color;

    String passedPlayer3Name;
    int passedPlayer3Color;

    String passedPlayer4Name;
    int passedPlayer4Color;
    String passedNumber;

    int[] player_colors = new int[4];
    int[] scores = {0, 0, 0, 0};
    View[] scoreBox = new View[4];


    int current_player = 1;
    int num_players;
    int filled_boxes = 0;

    TextView[] player_scores = new TextView[4];
    String[] player_names = new String[4];

    TextView currentPlayerDisplay;
    View currentPlayerDisplayLine;

    View player1ColorFrame;
    View player1ColorDisplay;
    View player1CurrentIdentifier;
    TextView player1Score;

    View player2ColorFrame;
    View player2ColorDisplay;
    View player2CurrentIdentifier;
    TextView player2Score;

    View player3ColorFrame;
    View player3ColorDisplay;
    View player3CurrentIdentifier;
    TextView player3Score;

    View player4ColorFrame;
    View player4ColorDisplay;
    View player4CurrentIdentifier;
    TextView player4Score;

    View player5ColorFrame;
    View player5ColorDisplay;
    View player5CurrentIdentifier;
    TextView player5Score;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board6x6);
        getSupportActionBar().hide();
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        home_button = findViewById(R.id.home_button);
        help_button = findViewById(R.id.help_button);
        pauseBtn = findViewById(R.id.pauseButton);
        pauseBtn.setPaintFlags(pauseBtn.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        home_button.setOnClickListener(view -> {
            Intent intent = new Intent(Board_6x6.this, Pop1.class);
            startActivity(intent);
        });
        help_button.setOnClickListener(view -> {
            Intent intent = new Intent(Board_6x6.this, Help.class);
            startActivity(intent);
        });

        pauseBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Board_6x6.this, Pause.class);
            startActivity(intent);
        });

        //Player Name Section -- Hide them
        //Current Player name Display -- DON'T hide this one
        currentPlayerDisplay = findViewById(R.id.currentPlayerName);
        currentPlayerDisplayLine = findViewById(R.id.currentPlayerNameLine);

        //Player 1 - Colors/Score/GreyBox
        player1ColorFrame = findViewById(R.id.Player1Frame);
        player1ColorFrame.setVisibility(View.GONE);
        player1ColorDisplay = findViewById(R.id.Player1Color);
        player1ColorDisplay.setVisibility(View.GONE);
        player1CurrentIdentifier = findViewById(R.id.Player1CurrentIdentifier);
        player1CurrentIdentifier.setVisibility(View.GONE);
        player1Score = findViewById(R.id.Player1Score);
        player1Score.setVisibility(View.GONE);

        //Player 2 - Colors/Score/GreyBox
        player2ColorFrame = findViewById(R.id.Player2Frame);
        player2ColorFrame.setVisibility(View.GONE);
        player2ColorDisplay = findViewById(R.id.Player2Color);
        player2ColorDisplay.setVisibility(View.GONE);
        player2CurrentIdentifier = findViewById(R.id.Player2CurrentIdentifier);
        player2CurrentIdentifier.setVisibility(View.GONE);
        player2Score = findViewById(R.id.Player2Score);
        player2Score.setVisibility(View.GONE);

        //Player 3 - Colors/Score/GreyBox
        player3ColorFrame = findViewById(R.id.Player3Frame);
        player3ColorFrame.setVisibility(View.GONE);
        player3ColorDisplay = findViewById(R.id.Player3Color);
        player3ColorDisplay.setVisibility(View.GONE);
        player3CurrentIdentifier = findViewById(R.id.Player3CurrentIdentifier);
        player3CurrentIdentifier.setVisibility(View.GONE);
        player3Score = findViewById(R.id.Player3Score);
        player3Score.setVisibility(View.GONE);

        //Player 4 - Colors/Score/GreyBox
        player4ColorFrame = findViewById(R.id.Player4Frame);
        player4ColorFrame.setVisibility(View.GONE);
        player4ColorDisplay = findViewById(R.id.Player4Color);
        player4ColorDisplay.setVisibility(View.GONE);
        player4CurrentIdentifier = findViewById(R.id.Player4CurrentIdentifier);
        player4CurrentIdentifier.setVisibility(View.GONE);
        player4Score = findViewById(R.id.Player4Score);
        player4Score.setVisibility(View.GONE);

        //Player 5 - Colors/Score/GreyBox
        player5ColorFrame = findViewById(R.id.Player5Frame);
        player5ColorFrame.setVisibility(View.GONE);
        player5ColorDisplay = findViewById(R.id.Player5Color);
        player5ColorDisplay.setVisibility(View.GONE);
        player5CurrentIdentifier = findViewById(R.id.Player5CurrentIdentifier);
        player5CurrentIdentifier.setVisibility(View.GONE);
        player5Score = findViewById(R.id.Player5Score);
        player5Score.setVisibility(View.GONE);

        //Get the intent data from Game Set Up Page
        //get the passed in values
        Bundle setupInfo = getIntent().getExtras();

        if (setupInfo != null) {
            //number of players
            passedNumber = setupInfo.getString("playerNumber");
            num_players = Integer.parseInt(passedNumber);
            Log.e("passed number:", passedNumber);


            if (passedNumber.equals("2")) {

                //Set the Player 2 and Player 3 sections to visible -- 2 and 3 for formatting
                player2ColorFrame.setVisibility(View.VISIBLE);
                player2ColorDisplay.setVisibility(View.VISIBLE);
                player2CurrentIdentifier.setVisibility(View.VISIBLE);
                player2Score.setVisibility(View.VISIBLE);

                player3ColorFrame.setVisibility(View.VISIBLE);
                player3ColorDisplay.setVisibility(View.VISIBLE);
                player3Score.setVisibility(View.VISIBLE);

                //Get the information of Player 1
                passedPlayer1Name = setupInfo.getString("player1InputtedName");
                currentPlayerDisplay.setText(passedPlayer1Name);
                passedPlayer1Color = setupInfo.getInt("sendPlayer1Color");
                currentPlayerDisplayLine.setBackgroundColor(passedPlayer1Color);
                player2ColorDisplay.setBackgroundColor(passedPlayer1Color);

                //Get the information of Player 2
                passedPlayer2Name = setupInfo.getString("player2InputtedName");
                passedPlayer2Color = setupInfo.getInt("sendPlayer2Color");
                player3ColorDisplay.setBackgroundColor(passedPlayer2Color);

                Log.e("Player 1 Color:", String.valueOf(passedPlayer1Color));
                Log.e("Player 2 Color:", String.valueOf(passedPlayer2Color));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    player_colors[0] = passedPlayer1Color;
                    player_colors[1] = passedPlayer2Color;
                }

                player_names[0] = passedPlayer1Name;
                player_names[1] = passedPlayer2Name;

                player_scores[0] = player2Score;
                player_scores[1] = player3Score;

                scoreBox[0] = player2CurrentIdentifier;
                scoreBox[1] = player3CurrentIdentifier;
            }
            else if (passedNumber.equals("3")) {
                //Set the Player 1, 5, and 4 sections to visible
                player1ColorFrame.setVisibility(View.VISIBLE);
                player1ColorDisplay.setVisibility(View.VISIBLE);
                player1CurrentIdentifier.setVisibility(View.VISIBLE);
                player1Score.setVisibility(View.VISIBLE);

                player5ColorFrame.setVisibility(View.VISIBLE);
                player5ColorDisplay.setVisibility(View.VISIBLE);
                player5Score.setVisibility(View.VISIBLE);

                player4ColorFrame.setVisibility(View.VISIBLE);
                player4ColorDisplay.setVisibility(View.VISIBLE);
                player4Score.setVisibility(View.VISIBLE);

                //Get the information of Player 1 --> Player 1 section
                passedPlayer1Name = setupInfo.getString("player1InputtedName");
                currentPlayerDisplay.setText(passedPlayer1Name);
                passedPlayer1Color = setupInfo.getInt("sendPlayer1Color");
                currentPlayerDisplayLine.setBackgroundColor(passedPlayer1Color);
                player1ColorDisplay.setBackgroundColor(passedPlayer1Color);

                //Get the information of Player 2 --> Player 5 section
                passedPlayer2Name = setupInfo.getString("player2InputtedName");
                passedPlayer2Color = setupInfo.getInt("sendPlayer2Color");
                player5ColorDisplay.setBackgroundColor(passedPlayer2Color);

                //Get the information of Player 4 --> Player 4 section
                passedPlayer3Name = setupInfo.getString("player3InputtedName");
                passedPlayer3Color = setupInfo.getInt("sendPlayer3Color");
                player4ColorDisplay.setBackgroundColor(passedPlayer3Color);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    player_colors[0] = passedPlayer1Color;
                    player_colors[1] = passedPlayer2Color;
                    player_colors[2] = passedPlayer3Color;
                }

                player_names[0] = passedPlayer1Name;
                player_names[1] = passedPlayer2Name;
                player_names[2] = passedPlayer3Name;

                player_scores[0] = player1Score;
                player_scores[1] = player5Score;
                player_scores[2] = player4Score;

                scoreBox[0] = player1CurrentIdentifier;
                scoreBox[1] = player5CurrentIdentifier;
                scoreBox[2] = player4CurrentIdentifier;

            }
            else {
                //Set the Player 1, 2, 3, and 4 sections to visible
                player1ColorFrame.setVisibility(View.VISIBLE);
                player1ColorDisplay.setVisibility(View.VISIBLE);
                player1CurrentIdentifier.setVisibility(View.VISIBLE);
                player1Score.setVisibility(View.VISIBLE);

                player2ColorFrame.setVisibility(View.VISIBLE);
                player2ColorDisplay.setVisibility(View.VISIBLE);
                player2Score.setVisibility(View.VISIBLE);

                player3ColorFrame.setVisibility(View.VISIBLE);
                player3ColorDisplay.setVisibility(View.VISIBLE);
                player3Score.setVisibility(View.VISIBLE);

                player4ColorFrame.setVisibility(View.VISIBLE);
                player4ColorDisplay.setVisibility(View.VISIBLE);
                player4Score.setVisibility(View.VISIBLE);

                //Get the information of Player 1 --> Player 1 section
                passedPlayer1Name = setupInfo.getString("player1InputtedName");
                currentPlayerDisplay.setText(passedPlayer1Name);
                passedPlayer1Color = setupInfo.getInt("sendPlayer1Color");
                currentPlayerDisplayLine.setBackgroundColor(passedPlayer1Color);
                player1ColorDisplay.setBackgroundColor(passedPlayer1Color);

                //Get the information of Player 2 --> Player 2 section
                passedPlayer2Name = setupInfo.getString("player2InputtedName");
                passedPlayer2Color = setupInfo.getInt("sendPlayer2Color");
                player2ColorDisplay.setBackgroundColor(passedPlayer2Color);

                //Get the information of Player 3 --> Player 3 section
                passedPlayer3Name = setupInfo.getString("player3InputtedName");
                passedPlayer3Color = setupInfo.getInt("sendPlayer3Color");
                player3ColorDisplay.setBackgroundColor(passedPlayer3Color);

                //Get the information of Player 4 --> Player 4 section
                passedPlayer4Name = setupInfo.getString("player4InputtedName");
                passedPlayer4Color = setupInfo.getInt("sendPlayer4Color");
                player4ColorDisplay.setBackgroundColor(passedPlayer4Color);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    player_colors[0] = passedPlayer1Color;
                    player_colors[1] = passedPlayer2Color;
                    player_colors[2] = passedPlayer3Color;
                    player_colors[3] = passedPlayer4Color;
                }

                player_names[0] = passedPlayer1Name;
                player_names[1] = passedPlayer2Name;
                player_names[2] = passedPlayer3Name;
                player_names[3] = passedPlayer4Name;

                player_scores[0] = player1Score;
                player_scores[1] = player2Score;
                player_scores[2] = player3Score;
                player_scores[3] = player4Score;

                scoreBox[0] = player1CurrentIdentifier;
                scoreBox[1] = player2CurrentIdentifier;
                scoreBox[2] = player3CurrentIdentifier;
                scoreBox[3] = player4CurrentIdentifier;
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
        View h21 = findViewById(R.id.h21);
        View h22 = findViewById(R.id.h22);
        View h23 = findViewById(R.id.h23);
        View h24 = findViewById(R.id.h24);
        View h25 = findViewById(R.id.h25);
        View h26 = findViewById(R.id.h26);
        View h27 = findViewById(R.id.h27);
        View h28 = findViewById(R.id.h28);
        View h29 = findViewById(R.id.h29);
        View h30 = findViewById(R.id.h30);
        View h31 = findViewById(R.id.h31);
        View h32 = findViewById(R.id.h32);
        View h33 = findViewById(R.id.h33);
        View h34 = findViewById(R.id.h34);
        View h35 = findViewById(R.id.h35);
        View h36 = findViewById(R.id.h36);
        View h37 = findViewById(R.id.h37);
        View h38 = findViewById(R.id.h38);
        View h39 = findViewById(R.id.h39);
        View h40 = findViewById(R.id.h40);
        View h41 = findViewById(R.id.h41);
        View h42 = findViewById(R.id.h42);

        View[] horizontals = {h1,  h2,  h3,  h4,  h5,  h6,  h7,  h8,  h9,  h10,
                              h11, h12, h13, h14, h15, h16, h17, h18, h19, h20,
                              h21, h22, h23, h24, h25, h26, h27, h28, h29, h30,
                              h31, h32, h33, h34, h35, h36, h37, h38, h39, h40,
                              h41, h42};

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
        View v21 = findViewById(R.id.v21);
        View v22 = findViewById(R.id.v22);
        View v23 = findViewById(R.id.v23);
        View v24 = findViewById(R.id.v24);
        View v25 = findViewById(R.id.v25);
        View v26 = findViewById(R.id.v26);
        View v27 = findViewById(R.id.v27);
        View v28 = findViewById(R.id.v28);
        View v29 = findViewById(R.id.v29);
        View v30 = findViewById(R.id.v30);
        View v31 = findViewById(R.id.v31);
        View v32 = findViewById(R.id.v32);
        View v33 = findViewById(R.id.v33);
        View v34 = findViewById(R.id.v34);
        View v35 = findViewById(R.id.v35);
        View v36 = findViewById(R.id.v36);
        View v37 = findViewById(R.id.v37);
        View v38 = findViewById(R.id.v38);
        View v39 = findViewById(R.id.v39);
        View v40 = findViewById(R.id.v40);
        View v41 = findViewById(R.id.v41);
        View v42 = findViewById(R.id.v42);

        View[] verticals = {v1,  v2,  v3,  v4,  v5,  v6,  v7,  v8,  v9,  v10,
                            v11, v12, v13, v14, v15, v16, v17, v18, v19, v20,
                            v21, v22, v23, v24, v25, v26, v27, v28, v29, v30,
                            v31, v32, v33, v34, v35, v36, v37, v38, v39, v40,
                            v41, v42};

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
        View sq17 = findViewById(R.id.sq17);
        View sq18 = findViewById(R.id.sq18);
        View sq19 = findViewById(R.id.sq19);
        View sq20 = findViewById(R.id.sq20);
        View sq21 = findViewById(R.id.sq21);
        View sq22 = findViewById(R.id.sq22);
        View sq23 = findViewById(R.id.sq23);
        View sq24 = findViewById(R.id.sq24);
        View sq25 = findViewById(R.id.sq25);
        View sq26 = findViewById(R.id.sq26);
        View sq27 = findViewById(R.id.sq27);
        View sq28 = findViewById(R.id.sq28);
        View sq29 = findViewById(R.id.sq29);
        View sq30 = findViewById(R.id.sq30);
        View sq31 = findViewById(R.id.sq31);
        View sq32 = findViewById(R.id.sq32);
        View sq33 = findViewById(R.id.sq33);
        View sq34 = findViewById(R.id.sq34);
        View sq35 = findViewById(R.id.sq35);
        View sq36 = findViewById(R.id.sq36);


        View[] squares = {sq1,  sq2,  sq3,  sq4,  sq5,  sq6,  sq7,  sq8,  sq9,  sq10,
                          sq11, sq12, sq13, sq14, sq15, sq16, sq17, sq18, sq19, sq20,
                          sq21, sq22, sq23, sq24, sq25, sq26, sq27, sq28, sq29, sq30,
                          sq31, sq32, sq33, sq34, sq35, sq36};


        // Adding game blocks to blocks Map. Add on click listener to each line to check if the other lines in each square are filled in.

        //Row 1
        blocks.put(squares[0], new View[]{horizontals[0], horizontals[6], verticals[0], verticals[1]});
        blocks.put(squares[1], new View[]{horizontals[1], horizontals[7], verticals[1], verticals[2]});
        blocks.put(squares[2], new View[]{horizontals[2], horizontals[8], verticals[2], verticals[3]});
        blocks.put(squares[3], new View[]{horizontals[3], horizontals[9], verticals[3], verticals[4]});
        blocks.put(squares[4], new View[]{horizontals[4], horizontals[10], verticals[4], verticals[5]});
        blocks.put(squares[5], new View[]{horizontals[5], horizontals[11], verticals[5], verticals[6]});

        //Row 2
        blocks.put(squares[6], new View[]{horizontals[6], horizontals[12], verticals[7], verticals[8]});
        blocks.put(squares[7], new View[]{horizontals[7], horizontals[13], verticals[8], verticals[9]});
        blocks.put(squares[8], new View[]{horizontals[8], horizontals[14], verticals[9], verticals[10]});
        blocks.put(squares[9], new View[]{horizontals[9], horizontals[15], verticals[10], verticals[11]});
        blocks.put(squares[10], new View[]{horizontals[10], horizontals[16], verticals[11], verticals[12]});
        blocks.put(squares[11], new View[]{horizontals[11], horizontals[17], verticals[12], verticals[13]});

        //Row 3
        blocks.put(squares[12], new View[]{horizontals[12], horizontals[18], verticals[14], verticals[15]});
        blocks.put(squares[13], new View[]{horizontals[13], horizontals[19], verticals[15], verticals[16]});
        blocks.put(squares[14], new View[]{horizontals[14], horizontals[20], verticals[16], verticals[17]});
        blocks.put(squares[15], new View[]{horizontals[15], horizontals[21], verticals[17], verticals[18]});
        blocks.put(squares[16], new View[]{horizontals[16], horizontals[22], verticals[18], verticals[19]});
        blocks.put(squares[17], new View[]{horizontals[17], horizontals[23], verticals[19], verticals[20]});

        //Row 4
        blocks.put(squares[18], new View[]{horizontals[18], horizontals[24], verticals[21], verticals[22]});
        blocks.put(squares[19], new View[]{horizontals[19], horizontals[25], verticals[22], verticals[23]});
        blocks.put(squares[20], new View[]{horizontals[20], horizontals[26], verticals[23], verticals[24]});
        blocks.put(squares[21], new View[]{horizontals[21], horizontals[27], verticals[24], verticals[25]});
        blocks.put(squares[22], new View[]{horizontals[22], horizontals[28], verticals[25], verticals[26]});
        blocks.put(squares[23], new View[]{horizontals[23], horizontals[29], verticals[26], verticals[27]});

        //Row 5
        blocks.put(squares[24], new View[]{horizontals[24], horizontals[30], verticals[28], verticals[29]});
        blocks.put(squares[25], new View[]{horizontals[25], horizontals[31], verticals[29], verticals[30]});
        blocks.put(squares[26], new View[]{horizontals[26], horizontals[32], verticals[30], verticals[31]});
        blocks.put(squares[27], new View[]{horizontals[27], horizontals[33], verticals[31], verticals[32]});
        blocks.put(squares[28], new View[]{horizontals[28], horizontals[34], verticals[32], verticals[33]});
        blocks.put(squares[29], new View[]{horizontals[29], horizontals[35], verticals[33], verticals[34]});

        //Row 6
        blocks.put(squares[30], new View[]{horizontals[30], horizontals[36], verticals[35], verticals[36]});
        blocks.put(squares[31], new View[]{horizontals[31], horizontals[37], verticals[36], verticals[37]});
        blocks.put(squares[32], new View[]{horizontals[32], horizontals[38], verticals[37], verticals[38]});
        blocks.put(squares[33], new View[]{horizontals[33], horizontals[39], verticals[38], verticals[39]});
        blocks.put(squares[34], new View[]{horizontals[34], horizontals[40], verticals[39], verticals[40]});
        blocks.put(squares[35], new View[]{horizontals[35], horizontals[41], verticals[40], verticals[41]});




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
    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void checkLines(View view) {

        //ADD A CHECK TO MAKE SURE THE PLAYER CAN'T CLICK ON AN ALREADY PRESSED LINE
        Log.e("Current Player at Top:", String.valueOf(current_player));

        //Check to make sure that it isn't already pressed - it's background is the board line
        if (view.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.board_line).getConstantState())) {

            //When a line is pressed
            //2 PLAYERS
            if (passedNumber.equals("2")) {
                //if Player 1 Pressed the Line
                if (current_player == 1) {
                    //set the view to the drawable
                    view.setBackgroundResource(R.drawable.clicked_line);
                    //set it to the color of the current player
                    view.setBackgroundColor(passedPlayer1Color);
                }

                //if Player 2 Pressed the Line
                if (current_player == 2) {
                    //set the view to the drawable
                    view.setBackgroundResource(R.drawable.clicked_line);
                    //set it to the color of the current player
                    view.setBackgroundColor(passedPlayer2Color);
                }
            }

            //3 PLAYERS
            if (passedNumber.equals("3")) {
                //if Player 1 Pressed the Line
                if (current_player == 1) {
                    //set the view to the drawable
                    view.setBackgroundResource(R.drawable.clicked_line);
                    //set it to the color of the current player
                    view.setBackgroundColor(passedPlayer1Color);
                }

                //if Player 2 Pressed the Line
                if (current_player == 2) {
                    //set the view to the drawable
                    view.setBackgroundResource(R.drawable.clicked_line);
                    //set it to the color of the current player
                    view.setBackgroundColor(passedPlayer2Color);
                }

                //if Player 3 Pressed the Line
                if (current_player == 3) {
                    //set the view to the drawable
                    view.setBackgroundResource(R.drawable.clicked_line);
                    //set it to the color of the current player
                    view.setBackgroundColor(passedPlayer3Color);
                }
            }

            //4 PLAYERS
            if (passedNumber.equals("4")) {
                //if Player 1 Pressed the Line
                if (current_player == 1) {
                    //set the view to the drawable
                    view.setBackgroundResource(R.drawable.clicked_line);
                    //set it to the color of the current player
                    view.setBackgroundColor(passedPlayer1Color);
                }

                //if Player 2 Pressed the Line
                if (current_player == 2) {
                    //set the view to the drawable
                    view.setBackgroundResource(R.drawable.clicked_line);
                    //set it to the color of the current player
                    view.setBackgroundColor(passedPlayer2Color);
                }

                //if Player 3 Pressed the Line
                if (current_player == 3) {
                    //set the view to the drawable
                    view.setBackgroundResource(R.drawable.clicked_line);
                    //set it to the color of the current player
                    view.setBackgroundColor(passedPlayer3Color);
                }

                //if Player 4 Pressed the Line
                if (current_player == 4) {
                    //set the view to the drawable
                    view.setBackgroundResource(R.drawable.clicked_line);
                    //set it to the color of the current player
                    view.setBackgroundColor(passedPlayer4Color);
                }
            }

            //int numFill = 0;
            boolean filled_square = false;
            for (Map.Entry block : blocks.entrySet()) {
                View[] sides = (View[]) block.getValue();
                for (View side : sides) {

                    // Check if the current side we are looking at is the one we clicked on
                    if (side == view) {

                        // This is the square we want to be in
                        int count = 0;
                        for (View temp : sides) {

                            if (!temp.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.board_line).getConstantState())) {
                                count++;
                            }

                            if (count == 4) {
                                //numFill++;
                                View current = (View) block.getKey();
                                Log.e("Current Player in Fill", String.valueOf(current_player));
                                Log.e("Current Color in Fill", String.valueOf(player_colors[current_player - 1]));
                                current.setBackgroundColor(player_colors[current_player - 1]);
                                scores[current_player - 1]++;
                                player_scores[current_player - 1].setText(String.valueOf(scores[current_player - 1]));
                                filled_square = true;
                                filled_boxes++;
                            }
                        }
                    }
                }
            }

            scoreBox[current_player - 1].setVisibility(View.GONE);

            //For changing player after they make a box
            // increment for double fill for line color change
//        if(numFill == 2) {
//            current_player++;
//            Log.e("CurrentPlayer++ Double", String.valueOf(current_player));
//        }
//
//        //increment for single fill for line color change
//        if (numFill == 1 && filled_square) {
//            current_player++;
//            Log.e("CurrentPlayer++ Filled", String.valueOf(current_player));
//        }

            //increment if no squares have been filled in yet
            if (!filled_square) {
                current_player++;
                Log.e("CurrentPlayer++ !Filled", String.valueOf(current_player));
            }

            if (current_player > num_players)
                current_player = 1;

            //Change the current player display
            currentPlayerDisplay.setText(player_names[current_player - 1]);
            currentPlayerDisplayLine.setBackgroundColor(player_colors[current_player - 1]);
            scoreBox[current_player - 1].setVisibility(View.VISIBLE);


            //Once the board is filled:
            if (filled_boxes == 36) {

                int maxScore = -1;
                int maxScoreIndex = 0;
                boolean tie = false;
                boolean firstTie = true;
                ArrayList<Integer> tieScoreIndexes = new ArrayList<Integer>();
                ArrayList<Integer> tieColors = new ArrayList<Integer>();

                Intent intent = new Intent(Board_6x6.this, winnerPage.class);

                //find who has the highest score -- loop through the scores array
                for (int i = 0; i < scores.length; i++) {

                    //add a check for a tie
                    if (scores[i] == maxScore){
                        tie = true;
                        Log.e("myTag", "THERE IS A TIE");
                        //if it is the first time the same number is founs
                        if (firstTie) {
                            //add both the users indexes
                            tieScoreIndexes.add(maxScoreIndex);
                            tieScoreIndexes.add(i);
                            firstTie = false;
                        }
                        else {
                            //just add the current tie index
                            tieScoreIndexes.add(i);
                        }
                    }

                    //if there is a new highest score
                    if (scores[i] > maxScore) {
                        maxScore = scores[i];
                        maxScoreIndex = i;
                    }
                }

                Log.e("Highest Score", String.valueOf(maxScore));
                Log.e("Highest Score Index", String.valueOf(maxScoreIndex));

                //Get the winner's and color name
                //if there was a tie
                if (tie) {
                    String winnerName = "";
                    int winnerColor = 0;

                    for (int j = 0; j < tieScoreIndexes.size() ; j++) {

                        Log.e("MyTag", "Tie score array size is " + tieScoreIndexes.size());
                        int tieIndex = tieScoreIndexes.get(j);
                        String playerName = (String) player_names[tieIndex];

                        //2 way tie name formatting
                        if (tieScoreIndexes.size() == 2) {
                            if (j == 0) {
                                winnerName = playerName;
                            }
                            if (j == 1) {
                                winnerName = winnerName + " and " + playerName;
                            }
                        }

                        //3 way tie name formatting
                        if (tieScoreIndexes.size() == 3) {
                            if (j == 0) {
                                winnerName = playerName;
                            }
                            if (j == 1) {
                                winnerName = winnerName + ", " + playerName;
                            }
                            if (j == 2) {
                                winnerName = winnerName + " and " + playerName;
                            }
                        }

                        //4 way tie name formatting
                        if (tieScoreIndexes.size() == 4) {
                            if (j == 0) {
                                winnerName = playerName;
                            }
                            if (j == 1 || j == 2) {
                                winnerName = winnerName + ", " + playerName;
                            }
                            if (j == 3) {
                                winnerName = winnerName + " and " + playerName;
                            }
                        }

                        winnerColor = player_colors[tieIndex];
                        tieColors.add(winnerColor);
                        Log.e("Winner's Color", String.valueOf(winnerColor));
                    }

                    Log.e("Winner's Name", winnerName.toString());
                    intent.putExtra("numWinners",  tieScoreIndexes.size());
                    intent.putExtra("winnersName", winnerName);

                    intent.putExtra("winnerTieColors", tieColors);
                }

                //if there is no tie
                else {

                    String winnerName = (String) player_names[maxScoreIndex];
                    Log.e("Winner's Name", winnerName);
                    intent.putExtra("numWinners",  1);
                    intent.putExtra("winnersName", winnerName);

                    //get the color of the winner
                    int winnerColor = player_colors[maxScoreIndex];
                    Log.e("Winner's Color", String.valueOf(winnerColor));
                    intent.putExtra("winnersColor", winnerColor);
                }

                //Get the winner's score
                int winnerScore = maxScore;
                Log.e("Winner's Score", String.valueOf(winnerScore));
                intent.putExtra("winnersScore", winnerScore);

                //add all player information if the users want to play another game with the same criteria
                if (passedNumber.equals("2")) {

                    intent.putExtra("playerNumber", passedNumber);
                    intent.putExtra("boardSize", "6 x 6");

                    //Player 1 Information
                    intent.putExtra("player1InputtedName", passedPlayer1Name);
                    intent.putExtra("sendPlayer1Color", passedPlayer1Color);

                    //Player 2
                    intent.putExtra("player2InputtedName", passedPlayer2Name);
                    intent.putExtra("sendPlayer2Color", passedPlayer2Color);
                }

                if (passedNumber.equals("3")) {

                    intent.putExtra("playerNumber", passedNumber);
                    intent.putExtra("boardSize", "6 x 6");

                    //Player 1 Information
                    intent.putExtra("player1InputtedName", passedPlayer1Name);
                    intent.putExtra("sendPlayer1Color", passedPlayer1Color);

                    //Player 2
                    intent.putExtra("player2InputtedName", passedPlayer2Name);
                    intent.putExtra("sendPlayer2Color", passedPlayer2Color);

                    //Player 3
                    intent.putExtra("player3InputtedName", passedPlayer3Name);
                    intent.putExtra("sendPlayer3Color", passedPlayer3Color);
                }

                if (passedNumber.equals("4")) {

                    intent.putExtra("playerNumber", passedNumber);
                    intent.putExtra("boardSize", "6 x 6");

                    //Player 1 Information
                    intent.putExtra("player1InputtedName", passedPlayer1Name);
                    intent.putExtra("sendPlayer1Color", passedPlayer1Color);

                    //Player 2
                    intent.putExtra("player2InputtedName", passedPlayer2Name);
                    intent.putExtra("sendPlayer2Color", passedPlayer2Color);

                    //Player 3
                    intent.putExtra("player3InputtedName", passedPlayer3Name);
                    intent.putExtra("sendPlayer3Color", passedPlayer3Color);

                    //Player 4
                    intent.putExtra("player4InputtedName", passedPlayer4Name);
                    intent.putExtra("sendPlayer4Color", passedPlayer4Color);
                }

                startActivity(intent);
            }
        }
    }
}

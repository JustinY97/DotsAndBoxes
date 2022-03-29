package com.justin.dotsandboxes;
import android.annotation.SuppressLint;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class GameSetUpPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText player1;
    EditText player2;
    EditText player3;
    EditText player4;
    String player1Input;
    String player2Input;
    String player3Input;
    String player4Input;
    View player1Color;
    int color1ID;
    View player2Color;
    int color2ID;
    View player3Color;
    View player4Color;

    ImageView home_button;
    ImageView help_button;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.game_setup);

        home_button = findViewById(R.id.home_button);
        help_button = findViewById(R.id.help_button);

        home_button.setOnClickListener(view -> {
            Intent intent = new Intent(GameSetUpPage.this, MainActivity.class);
            startActivity(intent);
        });

        help_button.setOnClickListener(view -> {
            Intent intent = new Intent(GameSetUpPage.this, Help.class);
            startActivity(intent);
        });

        //Board Size Drop Down
        Spinner boardSizeDropDown = findViewById(R.id.BoardSizeDropDown);
        ArrayAdapter<CharSequence> boardAdapter = ArrayAdapter.createFromResource(this, R.array.boardSize_list, android.R.layout.simple_spinner_item);
        boardAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boardSizeDropDown.setAdapter(boardAdapter);

        //Player Number Drop Down
        Spinner playerNumberDropDown = findViewById(R.id.playerNumberDropDown);
        ArrayAdapter<CharSequence> playerAdapter = ArrayAdapter.createFromResource(this, R.array.players_list, android.R.layout.simple_spinner_item);
        playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerNumberDropDown.setAdapter(playerAdapter);
        playerNumberDropDown.setOnItemSelectedListener(this);

        //get the colors
        player1Color = findViewById(R.id.Player1Color);
        color1ID = ((ColorDrawable) player1Color.getBackground()).getColor();

        player2Color = findViewById(R.id.player2Color);
        color2ID = ((ColorDrawable) player2Color.getBackground()).getColor();

        player3Color = findViewById(R.id.player3Color);
        ColorDrawable viewColor3 = (ColorDrawable) player3Color.getBackground();
        int color3ID = viewColor3.getColor();

        player4Color = findViewById(R.id.player4Color);
        ColorDrawable viewColor4 = (ColorDrawable) player4Color.getBackground();
        int color4ID = viewColor4.getColor();

        Button startGame = findViewById(R.id.startGameButton);

        startGame.setOnClickListener(view -> {

            Intent intent = new Intent(GameSetUpPage.this, Board_4x4.class);

            //get the board size
            String selectedBoard = boardSizeDropDown.getSelectedItem().toString();
            intent.putExtra("boardSize", selectedBoard);

            //get the number of players
            String selectedNumber = playerNumberDropDown.getSelectedItem().toString();
            intent.putExtra("playerNumber", selectedNumber);

            //get the names of the players
            if (selectedNumber.equals("2")) {
                //get the names of the 2 players
                player1Input = player1.getText().toString();
                intent.putExtra("player1InputtedName", player1Input);
                intent.putExtra("sendPlayer1Color", color1ID);
                player2Input = player2.getText().toString();
                intent.putExtra("player2InputtedName", player2Input);
                intent.putExtra("sendPlayer2Color", color2ID);
            }
            else if (selectedNumber.equals("3")) {
                //get the names of the 3 players
                player1Input = player1.getText().toString();
                intent.putExtra("player1InputtedName", player1Input);
                intent.putExtra("sendPlayer1Color", color1ID);
                player2Input = player2.getText().toString();
                intent.putExtra("player2InputtedName", player2Input);
                intent.putExtra("sendPlayer2Color", color2ID);
                player3Input = player3.getText().toString();
                intent.putExtra("player3InputtedName", player3Input);
                intent.putExtra("sendPlayer3Color", color3ID);
            }
            else {
                //get the names of the 4 players
                player1Input = player1.getText().toString();
                intent.putExtra("player1InputtedName", player1Input);
                intent.putExtra("sendPlayer1Color", color1ID);

                player2Input = player2.getText().toString();
                intent.putExtra("player2InputtedName", player2Input);
                intent.putExtra("sendPlayer2Color", color2ID);

                player3Input = player3.getText().toString();
                intent.putExtra("player3InputtedName", player3Input);
                intent.putExtra("sendPlayer3Color", color3ID);

                player4Input = player4.getText().toString();
                intent.putExtra("player4InputtedName", player4Input);
                intent.putExtra("sendPlayer4Color", color4ID);
            }

            //send the information and go to the game page
            startActivity(intent);
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String numberOfPlayers = parent.getItemAtPosition(position).toString();

        //Player Name Inputs
        player1 = findViewById(R.id.Player1Name);
        player1Color = findViewById(R.id.Player1Color);

        player2 = findViewById(R.id.Player2Name);
        player2Color = findViewById(R.id.player2Color);

        player3 = findViewById(R.id.Player3Name);
        View player3Underline = findViewById(R.id.Player3NameLine);
        player3Color = findViewById(R.id.player3Color);

        player4 = findViewById(R.id.Player4Name);
        View player4Underline = findViewById(R.id.Player4NameLine);
        player4Color = findViewById(R.id.player4Color);


        //Check to see how many players is currently selected
        if (numberOfPlayers.equals("2")) {
            //have the first two players visible
            player1.setVisibility(View.VISIBLE);
            player1Color.setVisibility(View.VISIBLE);
            player2.setVisibility(View.VISIBLE);
            player2Color.setVisibility(View.VISIBLE);
            //hide player 3 and 4
            player3.setVisibility(View.GONE);
            player3Underline.setVisibility(View.GONE);
            player3Color.setVisibility(View.GONE);
            player4.setVisibility(View.GONE);
            player4Underline.setVisibility(View.GONE);
            player4Color.setVisibility(View.GONE);
        }
        else if (numberOfPlayers.equals("3")) {
            //have the three players visible
            player1.setVisibility(View.VISIBLE);
            player1Color.setVisibility(View.VISIBLE);
            player2.setVisibility(View.VISIBLE);
            player2Color.setVisibility(View.VISIBLE);
            player3.setVisibility(View.VISIBLE);
            player3Underline.setVisibility(View.VISIBLE);
            player3Color.setVisibility(View.VISIBLE);
            //hide player 4
            player4.setVisibility(View.GONE);
            player4Underline.setVisibility(View.GONE);
            player4Color.setVisibility(View.GONE);
        }
        else {
            //have everything be visible
            player1.setVisibility(View.VISIBLE);
            player1Color.setVisibility(View.VISIBLE);
            player2.setVisibility(View.VISIBLE);
            player2Color.setVisibility(View.VISIBLE);
            player3.setVisibility(View.VISIBLE);
            player3Underline.setVisibility(View.VISIBLE);
            player3Color.setVisibility(View.VISIBLE);
            player4.setVisibility(View.VISIBLE);
            player4Underline.setVisibility(View.VISIBLE);
            player4Color.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

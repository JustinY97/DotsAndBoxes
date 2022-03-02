package com.justin.dotsandboxes;
import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
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

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_setup);

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

        Button startGame = findViewById(R.id.startGameButton);

        startGame.setOnClickListener(view -> {

            Intent intent = new Intent(GameSetUpPage.this, GameBoard.class);

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
                player2Input = player2.getText().toString();
                intent.putExtra("player2InputtedName", player2Input);
            }
            else if (selectedNumber.equals("3")) {
                //get the names of the 3 players
                player1Input = player1.getText().toString();
                intent.putExtra("player1InputtedName", player1Input);
                player2Input = player2.getText().toString();
                intent.putExtra("player2InputtedName", player2Input);
                player3Input = player3.getText().toString();
                intent.putExtra("player3InputtedName", player3Input);
            }
            else {
                //get the names of the 4 players
                player1Input = player1.getText().toString();
                intent.putExtra("player1InputtedName", player1Input);
                player2Input = player2.getText().toString();
                intent.putExtra("player2InputtedName", player2Input);
                player3Input = player3.getText().toString();
                intent.putExtra("player3InputtedName", player3Input);
                player4Input = player4.getText().toString();
                intent.putExtra("player4InputtedName", player4Input);
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
        View player1Color = findViewById(R.id.Player1Color);

        player2 = findViewById(R.id.Player2Name);
        View player2Color = findViewById(R.id.player2Color);

        player3 = findViewById(R.id.Player3Name);
        View player3Underline = findViewById(R.id.Player3NameLine);
        View player3Color = findViewById(R.id.player3Color);

        player4 = findViewById(R.id.Player4Name);
        View player4Underline = findViewById(R.id.Player4NameLine);
        View player4Color = findViewById(R.id.player4Color);


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

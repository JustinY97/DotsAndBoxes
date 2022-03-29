package com.justin.dotsandboxes;
import android.annotation.SuppressLint;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
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
import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;
import java.util.List;


public class GameSetUpPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Name Input Variables
    EditText player1;
    EditText player2;
    EditText player3;
    EditText player4;
    String player1Input;
    String player2Input;
    String player3Input;
    String player4Input;
    View player1Underline;
    View player2Underline;
    View player3Underline;
    View player4Underline;

    //Color Image Next to Name Variables
    View player1ColorFrame;
    AppCompatButton player1Color;
    int player1ColorId;
    String player1ColorHex = "";
    View player2ColorFrame;
    AppCompatButton player2Color;
    int player2ColorId;
    String player2ColorHex = "";
    View player3ColorFrame;
    AppCompatButton player3Color;
    int player3ColorId;
    String player3ColorHex = "";
    View player4ColorFrame;
    AppCompatButton player4Color;
    int player4ColorId;
    String player4ColorHex = "";

    //Player 1 Color Picker Variables
    View player1MainFrame;
    View player1RedFrame;
    AppCompatButton player1Red;
    View player1RedDisabled;

    View player1GreenFrame;
    AppCompatButton player1Green;
    View player1GreenDisabled;

    View player1DarkBlueFrame;
    AppCompatButton player1DarkBlue;
    View player1DarkBlueDisabled;

    View player1OrangeFrame;
    AppCompatButton player1Orange;
    View player1OrangeDisabled;

    View player1PurpleFrame;
    AppCompatButton player1Purple;
    View player1PurpleDisabled;

    View player1PinkFrame;
    AppCompatButton player1Pink;
    View player1PinkDisabled;

    //Player 2 Color Picker Variables
    View player2MainFrame;
    View player2RedFrame;
    AppCompatButton player2Red;
    View player2RedDisabled;

    View player2GreenFrame;
    AppCompatButton player2Green;
    View player2GreenDisabled;

    View player2DarkBlueFrame;
    AppCompatButton player2DarkBlue;
    View player2DarkBlueDisabled;

    View player2OrangeFrame;
    AppCompatButton player2Orange;
    View player2OrangeDisabled;

    View player2PurpleFrame;
    AppCompatButton player2Purple;
    View player2PurpleDisabled;

    View player2PinkFrame;
    AppCompatButton player2Pink;
    View player2PinkDisabled;
    boolean hideThree = false;

    //Player 3 Color Picker Variables
    View player3MainFrame;
    View player3RedFrame;
    AppCompatButton player3Red;
    View player3RedDisabled;
    
    View player3GreenFrame;
    AppCompatButton player3Green;
    View player3GreenDisabled;
    
    View player3DarkBlueFrame;
    AppCompatButton player3DarkBlue;
    View player3DarkBlueDisabled;
    
    View player3OrangeFrame;
    AppCompatButton player3Orange;
    View player3OrangeDisabled;
    
    View player3PurpleFrame;
    AppCompatButton player3Purple;
    View player3PurpleDisabled;
    
    View player3PinkFrame;
    AppCompatButton player3Pink;
    View player3PinkDisabled;
    boolean hideFour = false;

    //Player 4 Color Picker Variables
    View player4MainFrame;
    View player4RedFrame;
    AppCompatButton player4Red;
    View player4RedDisabled;
    
    View player4GreenFrame;
    AppCompatButton player4Green;
    View player4GreenDisabled;
    
    View player4DarkBlueFrame;
    AppCompatButton player4DarkBlue;
    View player4DarkBlueDisabled;
    
    View player4OrangeFrame;
    AppCompatButton player4Orange;
    View player4OrangeDisabled;
    
    View player4PurpleFrame;
    AppCompatButton player4Purple;
    View player4PurpleDisabled;
    
    View player4PinkFrame;
    AppCompatButton player4Pink;
    View player4PinkDisabled;
    boolean hideStart = false;

    //list to hold the chosen images
    ArrayList<String> playerColors = new ArrayList<String>();

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
            Intent intent = new Intent(GameSetUpPage.this, Pop.class);
            startActivity(intent);
        });

        help_button.setOnClickListener(view -> {
            Intent intent = new Intent(GameSetUpPage.this, Help.class);
            startActivity(intent);
        });

        //Board Size Drop Down
        Spinner boardSizeDropDown = findViewById(R.id.BoardSizeDropDown);
        ArrayAdapter<CharSequence> boardAdapter = ArrayAdapter.createFromResource(this, R.array.boardSize_list, R.layout.spinner_item);
        boardAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boardSizeDropDown.setAdapter(boardAdapter);

        //Player Number Drop Down
        Spinner playerNumberDropDown = findViewById(R.id.playerNumberDropDown);
        ArrayAdapter<CharSequence> playerAdapter = ArrayAdapter.createFromResource(this, R.array.players_list, R.layout.spinner_item);
        playerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerNumberDropDown.setAdapter(playerAdapter);
        playerNumberDropDown.setOnItemSelectedListener(this);

        //Start Game Button
        Button startGame = findViewById(R.id.startGameButton);

        //Players Name Fields
        player1 = findViewById(R.id.Player1Name);
        player1Underline = findViewById(R.id.Player1NameLine);
        player1ColorFrame = findViewById(R.id.Player1ColorFrame);

        player2 = findViewById(R.id.Player2Name);
        player2Underline = findViewById(R.id.Player2NameLine);
        player2ColorFrame = findViewById(R.id.Player2ColorFrame);

        player3 = findViewById(R.id.Player3Name);
        player3Underline = findViewById(R.id.Player3NameLine);
        player3ColorFrame = findViewById(R.id.Player3ColorFrame);

        player4 = findViewById(R.id.Player4Name);
        player4Underline = findViewById(R.id.Player4NameLine);
        player4ColorFrame = findViewById(R.id.Player4ColorFrame);

        /***********************
         * COLOR PICKER SECTION
         **********************/
        //Players colors
        player1Color = findViewById(R.id.Player1Color);
        player2Color = findViewById(R.id.Player2Color);
        player3Color = findViewById(R.id.Player3Color);
        player4Color = findViewById(R.id.Player4Color);


        /***********
         * Player 1
         **********/
        //get the color picker elements
        player1MainFrame = findViewById(R.id.Color_Picker_Main_Frame_Player1);
        player1MainFrame.getBackground().setAlpha(255);
        player1RedFrame = findViewById(R.id.Color_Picker_Red_Frame_Player1);
        player1Red = findViewById(R.id.ColorPickerRed_Player1);
        player1RedDisabled = findViewById(R.id.Disabled_ColorPickerRed_Player1);
        player1GreenFrame = findViewById(R.id.Color_Picker_Green_Frame_Player1);
        player1Green = findViewById(R.id.ColorPickerGreen_Player1);
        player1GreenDisabled = findViewById(R.id.Disabled_ColorPickerGreen_Player1);
        player1DarkBlueFrame = findViewById(R.id.Color_Picker_DarkBlue_Frame_Player1);
        player1DarkBlue = findViewById(R.id.ColorPickerDarkBlue_Player1);
        player1DarkBlueDisabled = findViewById(R.id.Disabled_ColorPickerDarkBlue_Player1);
        player1OrangeFrame = findViewById(R.id.Color_Picker_Orange_Frame_Player1);
        player1Orange = findViewById(R.id.ColorPickerOrange_Player1);
        player1OrangeDisabled = findViewById(R.id.Disabled_ColorPickerOrange_Player1);
        player1PurpleFrame = findViewById(R.id.Color_Picker_Purple_Frame_Player1);
        player1Purple = findViewById(R.id.ColorPickerPurple_Player1);
        player1PurpleDisabled = findViewById(R.id.Disabled_ColorPickerPurple_Player1);
        player1PinkFrame = findViewById(R.id.Color_Picker_Pink_Frame_Player1);
        player1Pink = findViewById(R.id.ColorPickerPink_Player1);
        player1PinkDisabled = findViewById(R.id.Disabled_ColorPickerPink_Player1);

        //Show Player 1 Color picker
        player1Color.setOnClickListener(view -> {
            //the color picker is open on their screen - the user wishes to close the color picker
            if (player1MainFrame.getVisibility() == View.VISIBLE) {

                //show the name inputs again
                player1.setVisibility(View.VISIBLE);
                player1Underline.setVisibility(View.VISIBLE);
                player2.setVisibility(View.VISIBLE);
                player2Underline.setVisibility(View.VISIBLE);

                //hide the color picker
                player1MainFrame.setVisibility(View.GONE);
                player1RedFrame.setVisibility(View.GONE);
                player1Red.setVisibility(View.GONE);
                player1RedDisabled.setVisibility(View.GONE);
                player1GreenFrame.setVisibility(View.GONE);
                player1Green.setVisibility(View.GONE);
                player1GreenDisabled.setVisibility(View.GONE);
                player1DarkBlueFrame.setVisibility(View.GONE);
                player1DarkBlue.setVisibility(View.GONE);
                player1DarkBlueDisabled.setVisibility(View.GONE);
                player1OrangeFrame.setVisibility(View.GONE);
                player1Orange.setVisibility(View.GONE);
                player1OrangeDisabled.setVisibility(View.GONE);
                player1PurpleFrame.setVisibility(View.GONE);
                player1Purple.setVisibility(View.GONE);
                player1PurpleDisabled.setVisibility(View.GONE);
                player1PinkFrame.setVisibility(View.GONE);
                player1Pink.setVisibility(View.GONE);
                player1PinkDisabled.setVisibility(View.GONE);
            }

            //if the color picker is not on their screen - the user wants to pick a color
            else {

                //check to see if any other color picker is currently open
                //if Player 2 color picker is open
                if (player2MainFrame.getVisibility() == View.VISIBLE) {
                    //make player 2's color picker invisible
                    player2MainFrame.setVisibility(View.GONE);
                    player2RedFrame.setVisibility(View.GONE);
                    player2Red.setVisibility(View.GONE);
                    player2RedDisabled.setVisibility(View.GONE);
                    player2GreenFrame.setVisibility(View.GONE);
                    player2Green.setVisibility(View.GONE);
                    player2GreenDisabled.setVisibility(View.GONE);
                    player2DarkBlueFrame.setVisibility(View.GONE);
                    player2DarkBlue.setVisibility(View.GONE);
                    player2DarkBlueDisabled.setVisibility(View.GONE);
                    player2OrangeFrame.setVisibility(View.GONE);
                    player2Orange.setVisibility(View.GONE);
                    player2OrangeDisabled.setVisibility(View.GONE);
                    player2PurpleFrame.setVisibility(View.GONE);
                    player2Purple.setVisibility(View.GONE);
                    player2PurpleDisabled.setVisibility(View.GONE);
                    player2PinkFrame.setVisibility(View.GONE);
                    player2Pink.setVisibility(View.GONE);
                    player2PinkDisabled.setVisibility(View.GONE);

                    //show the name inputs again
                    player2.setVisibility(View.VISIBLE);
                    player2Underline.setVisibility(View.VISIBLE);
                    if (hideThree) {
                        player3.setVisibility(View.VISIBLE);
                        player3Underline.setVisibility(View.VISIBLE);
                    }
                }
                //if Player 3 color picker is open
                if (player3MainFrame.getVisibility() == View.VISIBLE) {
                    //make player 3's color picker invisible
                    player3MainFrame.setVisibility(View.GONE);
                    player3RedFrame.setVisibility(View.GONE);
                    player3Red.setVisibility(View.GONE);
                    player3RedDisabled.setVisibility(View.GONE);
                    player3GreenFrame.setVisibility(View.GONE);
                    player3Green.setVisibility(View.GONE);
                    player3GreenDisabled.setVisibility(View.GONE);
                    player3DarkBlueFrame.setVisibility(View.GONE);
                    player3DarkBlue.setVisibility(View.GONE);
                    player3DarkBlueDisabled.setVisibility(View.GONE);
                    player3OrangeFrame.setVisibility(View.GONE);
                    player3Orange.setVisibility(View.GONE);
                    player3OrangeDisabled.setVisibility(View.GONE);
                    player3PurpleFrame.setVisibility(View.GONE);
                    player3Purple.setVisibility(View.GONE);
                    player3PurpleDisabled.setVisibility(View.GONE);
                    player3PinkFrame.setVisibility(View.GONE);
                    player3Pink.setVisibility(View.GONE);
                    player3PinkDisabled.setVisibility(View.GONE);

                    //show the name inputs again
                    player3.setVisibility(View.VISIBLE);
                    player3Underline.setVisibility(View.VISIBLE);
                    if (hideFour) {
                        player4.setVisibility(View.VISIBLE);
                        player4Underline.setVisibility(View.VISIBLE);
                    }
                }
                //if Player 4 color picker is open
                if (player4MainFrame.getVisibility() == View.VISIBLE) {
                    //make player 4's color picker invisible
                    player4MainFrame.setVisibility(View.GONE);
                    player4RedFrame.setVisibility(View.GONE);
                    player4Red.setVisibility(View.GONE);
                    player4RedDisabled.setVisibility(View.GONE);
                    player4GreenFrame.setVisibility(View.GONE);
                    player4Green.setVisibility(View.GONE);
                    player4GreenDisabled.setVisibility(View.GONE);
                    player4DarkBlueFrame.setVisibility(View.GONE);
                    player4DarkBlue.setVisibility(View.GONE);
                    player4DarkBlueDisabled.setVisibility(View.GONE);
                    player4OrangeFrame.setVisibility(View.GONE);
                    player4Orange.setVisibility(View.GONE);
                    player4OrangeDisabled.setVisibility(View.GONE);
                    player4PurpleFrame.setVisibility(View.GONE);
                    player4Purple.setVisibility(View.GONE);
                    player4PurpleDisabled.setVisibility(View.GONE);
                    player4PinkFrame.setVisibility(View.GONE);
                    player4Pink.setVisibility(View.GONE);
                    player4PinkDisabled.setVisibility(View.GONE);

                    //show the name inputs again
                    player4.setVisibility(View.VISIBLE);
                    player4Underline.setVisibility(View.VISIBLE);
                    if (hideStart) {
                        startGame.setVisibility(View.VISIBLE);
                    }
                }

                //hide the first 2 name inputs
                player1.setVisibility(View.GONE);
                player1Underline.setVisibility(View.GONE);
                player2.setVisibility(View.GONE);
                player2Underline.setVisibility(View.GONE);

                //show the color picker
                player1MainFrame.setVisibility(View.VISIBLE);
                player1RedFrame.setVisibility(View.VISIBLE);
                player1Red.setVisibility(View.VISIBLE);
                player1GreenFrame.setVisibility(View.VISIBLE);
                player1Green.setVisibility(View.VISIBLE);
                player1DarkBlueFrame.setVisibility(View.VISIBLE);
                player1DarkBlue.setVisibility(View.VISIBLE);
                player1OrangeFrame.setVisibility(View.VISIBLE);
                player1Orange.setVisibility(View.VISIBLE);
                player1PurpleFrame.setVisibility(View.VISIBLE);
                player1Purple.setVisibility(View.VISIBLE);
                player1PinkFrame.setVisibility(View.VISIBLE);
                player1Pink.setVisibility(View.VISIBLE);

                //reset the color picker values
                player1Red.setEnabled(true);
                player1RedDisabled.setVisibility(View.GONE);
                player1Green.setEnabled(true);
                player1GreenDisabled.setVisibility(View.GONE);
                player1DarkBlue.setEnabled(true);
                player1DarkBlueDisabled.setVisibility(View.GONE);
                player1Orange.setEnabled(true);
                player1OrangeDisabled.setVisibility(View.GONE);
                player1Purple.setEnabled(true);
                player1PurpleDisabled.setVisibility(View.GONE);
                player1Pink.setEnabled(true);
                player1PinkDisabled.setVisibility(View.GONE);

                //check if another player is using any color - if they are disable the corresponding colored button
                if (!player2ColorHex.equals("")) {
                    //if Player 2 is using RED
                    if(player2ColorHex.equals("#EA0000")) {
                        //disable the red
                        Log.e("MyTag", "Player 2 is using RED");
                        player1Red.setEnabled(false);
                        player1Red.setVisibility(View.GONE);
                        player1RedDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using GREEN
                    if(player2ColorHex.equals("#0ECC15")) {
                        //disable the green
                        Log.e("MyTag", "Player 2 is using GREEN");
                        player1Green.setEnabled(false);
                        player1Green.setVisibility(View.GONE);
                        player1GreenDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using DARK BLUE
                    if(player2ColorHex.equals("#0009EA")) {
                        //disable the dark blue
                        Log.e("MyTag", "Player 2 is using DARK BLUE");
                        player1DarkBlue.setEnabled(false);
                        player1DarkBlue.setVisibility(View.GONE);
                        player1DarkBlueDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using ORANGE
                    if(player2ColorHex.equals("#EA8C00")) {
                        //disable the orange
                        Log.e("MyTag", "Player 2 is using ORANGE");
                        player1Orange.setEnabled(false);
                        player1Orange.setVisibility(View.GONE);
                        player1OrangeDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using PURPLE
                    if(player2ColorHex.equals("#BA2CEC")) {
                        //disable the purple
                        Log.e("MyTag", "Player 2 is using PURPLE");
                        player1Purple.setEnabled(false);
                        player1Purple.setVisibility(View.GONE);
                        player1PurpleDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using PINK
                    if(player2ColorHex.equals("#F137DF")) {
                        //disable the pink
                        Log.e("MyTag", "Player 2 is using PINK");
                        player1Pink.setEnabled(false);
                        player1Pink.setVisibility(View.GONE);
                        player1PinkDisabled.setVisibility(View.VISIBLE);
                    }
                }

                if (!player3ColorHex.equals("")) {
                    //if Player 3 is using RED
                    if(player3ColorHex.equals("#EA0000")) {
                        //disable the red
                        Log.e("MyTag", "Player 3 is using RED");
                        player1Red.setEnabled(false);
                        player1Red.setVisibility(View.GONE);
                        player1RedDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using GREEN
                    if(player3ColorHex.equals("#0ECC15")) {
                        //disable the green
                        Log.e("MyTag", "Player 3 is using GREEN");
                        player1Green.setEnabled(false);
                        player1Green.setVisibility(View.GONE);
                        player1GreenDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using DARK BLUE
                    if(player3ColorHex.equals("#0009EA")) {
                        //disable the dark blue
                        Log.e("MyTag", "Player 3 is using DARK BLUE");
                        player1DarkBlue.setEnabled(false);
                        player1DarkBlue.setVisibility(View.GONE);
                        player1DarkBlueDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using ORANGE
                    if(player3ColorHex.equals("#EA8C00")) {
                        //disable the orange
                        Log.e("MyTag", "Player 3 is using ORANGE");
                        player1Orange.setEnabled(false);
                        player1Orange.setVisibility(View.GONE);
                        player1OrangeDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using PURPLE
                    if(player3ColorHex.equals("#BA2CEC")) {
                        //disable the purple
                        Log.e("MyTag", "Player 3 is using PURPLE");
                        player1Purple.setEnabled(false);
                        player1Purple.setVisibility(View.GONE);
                        player1PurpleDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using PINK
                    if(player3ColorHex.equals("#F137DF")) {
                        //disable the pink
                        Log.e("MyTag", "Player 3 is using PINK");
                        player1Pink.setEnabled(false);
                        player1Pink.setVisibility(View.GONE);
                        player1PinkDisabled.setVisibility(View.VISIBLE);
                    }
                }

                if (!player4ColorHex.equals("")) {
                    //if Player 4 is using RED
                    if(player4ColorHex.equals("#EA0000")) {
                        //disable the red
                        Log.e("MyTag", "Player 4 is using RED");
                        player1Red.setEnabled(false);
                        player1Red.setVisibility(View.GONE);
                        player1RedDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using GREEN
                    if(player4ColorHex.equals("#0ECC15")) {
                        //disable the green
                        Log.e("MyTag", "Player 4 is using GREEN");
                        player1Green.setEnabled(false);
                        player1Green.setVisibility(View.GONE);
                        player1GreenDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using DARK BLUE
                    if(player4ColorHex.equals("#0009EA")) {
                        //disable the dark blue
                        Log.e("MyTag", "Player 4 is using DARK BLUE");
                        player1DarkBlue.setEnabled(false);
                        player1DarkBlue.setVisibility(View.GONE);
                        player1DarkBlueDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using ORANGE
                    if(player4ColorHex.equals("#EA8C00")) {
                        //disable the orange
                        Log.e("MyTag", "Player 4 is using ORANGE");
                        player1Orange.setEnabled(false);
                        player1Orange.setVisibility(View.GONE);
                        player1OrangeDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using PURPLE
                    if(player4ColorHex.equals("#BA2CEC")) {
                        //disable the purple
                        Log.e("MyTag", "Player 4 is using PURPLE");
                        player1Purple.setEnabled(false);
                        player1Purple.setVisibility(View.GONE);
                        player1PurpleDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using PINK
                    if(player4ColorHex.equals("#F137DF")) {
                        //disable the pink
                        Log.e("MyTag", "Player 4 is using PINK");
                        player1Pink.setEnabled(false);
                        player1Pink.setVisibility(View.GONE);
                        player1PinkDisabled.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        //Color Check Time:
        //If Player 1 Chooses Red
        player1Red.setOnClickListener(view -> {
            //set the players color to red
            player1Color.setBackgroundColor(Color.parseColor("#EA0000"));
            player1ColorId = Color.parseColor("#EA0000");
            player1ColorHex = "#EA0000";

            //make the color picker invisible again
            player1MainFrame.setVisibility(View.GONE);
            player1RedFrame.setVisibility(View.GONE);
            player1Red.setVisibility(View.GONE);
            player1RedDisabled.setVisibility(View.GONE);
            player1GreenFrame.setVisibility(View.GONE);
            player1Green.setVisibility(View.GONE);
            player1GreenDisabled.setVisibility(View.GONE);
            player1DarkBlueFrame.setVisibility(View.GONE);
            player1DarkBlue.setVisibility(View.GONE);
            player1DarkBlueDisabled.setVisibility(View.GONE);
            player1OrangeFrame.setVisibility(View.GONE);
            player1Orange.setVisibility(View.GONE);
            player1OrangeDisabled.setVisibility(View.GONE);
            player1PurpleFrame.setVisibility(View.GONE);
            player1Purple.setVisibility(View.GONE);
            player1PurpleDisabled.setVisibility(View.GONE);
            player1PinkFrame.setVisibility(View.GONE);
            player1Pink.setVisibility(View.GONE);
            player1PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player1.setVisibility(View.VISIBLE);
            player1Underline.setVisibility(View.VISIBLE);
            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
        });

        //If Player 1 Chooses Green
        player1Green.setOnClickListener(view -> {
            //set the players color to green
            player1Color.setBackgroundColor(Color.parseColor("#0ECC15"));
            player1ColorId = Color.parseColor("#0ECC15");
            player1ColorHex = "#0ECC15";

            //make the color picker invisible again
            player1MainFrame.setVisibility(View.GONE);
            player1RedFrame.setVisibility(View.GONE);
            player1Red.setVisibility(View.GONE);
            player1RedDisabled.setVisibility(View.GONE);
            player1GreenFrame.setVisibility(View.GONE);
            player1Green.setVisibility(View.GONE);
            player1GreenDisabled.setVisibility(View.GONE);
            player1DarkBlueFrame.setVisibility(View.GONE);
            player1DarkBlue.setVisibility(View.GONE);
            player1DarkBlueDisabled.setVisibility(View.GONE);
            player1OrangeFrame.setVisibility(View.GONE);
            player1Orange.setVisibility(View.GONE);
            player1OrangeDisabled.setVisibility(View.GONE);
            player1PurpleFrame.setVisibility(View.GONE);
            player1Purple.setVisibility(View.GONE);
            player1PurpleDisabled.setVisibility(View.GONE);
            player1PinkFrame.setVisibility(View.GONE);
            player1Pink.setVisibility(View.GONE);
            player1PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player1.setVisibility(View.VISIBLE);
            player1Underline.setVisibility(View.VISIBLE);
            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
        });

        //If Player 1 Chooses Dark Blue
        player1DarkBlue.setOnClickListener(view -> {
            //set the players color to dark blue
            player1Color.setBackgroundColor(Color.parseColor("#0009EA"));
            player1ColorId = Color.parseColor("#0009EA");
            player1ColorHex = "#0009EA";

            //make the color picker invisible again
            player1MainFrame.setVisibility(View.GONE);
            player1RedFrame.setVisibility(View.GONE);
            player1Red.setVisibility(View.GONE);
            player1RedDisabled.setVisibility(View.GONE);
            player1GreenFrame.setVisibility(View.GONE);
            player1Green.setVisibility(View.GONE);
            player1GreenDisabled.setVisibility(View.GONE);
            player1DarkBlueFrame.setVisibility(View.GONE);
            player1DarkBlue.setVisibility(View.GONE);
            player1DarkBlueDisabled.setVisibility(View.GONE);
            player1OrangeFrame.setVisibility(View.GONE);
            player1Orange.setVisibility(View.GONE);
            player1OrangeDisabled.setVisibility(View.GONE);
            player1PurpleFrame.setVisibility(View.GONE);
            player1Purple.setVisibility(View.GONE);
            player1PurpleDisabled.setVisibility(View.GONE);
            player1PinkFrame.setVisibility(View.GONE);
            player1Pink.setVisibility(View.GONE);
            player1PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player1.setVisibility(View.VISIBLE);
            player1Underline.setVisibility(View.VISIBLE);
            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
        });

        //If Player 1 Chooses Orange
        player1Orange.setOnClickListener(view -> {
            //set the players color to orange
            player1Color.setBackgroundColor(Color.parseColor("#EA8C00"));
            player1ColorId = Color.parseColor("#EA8C00");
            player1ColorHex = "#EA8C00";

            //make the color picker invisible again
            player1MainFrame.setVisibility(View.GONE);
            player1RedFrame.setVisibility(View.GONE);
            player1Red.setVisibility(View.GONE);
            player1RedDisabled.setVisibility(View.GONE);
            player1GreenFrame.setVisibility(View.GONE);
            player1Green.setVisibility(View.GONE);
            player1GreenDisabled.setVisibility(View.GONE);
            player1DarkBlueFrame.setVisibility(View.GONE);
            player1DarkBlue.setVisibility(View.GONE);
            player1DarkBlueDisabled.setVisibility(View.GONE);
            player1OrangeFrame.setVisibility(View.GONE);
            player1Orange.setVisibility(View.GONE);
            player1OrangeDisabled.setVisibility(View.GONE);
            player1PurpleFrame.setVisibility(View.GONE);
            player1Purple.setVisibility(View.GONE);
            player1PurpleDisabled.setVisibility(View.GONE);
            player1PinkFrame.setVisibility(View.GONE);
            player1Pink.setVisibility(View.GONE);
            player1PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player1.setVisibility(View.VISIBLE);
            player1Underline.setVisibility(View.VISIBLE);
            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
        });

        //If Player 1 Chooses Purple
        player1Purple.setOnClickListener(view -> {
            //set the players color to purple
            player1Color.setBackgroundColor(Color.parseColor("#BA2CEC"));
            player1ColorId = Color.parseColor("#BA2CEC");
            player1ColorHex = "#BA2CEC";

            //make the color picker invisible again
            player1MainFrame.setVisibility(View.GONE);
            player1RedFrame.setVisibility(View.GONE);
            player1Red.setVisibility(View.GONE);
            player1RedDisabled.setVisibility(View.GONE);
            player1GreenFrame.setVisibility(View.GONE);
            player1Green.setVisibility(View.GONE);
            player1GreenDisabled.setVisibility(View.GONE);
            player1DarkBlueFrame.setVisibility(View.GONE);
            player1DarkBlue.setVisibility(View.GONE);
            player1DarkBlueDisabled.setVisibility(View.GONE);
            player1OrangeFrame.setVisibility(View.GONE);
            player1Orange.setVisibility(View.GONE);
            player1OrangeDisabled.setVisibility(View.GONE);
            player1PurpleFrame.setVisibility(View.GONE);
            player1Purple.setVisibility(View.GONE);
            player1PurpleDisabled.setVisibility(View.GONE);
            player1PinkFrame.setVisibility(View.GONE);
            player1Pink.setVisibility(View.GONE);
            player1PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player1.setVisibility(View.VISIBLE);
            player1Underline.setVisibility(View.VISIBLE);
            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
        });

        //If Player 1 Chooses Pink
        player1Pink.setOnClickListener(view -> {
           //set the players color to pink
           player1Color.setBackgroundColor(Color.parseColor("#F137DF"));
           player1ColorId = Color.parseColor("#F137DF");
            player1ColorHex = "#F137DF";

           //make the color picker invisible again
            player1MainFrame.setVisibility(View.GONE);
            player1RedFrame.setVisibility(View.GONE);
            player1Red.setVisibility(View.GONE);
            player1RedDisabled.setVisibility(View.GONE);
            player1GreenFrame.setVisibility(View.GONE);
            player1Green.setVisibility(View.GONE);
            player1GreenDisabled.setVisibility(View.GONE);
            player1DarkBlueFrame.setVisibility(View.GONE);
            player1DarkBlue.setVisibility(View.GONE);
            player1DarkBlueDisabled.setVisibility(View.GONE);
            player1OrangeFrame.setVisibility(View.GONE);
            player1Orange.setVisibility(View.GONE);
            player1OrangeDisabled.setVisibility(View.GONE);
            player1PurpleFrame.setVisibility(View.GONE);
            player1Purple.setVisibility(View.GONE);
            player1PurpleDisabled.setVisibility(View.GONE);
            player1PinkFrame.setVisibility(View.GONE);
            player1Pink.setVisibility(View.GONE);
            player1PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player1.setVisibility(View.VISIBLE);
            player1Underline.setVisibility(View.VISIBLE);
            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
        });


        /***********
         * Player 2
         **********/
        //get the color picker elements
        player2MainFrame = findViewById(R.id.Color_Picker_Main_Frame_Player2);
        player2MainFrame.getBackground().setAlpha(255);
        player2RedFrame = findViewById(R.id.Color_Picker_Red_Frame_Player2);
        player2Red = findViewById(R.id.ColorPickerRed_Player2);
        player2RedDisabled = findViewById(R.id.Disabled_ColorPickerRed_Player2);
        player2GreenFrame = findViewById(R.id.Color_Picker_Green_Frame_Player2);
        player2Green = findViewById(R.id.ColorPickerGreen_Player2);
        player2GreenDisabled = findViewById(R.id.Disabled_ColorPickerGreen_Player2);
        player2DarkBlueFrame = findViewById(R.id.Color_Picker_DarkBlue_Frame_Player2);
        player2DarkBlue = findViewById(R.id.ColorPickerDarkBlue_Player2);
        player2DarkBlueDisabled = findViewById(R.id.Disabled_ColorPickerDarkBlue_Player2);
        player2OrangeFrame = findViewById(R.id.Color_Picker_Orange_Frame_Player2);
        player2Orange = findViewById(R.id.ColorPickerOrange_Player2);
        player2OrangeDisabled = findViewById(R.id.Disabled_ColorPickerOrange_Player2);
        player2PurpleFrame = findViewById(R.id.Color_Picker_Purple_Frame_Player2);
        player2Purple = findViewById(R.id.ColorPickerPurple_Player2);
        player2PurpleDisabled = findViewById(R.id.Disabled_ColorPickerPurple_Player2);
        player2PinkFrame = findViewById(R.id.Color_Picker_Pink_Frame_Player2);
        player2Pink = findViewById(R.id.ColorPickerPink_Player2);
        player2PinkDisabled = findViewById(R.id.Disabled_ColorPickerPink_Player2);

        //Show Player 2 Color picker
        player2Color.setOnClickListener(view -> {
            //the color picker is open on their screen - the user wishes to close the color picker
            if (player2MainFrame.getVisibility() == View.VISIBLE) {

                //show the name inputs again
                player2.setVisibility(View.VISIBLE);
                player2Underline.setVisibility(View.VISIBLE);
                if (hideThree) {
                    player3.setVisibility(View.VISIBLE);
                    player3Underline.setVisibility(View.VISIBLE);
                }

                //hide the color picker
                player2MainFrame.setVisibility(View.GONE);
                player2RedFrame.setVisibility(View.GONE);
                player2Red.setVisibility(View.GONE);
                player2RedDisabled.setVisibility(View.GONE);
                player2GreenFrame.setVisibility(View.GONE);
                player2Green.setVisibility(View.GONE);
                player2GreenDisabled.setVisibility(View.GONE);
                player2DarkBlueFrame.setVisibility(View.GONE);
                player2DarkBlue.setVisibility(View.GONE);
                player2DarkBlueDisabled.setVisibility(View.GONE);
                player2OrangeFrame.setVisibility(View.GONE);
                player2Orange.setVisibility(View.GONE);
                player2OrangeDisabled.setVisibility(View.GONE);
                player2PurpleFrame.setVisibility(View.GONE);
                player2Purple.setVisibility(View.GONE);
                player2PurpleDisabled.setVisibility(View.GONE);
                player2PinkFrame.setVisibility(View.GONE);
                player2Pink.setVisibility(View.GONE);
                player2PinkDisabled.setVisibility(View.GONE);
            }

            //if the color picker is not on their screen - the user wants to pick a color
            else {

                //check to see if any other color picker is currently open
                //if Player 1 color picker is open
                if (player1MainFrame.getVisibility() == View.VISIBLE) {
                    //make player 1's color picker invisible
                    player1MainFrame.setVisibility(View.GONE);
                    player1RedFrame.setVisibility(View.GONE);
                    player1Red.setVisibility(View.GONE);
                    player1RedDisabled.setVisibility(View.GONE);
                    player1GreenFrame.setVisibility(View.GONE);
                    player1Green.setVisibility(View.GONE);
                    player1GreenDisabled.setVisibility(View.GONE);
                    player1DarkBlueFrame.setVisibility(View.GONE);
                    player1DarkBlue.setVisibility(View.GONE);
                    player1DarkBlueDisabled.setVisibility(View.GONE);
                    player1OrangeFrame.setVisibility(View.GONE);
                    player1Orange.setVisibility(View.GONE);
                    player1OrangeDisabled.setVisibility(View.GONE);
                    player1PurpleFrame.setVisibility(View.GONE);
                    player1Purple.setVisibility(View.GONE);
                    player1PurpleDisabled.setVisibility(View.GONE);
                    player1PinkFrame.setVisibility(View.GONE);
                    player1Pink.setVisibility(View.GONE);
                    player1PinkDisabled.setVisibility(View.GONE);

                    //show the name inputs again
                    player1.setVisibility(View.VISIBLE);
                    player1Underline.setVisibility(View.VISIBLE);
                    player2.setVisibility(View.VISIBLE);
                    player2Underline.setVisibility(View.VISIBLE);
                }
                //if Player 3 color picker is open
                if (player3MainFrame.getVisibility() == View.VISIBLE) {
                    //make player 3's color picker invisible
                    player3MainFrame.setVisibility(View.GONE);
                    player3RedFrame.setVisibility(View.GONE);
                    player3Red.setVisibility(View.GONE);
                    player3RedDisabled.setVisibility(View.GONE);
                    player3GreenFrame.setVisibility(View.GONE);
                    player3Green.setVisibility(View.GONE);
                    player3GreenDisabled.setVisibility(View.GONE);
                    player3DarkBlueFrame.setVisibility(View.GONE);
                    player3DarkBlue.setVisibility(View.GONE);
                    player3DarkBlueDisabled.setVisibility(View.GONE);
                    player3OrangeFrame.setVisibility(View.GONE);
                    player3Orange.setVisibility(View.GONE);
                    player3OrangeDisabled.setVisibility(View.GONE);
                    player3PurpleFrame.setVisibility(View.GONE);
                    player3Purple.setVisibility(View.GONE);
                    player3PurpleDisabled.setVisibility(View.GONE);
                    player3PinkFrame.setVisibility(View.GONE);
                    player3Pink.setVisibility(View.GONE);
                    player3PinkDisabled.setVisibility(View.GONE);

                    //show the name inputs again
                    player3.setVisibility(View.VISIBLE);
                    player3Underline.setVisibility(View.VISIBLE);
                    if (hideFour) {
                        player4.setVisibility(View.VISIBLE);
                        player4Underline.setVisibility(View.VISIBLE);
                    }
                }
                //if Player 4 color picker is open
                if (player4MainFrame.getVisibility() == View.VISIBLE) {
                    //make player 4's color picker invisible
                    player4MainFrame.setVisibility(View.GONE);
                    player4RedFrame.setVisibility(View.GONE);
                    player4Red.setVisibility(View.GONE);
                    player4RedDisabled.setVisibility(View.GONE);
                    player4GreenFrame.setVisibility(View.GONE);
                    player4Green.setVisibility(View.GONE);
                    player4GreenDisabled.setVisibility(View.GONE);
                    player4DarkBlueFrame.setVisibility(View.GONE);
                    player4DarkBlue.setVisibility(View.GONE);
                    player4DarkBlueDisabled.setVisibility(View.GONE);
                    player4OrangeFrame.setVisibility(View.GONE);
                    player4Orange.setVisibility(View.GONE);
                    player4OrangeDisabled.setVisibility(View.GONE);
                    player4PurpleFrame.setVisibility(View.GONE);
                    player4Purple.setVisibility(View.GONE);
                    player4PurpleDisabled.setVisibility(View.GONE);
                    player4PinkFrame.setVisibility(View.GONE);
                    player4Pink.setVisibility(View.GONE);
                    player4PinkDisabled.setVisibility(View.GONE);

                    //show the name inputs again
                    player4.setVisibility(View.VISIBLE);
                    player4Underline.setVisibility(View.VISIBLE);
                    if (hideStart) {
                        startGame.setVisibility(View.VISIBLE);
                    }
                }

                //hide the first 2 name inputs
                player2.setVisibility(View.GONE);
                player2Underline.setVisibility(View.GONE);
                if (hideThree) {
                    player3.setVisibility(View.GONE);
                    player3Underline.setVisibility(View.GONE);
                }

                //show the color picker
                player2MainFrame.setVisibility(View.VISIBLE);
                player2RedFrame.setVisibility(View.VISIBLE);
                player2Red.setVisibility(View.VISIBLE);
                player2GreenFrame.setVisibility(View.VISIBLE);
                player2Green.setVisibility(View.VISIBLE);
                player2DarkBlueFrame.setVisibility(View.VISIBLE);
                player2DarkBlue.setVisibility(View.VISIBLE);
                player2OrangeFrame.setVisibility(View.VISIBLE);
                player2Orange.setVisibility(View.VISIBLE);
                player2PurpleFrame.setVisibility(View.VISIBLE);
                player2Purple.setVisibility(View.VISIBLE);
                player2PinkFrame.setVisibility(View.VISIBLE);
                player2Pink.setVisibility(View.VISIBLE);

                //reset the color picker values
                player2Red.setEnabled(true);
                player2RedDisabled.setVisibility(View.GONE);
                player2Green.setEnabled(true);
                player2GreenDisabled.setVisibility(View.GONE);
                player2DarkBlue.setEnabled(true);
                player2DarkBlueDisabled.setVisibility(View.GONE);
                player2Orange.setEnabled(true);
                player2OrangeDisabled.setVisibility(View.GONE);
                player2Purple.setEnabled(true);
                player2PurpleDisabled.setVisibility(View.GONE);
                player2Pink.setEnabled(true);
                player2PinkDisabled.setVisibility(View.GONE);

                //check if another player is using any color - if they are disable the corresponding colored button
                if (!player1ColorHex.equals("")) {
                    //if Player 1 is using RED
                    if(player1ColorHex.equals("#EA0000")) {
                        //disable the red
                        Log.e("MyTag", "Player 1 is using RED");
                        player2Red.setEnabled(false);
                        player2Red.setVisibility(View.GONE);
                        player2RedDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using GREEN
                    if(player1ColorHex.equals("#0ECC15")) {
                        //disable the green
                        Log.e("MyTag", "Player 1 is using GREEN");
                        player2Green.setEnabled(false);
                        player2Green.setVisibility(View.GONE);
                        player2GreenDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using DARK BLUE
                    if(player1ColorHex.equals("#0009EA")) {
                        //disable the dark blue
                        Log.e("MyTag", "Player 1 is using DARK BLUE");
                        player2DarkBlue.setEnabled(false);
                        player2DarkBlue.setVisibility(View.GONE);
                        player2DarkBlueDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using ORANGE
                    if(player1ColorHex.equals("#EA8C00")) {
                        //disable the orange
                        Log.e("MyTag", "Player 1 is using ORANGE");
                        player2Orange.setEnabled(false);
                        player2Orange.setVisibility(View.GONE);
                        player2OrangeDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using PURPLE
                    if(player1ColorHex.equals("#BA2CEC")) {
                        //disable the purple
                        Log.e("MyTag", "Player 1 is using PURPLE");
                        player2Purple.setEnabled(false);
                        player2Purple.setVisibility(View.GONE);
                        player2PurpleDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using PINK
                    if(player1ColorHex.equals("#F137DF")) {
                        //disable the pink
                        Log.e("MyTag", "Player 1 is using PINK");
                        player2Pink.setEnabled(false);
                        player2Pink.setVisibility(View.GONE);
                        player2PinkDisabled.setVisibility(View.VISIBLE);
                    }
                }

                if (!player3ColorHex.equals("")) {
                    //if Player 3 is using RED
                    if(player3ColorHex.equals("#EA0000")) {
                        //disable the red
                        Log.e("MyTag", "Player 3 is using RED");
                        player2Red.setEnabled(false);
                        player2Red.setVisibility(View.GONE);
                        player2RedDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using GREEN
                    if(player3ColorHex.equals("#0ECC15")) {
                        //disable the green
                        Log.e("MyTag", "Player 3 is using GREEN");
                        player2Green.setEnabled(false);
                        player2Green.setVisibility(View.GONE);
                        player2GreenDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using DARK BLUE
                    if(player3ColorHex.equals("#0009EA")) {
                        //disable the dark blue
                        Log.e("MyTag", "Player 3 is using DARK BLUE");
                        player2DarkBlue.setEnabled(false);
                        player2DarkBlue.setVisibility(View.GONE);
                        player2DarkBlueDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using ORANGE
                    if(player3ColorHex.equals("#EA8C00")) {
                        //disable the orange
                        Log.e("MyTag", "Player 3 is using ORANGE");
                        player2Orange.setEnabled(false);
                        player2Orange.setVisibility(View.GONE);
                        player2OrangeDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using PURPLE
                    if(player3ColorHex.equals("#BA2CEC")) {
                        //disable the purple
                        Log.e("MyTag", "Player 3 is using PURPLE");
                        player2Purple.setEnabled(false);
                        player2Purple.setVisibility(View.GONE);
                        player2PurpleDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using PINK
                    if(player3ColorHex.equals("#F137DF")) {
                        //disable the pink
                        Log.e("MyTag", "Player 3 is using PINK");
                        player2Pink.setEnabled(false);
                        player2Pink.setVisibility(View.GONE);
                        player2PinkDisabled.setVisibility(View.VISIBLE);
                    }
                }

                if (!player4ColorHex.equals("")) {
                    //if Player 4 is using RED
                    if(player4ColorHex.equals("#EA0000")) {
                        //disable the red
                        Log.e("MyTag", "Player 4 is using RED");
                        player2Red.setEnabled(false);
                        player2Red.setVisibility(View.GONE);
                        player2RedDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using GREEN
                    if(player4ColorHex.equals("#0ECC15")) {
                        //disable the green
                        Log.e("MyTag", "Player 4 is using GREEN");
                        player2Green.setEnabled(false);
                        player2Green.setVisibility(View.GONE);
                        player2GreenDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using DARK BLUE
                    if(player4ColorHex.equals("#0009EA")) {
                        //disable the dark blue
                        Log.e("MyTag", "Player 4 is using DARK BLUE");
                        player2DarkBlue.setEnabled(false);
                        player2DarkBlue.setVisibility(View.GONE);
                        player2DarkBlueDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using ORANGE
                    if(player4ColorHex.equals("#EA8C00")) {
                        //disable the orange
                        Log.e("MyTag", "Player 4 is using ORANGE");
                        player2Orange.setEnabled(false);
                        player2Orange.setVisibility(View.GONE);
                        player2OrangeDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using PURPLE
                    if(player4ColorHex.equals("#BA2CEC")) {
                        //disable the purple
                        Log.e("MyTag", "Player 4 is using PURPLE");
                        player2Purple.setEnabled(false);
                        player2Purple.setVisibility(View.GONE);
                        player2PurpleDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using PINK
                    if(player4ColorHex.equals("#F137DF")) {
                        //disable the pink
                        Log.e("MyTag", "Player 4 is using PINK");
                        player2Pink.setEnabled(false);
                        player2Pink.setVisibility(View.GONE);
                        player2PinkDisabled.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        //Color Check Time:
        //If Player 2 Chooses Red
        player2Red.setOnClickListener(view -> {
            //set the players color to red
            player2Color.setBackgroundColor(Color.parseColor("#EA0000"));
            player2ColorId = Color.parseColor("#EA0000");
            player2ColorHex = "#EA0000";

            //make the color picker invisible again
            player2MainFrame.setVisibility(View.GONE);
            player2RedFrame.setVisibility(View.GONE);
            player2Red.setVisibility(View.GONE);
            player2RedDisabled.setVisibility(View.GONE);
            player2GreenFrame.setVisibility(View.GONE);
            player2Green.setVisibility(View.GONE);
            player2GreenDisabled.setVisibility(View.GONE);
            player2DarkBlueFrame.setVisibility(View.GONE);
            player2DarkBlue.setVisibility(View.GONE);
            player2DarkBlueDisabled.setVisibility(View.GONE);
            player2OrangeFrame.setVisibility(View.GONE);
            player2Orange.setVisibility(View.GONE);
            player2OrangeDisabled.setVisibility(View.GONE);
            player2PurpleFrame.setVisibility(View.GONE);
            player2Purple.setVisibility(View.GONE);
            player2PurpleDisabled.setVisibility(View.GONE);
            player2PinkFrame.setVisibility(View.GONE);
            player2Pink.setVisibility(View.GONE);
            player2PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
            if (hideThree) {
                player3.setVisibility(View.VISIBLE);
                player3Underline.setVisibility(View.VISIBLE);
            }
        });

        //If Player 2 Chooses Green
        player2Green.setOnClickListener(view -> {
            //set the players color to green
            player2Color.setBackgroundColor(Color.parseColor("#0ECC15"));
            player2ColorId = Color.parseColor("#0ECC15");
            player2ColorHex = "#0ECC15";

            //make the color picker invisible again
            player2MainFrame.setVisibility(View.GONE);
            player2RedFrame.setVisibility(View.GONE);
            player2Red.setVisibility(View.GONE);
            player2RedDisabled.setVisibility(View.GONE);
            player2GreenFrame.setVisibility(View.GONE);
            player2Green.setVisibility(View.GONE);
            player2GreenDisabled.setVisibility(View.GONE);
            player2DarkBlueFrame.setVisibility(View.GONE);
            player2DarkBlue.setVisibility(View.GONE);
            player2DarkBlueDisabled.setVisibility(View.GONE);
            player2OrangeFrame.setVisibility(View.GONE);
            player2Orange.setVisibility(View.GONE);
            player2OrangeDisabled.setVisibility(View.GONE);
            player2PurpleFrame.setVisibility(View.GONE);
            player2Purple.setVisibility(View.GONE);
            player2PurpleDisabled.setVisibility(View.GONE);
            player2PinkFrame.setVisibility(View.GONE);
            player2Pink.setVisibility(View.GONE);
            player2PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
            if (hideThree) {
                player3.setVisibility(View.VISIBLE);
                player3Underline.setVisibility(View.VISIBLE);
            }
        });

        //If Player 2 Chooses Dark Blue
        player2DarkBlue.setOnClickListener(view -> {
            //set the players color to dark blue
            player2Color.setBackgroundColor(Color.parseColor("#0009EA"));
            player2ColorId = Color.parseColor("#0009EA");
            player2ColorHex = "#0009EA";

            //make the color picker invisible again
            player2MainFrame.setVisibility(View.GONE);
            player2RedFrame.setVisibility(View.GONE);
            player2Red.setVisibility(View.GONE);
            player2RedDisabled.setVisibility(View.GONE);
            player2GreenFrame.setVisibility(View.GONE);
            player2Green.setVisibility(View.GONE);
            player2GreenDisabled.setVisibility(View.GONE);
            player2DarkBlueFrame.setVisibility(View.GONE);
            player2DarkBlue.setVisibility(View.GONE);
            player2DarkBlueDisabled.setVisibility(View.GONE);
            player2OrangeFrame.setVisibility(View.GONE);
            player2Orange.setVisibility(View.GONE);
            player2OrangeDisabled.setVisibility(View.GONE);
            player2PurpleFrame.setVisibility(View.GONE);
            player2Purple.setVisibility(View.GONE);
            player2PurpleDisabled.setVisibility(View.GONE);
            player2PinkFrame.setVisibility(View.GONE);
            player2Pink.setVisibility(View.GONE);
            player2PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
            if (hideThree) {
                player3.setVisibility(View.VISIBLE);
                player3Underline.setVisibility(View.VISIBLE);
            }
        });

        //If Player 2 Chooses Orange
        player2Orange.setOnClickListener(view -> {
            //set the players color to orange
            player2Color.setBackgroundColor(Color.parseColor("#EA8C00"));
            player2ColorId = Color.parseColor("#EA8C00");
            player2ColorHex = "#EA8C00";

            //make the color picker invisible again
            player2MainFrame.setVisibility(View.GONE);
            player2RedFrame.setVisibility(View.GONE);
            player2Red.setVisibility(View.GONE);
            player2RedDisabled.setVisibility(View.GONE);
            player2GreenFrame.setVisibility(View.GONE);
            player2Green.setVisibility(View.GONE);
            player2GreenDisabled.setVisibility(View.GONE);
            player2DarkBlueFrame.setVisibility(View.GONE);
            player2DarkBlue.setVisibility(View.GONE);
            player2DarkBlueDisabled.setVisibility(View.GONE);
            player2OrangeFrame.setVisibility(View.GONE);
            player2Orange.setVisibility(View.GONE);
            player2OrangeDisabled.setVisibility(View.GONE);
            player2PurpleFrame.setVisibility(View.GONE);
            player2Purple.setVisibility(View.GONE);
            player2PurpleDisabled.setVisibility(View.GONE);
            player2PinkFrame.setVisibility(View.GONE);
            player2Pink.setVisibility(View.GONE);
            player2PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
            if (hideThree) {
                player3.setVisibility(View.VISIBLE);
                player3Underline.setVisibility(View.VISIBLE);
            }
        });

        //If Player 2 Chooses Purple
        player2Purple.setOnClickListener(view -> {
            //set the players color to purple
            player2Color.setBackgroundColor(Color.parseColor("#BA2CEC"));
            player2ColorId = Color.parseColor("#BA2CEC");
            player2ColorHex = "#BA2CEC";

            //make the color picker invisible again
            player2MainFrame.setVisibility(View.GONE);
            player2RedFrame.setVisibility(View.GONE);
            player2Red.setVisibility(View.GONE);
            player2RedDisabled.setVisibility(View.GONE);
            player2GreenFrame.setVisibility(View.GONE);
            player2Green.setVisibility(View.GONE);
            player2GreenDisabled.setVisibility(View.GONE);
            player2DarkBlueFrame.setVisibility(View.GONE);
            player2DarkBlue.setVisibility(View.GONE);
            player2DarkBlueDisabled.setVisibility(View.GONE);
            player2OrangeFrame.setVisibility(View.GONE);
            player2Orange.setVisibility(View.GONE);
            player2OrangeDisabled.setVisibility(View.GONE);
            player2PurpleFrame.setVisibility(View.GONE);
            player2Purple.setVisibility(View.GONE);
            player2PurpleDisabled.setVisibility(View.GONE);
            player2PinkFrame.setVisibility(View.GONE);
            player2Pink.setVisibility(View.GONE);
            player2PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
            if (hideThree) {
                player3.setVisibility(View.VISIBLE);
                player3Underline.setVisibility(View.VISIBLE);
            }
        });

        //If Player 2 Chooses Pink
        player2Pink.setOnClickListener(view -> {
            //set the players color to pink
            player2Color.setBackgroundColor(Color.parseColor("#F137DF"));
            player2ColorId = Color.parseColor("#F137DF");
            player2ColorHex = "#F137DF";

            //make the color picker invisible again
            player2MainFrame.setVisibility(View.GONE);
            player2RedFrame.setVisibility(View.GONE);
            player2Red.setVisibility(View.GONE);
            player2RedDisabled.setVisibility(View.GONE);
            player2GreenFrame.setVisibility(View.GONE);
            player2Green.setVisibility(View.GONE);
            player2GreenDisabled.setVisibility(View.GONE);
            player2DarkBlueFrame.setVisibility(View.GONE);
            player2DarkBlue.setVisibility(View.GONE);
            player2DarkBlueDisabled.setVisibility(View.GONE);
            player2OrangeFrame.setVisibility(View.GONE);
            player2Orange.setVisibility(View.GONE);
            player2OrangeDisabled.setVisibility(View.GONE);
            player2PurpleFrame.setVisibility(View.GONE);
            player2Purple.setVisibility(View.GONE);
            player2PurpleDisabled.setVisibility(View.GONE);
            player2PinkFrame.setVisibility(View.GONE);
            player2Pink.setVisibility(View.GONE);
            player2PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
            if (hideThree) {
                player3.setVisibility(View.VISIBLE);
                player3Underline.setVisibility(View.VISIBLE);
            }
        });

        /***********
         * Player 3
         **********/
        //get the color picker elements
        player3MainFrame = findViewById(R.id.Color_Picker_Main_Frame_Player3);
        player3MainFrame.getBackground().setAlpha(255);
        player3RedFrame = findViewById(R.id.Color_Picker_Red_Frame_Player3);
        player3Red = findViewById(R.id.ColorPickerRed_Player3);
        player3RedDisabled = findViewById(R.id.Disabled_ColorPickerRed_Player3);
        player3GreenFrame = findViewById(R.id.Color_Picker_Green_Frame_Player3);
        player3Green = findViewById(R.id.ColorPickerGreen_Player3);
        player3GreenDisabled = findViewById(R.id.Disabled_ColorPickerGreen_Player3);
        player3DarkBlueFrame = findViewById(R.id.Color_Picker_DarkBlue_Frame_Player3);
        player3DarkBlue = findViewById(R.id.ColorPickerDarkBlue_Player3);
        player3DarkBlueDisabled = findViewById(R.id.Disabled_ColorPickerDarkBlue_Player3);
        player3OrangeFrame = findViewById(R.id.Color_Picker_Orange_Frame_Player3);
        player3Orange = findViewById(R.id.ColorPickerOrange_Player3);
        player3OrangeDisabled = findViewById(R.id.Disabled_ColorPickerOrange_Player3);
        player3PurpleFrame = findViewById(R.id.Color_Picker_Purple_Frame_Player3);
        player3Purple = findViewById(R.id.ColorPickerPurple_Player3);
        player3PurpleDisabled = findViewById(R.id.Disabled_ColorPickerPurple_Player3);
        player3PinkFrame = findViewById(R.id.Color_Picker_Pink_Frame_Player3);
        player3Pink = findViewById(R.id.ColorPickerPink_Player3);
        player3PinkDisabled = findViewById(R.id.Disabled_ColorPickerPink_Player3);

        //Show Player 3 Color picker
        player3Color.setOnClickListener(view -> {
            //the color picker is open on their screen - the user wishes to close the color picker
            if (player3MainFrame.getVisibility() == View.VISIBLE) {

                //show the name inputs again
                player3.setVisibility(View.VISIBLE);
                player3Underline.setVisibility(View.VISIBLE);
                if (hideFour) {
                    player4.setVisibility(View.VISIBLE);
                    player4Underline.setVisibility(View.VISIBLE);
                }

                //hide the color picker
                player3MainFrame.setVisibility(View.GONE);
                player3RedFrame.setVisibility(View.GONE);
                player3Red.setVisibility(View.GONE);
                player3RedDisabled.setVisibility(View.GONE);
                player3GreenFrame.setVisibility(View.GONE);
                player3Green.setVisibility(View.GONE);
                player3GreenDisabled.setVisibility(View.GONE);
                player3DarkBlueFrame.setVisibility(View.GONE);
                player3DarkBlue.setVisibility(View.GONE);
                player3DarkBlueDisabled.setVisibility(View.GONE);
                player3OrangeFrame.setVisibility(View.GONE);
                player3Orange.setVisibility(View.GONE);
                player3OrangeDisabled.setVisibility(View.GONE);
                player3PurpleFrame.setVisibility(View.GONE);
                player3Purple.setVisibility(View.GONE);
                player3PurpleDisabled.setVisibility(View.GONE);
                player3PinkFrame.setVisibility(View.GONE);
                player3Pink.setVisibility(View.GONE);
                player3PinkDisabled.setVisibility(View.GONE);
            }

            //if the color picker is not on their screen - the user wants to pick a color
            else {

                //check to see if any other color picker is currently open
                //if Player 1 color picker is open
                if (player1MainFrame.getVisibility() == View.VISIBLE) {
                    //make player 1's color picker invisible
                    player1MainFrame.setVisibility(View.GONE);
                    player1RedFrame.setVisibility(View.GONE);
                    player1Red.setVisibility(View.GONE);
                    player1RedDisabled.setVisibility(View.GONE);
                    player1GreenFrame.setVisibility(View.GONE);
                    player1Green.setVisibility(View.GONE);
                    player1GreenDisabled.setVisibility(View.GONE);
                    player1DarkBlueFrame.setVisibility(View.GONE);
                    player1DarkBlue.setVisibility(View.GONE);
                    player1DarkBlueDisabled.setVisibility(View.GONE);
                    player1OrangeFrame.setVisibility(View.GONE);
                    player1Orange.setVisibility(View.GONE);
                    player1OrangeDisabled.setVisibility(View.GONE);
                    player1PurpleFrame.setVisibility(View.GONE);
                    player1Purple.setVisibility(View.GONE);
                    player1PurpleDisabled.setVisibility(View.GONE);
                    player1PinkFrame.setVisibility(View.GONE);
                    player1Pink.setVisibility(View.GONE);
                    player1PinkDisabled.setVisibility(View.GONE);

                    //show the name inputs again
                    player1.setVisibility(View.VISIBLE);
                    player1Underline.setVisibility(View.VISIBLE);
                    player2.setVisibility(View.VISIBLE);
                    player2Underline.setVisibility(View.VISIBLE);
                }
                //if Player 2 color picker is open
                if (player2MainFrame.getVisibility() == View.VISIBLE) {
                    //make player 2's color picker invisible
                    player2MainFrame.setVisibility(View.GONE);
                    player2RedFrame.setVisibility(View.GONE);
                    player2Red.setVisibility(View.GONE);
                    player2RedDisabled.setVisibility(View.GONE);
                    player2GreenFrame.setVisibility(View.GONE);
                    player2Green.setVisibility(View.GONE);
                    player2GreenDisabled.setVisibility(View.GONE);
                    player2DarkBlueFrame.setVisibility(View.GONE);
                    player2DarkBlue.setVisibility(View.GONE);
                    player2DarkBlueDisabled.setVisibility(View.GONE);
                    player2OrangeFrame.setVisibility(View.GONE);
                    player2Orange.setVisibility(View.GONE);
                    player2OrangeDisabled.setVisibility(View.GONE);
                    player2PurpleFrame.setVisibility(View.GONE);
                    player2Purple.setVisibility(View.GONE);
                    player2PurpleDisabled.setVisibility(View.GONE);
                    player2PinkFrame.setVisibility(View.GONE);
                    player2Pink.setVisibility(View.GONE);
                    player2PinkDisabled.setVisibility(View.GONE);

                    //show the name inputs again
                    player2.setVisibility(View.VISIBLE);
                    player2Underline.setVisibility(View.VISIBLE);
                    if (hideThree) {
                        player3.setVisibility(View.VISIBLE);
                        player3Underline.setVisibility(View.VISIBLE);
                    }
                }
                //if Player 4 color picker is open
                if (player4MainFrame.getVisibility() == View.VISIBLE) {
                    //make player 4's color picker invisible
                    player4MainFrame.setVisibility(View.GONE);
                    player4RedFrame.setVisibility(View.GONE);
                    player4Red.setVisibility(View.GONE);
                    player4RedDisabled.setVisibility(View.GONE);
                    player4GreenFrame.setVisibility(View.GONE);
                    player4Green.setVisibility(View.GONE);
                    player4GreenDisabled.setVisibility(View.GONE);
                    player4DarkBlueFrame.setVisibility(View.GONE);
                    player4DarkBlue.setVisibility(View.GONE);
                    player4DarkBlueDisabled.setVisibility(View.GONE);
                    player4OrangeFrame.setVisibility(View.GONE);
                    player4Orange.setVisibility(View.GONE);
                    player4OrangeDisabled.setVisibility(View.GONE);
                    player4PurpleFrame.setVisibility(View.GONE);
                    player4Purple.setVisibility(View.GONE);
                    player4PurpleDisabled.setVisibility(View.GONE);
                    player4PinkFrame.setVisibility(View.GONE);
                    player4Pink.setVisibility(View.GONE);
                    player4PinkDisabled.setVisibility(View.GONE);

                    //show the name inputs again
                    player4.setVisibility(View.VISIBLE);
                    player4Underline.setVisibility(View.VISIBLE);
                    if (hideStart) {
                        startGame.setVisibility(View.VISIBLE);
                    }
                }

                //hide the first 2 name inputs
                player3.setVisibility(View.GONE);
                player3Underline.setVisibility(View.GONE);
                if (hideFour) {
                    player4.setVisibility(View.GONE);
                    player4Underline.setVisibility(View.GONE);
                }

                //show the color picker
                player3MainFrame.setVisibility(View.VISIBLE);
                player3RedFrame.setVisibility(View.VISIBLE);
                player3Red.setVisibility(View.VISIBLE);
                player3GreenFrame.setVisibility(View.VISIBLE);
                player3Green.setVisibility(View.VISIBLE);
                player3DarkBlueFrame.setVisibility(View.VISIBLE);
                player3DarkBlue.setVisibility(View.VISIBLE);
                player3OrangeFrame.setVisibility(View.VISIBLE);
                player3Orange.setVisibility(View.VISIBLE);
                player3PurpleFrame.setVisibility(View.VISIBLE);
                player3Purple.setVisibility(View.VISIBLE);
                player3PinkFrame.setVisibility(View.VISIBLE);
                player3Pink.setVisibility(View.VISIBLE);

                //reset the color picker values
                player3Red.setEnabled(true);
                player3RedDisabled.setVisibility(View.GONE);
                player3Green.setEnabled(true);
                player3GreenDisabled.setVisibility(View.GONE);
                player3DarkBlue.setEnabled(true);
                player3DarkBlueDisabled.setVisibility(View.GONE);
                player3Orange.setEnabled(true);
                player3OrangeDisabled.setVisibility(View.GONE);
                player3Purple.setEnabled(true);
                player3PurpleDisabled.setVisibility(View.GONE);
                player3Pink.setEnabled(true);
                player3PinkDisabled.setVisibility(View.GONE);

                //check if another player is using any color - if they are disable the corresponding colored button
                if (!player1ColorHex.equals("")) {
                    //if Player 1 is using RED
                    if(player1ColorHex.equals("#EA0000")) {
                        //disable the red
                        Log.e("MyTag", "Player 1 is using RED");
                        player3Red.setEnabled(false);
                        player3Red.setVisibility(View.GONE);
                        player3RedDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using GREEN
                    if(player1ColorHex.equals("#0ECC15")) {
                        //disable the green
                        Log.e("MyTag", "Player 1 is using GREEN");
                        player3Green.setEnabled(false);
                        player3Green.setVisibility(View.GONE);
                        player3GreenDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using DARK BLUE
                    if(player1ColorHex.equals("#0009EA")) {
                        //disable the dark blue
                        Log.e("MyTag", "Player 1 is using DARK BLUE");
                        player3DarkBlue.setEnabled(false);
                        player3DarkBlue.setVisibility(View.GONE);
                        player3DarkBlueDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using ORANGE
                    if(player1ColorHex.equals("#EA8C00")) {
                        //disable the orange
                        Log.e("MyTag", "Player 1 is using ORANGE");
                        player3Orange.setEnabled(false);
                        player3Orange.setVisibility(View.GONE);
                        player3OrangeDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using PURPLE
                    if(player1ColorHex.equals("#BA2CEC")) {
                        //disable the purple
                        Log.e("MyTag", "Player 1 is using PURPLE");
                        player3Purple.setEnabled(false);
                        player3Purple.setVisibility(View.GONE);
                        player3PurpleDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using PINK
                    if(player1ColorHex.equals("#F137DF")) {
                        //disable the pink
                        Log.e("MyTag", "Player 1 is using PINK");
                        player3Pink.setEnabled(false);
                        player3Pink.setVisibility(View.GONE);
                        player3PinkDisabled.setVisibility(View.VISIBLE);
                    }
                }

                if (!player2ColorHex.equals("")) {
                    //if Player 2 is using RED
                    if(player2ColorHex.equals("#EA0000")) {
                        //disable the red
                        Log.e("MyTag", "Player 2 is using RED");
                        player3Red.setEnabled(false);
                        player3Red.setVisibility(View.GONE);
                        player3RedDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using GREEN
                    if(player2ColorHex.equals("#0ECC15")) {
                        //disable the green
                        Log.e("MyTag", "Player 2 is using GREEN");
                        player3Green.setEnabled(false);
                        player3Green.setVisibility(View.GONE);
                        player3GreenDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using DARK BLUE
                    if(player2ColorHex.equals("#0009EA")) {
                        //disable the dark blue
                        Log.e("MyTag", "Player 2 is using DARK BLUE");
                        player3DarkBlue.setEnabled(false);
                        player3DarkBlue.setVisibility(View.GONE);
                        player3DarkBlueDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using ORANGE
                    if(player2ColorHex.equals("#EA8C00")) {
                        //disable the orange
                        Log.e("MyTag", "Player 2 is using ORANGE");
                        player3Orange.setEnabled(false);
                        player3Orange.setVisibility(View.GONE);
                        player3OrangeDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using PURPLE
                    if(player2ColorHex.equals("#BA2CEC")) {
                        //disable the purple
                        Log.e("MyTag", "Player 2 is using PURPLE");
                        player3Purple.setEnabled(false);
                        player3Purple.setVisibility(View.GONE);
                        player3PurpleDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using PINK
                    if(player2ColorHex.equals("#F137DF")) {
                        //disable the pink
                        Log.e("MyTag", "Player 2 is using PINK");
                        player3Pink.setEnabled(false);
                        player3Pink.setVisibility(View.GONE);
                        player3PinkDisabled.setVisibility(View.VISIBLE);
                    }
                }

                if (!player4ColorHex.equals("")) {
                    //if Player 4 is using RED
                    if(player4ColorHex.equals("#EA0000")) {
                        //disable the red
                        Log.e("MyTag", "Player 4 is using RED");
                        player3Red.setEnabled(false);
                        player3Red.setVisibility(View.GONE);
                        player3RedDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using GREEN
                    if(player4ColorHex.equals("#0ECC15")) {
                        //disable the green
                        Log.e("MyTag", "Player 4 is using GREEN");
                        player3Green.setEnabled(false);
                        player3Green.setVisibility(View.GONE);
                        player3GreenDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using DARK BLUE
                    if(player4ColorHex.equals("#0009EA")) {
                        //disable the dark blue
                        Log.e("MyTag", "Player 4 is using DARK BLUE");
                        player3DarkBlue.setEnabled(false);
                        player3DarkBlue.setVisibility(View.GONE);
                        player3DarkBlueDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using ORANGE
                    if(player4ColorHex.equals("#EA8C00")) {
                        //disable the orange
                        Log.e("MyTag", "Player 4 is using ORANGE");
                        player3Orange.setEnabled(false);
                        player3Orange.setVisibility(View.GONE);
                        player3OrangeDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using PURPLE
                    if(player4ColorHex.equals("#BA2CEC")) {
                        //disable the purple
                        Log.e("MyTag", "Player 4 is using PURPLE");
                        player3Purple.setEnabled(false);
                        player3Purple.setVisibility(View.GONE);
                        player3PurpleDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 4 is using PINK
                    if(player4ColorHex.equals("#F137DF")) {
                        //disable the pink
                        Log.e("MyTag", "Player 4 is using PINK");
                        player3Pink.setEnabled(false);
                        player3Pink.setVisibility(View.GONE);
                        player3PinkDisabled.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        //Color Check Time:
        //If Player 3 Chooses Red
        player3Red.setOnClickListener(view -> {
            //set the players color to red
            player3Color.setBackgroundColor(Color.parseColor("#EA0000"));
            player3ColorId = Color.parseColor("#EA0000");
            player3ColorHex = "#EA0000";

            //make the color picker invisible again
            player3MainFrame.setVisibility(View.GONE);
            player3RedFrame.setVisibility(View.GONE);
            player3Red.setVisibility(View.GONE);
            player3RedDisabled.setVisibility(View.GONE);
            player3GreenFrame.setVisibility(View.GONE);
            player3Green.setVisibility(View.GONE);
            player3GreenDisabled.setVisibility(View.GONE);
            player3DarkBlueFrame.setVisibility(View.GONE);
            player3DarkBlue.setVisibility(View.GONE);
            player3DarkBlueDisabled.setVisibility(View.GONE);
            player3OrangeFrame.setVisibility(View.GONE);
            player3Orange.setVisibility(View.GONE);
            player3OrangeDisabled.setVisibility(View.GONE);
            player3PurpleFrame.setVisibility(View.GONE);
            player3Purple.setVisibility(View.GONE);
            player3PurpleDisabled.setVisibility(View.GONE);
            player3PinkFrame.setVisibility(View.GONE);
            player3Pink.setVisibility(View.GONE);
            player3PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player3.setVisibility(View.VISIBLE);
            player3Underline.setVisibility(View.VISIBLE);
            if (hideFour) {
                player4.setVisibility(View.VISIBLE);
                player4Underline.setVisibility(View.VISIBLE);
            }
        });

        //If Player 3 Chooses Green
        player3Green.setOnClickListener(view -> {
            //set the players color to green
            player3Color.setBackgroundColor(Color.parseColor("#0ECC15"));
            player3ColorId = Color.parseColor("#0ECC15");
            player3ColorHex = "#0ECC15";

            //make the color picker invisible again
            player3MainFrame.setVisibility(View.GONE);
            player3RedFrame.setVisibility(View.GONE);
            player3Red.setVisibility(View.GONE);
            player3RedDisabled.setVisibility(View.GONE);
            player3GreenFrame.setVisibility(View.GONE);
            player3Green.setVisibility(View.GONE);
            player3GreenDisabled.setVisibility(View.GONE);
            player3DarkBlueFrame.setVisibility(View.GONE);
            player3DarkBlue.setVisibility(View.GONE);
            player3DarkBlueDisabled.setVisibility(View.GONE);
            player3OrangeFrame.setVisibility(View.GONE);
            player3Orange.setVisibility(View.GONE);
            player3OrangeDisabled.setVisibility(View.GONE);
            player3PurpleFrame.setVisibility(View.GONE);
            player3Purple.setVisibility(View.GONE);
            player3PurpleDisabled.setVisibility(View.GONE);
            player3PinkFrame.setVisibility(View.GONE);
            player3Pink.setVisibility(View.GONE);
            player3PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player3.setVisibility(View.VISIBLE);
            player3Underline.setVisibility(View.VISIBLE);
            if (hideFour) {
                player4.setVisibility(View.VISIBLE);
                player4Underline.setVisibility(View.VISIBLE);
            }
        });

        //If Player 3 Chooses Dark Blue
        player3DarkBlue.setOnClickListener(view -> {
            //set the players color to dark blue
            player3Color.setBackgroundColor(Color.parseColor("#0009EA"));
            player3ColorId = Color.parseColor("#0009EA");
            player3ColorHex = "#0009EA";

            //make the color picker invisible again
            player3MainFrame.setVisibility(View.GONE);
            player3RedFrame.setVisibility(View.GONE);
            player3Red.setVisibility(View.GONE);
            player3RedDisabled.setVisibility(View.GONE);
            player3GreenFrame.setVisibility(View.GONE);
            player3Green.setVisibility(View.GONE);
            player3GreenDisabled.setVisibility(View.GONE);
            player3DarkBlueFrame.setVisibility(View.GONE);
            player3DarkBlue.setVisibility(View.GONE);
            player3DarkBlueDisabled.setVisibility(View.GONE);
            player3OrangeFrame.setVisibility(View.GONE);
            player3Orange.setVisibility(View.GONE);
            player3OrangeDisabled.setVisibility(View.GONE);
            player3PurpleFrame.setVisibility(View.GONE);
            player3Purple.setVisibility(View.GONE);
            player3PurpleDisabled.setVisibility(View.GONE);
            player3PinkFrame.setVisibility(View.GONE);
            player3Pink.setVisibility(View.GONE);
            player3PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player3.setVisibility(View.VISIBLE);
            player3Underline.setVisibility(View.VISIBLE);
            if (hideFour) {
                player4.setVisibility(View.VISIBLE);
                player4Underline.setVisibility(View.VISIBLE);
            }
        });

        //If Player 3 Chooses Orange
        player3Orange.setOnClickListener(view -> {
            //set the players color to orange
            player3Color.setBackgroundColor(Color.parseColor("#EA8C00"));
            player3ColorId = Color.parseColor("#EA8C00");
            player3ColorHex = "#EA8C00";

            //make the color picker invisible again
            player3MainFrame.setVisibility(View.GONE);
            player3RedFrame.setVisibility(View.GONE);
            player3Red.setVisibility(View.GONE);
            player3RedDisabled.setVisibility(View.GONE);
            player3GreenFrame.setVisibility(View.GONE);
            player3Green.setVisibility(View.GONE);
            player3GreenDisabled.setVisibility(View.GONE);
            player3DarkBlueFrame.setVisibility(View.GONE);
            player3DarkBlue.setVisibility(View.GONE);
            player3DarkBlueDisabled.setVisibility(View.GONE);
            player3OrangeFrame.setVisibility(View.GONE);
            player3Orange.setVisibility(View.GONE);
            player3OrangeDisabled.setVisibility(View.GONE);
            player3PurpleFrame.setVisibility(View.GONE);
            player3Purple.setVisibility(View.GONE);
            player3PurpleDisabled.setVisibility(View.GONE);
            player3PinkFrame.setVisibility(View.GONE);
            player3Pink.setVisibility(View.GONE);
            player3PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player3.setVisibility(View.VISIBLE);
            player3Underline.setVisibility(View.VISIBLE);
            if (hideFour) {
                player4.setVisibility(View.VISIBLE);
                player4Underline.setVisibility(View.VISIBLE);
            }
        });

        //If Player 3 Chooses Purple
        player3Purple.setOnClickListener(view -> {
            //set the players color to purple
            player3Color.setBackgroundColor(Color.parseColor("#BA2CEC"));
            player3ColorId = Color.parseColor("#BA2CEC");
            player3ColorHex = "#BA2CEC";

            //make the color picker invisible again
            player3MainFrame.setVisibility(View.GONE);
            player3RedFrame.setVisibility(View.GONE);
            player3Red.setVisibility(View.GONE);
            player3RedDisabled.setVisibility(View.GONE);
            player3GreenFrame.setVisibility(View.GONE);
            player3Green.setVisibility(View.GONE);
            player3GreenDisabled.setVisibility(View.GONE);
            player3DarkBlueFrame.setVisibility(View.GONE);
            player3DarkBlue.setVisibility(View.GONE);
            player3DarkBlueDisabled.setVisibility(View.GONE);
            player3OrangeFrame.setVisibility(View.GONE);
            player3Orange.setVisibility(View.GONE);
            player3OrangeDisabled.setVisibility(View.GONE);
            player3PurpleFrame.setVisibility(View.GONE);
            player3Purple.setVisibility(View.GONE);
            player3PurpleDisabled.setVisibility(View.GONE);
            player3PinkFrame.setVisibility(View.GONE);
            player3Pink.setVisibility(View.GONE);
            player3PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player3.setVisibility(View.VISIBLE);
            player3Underline.setVisibility(View.VISIBLE);
            if (hideFour) {
                player4.setVisibility(View.VISIBLE);
                player4Underline.setVisibility(View.VISIBLE);
            }
        });

        //If Player 3 Chooses Pink
        player3Pink.setOnClickListener(view -> {
            //set the players color to pink
            player3Color.setBackgroundColor(Color.parseColor("#F137DF"));
            player3ColorId = Color.parseColor("#F137DF");
            player3ColorHex = "#F137DF";

            //make the color picker invisible again
            player3MainFrame.setVisibility(View.GONE);
            player3RedFrame.setVisibility(View.GONE);
            player3Red.setVisibility(View.GONE);
            player3RedDisabled.setVisibility(View.GONE);
            player3GreenFrame.setVisibility(View.GONE);
            player3Green.setVisibility(View.GONE);
            player3GreenDisabled.setVisibility(View.GONE);
            player3DarkBlueFrame.setVisibility(View.GONE);
            player3DarkBlue.setVisibility(View.GONE);
            player3DarkBlueDisabled.setVisibility(View.GONE);
            player3OrangeFrame.setVisibility(View.GONE);
            player3Orange.setVisibility(View.GONE);
            player3OrangeDisabled.setVisibility(View.GONE);
            player3PurpleFrame.setVisibility(View.GONE);
            player3Purple.setVisibility(View.GONE);
            player3PurpleDisabled.setVisibility(View.GONE);
            player3PinkFrame.setVisibility(View.GONE);
            player3Pink.setVisibility(View.GONE);
            player3PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player3.setVisibility(View.VISIBLE);
            player3Underline.setVisibility(View.VISIBLE);
            if (hideFour) {
                player4.setVisibility(View.VISIBLE);
                player4Underline.setVisibility(View.VISIBLE);
            }
        });


        /***********
         * Player 4
         **********/
        //get the color picker elements
        player4MainFrame = findViewById(R.id.Color_Picker_Main_Frame_Player4);
        player4MainFrame.getBackground().setAlpha(255);
        player4RedFrame = findViewById(R.id.Color_Picker_Red_Frame_Player4);
        player4Red = findViewById(R.id.ColorPickerRed_Player4);
        player4RedDisabled = findViewById(R.id.Disabled_ColorPickerRed_Player4);
        player4GreenFrame = findViewById(R.id.Color_Picker_Green_Frame_Player4);
        player4Green = findViewById(R.id.ColorPickerGreen_Player4);
        player4GreenDisabled = findViewById(R.id.Disabled_ColorPickerGreen_Player4);
        player4DarkBlueFrame = findViewById(R.id.Color_Picker_DarkBlue_Frame_Player4);
        player4DarkBlue = findViewById(R.id.ColorPickerDarkBlue_Player4);
        player4DarkBlueDisabled = findViewById(R.id.Disabled_ColorPickerDarkBlue_Player4);
        player4OrangeFrame = findViewById(R.id.Color_Picker_Orange_Frame_Player4);
        player4Orange = findViewById(R.id.ColorPickerOrange_Player4);
        player4OrangeDisabled = findViewById(R.id.Disabled_ColorPickerOrange_Player4);
        player4PurpleFrame = findViewById(R.id.Color_Picker_Purple_Frame_Player4);
        player4Purple = findViewById(R.id.ColorPickerPurple_Player4);
        player4PurpleDisabled = findViewById(R.id.Disabled_ColorPickerPurple_Player4);
        player4PinkFrame = findViewById(R.id.Color_Picker_Pink_Frame_Player4);
        player4Pink = findViewById(R.id.ColorPickerPink_Player4);
        player4PinkDisabled = findViewById(R.id.Disabled_ColorPickerPink_Player4);

        //Show Player 4 Color picker
        player4Color.setOnClickListener(view -> {
            //the color picker is open on their screen - the user wishes to close the color picker
            if (player4MainFrame.getVisibility() == View.VISIBLE) {

                //show the name inputs again
                player4.setVisibility(View.VISIBLE);
                player4Underline.setVisibility(View.VISIBLE);
                if (hideStart) {
                    startGame.setVisibility(View.VISIBLE);
                }

                //hide the color picker
                player4MainFrame.setVisibility(View.GONE);
                player4RedFrame.setVisibility(View.GONE);
                player4Red.setVisibility(View.GONE);
                player4RedDisabled.setVisibility(View.GONE);
                player4GreenFrame.setVisibility(View.GONE);
                player4Green.setVisibility(View.GONE);
                player4GreenDisabled.setVisibility(View.GONE);
                player4DarkBlueFrame.setVisibility(View.GONE);
                player4DarkBlue.setVisibility(View.GONE);
                player4DarkBlueDisabled.setVisibility(View.GONE);
                player4OrangeFrame.setVisibility(View.GONE);
                player4Orange.setVisibility(View.GONE);
                player4OrangeDisabled.setVisibility(View.GONE);
                player4PurpleFrame.setVisibility(View.GONE);
                player4Purple.setVisibility(View.GONE);
                player4PurpleDisabled.setVisibility(View.GONE);
                player4PinkFrame.setVisibility(View.GONE);
                player4Pink.setVisibility(View.GONE);
                player4PinkDisabled.setVisibility(View.GONE);
            }

            //if the color picker is not on their screen - the user wants to pick a color
            else {

                //check to see if any other color picker is currently open
                //if Player 1 color picker is open
                if (player1MainFrame.getVisibility() == View.VISIBLE) {
                    //make player 1's color picker invisible
                    player1MainFrame.setVisibility(View.GONE);
                    player1RedFrame.setVisibility(View.GONE);
                    player1Red.setVisibility(View.GONE);
                    player1RedDisabled.setVisibility(View.GONE);
                    player1GreenFrame.setVisibility(View.GONE);
                    player1Green.setVisibility(View.GONE);
                    player1GreenDisabled.setVisibility(View.GONE);
                    player1DarkBlueFrame.setVisibility(View.GONE);
                    player1DarkBlue.setVisibility(View.GONE);
                    player1DarkBlueDisabled.setVisibility(View.GONE);
                    player1OrangeFrame.setVisibility(View.GONE);
                    player1Orange.setVisibility(View.GONE);
                    player1OrangeDisabled.setVisibility(View.GONE);
                    player1PurpleFrame.setVisibility(View.GONE);
                    player1Purple.setVisibility(View.GONE);
                    player1PurpleDisabled.setVisibility(View.GONE);
                    player1PinkFrame.setVisibility(View.GONE);
                    player1Pink.setVisibility(View.GONE);
                    player1PinkDisabled.setVisibility(View.GONE);

                    //show the name inputs again
                    player1.setVisibility(View.VISIBLE);
                    player1Underline.setVisibility(View.VISIBLE);
                    player2.setVisibility(View.VISIBLE);
                    player2Underline.setVisibility(View.VISIBLE);
                }
                //if Player 2 color picker is open
                if (player2MainFrame.getVisibility() == View.VISIBLE) {
                    //make player 2's color picker invisible
                    player2MainFrame.setVisibility(View.GONE);
                    player2RedFrame.setVisibility(View.GONE);
                    player2Red.setVisibility(View.GONE);
                    player2RedDisabled.setVisibility(View.GONE);
                    player2GreenFrame.setVisibility(View.GONE);
                    player2Green.setVisibility(View.GONE);
                    player2GreenDisabled.setVisibility(View.GONE);
                    player2DarkBlueFrame.setVisibility(View.GONE);
                    player2DarkBlue.setVisibility(View.GONE);
                    player2DarkBlueDisabled.setVisibility(View.GONE);
                    player2OrangeFrame.setVisibility(View.GONE);
                    player2Orange.setVisibility(View.GONE);
                    player2OrangeDisabled.setVisibility(View.GONE);
                    player2PurpleFrame.setVisibility(View.GONE);
                    player2Purple.setVisibility(View.GONE);
                    player2PurpleDisabled.setVisibility(View.GONE);
                    player2PinkFrame.setVisibility(View.GONE);
                    player2Pink.setVisibility(View.GONE);
                    player2PinkDisabled.setVisibility(View.GONE);

                    //show the name inputs again
                    player2.setVisibility(View.VISIBLE);
                    player2Underline.setVisibility(View.VISIBLE);
                    if (hideThree) {
                        player3.setVisibility(View.VISIBLE);
                        player3Underline.setVisibility(View.VISIBLE);
                    }
                }
                //if Player 3 color picker is open
                if (player3MainFrame.getVisibility() == View.VISIBLE) {
                    //make player 3's color picker invisible
                    player3MainFrame.setVisibility(View.GONE);
                    player3RedFrame.setVisibility(View.GONE);
                    player3Red.setVisibility(View.GONE);
                    player3RedDisabled.setVisibility(View.GONE);
                    player3GreenFrame.setVisibility(View.GONE);
                    player3Green.setVisibility(View.GONE);
                    player3GreenDisabled.setVisibility(View.GONE);
                    player3DarkBlueFrame.setVisibility(View.GONE);
                    player3DarkBlue.setVisibility(View.GONE);
                    player3DarkBlueDisabled.setVisibility(View.GONE);
                    player3OrangeFrame.setVisibility(View.GONE);
                    player3Orange.setVisibility(View.GONE);
                    player3OrangeDisabled.setVisibility(View.GONE);
                    player3PurpleFrame.setVisibility(View.GONE);
                    player3Purple.setVisibility(View.GONE);
                    player3PurpleDisabled.setVisibility(View.GONE);
                    player3PinkFrame.setVisibility(View.GONE);
                    player3Pink.setVisibility(View.GONE);
                    player3PinkDisabled.setVisibility(View.GONE);

                    //show the name inputs again
                    player3.setVisibility(View.VISIBLE);
                    player3Underline.setVisibility(View.VISIBLE);
                    if (hideFour) {
                        player4.setVisibility(View.VISIBLE);
                        player4Underline.setVisibility(View.VISIBLE);
                    }
                }

                //hide the first 2 name inputs
                player4.setVisibility(View.GONE);
                player4Underline.setVisibility(View.GONE);
                if (hideStart) {
                    startGame.setVisibility(View.GONE);
                }

                //show the color picker
                player4MainFrame.setVisibility(View.VISIBLE);
                player4RedFrame.setVisibility(View.VISIBLE);
                player4Red.setVisibility(View.VISIBLE);
                player4GreenFrame.setVisibility(View.VISIBLE);
                player4Green.setVisibility(View.VISIBLE);
                player4DarkBlueFrame.setVisibility(View.VISIBLE);
                player4DarkBlue.setVisibility(View.VISIBLE);
                player4OrangeFrame.setVisibility(View.VISIBLE);
                player4Orange.setVisibility(View.VISIBLE);
                player4PurpleFrame.setVisibility(View.VISIBLE);
                player4Purple.setVisibility(View.VISIBLE);
                player4PinkFrame.setVisibility(View.VISIBLE);
                player4Pink.setVisibility(View.VISIBLE);

                //reset the color picker values
                player4Red.setEnabled(true);
                player4RedDisabled.setVisibility(View.GONE);
                player4Green.setEnabled(true);
                player4GreenDisabled.setVisibility(View.GONE);
                player4DarkBlue.setEnabled(true);
                player4DarkBlueDisabled.setVisibility(View.GONE);
                player4Orange.setEnabled(true);
                player4OrangeDisabled.setVisibility(View.GONE);
                player4Purple.setEnabled(true);
                player4PurpleDisabled.setVisibility(View.GONE);
                player4Pink.setEnabled(true);
                player4PinkDisabled.setVisibility(View.GONE);

                //check if another player is using any color - if they are disable the corresponding colored button
                if (!player1ColorHex.equals("")) {
                    //if Player 1 is using RED
                    if(player1ColorHex.equals("#EA0000")) {
                        //disable the red
                        Log.e("MyTag", "Player 1 is using RED");
                        player4Red.setEnabled(false);
                        player4Red.setVisibility(View.GONE);
                        player4RedDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using GREEN
                    if(player1ColorHex.equals("#0ECC15")) {
                        //disable the green
                        Log.e("MyTag", "Player 1 is using GREEN");
                        player4Green.setEnabled(false);
                        player4Green.setVisibility(View.GONE);
                        player4GreenDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using DARK BLUE
                    if(player1ColorHex.equals("#0009EA")) {
                        //disable the dark blue
                        Log.e("MyTag", "Player 1 is using DARK BLUE");
                        player4DarkBlue.setEnabled(false);
                        player4DarkBlue.setVisibility(View.GONE);
                        player4DarkBlueDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using ORANGE
                    if(player1ColorHex.equals("#EA8C00")) {
                        //disable the orange
                        Log.e("MyTag", "Player 1 is using ORANGE");
                        player4Orange.setEnabled(false);
                        player4Orange.setVisibility(View.GONE);
                        player4OrangeDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using PURPLE
                    if(player1ColorHex.equals("#BA2CEC")) {
                        //disable the purple
                        Log.e("MyTag", "Player 1 is using PURPLE");
                        player4Purple.setEnabled(false);
                        player4Purple.setVisibility(View.GONE);
                        player4PurpleDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 1 is using PINK
                    if(player1ColorHex.equals("#F137DF")) {
                        //disable the pink
                        Log.e("MyTag", "Player 1 is using PINK");
                        player4Pink.setEnabled(false);
                        player4Pink.setVisibility(View.GONE);
                        player4PinkDisabled.setVisibility(View.VISIBLE);
                    }
                }

                if (!player2ColorHex.equals("")) {
                    //if Player 2 is using RED
                    if(player2ColorHex.equals("#EA0000")) {
                        //disable the red
                        Log.e("MyTag", "Player 2 is using RED");
                        player4Red.setEnabled(false);
                        player4Red.setVisibility(View.GONE);
                        player4RedDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using GREEN
                    if(player2ColorHex.equals("#0ECC15")) {
                        //disable the green
                        Log.e("MyTag", "Player 2 is using GREEN");
                        player4Green.setEnabled(false);
                        player4Green.setVisibility(View.GONE);
                        player4GreenDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using DARK BLUE
                    if(player2ColorHex.equals("#0009EA")) {
                        //disable the dark blue
                        Log.e("MyTag", "Player 2 is using DARK BLUE");
                        player4DarkBlue.setEnabled(false);
                        player4DarkBlue.setVisibility(View.GONE);
                        player4DarkBlueDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using ORANGE
                    if(player2ColorHex.equals("#EA8C00")) {
                        //disable the orange
                        Log.e("MyTag", "Player 2 is using ORANGE");
                        player4Orange.setEnabled(false);
                        player4Orange.setVisibility(View.GONE);
                        player4OrangeDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using PURPLE
                    if(player2ColorHex.equals("#BA2CEC")) {
                        //disable the purple
                        Log.e("MyTag", "Player 2 is using PURPLE");
                        player4Purple.setEnabled(false);
                        player4Purple.setVisibility(View.GONE);
                        player4PurpleDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 2 is using PINK
                    if(player2ColorHex.equals("#F137DF")) {
                        //disable the pink
                        Log.e("MyTag", "Player 2 is using PINK");
                        player4Pink.setEnabled(false);
                        player4Pink.setVisibility(View.GONE);
                        player4PinkDisabled.setVisibility(View.VISIBLE);
                    }
                }

                if (!player3ColorHex.equals("")) {
                    //if Player 3 is using RED
                    if(player3ColorHex.equals("#EA0000")) {
                        //disable the red
                        Log.e("MyTag", "Player 3 is using RED");
                        player4Red.setEnabled(false);
                        player4Red.setVisibility(View.GONE);
                        player4RedDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using GREEN
                    if(player3ColorHex.equals("#0ECC15")) {
                        //disable the green
                        Log.e("MyTag", "Player 3 is using GREEN");
                        player4Green.setEnabled(false);
                        player4Green.setVisibility(View.GONE);
                        player4GreenDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using DARK BLUE
                    if(player3ColorHex.equals("#0009EA")) {
                        //disable the dark blue
                        Log.e("MyTag", "Player 3 is using DARK BLUE");
                        player4DarkBlue.setEnabled(false);
                        player4DarkBlue.setVisibility(View.GONE);
                        player4DarkBlueDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using ORANGE
                    if(player3ColorHex.equals("#EA8C00")) {
                        //disable the orange
                        Log.e("MyTag", "Player 3 is using ORANGE");
                        player4Orange.setEnabled(false);
                        player4Orange.setVisibility(View.GONE);
                        player4OrangeDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using PURPLE
                    if(player3ColorHex.equals("#BA2CEC")) {
                        //disable the purple
                        Log.e("MyTag", "Player 3 is using PURPLE");
                        player4Purple.setEnabled(false);
                        player4Purple.setVisibility(View.GONE);
                        player4PurpleDisabled.setVisibility(View.VISIBLE);
                    }

                    //if Player 3 is using PINK
                    if(player3ColorHex.equals("#F137DF")) {
                        //disable the pink
                        Log.e("MyTag", "Player 3 is using PINK");
                        player4Pink.setEnabled(false);
                        player4Pink.setVisibility(View.GONE);
                        player4PinkDisabled.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        //Color Check Time:
        //If Player 4 Chooses Red
        player4Red.setOnClickListener(view -> {
            //set the players color to red
            player4Color.setBackgroundColor(Color.parseColor("#EA0000"));
            player4ColorId = Color.parseColor("#EA0000");
            player4ColorHex = "#EA0000";

            //make the color picker invisible again
            player4MainFrame.setVisibility(View.GONE);
            player4RedFrame.setVisibility(View.GONE);
            player4Red.setVisibility(View.GONE);
            player4RedDisabled.setVisibility(View.GONE);
            player4GreenFrame.setVisibility(View.GONE);
            player4Green.setVisibility(View.GONE);
            player4GreenDisabled.setVisibility(View.GONE);
            player4DarkBlueFrame.setVisibility(View.GONE);
            player4DarkBlue.setVisibility(View.GONE);
            player4DarkBlueDisabled.setVisibility(View.GONE);
            player4OrangeFrame.setVisibility(View.GONE);
            player4Orange.setVisibility(View.GONE);
            player4OrangeDisabled.setVisibility(View.GONE);
            player4PurpleFrame.setVisibility(View.GONE);
            player4Purple.setVisibility(View.GONE);
            player4PurpleDisabled.setVisibility(View.GONE);
            player4PinkFrame.setVisibility(View.GONE);
            player4Pink.setVisibility(View.GONE);
            player4PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player4.setVisibility(View.VISIBLE);
            player4Underline.setVisibility(View.VISIBLE);
            if (hideStart) {
                startGame.setVisibility(View.VISIBLE);
            }
        });

        //If Player 4 Chooses Green
        player4Green.setOnClickListener(view -> {
            //set the players color to green
            player4Color.setBackgroundColor(Color.parseColor("#0ECC15"));
            player4ColorId = Color.parseColor("#0ECC15");
            player4ColorHex = "#0ECC15";

            //make the color picker invisible again
            player4MainFrame.setVisibility(View.GONE);
            player4RedFrame.setVisibility(View.GONE);
            player4Red.setVisibility(View.GONE);
            player4RedDisabled.setVisibility(View.GONE);
            player4GreenFrame.setVisibility(View.GONE);
            player4Green.setVisibility(View.GONE);
            player4GreenDisabled.setVisibility(View.GONE);
            player4DarkBlueFrame.setVisibility(View.GONE);
            player4DarkBlue.setVisibility(View.GONE);
            player4DarkBlueDisabled.setVisibility(View.GONE);
            player4OrangeFrame.setVisibility(View.GONE);
            player4Orange.setVisibility(View.GONE);
            player4OrangeDisabled.setVisibility(View.GONE);
            player4PurpleFrame.setVisibility(View.GONE);
            player4Purple.setVisibility(View.GONE);
            player4PurpleDisabled.setVisibility(View.GONE);
            player4PinkFrame.setVisibility(View.GONE);
            player4Pink.setVisibility(View.GONE);
            player4PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player4.setVisibility(View.VISIBLE);
            player4Underline.setVisibility(View.VISIBLE);
            if (hideStart) {
                startGame.setVisibility(View.VISIBLE);
            }
        });

        //If Player 4 Chooses Dark Blue
        player4DarkBlue.setOnClickListener(view -> {
            //set the players color to dark blue
            player4Color.setBackgroundColor(Color.parseColor("#0009EA"));
            player4ColorId = Color.parseColor("#0009EA");
            player4ColorHex = "#0009EA";

            //make the color picker invisible again
            player4MainFrame.setVisibility(View.GONE);
            player4RedFrame.setVisibility(View.GONE);
            player4Red.setVisibility(View.GONE);
            player4RedDisabled.setVisibility(View.GONE);
            player4GreenFrame.setVisibility(View.GONE);
            player4Green.setVisibility(View.GONE);
            player4GreenDisabled.setVisibility(View.GONE);
            player4DarkBlueFrame.setVisibility(View.GONE);
            player4DarkBlue.setVisibility(View.GONE);
            player4DarkBlueDisabled.setVisibility(View.GONE);
            player4OrangeFrame.setVisibility(View.GONE);
            player4Orange.setVisibility(View.GONE);
            player4OrangeDisabled.setVisibility(View.GONE);
            player4PurpleFrame.setVisibility(View.GONE);
            player4Purple.setVisibility(View.GONE);
            player4PurpleDisabled.setVisibility(View.GONE);
            player4PinkFrame.setVisibility(View.GONE);
            player4Pink.setVisibility(View.GONE);
            player4PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player4.setVisibility(View.VISIBLE);
            player4Underline.setVisibility(View.VISIBLE);
            if (hideStart) {
                startGame.setVisibility(View.VISIBLE);
            }
        });

        //If Player 3 Chooses Orange
        player4Orange.setOnClickListener(view -> {
            //set the players color to orange
            player4Color.setBackgroundColor(Color.parseColor("#EA8C00"));
            player4ColorId = Color.parseColor("#EA8C00");
            player4ColorHex = "#EA8C00";

            //make the color picker invisible again
            player4MainFrame.setVisibility(View.GONE);
            player4RedFrame.setVisibility(View.GONE);
            player4Red.setVisibility(View.GONE);
            player4RedDisabled.setVisibility(View.GONE);
            player4GreenFrame.setVisibility(View.GONE);
            player4Green.setVisibility(View.GONE);
            player4GreenDisabled.setVisibility(View.GONE);
            player4DarkBlueFrame.setVisibility(View.GONE);
            player4DarkBlue.setVisibility(View.GONE);
            player4DarkBlueDisabled.setVisibility(View.GONE);
            player4OrangeFrame.setVisibility(View.GONE);
            player4Orange.setVisibility(View.GONE);
            player4OrangeDisabled.setVisibility(View.GONE);
            player4PurpleFrame.setVisibility(View.GONE);
            player4Purple.setVisibility(View.GONE);
            player4PurpleDisabled.setVisibility(View.GONE);
            player4PinkFrame.setVisibility(View.GONE);
            player4Pink.setVisibility(View.GONE);
            player4PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player4.setVisibility(View.VISIBLE);
            player4Underline.setVisibility(View.VISIBLE);
            if (hideStart) {
                startGame.setVisibility(View.VISIBLE);
            }
        });

        //If Player 4 Chooses Purple
        player4Purple.setOnClickListener(view -> {
            //set the players color to purple
            player4Color.setBackgroundColor(Color.parseColor("#BA2CEC"));
            player4ColorId = Color.parseColor("#BA2CEC");
            player4ColorHex = "#BA2CEC";

            //make the color picker invisible again
            player4MainFrame.setVisibility(View.GONE);
            player4RedFrame.setVisibility(View.GONE);
            player4Red.setVisibility(View.GONE);
            player4RedDisabled.setVisibility(View.GONE);
            player4GreenFrame.setVisibility(View.GONE);
            player4Green.setVisibility(View.GONE);
            player4GreenDisabled.setVisibility(View.GONE);
            player4DarkBlueFrame.setVisibility(View.GONE);
            player4DarkBlue.setVisibility(View.GONE);
            player4DarkBlueDisabled.setVisibility(View.GONE);
            player4OrangeFrame.setVisibility(View.GONE);
            player4Orange.setVisibility(View.GONE);
            player4OrangeDisabled.setVisibility(View.GONE);
            player4PurpleFrame.setVisibility(View.GONE);
            player4Purple.setVisibility(View.GONE);
            player4PurpleDisabled.setVisibility(View.GONE);
            player4PinkFrame.setVisibility(View.GONE);
            player4Pink.setVisibility(View.GONE);
            player4PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player4.setVisibility(View.VISIBLE);
            player4Underline.setVisibility(View.VISIBLE);
            if (hideStart) {
                startGame.setVisibility(View.VISIBLE);
            }
        });

        //If Player 4 Chooses Pink
        player4Pink.setOnClickListener(view -> {
            //set the players color to pink
            player4Color.setBackgroundColor(Color.parseColor("#F137DF"));
            player4ColorId = Color.parseColor("#F137DF");
            player4ColorHex = "#F137DF";

            //make the color picker invisible again
            player4MainFrame.setVisibility(View.GONE);
            player4RedFrame.setVisibility(View.GONE);
            player4Red.setVisibility(View.GONE);
            player4RedDisabled.setVisibility(View.GONE);
            player4GreenFrame.setVisibility(View.GONE);
            player4Green.setVisibility(View.GONE);
            player4GreenDisabled.setVisibility(View.GONE);
            player4DarkBlueFrame.setVisibility(View.GONE);
            player4DarkBlue.setVisibility(View.GONE);
            player4DarkBlueDisabled.setVisibility(View.GONE);
            player4OrangeFrame.setVisibility(View.GONE);
            player4Orange.setVisibility(View.GONE);
            player4OrangeDisabled.setVisibility(View.GONE);
            player4PurpleFrame.setVisibility(View.GONE);
            player4Purple.setVisibility(View.GONE);
            player4PurpleDisabled.setVisibility(View.GONE);
            player4PinkFrame.setVisibility(View.GONE);
            player4Pink.setVisibility(View.GONE);
            player4PinkDisabled.setVisibility(View.GONE);

            //show the name inputs again
            player4.setVisibility(View.VISIBLE);
            player4Underline.setVisibility(View.VISIBLE);
            if (hideStart) {
                startGame.setVisibility(View.VISIBLE);
            }
        });

        //When the Start Game Button is pressed
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

                player2Input = player2.getText().toString();
                intent.putExtra("player2InputtedName", player2Input);

                //get the players colors
                Log.e("myTag", "Player 1 Color is " + player1ColorId);
                intent.putExtra("sendPlayer1Color", player1ColorId);

                Log.e("myTag", "Player 2 Color is " + player2ColorId);
                intent.putExtra("sendPlayer2Color", player2ColorId);

            }
            else if (selectedNumber.equals("3")) {
                //get the names of the 3 players
                player1Input = player1.getText().toString();
                intent.putExtra("player1InputtedName", player1Input);

                player2Input = player2.getText().toString();
                intent.putExtra("player2InputtedName", player2Input);


                player3Input = player3.getText().toString();
                intent.putExtra("player3InputtedName", player3Input);

                //get the players colors
                Log.e("myTag", "Player 1 Color is " + player1ColorId);
                intent.putExtra("sendPlayer1Color", player1ColorId);

                Log.e("myTag", "Player 2 Color is " + player2ColorId);
                intent.putExtra("sendPlayer2Color", player2ColorId);

                Log.e("myTag", "Player 3 Color is " + player3ColorId);
                intent.putExtra("sendPlayer3Color", player3ColorId);
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

                //get the players colors
                Log.e("myTag", "Player 1 Color is " + player1ColorId);
                intent.putExtra("sendPlayer1Color", player1ColorId);

                Log.e("myTag", "Player 2 Color is " + player2ColorId);
                intent.putExtra("sendPlayer2Color", player2ColorId);

                Log.e("myTag", "Player 3 Color is " + player3ColorId);
                intent.putExtra("sendPlayer3Color", player3ColorId);

                Log.e("myTag", "Player 4 Color is " + player4ColorId);
                intent.putExtra("sendPlayer4Color", player4ColorId);

            }

            //send the information and go to the game page
            startActivity(intent);
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String numberOfPlayers = parent.getItemAtPosition(position).toString();

        //Check to see how many players is currently selected
        if (numberOfPlayers.equals("2")) {

            hideThree = false;
            //reset player 3's Hex
            player3ColorHex = "";
            //reset player 4's Hex
            player4ColorHex = "";

            //have the first two players visible

            //Player 1 Name Input + Chosen Color
            player1.setVisibility(View.VISIBLE);
            player1ColorFrame.setVisibility(View.VISIBLE);
            player1Color.setVisibility(View.VISIBLE);

            //Player 1 Color Picker -- default visibility --> GONE
            player1MainFrame.setVisibility(View.GONE);
            player1RedFrame.setVisibility(View.GONE);
            player1Red.setVisibility(View.GONE);
            player1RedDisabled.setVisibility(View.GONE);
            player1GreenFrame.setVisibility(View.GONE);
            player1Green.setVisibility(View.GONE);
            player1GreenDisabled.setVisibility(View.GONE);
            player1DarkBlueFrame.setVisibility(View.GONE);
            player1DarkBlue.setVisibility(View.GONE);
            player1DarkBlueDisabled.setVisibility(View.GONE);
            player1OrangeFrame.setVisibility(View.GONE);
            player1Orange.setVisibility(View.GONE);
            player1OrangeDisabled.setVisibility(View.GONE);
            player1PurpleFrame.setVisibility(View.GONE);
            player1Purple.setVisibility(View.GONE);
            player1PurpleDisabled.setVisibility(View.GONE);
            player1PinkFrame.setVisibility(View.GONE);
            player1Pink.setVisibility(View.GONE);
            player1PinkDisabled.setVisibility(View.GONE);

            //Player 2 Name Input + Chosen Color
            player2.setVisibility(View.VISIBLE);
            player2ColorFrame.setVisibility(View.VISIBLE);
            player2Color.setVisibility(View.VISIBLE);

            //Player 2 Color Picker -- default visibility --> GONE
            player2MainFrame.setVisibility(View.GONE);
            player2RedFrame.setVisibility(View.GONE);
            player2Red.setVisibility(View.GONE);
            player2RedDisabled.setVisibility(View.GONE);
            player2GreenFrame.setVisibility(View.GONE);
            player2Green.setVisibility(View.GONE);
            player2GreenDisabled.setVisibility(View.GONE);
            player2DarkBlueFrame.setVisibility(View.GONE);
            player2DarkBlue.setVisibility(View.GONE);
            player2DarkBlueDisabled.setVisibility(View.GONE);
            player2OrangeFrame.setVisibility(View.GONE);
            player2Orange.setVisibility(View.GONE);
            player2OrangeDisabled.setVisibility(View.GONE);
            player2PurpleFrame.setVisibility(View.GONE);
            player2Purple.setVisibility(View.GONE);
            player2PurpleDisabled.setVisibility(View.GONE);
            player2PinkFrame.setVisibility(View.GONE);
            player2Pink.setVisibility(View.GONE);
            player2PinkDisabled.setVisibility(View.GONE);

            //Hide Player 3 & 4

            //Player 3 Name Inputs + Chosen Color
            player3.setVisibility(View.GONE);
            player3Underline.setVisibility(View.GONE);
            player3ColorFrame.setVisibility(View.GONE);
            player3Color.setVisibility(View.GONE);

            //Player 3 Color Picker
            player3MainFrame.setVisibility(View.GONE);
            player3RedFrame.setVisibility(View.GONE);
            player3Red.setVisibility(View.GONE);
            player3RedDisabled.setVisibility(View.GONE);
            player3GreenFrame.setVisibility(View.GONE);
            player3Green.setVisibility(View.GONE);
            player3GreenDisabled.setVisibility(View.GONE);
            player3DarkBlueFrame.setVisibility(View.GONE);
            player3DarkBlue.setVisibility(View.GONE);
            player3DarkBlueDisabled.setVisibility(View.GONE);
            player3OrangeFrame.setVisibility(View.GONE);
            player3Orange.setVisibility(View.GONE);
            player3OrangeDisabled.setVisibility(View.GONE);
            player3PurpleFrame.setVisibility(View.GONE);
            player3Purple.setVisibility(View.GONE);
            player3PurpleDisabled.setVisibility(View.GONE);
            player3PinkFrame.setVisibility(View.GONE);
            player3Pink.setVisibility(View.GONE);
            player3PinkDisabled.setVisibility(View.GONE);

            //Player 4 Name Inputs + Chosen Color
            player4.setVisibility(View.GONE);
            player4Underline.setVisibility(View.GONE);
            player4ColorFrame.setVisibility(View.GONE);
            player4Color.setVisibility(View.GONE);

            //Player 4 Color Picker
            player4MainFrame.setVisibility(View.GONE);
            player4RedFrame.setVisibility(View.GONE);
            player4Red.setVisibility(View.GONE);
            player4RedDisabled.setVisibility(View.GONE);
            player4GreenFrame.setVisibility(View.GONE);
            player4Green.setVisibility(View.GONE);
            player4GreenDisabled.setVisibility(View.GONE);
            player4DarkBlueFrame.setVisibility(View.GONE);
            player4DarkBlue.setVisibility(View.GONE);
            player4DarkBlueDisabled.setVisibility(View.GONE);
            player4OrangeFrame.setVisibility(View.GONE);
            player4Orange.setVisibility(View.GONE);
            player4OrangeDisabled.setVisibility(View.GONE);
            player4PurpleFrame.setVisibility(View.GONE);
            player4Purple.setVisibility(View.GONE);
            player4PurpleDisabled.setVisibility(View.GONE);
            player4PinkFrame.setVisibility(View.GONE);
            player4Pink.setVisibility(View.GONE);
            player4PinkDisabled.setVisibility(View.GONE);
        }
        else if (numberOfPlayers.equals("3")) {

            hideThree = true;
            hideFour = false;
            //reset player 4's Hex
            player4ColorHex = "";

            //have the three players visible
            player1.setVisibility(View.VISIBLE);
            player1Underline.setVisibility(View.VISIBLE);
            player1ColorFrame.setVisibility(View.VISIBLE);
            player1Color.setVisibility(View.VISIBLE);
            //Player 1 Color Picker -- default visibility --> GONE
            player1MainFrame.setVisibility(View.GONE);
            player1RedFrame.setVisibility(View.GONE);
            player1Red.setVisibility(View.GONE);
            player1RedDisabled.setVisibility(View.GONE);
            player1GreenFrame.setVisibility(View.GONE);
            player1Green.setVisibility(View.GONE);
            player1GreenDisabled.setVisibility(View.GONE);
            player1DarkBlueFrame.setVisibility(View.GONE);
            player1DarkBlue.setVisibility(View.GONE);
            player1DarkBlueDisabled.setVisibility(View.GONE);
            player1OrangeFrame.setVisibility(View.GONE);
            player1Orange.setVisibility(View.GONE);
            player1OrangeDisabled.setVisibility(View.GONE);
            player1PurpleFrame.setVisibility(View.GONE);
            player1Purple.setVisibility(View.GONE);
            player1PurpleDisabled.setVisibility(View.GONE);
            player1PinkFrame.setVisibility(View.GONE);
            player1Pink.setVisibility(View.GONE);
            player1PinkDisabled.setVisibility(View.GONE);

            player2.setVisibility(View.VISIBLE);
            player2Underline.setVisibility(View.VISIBLE);
            player2ColorFrame.setVisibility(View.VISIBLE);
            player2Color.setVisibility(View.VISIBLE);
            //Player 2 Color Picker -- default visibility --> GONE
            player2MainFrame.setVisibility(View.GONE);
            player2RedFrame.setVisibility(View.GONE);
            player2Red.setVisibility(View.GONE);
            player2RedDisabled.setVisibility(View.GONE);
            player2GreenFrame.setVisibility(View.GONE);
            player2Green.setVisibility(View.GONE);
            player2GreenDisabled.setVisibility(View.GONE);
            player2DarkBlueFrame.setVisibility(View.GONE);
            player2DarkBlue.setVisibility(View.GONE);
            player2DarkBlueDisabled.setVisibility(View.GONE);
            player2OrangeFrame.setVisibility(View.GONE);
            player2Orange.setVisibility(View.GONE);
            player2OrangeDisabled.setVisibility(View.GONE);
            player2PurpleFrame.setVisibility(View.GONE);
            player2Purple.setVisibility(View.GONE);
            player2PurpleDisabled.setVisibility(View.GONE);
            player2PinkFrame.setVisibility(View.GONE);
            player2Pink.setVisibility(View.GONE);
            player2PinkDisabled.setVisibility(View.GONE);

            player3.setVisibility(View.VISIBLE);
            player3Underline.setVisibility(View.VISIBLE);
            player3ColorFrame.setVisibility(View.VISIBLE);
            player3Color.setVisibility(View.VISIBLE);
            player3Color.setBackgroundResource(R.drawable.empty_color_button);


            //hide player 4
            player4.setVisibility(View.GONE);
            player4Underline.setVisibility(View.GONE);
            player4ColorFrame.setVisibility(View.GONE);
            player4Color.setVisibility(View.GONE);
        }
        else {

            hideThree = true;
            hideFour = true;
            hideStart = true;

            //have everything be visible
            player1.setVisibility(View.VISIBLE);
            player1ColorFrame.setVisibility(View.VISIBLE);
            player1Color.setVisibility(View.VISIBLE);
            //Player 1 Color Picker -- default visibility --> GONE
            player1MainFrame.setVisibility(View.GONE);
            player1RedFrame.setVisibility(View.GONE);
            player1Red.setVisibility(View.GONE);
            player1RedDisabled.setVisibility(View.GONE);
            player1GreenFrame.setVisibility(View.GONE);
            player1Green.setVisibility(View.GONE);
            player1GreenDisabled.setVisibility(View.GONE);
            player1DarkBlueFrame.setVisibility(View.GONE);
            player1DarkBlue.setVisibility(View.GONE);
            player1DarkBlueDisabled.setVisibility(View.GONE);
            player1OrangeFrame.setVisibility(View.GONE);
            player1Orange.setVisibility(View.GONE);
            player1OrangeDisabled.setVisibility(View.GONE);
            player1PurpleFrame.setVisibility(View.GONE);
            player1Purple.setVisibility(View.GONE);
            player1PurpleDisabled.setVisibility(View.GONE);
            player1PinkFrame.setVisibility(View.GONE);
            player1Pink.setVisibility(View.GONE);
            player1PinkDisabled.setVisibility(View.GONE);

            player2.setVisibility(View.VISIBLE);
            player2ColorFrame.setVisibility(View.VISIBLE);
            player2Color.setVisibility(View.VISIBLE);
            //Player 2 Color Picker -- default visibility --> GONE
            player2MainFrame.setVisibility(View.GONE);
            player2RedFrame.setVisibility(View.GONE);
            player2Red.setVisibility(View.GONE);
            player2RedDisabled.setVisibility(View.GONE);
            player2GreenFrame.setVisibility(View.GONE);
            player2Green.setVisibility(View.GONE);
            player2GreenDisabled.setVisibility(View.GONE);
            player2DarkBlueFrame.setVisibility(View.GONE);
            player2DarkBlue.setVisibility(View.GONE);
            player2DarkBlueDisabled.setVisibility(View.GONE);
            player2OrangeFrame.setVisibility(View.GONE);
            player2Orange.setVisibility(View.GONE);
            player2OrangeDisabled.setVisibility(View.GONE);
            player2PurpleFrame.setVisibility(View.GONE);
            player2Purple.setVisibility(View.GONE);
            player2PurpleDisabled.setVisibility(View.GONE);
            player2PinkFrame.setVisibility(View.GONE);
            player2Pink.setVisibility(View.GONE);
            player2PinkDisabled.setVisibility(View.GONE);

            player3.setVisibility(View.VISIBLE);
            player3Underline.setVisibility(View.VISIBLE);
            player3ColorFrame.setVisibility(View.VISIBLE);
            player3Color.setVisibility(View.VISIBLE);
            //Player 3 Color Picker
            player3MainFrame.setVisibility(View.GONE);
            player3RedFrame.setVisibility(View.GONE);
            player3Red.setVisibility(View.GONE);
            player3RedDisabled.setVisibility(View.GONE);
            player3GreenFrame.setVisibility(View.GONE);
            player3Green.setVisibility(View.GONE);
            player3GreenDisabled.setVisibility(View.GONE);
            player3DarkBlueFrame.setVisibility(View.GONE);
            player3DarkBlue.setVisibility(View.GONE);
            player3DarkBlueDisabled.setVisibility(View.GONE);
            player3OrangeFrame.setVisibility(View.GONE);
            player3Orange.setVisibility(View.GONE);
            player3OrangeDisabled.setVisibility(View.GONE);
            player3PurpleFrame.setVisibility(View.GONE);
            player3Purple.setVisibility(View.GONE);
            player3PurpleDisabled.setVisibility(View.GONE);
            player3PinkFrame.setVisibility(View.GONE);
            player3Pink.setVisibility(View.GONE);
            player3PinkDisabled.setVisibility(View.GONE);

            player4.setVisibility(View.VISIBLE);
            player4Underline.setVisibility(View.VISIBLE);
            player4ColorFrame.setVisibility(View.VISIBLE);
            player4Color.setVisibility(View.VISIBLE);
            player4Color.setBackgroundResource(R.drawable.empty_color_button);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

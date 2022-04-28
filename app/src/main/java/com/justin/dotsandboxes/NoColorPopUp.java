package com.justin.dotsandboxes;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Objects;

public class NoColorPopUp extends DialogFragment {

    public static String TAG = "NoColorPopUp";

    String player1NoColorName = "";
    String player2NoColorName = "";
    String player3NoColorName = "";
    String player4NoColorName = "";

    int numNoColor = 0;

    ArrayList<String> passedPlayerName = new ArrayList<String>();
    Button dismissButton;

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nocolor_popup_window, container, false);

        Bundle getNames = getArguments();
        if (getNames != null) {

            player1NoColorName = getNames.getString("player1", "");
            if (!player1NoColorName.equals("")) {
                passedPlayerName.add(player1NoColorName);
                numNoColor++;
                Log.e("myTag", "Player 1 didn't put in a color");

            }

            player2NoColorName = getNames.getString("player2", "");
                if (!player2NoColorName.equals("")) {
                    passedPlayerName.add(player2NoColorName);
                    numNoColor++;
                    Log.e("myTag", "Player 2 didn't put in a color");
                }
            player3NoColorName = getNames.getString("player3", "");
                if (!player3NoColorName.equals("")) {
                    passedPlayerName.add(player3NoColorName);
                    numNoColor++;
                    Log.e("myTag", "Player 3 didn't put in a color");
                }
            player4NoColorName = getNames.getString("player4", "");
                if (!player4NoColorName.equals("")) {
                    passedPlayerName.add(player4NoColorName);
                    numNoColor++;
                    Log.e("myTag", "Player 4 didn't put in a color");
                }
        }

        String noColorNames = "";
        int i;
        for (i = 0; i < passedPlayerName.size(); i++) {

            if (numNoColor == 1) {
                noColorNames = passedPlayerName.get(i);
            }

            if (numNoColor == 2) {
                if (i == 0) {
                    noColorNames = passedPlayerName.get(i);
                }

                if (i == 1) {
                    noColorNames = noColorNames + " and " + passedPlayerName.get(i);
                }
            }

            if (numNoColor == 3) {
                if (i == 0) {
                    noColorNames = passedPlayerName.get(i);
                }

                if (i == 1) {
                    noColorNames = noColorNames + ", " + passedPlayerName.get(i);
                }

                if (i == 2) {
                    noColorNames = noColorNames + " and " + passedPlayerName.get(i);
                }
            }


            if (numNoColor == 4) {
                if (i == 0) {
                    noColorNames = passedPlayerName.get(i);
                }

                if (i == 1 || i == 2) {
                    noColorNames = noColorNames + ", " + passedPlayerName.get(i);
                }

                if (i == 3) {
                    noColorNames = noColorNames + " and " + passedPlayerName.get(i);
                }
            }
        }
        TextView pluralCheck = view.findViewById(R.id.noColorText);
        if (numNoColor == 1) {
            String setNewText = "Needs to Enter a Color!";
            pluralCheck.setText(setNewText);
        }
        TextView showNames = view.findViewById(R.id.noColorPlayer);
        showNames.setText(noColorNames);
        Log.e("myTag", "showName TextView value is " + noColorNames);

        dismissButton = view.findViewById(R.id.dismiss_button);


        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }
}
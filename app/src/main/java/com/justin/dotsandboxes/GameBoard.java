package com.justin.dotsandboxes;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;


public class GameBoard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_board);
        LinearLayout layout = new LinearLayout(this);
        TableLayout game_board = new TableLayout(this);
        int rows = 10;
        int columns = 12;
        for(int i = 0; i < rows; i++){
            LinearLayout tableRow = new LinearLayout(this);
            for(int j = 0; j < columns; j++){
                ImageView node = new ImageView(this);
                node.setImageResource(R.drawable.board_node);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(50, 50);
                lp.setMargins(20, 20, 20, 20);

                node.setLayoutParams(lp);
                tableRow.addView(node);

            }
            game_board.addView(tableRow);
        }
        layout.addView(game_board);
        setContentView(layout);



    }
}
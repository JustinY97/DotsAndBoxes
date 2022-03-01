package com.justin.dotsandboxes;
import android.annotation.SuppressLint;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;


public class GameBoard extends AppCompatActivity {


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_board);
        LinearLayout layout = new LinearLayout(this);
        TableLayout game_board = new TableLayout(this);
        int rows = 10;
        int columns = 12;
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
        layout.addView(game_board);
        setContentView(layout);



    }
}
package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0-circle, 1-cross, 2-empty

    int[] gamestate = {2,2,2,2,2,2,2,2,2};

    int[] [] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    int activePlayer = 0;

    boolean gameActive = true ;

    boolean tie = false;

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gamestate[tappedCounter]==2 && gameActive== true) {

            gamestate[tappedCounter] = activePlayer;

            counter.setTranslationY(-1500);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.circle);
                activePlayer = 1;

            } else {

                counter.setImageResource(R.drawable.cross);

                activePlayer = 0;
            }


            counter.animate().translationYBy(1500).setDuration(1000);

            if (gamestate[0]!=2 && gamestate[1]!=2 && gamestate[2]!=2 && gamestate[3]!=2 && gamestate[4]!=2 && gamestate[5]!=2 && gamestate[6]!=2 && gamestate[7]!=2 && gamestate[8]!=2){
                tie=true;
            }

            for (int[] winningPosition : winningPositions) {
                if (gamestate[winningPosition[0]] == gamestate[winningPosition[1]] && gamestate[winningPosition[1]] == gamestate[winningPosition[2]] && gamestate[winningPosition[0]] != 2) {

                    String winner = "";

                    tie = false;

                    if (activePlayer == 1) {
                        winner = "circle";
                    }
                    else {
                        winner = "cross";
                    }
                    gameActive = false;

                    Button playAgainButton = (Button) findViewById(R.id.playagainbutton);

                    TextView winnerTextView = (TextView) findViewById(R.id.textView2);
                    winnerTextView.setText(winner + " has won");

                    playAgainButton.setVisibility(View.VISIBLE);

                    winnerTextView.setVisibility(View.VISIBLE);

                }

            }
            if (tie==true){
                gameActive = false;

                Button playAgainButton = (Button) findViewById(R.id.playagainbutton);

                TextView winnerTextView = (TextView) findViewById(R.id.textView2);
                winnerTextView.setText("no one has won");

                playAgainButton.setVisibility(View.VISIBLE);

                winnerTextView.setVisibility(View.VISIBLE);
            }
        }
    }
    public void playAgain(View view) {

        Button playAgainButton = (Button) findViewById(R.id.playagainbutton);

        TextView winnerTextView = (TextView) findViewById(R.id.textView2);

        playAgainButton.setVisibility(View.INVISIBLE);

        winnerTextView.setVisibility(View.INVISIBLE);

        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);
        ImageView imageView6 = (ImageView) findViewById(R.id.imageView6);
        ImageView imageView7 = (ImageView) findViewById(R.id.imageView7);
        ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
        ImageView imageView9 = (ImageView) findViewById(R.id.imageView9);


        imageView1.setImageDrawable(null);
        imageView2.setImageDrawable(null);
        imageView3.setImageDrawable(null);
        imageView4.setImageDrawable(null);
        imageView5.setImageDrawable(null);
        imageView6.setImageDrawable(null);
        imageView7.setImageDrawable(null);
        imageView8.setImageDrawable(null);
        imageView9.setImageDrawable(null);




        for (int i=0; i<gamestate.length; i++){

            gamestate[i] = 2;

        }


        activePlayer = 0;

        gameActive = true ;

        tie = false;



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
package sg.edu.np.WhackAMole;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.util.Random;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button ButtonLeft;
    private Button ButtonMiddle;
    private Button ButtonRight;
    private static final String TAG = "Whack-A-Mole!";
    private int score = 0;

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView Score = (TextView) findViewById(R.id.score);

        ButtonLeft = (Button) findViewById(R.id.ButtonLeft);
        ButtonMiddle = (Button) findViewById(R.id.ButtonMiddle);
        ButtonRight = (Button) findViewById(R.id.ButtonRight);

        ButtonLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(TAG,"Button Left Clicked!");
                if (ButtonLeft.getText() == "*"){
                    Log.v(TAG,"Hit, score added!");
                    score += 1;
                    Score.setText(Integer.toString(score));
                } else {
                    Log.v(TAG,"Miss, score deducted!");
                    score -= 1;
                    Score.setText(Integer.toString(score));
                }
                ButtonLeft.setText("O");
                ButtonMiddle.setText("O");
                ButtonRight.setText("O");
                setNewMole();
            }
        });

        ButtonMiddle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(TAG,"Button Middle Clicked!");
                if (ButtonMiddle.getText() == "*"){
                    Log.v(TAG,"Hit, score added!");
                    score += 1;
                    Score.setText(Integer.toString(score));
                } else {
                    Log.v(TAG,"Miss, score deducted!");
                    score -= 1;
                    Score.setText(Integer.toString(score));
                }
                ButtonLeft.setText("O");
                ButtonMiddle.setText("O");
                ButtonRight.setText("O");
                setNewMole();
            }
        });

        ButtonRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(TAG,"Button Right Clicked!");
                if (ButtonRight.getText() == "*"){
                    Log.v(TAG,"Hit, score added!");
                    score += 1;
                    Score.setText(Integer.toString(score));
                } else {
                    Log.v(TAG,"Miss, score deducted!");
                    score -= 1;
                    Score.setText(Integer.toString(score));
                }
                ButtonLeft.setText("O");
                ButtonMiddle.setText("O");
                ButtonRight.setText("O");
                setNewMole();
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Allocating mole!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG, "Pausing Whack-A-Mole!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TAG, "Resuming Whack-A-Mole!");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.v(TAG, "Restarting Whack-A-Mole!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "Stopping Whack-A-Mole!");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TAG, "Destroying Whack-A-Mole!");
    }

    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        if (randomLocation == 0){
            Button button = (Button)findViewById(R.id.ButtonLeft);
            button.setText("*");
        } else if (randomLocation == 1){
            Button button = (Button)findViewById(R.id.ButtonMiddle);
            button.setText("*");
        } else{
            Button button = (Button)findViewById(R.id.ButtonRight);
            button.setText("*");
        }
    }
}

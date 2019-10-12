package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {
    //setting up seek bar and text view strings
    private SeekBar seekBar;
    private TextView resultID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find and referencing the seek bar and view strings
        resultID = (TextView) findViewById(R.id.resultID);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        //setting up a result before bar is move
        resultID.setText("Pain Level:" +seekBar.getProgress() + "/" + seekBar.getMax());
        //Programming the seek bar to make it move
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //setting up a permanent color for seek bar result
                resultID.setTextColor(Color.DKGRAY);

                //setting up a result for when the seek bar is moved
                resultID.setText("Pain Level:" +seekBar.getProgress() + "/" + seekBar.getMax());
                Log.d("SB","Onprogress");


                }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("SB","OnStartTracking");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("SB","OnStop!");

                //if statement to change seek bar color from grey to red if progress is 7 or greater.
                if (seekBar.getProgress() >= 7) {
                    resultID.setTextColor(RED);
                }

            }
        });





    }
}

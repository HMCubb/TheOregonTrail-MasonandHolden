package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This is the WinScreen class.
 * This class displays to the user that they have won the game.
 *
 * @author Mason Muether and Holden Cubberley
 * @version 5/9/2023
 */
public class WinScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);

        configurePlayAgainButton();
    }

    public void configurePlayAgainButton() {

        Button playAgain = findViewById(R.id.playAgainButton2);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(WinScreen.this, MainActivity.class);

                WinScreen.this.startActivity(myIntent);
            }
        });


    }
}
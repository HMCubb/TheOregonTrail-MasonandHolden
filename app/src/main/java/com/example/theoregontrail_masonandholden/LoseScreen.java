package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * This is the LoseScreen class.
 * This class displays to the user that they have lost the game.
 *
 * @author Mason Muether and Holden Cubberley
 * @version 5/9/2023
 */
public class LoseScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose_screen);
    }
}
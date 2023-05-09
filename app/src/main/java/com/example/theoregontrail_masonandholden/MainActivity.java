package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final TextView loreText = findViewById(R.id.loreTextMain);
        loreText.setText("You are Hattie Campbell, a 13 year old girl who is about to embark on the Oregon Trail. Along with you are your parents Charles and Augusta, as well as your younger brothers Ben and Jake. You and your family are sick of the horrible living conditions in their current home in Independence, Missouri. There are high taxes, deadly diseases, and crowded farmlands. After losing four of your sisters last year, you and your family have sold everything and are ready to make this difficult journey out west.");

        configureStartButton();
    }


    private void configureStartButton() {

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Wagon wagon = new Wagon (5, 865.00, 0,0,0,0,0,0, 4, false, false, false, false, false, false);
                Entity Hattie = new Entity( "Hattie",false, false, false);
                Entity Charles = new Entity ("Charles",false, false, false);
                Entity Augusta = new Entity("Augusta",false, false, false);
                Entity Ben = new Entity ("Ben",false, false, false);
                Entity Jake = new Entity ( "Jake",false, false, false);
                DateAndDistance dateAndDistance = new DateAndDistance(0,1, 0, 0, 4, 1847, 20, 1, false, false, false, false,false,false,false,false,false);
                GeneralHealth health = new GeneralHealth(0.0, 0);
                Weather weather = new Weather(0,0);

                Intent intent = new Intent(MainActivity.this, Store.class);

                intent.putExtra("NewWeather", weather).putExtra("NewGeneralHealth", health).putExtra("NewWagon", wagon).putExtra("NewDateAndDistance", dateAndDistance).putExtra("NewHattie", Hattie).putExtra("NewCharles", Charles).putExtra("NewAugusta", Augusta).putExtra("NewBen", Ben).putExtra("NewJake", Jake);

                setContentView(R.layout.activity_store);
                startActivity(new Intent(MainActivity.this, Store.class));
                startActivity(intent);
            }
        });
    }

}


package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    Entity Hattie = new Entity( "Hattie",false, false, false);
    Entity Charles = new Entity ("Charles",false, false, false);
    Entity Augusta = new Entity("Augusta",false, false, false);
    Entity Ben = new Entity ("Ben",false, false, false);
    Entity Jake = new Entity ( "Jake",false, false, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureStartButton();
    }


    private void configureStartButton() {

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Store store = new Store();
                Wagon wagon = new Wagon(0,0.00,0,0,0,0,0,0);
                Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);

                Intent intent = new Intent(MainActivity.this, Store.class);

                intent.putExtra("NewWagon", wagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                startActivity(intent);
                setContentView(R.layout.activity_store);
                startActivity(new Intent(MainActivity.this, Store.class));
            }
        });
    }

}


package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class dailyEvents extends AppCompatActivity {

    public RandomEvents newRandomEvents;
    public Entity Hattie;
    public Entity Charles;
    public Entity Augusta;
    public Entity Ben;
    public Entity Jake;
    public DateAndDistance dateAndDistance;
    public Wagon wagon;

    public dailyEvents(){}
    public dailyEvents(Wagon wagon, DateAndDistance dateAndDistance, RandomEvents newRandomEvents, Entity newHattie, Entity newCharles, Entity newAugusta, Entity newBen, Entity newJake){
        this.dateAndDistance = dateAndDistance;
        this.newRandomEvents = newRandomEvents;
        this.Hattie = newHattie;
        this.Charles = newCharles;
        this.Augusta = newAugusta;
        this.Ben = newBen;
        this.Jake = newJake;
        this.wagon = wagon;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_events);

        newRandomEvents = (RandomEvents) getIntent().getSerializableExtra("NewRandomEvents");
        Hattie = (Entity) getIntent().getSerializableExtra("NewHattie");
        Charles = (Entity) getIntent().getSerializableExtra("NewCharles");
        Augusta = (Entity) getIntent().getSerializableExtra("NewAugusta");
        Ben = (Entity) getIntent().getSerializableExtra("NewBen");
        Jake = (Entity) getIntent().getSerializableExtra("NewJake");
        dateAndDistance = (DateAndDistance) getIntent().getSerializableExtra("NewDateAndDistance");
        wagon = (Wagon) getIntent().getSerializableExtra("NewWagon");

        EditText eventText = findViewById(R.id.eventText);
        eventText.setText(String.valueOf(newRandomEvents.lostMember));

        configureNextButton();
    }

    private void configureNextButton() {


        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                Intent intent = new Intent(dailyEvents.this, DailyStatus.class);

                intent.putExtra("NewWagon", newWagon).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                setContentView(R.layout.activity_daily_status);
                startActivity(new Intent(dailyEvents.this, DailyStatus.class));
                startActivity(intent);
            }
        });
    }

}
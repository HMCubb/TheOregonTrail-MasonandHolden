package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaceAndRationsPage extends AppCompatActivity {

    public RandomEvents randomEvents;
    public Entity Hattie;
    public Entity Charles;
    public Entity Augusta;
    public Entity Ben;
    public Entity Jake;
    public Wagon storeWagon;
    public DateAndDistance dateAndDistance;
    private int rationsNumber = 0;
    private int paceNumber = 0;

    public PaceAndRationsPage(){}

    public PaceAndRationsPage(DateAndDistance dateAndDistance, RandomEvents randomEvents, Entity newHattie, Entity newCharles, Entity newAugusta, Entity newBen, Entity newJake, Wagon wagon){
        this.Hattie = newHattie;
        this.Charles = newCharles;
        this.Augusta = newAugusta;
        this.Ben = newBen;
        this.Jake = newJake;
        this.storeWagon = wagon;
        this.randomEvents = randomEvents;
        this.dateAndDistance = dateAndDistance;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_and_rations_page);

        Hattie = (Entity) getIntent().getSerializableExtra("NewHattie");
        Charles = (Entity) getIntent().getSerializableExtra("NewCharles");
        Augusta = (Entity) getIntent().getSerializableExtra("NewAugusta");
        Ben = (Entity) getIntent().getSerializableExtra("NewBen");
        Jake = (Entity) getIntent().getSerializableExtra("NewJake");
        storeWagon = (Wagon) getIntent().getSerializableExtra("NewWagon");
        randomEvents = (RandomEvents) getIntent().getSerializableExtra("NewRandomEvents");
        dateAndDistance = (DateAndDistance) getIntent().getSerializableExtra("NewDateAndDistance");

        configurePaceUpButton();
        configurePaceDownButton();
        configureRationsUpButton();
        configureRationsDownButton();
        configureBackButton();

        paceNumber = dateAndDistance.pace;
        rationsNumber = storeWagon.getRations();

        EditText rationsValue = findViewById(R.id.rationsValue);
        EditText paceValue = findViewById(R.id.paceValue);
        paceValue.setText(String.valueOf(paceNumber));
        rationsValue.setText(String.valueOf(rationsNumber));


    }

    private void configureBackButton() {

        Button continueButton = (Button) findViewById(R.id.backButtonPAR);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.tongueBroke, randomEvents.wheelBroke, randomEvents.axelBroke, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                Wagon newWagon = new Wagon(storeWagon.people, storeWagon.money, storeWagon.oxen, storeWagon.food, storeWagon.clothes, storeWagon.tongues, storeWagon.axles, storeWagon.wheels, storeWagon.rations, storeWagon.brokenTongue, storeWagon.brokenWheel, storeWagon.brokenAxel, storeWagon.repairTongue, storeWagon.repairWheel, storeWagon.repairAxel);
                Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);


                Intent intent = new Intent(PaceAndRationsPage.this, LocationPage.class);

                intent.putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                setContentView(R.layout.activity_location_page);
                startActivity(new Intent(PaceAndRationsPage.this, LocationPage.class));
                startActivity(intent);
            }
        });
    }

    private void configurePaceUpButton() {

        Button paceUp = findViewById(R.id.paceUpButton);
        EditText paceValue = findViewById(R.id.paceValue);
        paceUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (dateAndDistance.pace >= 1 && dateAndDistance.pace < 3) {

                    dateAndDistance.paceUp();
                    paceNumber = paceNumber++;
                    paceValue.setText(String.valueOf(dateAndDistance.pace));
                }
            }
        });
    }

    private void configurePaceDownButton() {

        Button paceUp = findViewById(R.id.paceDownButton);
        EditText paceValue = findViewById(R.id.paceValue);
        paceUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (dateAndDistance.pace > 1 && dateAndDistance.pace <= 3) {

                    dateAndDistance.paceDown();
                    paceNumber = paceNumber--;
                    paceValue.setText(String.valueOf(dateAndDistance.pace));
                }
            }
        });
    }

    private void configureRationsUpButton() {

        Button paceUp = findViewById(R.id.rationsUpButton);
        EditText rationsValue = findViewById(R.id.rationsValue);
        paceUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getRations() >= 1 && storeWagon.getRations() < 5) {

                    rationsNumber++;
                    storeWagon.rationsUp();
                    rationsValue.setText(String.valueOf(storeWagon.rations));
                }
            }
        });
    }

    private void configureRationsDownButton() {

        Button paceUp = findViewById(R.id.rationsDownButton);
        EditText rationsValue = findViewById(R.id.rationsValue);
        paceUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getRations() > 1 && storeWagon.getRations() <= 5) {

                    rationsNumber--;
                    storeWagon.rationsDown();
                    rationsValue.setText(String.valueOf(storeWagon.rations));
                }
            }
        });
    }
}
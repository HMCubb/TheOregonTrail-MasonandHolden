package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;
import java.util.Random;

public class LocationPage extends AppCompatActivity {

    public RandomEvents locationRandoms;
    public Entity locationHattie;
    public Entity locationCharles;
    public Entity locationAugusta;
    public Entity locationBen;
    public Entity locationJake;
    public Wagon locationWagon;
    public DateAndDistance dateAndDistance;
    public LocationPage(){};
    
    public LocationPage(RandomEvents randomEvents, DateAndDistance dateAndDistance, RandomEvents locationRandoms, Entity locationHattie, Entity locationCharles, Entity locationAugusta, Entity locationBen, Entity locationJake, Wagon locationWagon){

        this.locationRandoms = randomEvents;
        this.dateAndDistance = dateAndDistance;
        this.locationRandoms = locationRandoms;
        this.locationHattie = locationHattie;
        this.locationCharles = locationCharles;
        this.locationBen = locationBen;
        this.locationJake = locationJake;
        this.locationWagon = locationWagon;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_page);

        locationRandoms = (RandomEvents) getIntent().getSerializableExtra("NewRandomEvents");
        locationHattie = (Entity) getIntent().getSerializableExtra("NewHattie");
        locationCharles = (Entity) getIntent().getSerializableExtra("NewCharles");
        locationAugusta = (Entity) getIntent().getSerializableExtra("NewAugusta");
        locationBen = (Entity) getIntent().getSerializableExtra("NewBen");
        locationJake = (Entity) getIntent().getSerializableExtra("NewJake");
        locationWagon = (Wagon) getIntent().getSerializableExtra("NewWagon");
        dateAndDistance = (DateAndDistance) getIntent().getSerializableExtra("NewDateAndDistance");
        
        configureMapButton();
        configureResourcesButton();
        configurePartyButton();
        configureShopButton();
        configureNextLocationButton();
    }

    private void configureMapButton() {

        Button continueButton = (Button) findViewById(R.id.mapButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Take user to a map screen with a dot or star on the location in which they are currently at.
            }
        });
    }

    private void configureResourcesButton() {

        Button continueButton = (Button) findViewById(R.id.resourcesButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Show user their current resources (wagon)
            }
        });
    }

    private void configurePartyButton() {

        Button continueButton = (Button) findViewById(R.id.partyButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RandomEvents newRandomEvents = new RandomEvents(locationRandoms.disease, locationRandoms.badWater, locationRandoms.lowWater, locationRandoms.roughTrail, locationRandoms.blizzard, locationRandoms.fog, locationRandoms.hail, locationRandoms.oxenDamage, locationRandoms.injury, locationRandoms.snakeBite, locationRandoms.loseTrail, locationRandoms.thief, locationRandoms.blockedTrail, locationRandoms.fire, locationRandoms.abandonedWagon, locationRandoms.oxenWandered, locationRandoms.lostMember, locationRandoms.badGrass, locationRandoms.fruit, locationRandoms.healedDisease, locationRandoms.healedInjury, locationRandoms.tongueBroke, locationRandoms.wheelBroke, locationRandoms.axelBroke, locationRandoms.daysLost, locationRandoms.foodLost, locationRandoms.clothesLost, locationRandoms.axlesLost, locationRandoms.wheelsLost, locationRandoms.wheelsLost, locationRandoms.memberLost);
                Entity newHattie = new Entity(locationHattie.name, locationHattie.sick, locationHattie.injured, locationHattie.dead);
                Entity newCharles = new Entity (locationCharles.name, locationCharles.sick, locationCharles.injured, locationCharles.dead);
                Entity newAugusta = new Entity(locationAugusta.name, locationAugusta.sick, locationAugusta.injured, locationAugusta.dead);
                Entity newBen = new Entity (locationBen.name, locationBen.sick, locationBen.injured, locationBen.dead);
                Entity newJake = new Entity(locationJake.name, locationJake.sick, locationJake.injured, locationJake.dead);
                Wagon newWagon = new Wagon(locationWagon.people, locationWagon.money, locationWagon.oxen, locationWagon.food, locationWagon.clothes, locationWagon.tongues, locationWagon.axles, locationWagon.wheels, locationWagon.rations, locationWagon.brokenTongue, locationWagon.brokenWheel, locationWagon.brokenAxel, locationWagon.repairTongue, locationWagon.repairWheel, locationWagon.repairAxel);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                Intent intent = new Intent(LocationPage.this, PaceAndRationsPage.class);

                intent.putExtra("NewRandomEvents", newRandomEvents).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake).putExtra("NewDateAndDistance", newDateAndDistance);
                setContentView(R.layout.activity_pace_and_rations_page);
                startActivity(new Intent(LocationPage.this, PaceAndRationsPage.class));
                startActivity(intent);
            }
        });
    }

    private void configureShopButton() {

        Button continueButton = (Button) findViewById(R.id.shopButton);
        continueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                RandomEvents newRandomEvents = new RandomEvents(locationRandoms.disease, locationRandoms.badWater, locationRandoms.lowWater, locationRandoms.roughTrail, locationRandoms.blizzard, locationRandoms.fog, locationRandoms.hail, locationRandoms.oxenDamage, locationRandoms.injury, locationRandoms.snakeBite, locationRandoms.loseTrail, locationRandoms.thief, locationRandoms.blockedTrail, locationRandoms.fire, locationRandoms.abandonedWagon, locationRandoms.oxenWandered, locationRandoms.lostMember, locationRandoms.badGrass, locationRandoms.fruit, locationRandoms.healedDisease, locationRandoms.healedInjury, locationRandoms.tongueBroke, locationRandoms.wheelBroke, locationRandoms.axelBroke, locationRandoms.daysLost, locationRandoms.foodLost, locationRandoms.clothesLost, locationRandoms.axlesLost, locationRandoms.wheelsLost, locationRandoms.wheelsLost, locationRandoms.memberLost);
                Entity newHattie = new Entity(locationHattie.name, locationHattie.sick, locationHattie.injured, locationHattie.dead);
                Entity newCharles = new Entity (locationCharles.name, locationCharles.sick, locationCharles.injured, locationCharles.dead);
                Entity newAugusta = new Entity(locationAugusta.name, locationAugusta.sick, locationAugusta.injured, locationAugusta.dead);
                Entity newBen = new Entity (locationBen.name, locationBen.sick, locationBen.injured, locationBen.dead);
                Entity newJake = new Entity(locationJake.name, locationJake.sick, locationJake.injured, locationJake.dead);
                Wagon newWagon = new Wagon(locationWagon.people, locationWagon.money, locationWagon.oxen, locationWagon.food, locationWagon.clothes, locationWagon.tongues, locationWagon.axles, locationWagon.wheels, locationWagon.rations, locationWagon.brokenTongue, locationWagon.brokenWheel, locationWagon.brokenAxel, locationWagon.repairTongue, locationWagon.repairWheel, locationWagon.repairAxel);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                Intent intent = new Intent(LocationPage.this, LocationStore.class);

                intent.putExtra("NewRandomEvents", newRandomEvents).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake).putExtra("NewDateAndDistance", newDateAndDistance);
                setContentView(R.layout.activity_location_store);
                startActivity(new Intent(LocationPage.this, LocationStore.class));
                startActivity(intent);
            }
        });
    }

    private void configureNextLocationButton() {

        Button continueButton = (Button) findViewById(R.id.nextButtonLocationButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
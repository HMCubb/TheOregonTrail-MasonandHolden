package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;

/**
 * The LocationPage class displays the map with all locations along the Oregon Trail, as well as a menu with several buttons.
 * @filename OregonTrailMasonandHolden
 * @author Holden Cubberley & Mason Muether
 * @date 5/9/2023
 */
public class LocationPage extends AppCompatActivity {

    // Public value initialization.
    public RandomEvents locationRandoms;
    public Entity locationHattie;
    public Entity locationCharles;
    public Entity locationAugusta;
    public Entity locationBen;
    public Entity locationJake;
    public Wagon locationWagon;
    public DateAndDistance dateAndDistance;
    public Weather newWeather;
    public GeneralHealth newHealth;
    public LocationPage(){};

    // Package with all values that this class intakes from serializable values (more for completeness).
    public LocationPage(Weather weather, GeneralHealth health, RandomEvents randomEvents, DateAndDistance dateAndDistance, RandomEvents locationRandoms, Entity locationHattie, Entity locationCharles, Entity locationAugusta, Entity locationBen, Entity locationJake, Wagon locationWagon){

        this.locationRandoms = randomEvents;
        this.dateAndDistance = dateAndDistance;
        this.locationRandoms = locationRandoms;
        this.locationHattie = locationHattie;
        this.locationCharles = locationCharles;
        this.locationBen = locationBen;
        this.locationJake = locationJake;
        this.locationWagon = locationWagon;
        this.newWeather = weather;
        this.newHealth = health;
    }

    /**
     * onCreate
     * When the program is initially ran, all of the serializable elements within this method are established.
     * The menu button classes are initialized, and so is the location text that is changed based on the location.
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_page);

        // Pulling the serialized values from the previous class.
        locationRandoms = (RandomEvents) getIntent().getSerializableExtra("NewRandomEvents");
        locationHattie = (Entity) getIntent().getSerializableExtra("NewHattie");
        locationCharles = (Entity) getIntent().getSerializableExtra("NewCharles");
        locationAugusta = (Entity) getIntent().getSerializableExtra("NewAugusta");
        locationBen = (Entity) getIntent().getSerializableExtra("NewBen");
        locationJake = (Entity) getIntent().getSerializableExtra("NewJake");
        locationWagon = (Wagon) getIntent().getSerializableExtra("NewWagon");
        dateAndDistance = (DateAndDistance) getIntent().getSerializableExtra("NewDateAndDistance");
        newHealth = (GeneralHealth) getIntent().getSerializableExtra("NewGeneralHealth");
        newWeather = (Weather) getIntent().getSerializableExtra("NewWeather");

        // Initialization of the button classes.
        configureResourcesButton();
        configurePartyButton();
        configureShopButton();
        configureNextLocationButton();

        // Initialization of the locationText text view field.
        final TextView locationText = findViewById(R.id.locationText);

        // Determines what text will appear in the locationText field.
        if (dateAndDistance.beenToTheDalles) {
            locationText.setText("The Dalles");
        }
        else if (dateAndDistance.beenToFortWallaWalla) {
            locationText.setText("Fort Walla Walla");
        }
        else if (dateAndDistance.beenToFortBoise) {
            locationText.setText("Fort Boise");
        }
        else if (dateAndDistance.beenToFortHall) {
            locationText.setText("Fort Hall");
        }
        else if (dateAndDistance.beenToSouthPass) {
            locationText.setText("South Pass");
        }
        else if (dateAndDistance.beenToIndependenceRock) {
            locationText.setText("Independence Rock");
        }
        else if (dateAndDistance.beenToFortLaramie) {
            locationText.setText("Fort Laramie");
        }
        else if (dateAndDistance.beenToKearny) {
            locationText.setText("Fort Kearney");
        }
    }


    // Everything that happens upon clicking the resources button.
    private void configureResourcesButton() {

        Button resourcesButton = (Button) findViewById(R.id.resourcesButton);
        resourcesButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Upon clicking the "resourcesButton" button, all objects are created, filled, and passed to the LocationStatus class.
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                // Creates new objects with all values generated in this class, then passes them to the LocationStatus class using serializable.
                RandomEvents newRandomEvents = new RandomEvents(locationRandoms.disease, locationRandoms.badWater, locationRandoms.lowWater, locationRandoms.roughTrail, locationRandoms.blizzard, locationRandoms.fog, locationRandoms.hail, locationRandoms.oxenDamage, locationRandoms.injury, locationRandoms.snakeBite, locationRandoms.loseTrail, locationRandoms.thief, locationRandoms.blockedTrail, locationRandoms.fire, locationRandoms.abandonedWagon, locationRandoms.oxenWandered, locationRandoms.lostMember, locationRandoms.badGrass, locationRandoms.fruit, locationRandoms.healedDisease, locationRandoms.healedInjury, locationRandoms.tongueBroke, locationRandoms.wheelBroke, locationRandoms.axelBroke, locationRandoms.daysLost, locationRandoms.foodLost, locationRandoms.clothesLost, locationRandoms.axlesLost, locationRandoms.wheelsLost, locationRandoms.wheelsLost, locationRandoms.memberLost);
                Entity newHattie = new Entity(locationHattie.name, locationHattie.sick, locationHattie.injured, locationHattie.dead);
                Entity newCharles = new Entity (locationCharles.name, locationCharles.sick, locationCharles.injured, locationCharles.dead);
                Entity newAugusta = new Entity(locationAugusta.name, locationAugusta.sick, locationAugusta.injured, locationAugusta.dead);
                Entity newBen = new Entity (locationBen.name, locationBen.sick, locationBen.injured, locationBen.dead);
                Entity newJake = new Entity(locationJake.name, locationJake.sick, locationJake.injured, locationJake.dead);
                Wagon newWagon = new Wagon(locationWagon.people, locationWagon.money, locationWagon.oxen, locationWagon.food, locationWagon.clothes, locationWagon.tongues, locationWagon.axles, locationWagon.wheels, locationWagon.rations, locationWagon.brokenTongue, locationWagon.brokenWheel, locationWagon.brokenAxel, locationWagon.repairTongue, locationWagon.repairWheel, locationWagon.repairAxel);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                Intent intent = new Intent(LocationPage.this, LocationStatus.class);

                intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake).putExtra("NewDateAndDistance", newDateAndDistance);
                setContentView(R.layout.activity_location_status);
                startActivity(new Intent(LocationPage.this, LocationStatus.class));
                startActivity(intent);}
        });
    }

    private void configurePartyButton() {

        Button configurePartyButton = (Button) findViewById(R.id.partyButton);
        configurePartyButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Upon clicking the "configurePartyButton" button, all objects are created, filled, and passed to the PaceAndRations class.
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                RandomEvents newRandomEvents = new RandomEvents(locationRandoms.disease, locationRandoms.badWater, locationRandoms.lowWater, locationRandoms.roughTrail, locationRandoms.blizzard, locationRandoms.fog, locationRandoms.hail, locationRandoms.oxenDamage, locationRandoms.injury, locationRandoms.snakeBite, locationRandoms.loseTrail, locationRandoms.thief, locationRandoms.blockedTrail, locationRandoms.fire, locationRandoms.abandonedWagon, locationRandoms.oxenWandered, locationRandoms.lostMember, locationRandoms.badGrass, locationRandoms.fruit, locationRandoms.healedDisease, locationRandoms.healedInjury, locationRandoms.tongueBroke, locationRandoms.wheelBroke, locationRandoms.axelBroke, locationRandoms.daysLost, locationRandoms.foodLost, locationRandoms.clothesLost, locationRandoms.axlesLost, locationRandoms.wheelsLost, locationRandoms.wheelsLost, locationRandoms.memberLost);
                Entity newHattie = new Entity(locationHattie.name, locationHattie.sick, locationHattie.injured, locationHattie.dead);
                Entity newCharles = new Entity (locationCharles.name, locationCharles.sick, locationCharles.injured, locationCharles.dead);
                Entity newAugusta = new Entity(locationAugusta.name, locationAugusta.sick, locationAugusta.injured, locationAugusta.dead);
                Entity newBen = new Entity (locationBen.name, locationBen.sick, locationBen.injured, locationBen.dead);
                Entity newJake = new Entity(locationJake.name, locationJake.sick, locationJake.injured, locationJake.dead);
                Wagon newWagon = new Wagon(locationWagon.people, locationWagon.money, locationWagon.oxen, locationWagon.food, locationWagon.clothes, locationWagon.tongues, locationWagon.axles, locationWagon.wheels, locationWagon.rations, locationWagon.brokenTongue, locationWagon.brokenWheel, locationWagon.brokenAxel, locationWagon.repairTongue, locationWagon.repairWheel, locationWagon.repairAxel);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                Intent intent = new Intent(LocationPage.this, PaceAndRationsPage.class);

                intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake).putExtra("NewDateAndDistance", newDateAndDistance);
                setContentView(R.layout.activity_pace_and_rations_page);
                startActivity(new Intent(LocationPage.this, PaceAndRationsPage.class));
                startActivity(intent);
            }
        });
    }

    private void configureShopButton() {

        Button shopButton = (Button) findViewById(R.id.shopButton);
        shopButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Upon clicking the "shopButton" button, all objects are created, filled, and passed to the LocationShop class.
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                RandomEvents newRandomEvents = new RandomEvents(locationRandoms.disease, locationRandoms.badWater, locationRandoms.lowWater, locationRandoms.roughTrail, locationRandoms.blizzard, locationRandoms.fog, locationRandoms.hail, locationRandoms.oxenDamage, locationRandoms.injury, locationRandoms.snakeBite, locationRandoms.loseTrail, locationRandoms.thief, locationRandoms.blockedTrail, locationRandoms.fire, locationRandoms.abandonedWagon, locationRandoms.oxenWandered, locationRandoms.lostMember, locationRandoms.badGrass, locationRandoms.fruit, locationRandoms.healedDisease, locationRandoms.healedInjury, locationRandoms.tongueBroke, locationRandoms.wheelBroke, locationRandoms.axelBroke, locationRandoms.daysLost, locationRandoms.foodLost, locationRandoms.clothesLost, locationRandoms.axlesLost, locationRandoms.wheelsLost, locationRandoms.wheelsLost, locationRandoms.memberLost);
                Entity newHattie = new Entity(locationHattie.name, locationHattie.sick, locationHattie.injured, locationHattie.dead);
                Entity newCharles = new Entity (locationCharles.name, locationCharles.sick, locationCharles.injured, locationCharles.dead);
                Entity newAugusta = new Entity(locationAugusta.name, locationAugusta.sick, locationAugusta.injured, locationAugusta.dead);
                Entity newBen = new Entity (locationBen.name, locationBen.sick, locationBen.injured, locationBen.dead);
                Entity newJake = new Entity(locationJake.name, locationJake.sick, locationJake.injured, locationJake.dead);
                Wagon newWagon = new Wagon(locationWagon.people, locationWagon.money, locationWagon.oxen, locationWagon.food, locationWagon.clothes, locationWagon.tongues, locationWagon.axles, locationWagon.wheels, locationWagon.rations, locationWagon.brokenTongue, locationWagon.brokenWheel, locationWagon.brokenAxel, locationWagon.repairTongue, locationWagon.repairWheel, locationWagon.repairAxel);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                Intent intent = new Intent(LocationPage.this, LocationStore.class);

                intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake).putExtra("NewDateAndDistance", newDateAndDistance);
                setContentView(R.layout.activity_location_store);
                startActivity(new Intent(LocationPage.this, LocationStore.class));
                startActivity(intent);
            }
        });
    }

    private void configureNextLocationButton() {

        Button nextLocationButton = (Button) findViewById(R.id.nextButtonLocationButton);
        nextLocationButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Upon clicking the "nextLocationButton" button, all objects are created, filled, and passed to the LocationStatus class.
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                RandomEvents newRandomEvents = new RandomEvents(locationRandoms.disease, locationRandoms.badWater, locationRandoms.lowWater, locationRandoms.roughTrail, locationRandoms.blizzard, locationRandoms.fog, locationRandoms.hail, locationRandoms.oxenDamage, locationRandoms.injury, locationRandoms.snakeBite, locationRandoms.loseTrail, locationRandoms.thief, locationRandoms.blockedTrail, locationRandoms.fire, locationRandoms.abandonedWagon, locationRandoms.oxenWandered, locationRandoms.lostMember, locationRandoms.badGrass, locationRandoms.fruit, locationRandoms.healedDisease, locationRandoms.healedInjury, locationRandoms.tongueBroke, locationRandoms.wheelBroke, locationRandoms.axelBroke, locationRandoms.daysLost, locationRandoms.foodLost, locationRandoms.clothesLost, locationRandoms.axlesLost, locationRandoms.wheelsLost, locationRandoms.wheelsLost, locationRandoms.memberLost);
                Entity newHattie = new Entity(locationHattie.name, locationHattie.sick, locationHattie.injured, locationHattie.dead);
                Entity newCharles = new Entity(locationCharles.name, locationCharles.sick, locationCharles.injured, locationCharles.dead);
                Entity newAugusta = new Entity(locationAugusta.name, locationAugusta.sick, locationAugusta.injured, locationAugusta.dead);
                Entity newBen = new Entity(locationBen.name, locationBen.sick, locationBen.injured, locationBen.dead);
                Entity newJake = new Entity(locationJake.name, locationJake.sick, locationJake.injured, locationJake.dead);
                Wagon newWagon = new Wagon(locationWagon.people, locationWagon.money, locationWagon.oxen, locationWagon.food, locationWagon.clothes, locationWagon.tongues, locationWagon.axles, locationWagon.wheels, locationWagon.rations, locationWagon.brokenTongue, locationWagon.brokenWheel, locationWagon.brokenAxel, locationWagon.repairTongue, locationWagon.repairWheel, locationWagon.repairAxel);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                Intent intent = new Intent(LocationPage.this, DailyStatus.class);

                intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake).putExtra("NewDateAndDistance", newDateAndDistance);
                setContentView(R.layout.activity_daily_status);
                startActivity(new Intent(LocationPage.this, DailyStatus.class));
                startActivity(intent);
            }
        });
    }
}
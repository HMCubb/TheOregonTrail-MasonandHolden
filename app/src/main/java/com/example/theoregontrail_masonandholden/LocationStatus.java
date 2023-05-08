package com.example.theoregontrail_masonandholden;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LocationStatus extends AppCompatActivity {

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

    public LocationStatus() {
    }

    public LocationStatus(Weather weather, GeneralHealth health, RandomEvents randomEvents, DateAndDistance dateAndDistance, RandomEvents locationRandoms, Entity locationHattie, Entity locationCharles, Entity locationAugusta, Entity locationBen, Entity locationJake, Wagon locationWagon) {

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

    @SuppressLint("DefaultLocale")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_status);

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

        configureBackButtonLS();

        final TextView PeopleCount = findViewById(R.id.PeopleCountLocation);
        final TextView MoneyCount = findViewById(R.id.MoneyCountLocation);
        final TextView FoodCount = findViewById(R.id.FoodCountLocation);
        final TextView OxenCount = findViewById(R.id.OxenCountLocation);
        final TextView ClothesCount = findViewById(R.id.ClothesCountLocation);
        final TextView TonguesCount = findViewById(R.id.TonguesCountLocation);
        final TextView AxlesCount = findViewById(R.id.AxlesCountLocation);
        final TextView WheelsCount = findViewById(R.id.WheelsCountLocation);
        final TextView DayTracker = findViewById(R.id.DayTrackerLocation);
        final TextView DistanceTracker = findViewById(R.id.DistanceTrackerLocation);
        final TextView HealthTracker = findViewById(R.id.HealthTrackerLocation);
        final TextView TemperatureTracker = findViewById(R.id.TemperatureTrackerLocation);
        
        PeopleCount.setText(String.valueOf(locationWagon.getPeople()));
        MoneyCount.setText(String.valueOf(String.format("%.2f", locationWagon.getMoney())));
        FoodCount.setText(String.valueOf(locationWagon.getFood()));
        OxenCount.setText(String.valueOf(locationWagon.getOxen()));
        ClothesCount.setText(String.valueOf(locationWagon.getClothes()));
        TonguesCount.setText(String.valueOf(locationWagon.getTongues()));
        AxlesCount.setText(String.valueOf(locationWagon.getAxles()));
        WheelsCount.setText(String.valueOf(locationWagon.getWheels()));
        HealthTracker.setText(String.valueOf(newHealth.GeneralHealth));
        DistanceTracker.setText(String.valueOf(dateAndDistance.getDistanceTraveled()));
        DayTracker.setText(String.valueOf(dateAndDistance.getDate()));
        TemperatureTracker.setText(String.valueOf(newWeather.temperature));
    }
    
    private void configureBackButtonLS() {

        Button backButtonLS = (Button) findViewById(R.id.NextDayButtonLocation);
        backButtonLS.setOnClickListener(new View.OnClickListener() {
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

                Intent intent = new Intent(LocationStatus.this, LocationPage.class);

                intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake).putExtra("NewDateAndDistance", newDateAndDistance);
                setContentView(R.layout.activity_location_status);
                startActivity(new Intent(LocationStatus.this, LocationPage.class));
                startActivity(intent);}
        });
    }
}

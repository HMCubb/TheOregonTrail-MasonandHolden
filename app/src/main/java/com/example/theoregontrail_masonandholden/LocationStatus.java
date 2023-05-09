package com.example.theoregontrail_masonandholden;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The LocationStatus class rolls all of the random events then passes those newly generated values back to the LocationPage page.
 * @filename OregonTrailMasonandHolden
 * @author Holden Cubberley & Mason Muether
 * @date 5/9/2023
 */
public class LocationStatus extends AppCompatActivity {

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

    public LocationStatus() {}

    // Package with all values that this class intakes from serializable values (more for completeness).
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

    /**
     * onCreate
     * When the program is initially ran, all of the serializable elements within this method are established.
     * All of the buttons and text values are also initialized and filled with their respective values.
     * The health is also established based on their numerical values.
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_status);

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

        // Initialization of the backButtonLS button class.
        configureBackButtonLS();

        // Initialization of the buttons and text values displayed on screen.
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

        // Pulling all the values from each object, then setting the corresponding text fields equal to those values.
        PeopleCount.setText(String.valueOf(locationWagon.getPeople()));
        MoneyCount.setText(String.valueOf(String.format("%.2f", locationWagon.getMoney())));
        FoodCount.setText(String.valueOf(locationWagon.getFood()));
        OxenCount.setText(String.valueOf(locationWagon.getOxen()));
        ClothesCount.setText(String.valueOf(locationWagon.getClothes()));
        TonguesCount.setText(String.valueOf(locationWagon.getTongues()));
        AxlesCount.setText(String.valueOf(locationWagon.getAxles()));
        WheelsCount.setText(String.valueOf(locationWagon.getWheels()));
        DistanceTracker.setText(String.valueOf(dateAndDistance.getDistanceTraveled()));
        DistanceTracker.append(" miles");
        DayTracker.setText(String.valueOf(dateAndDistance.getDate()));
        TemperatureTracker.setText(String.valueOf(newWeather.getTemperature() + 10));
        TemperatureTracker.append("°F");

        // Establishes the health string as very poor, poor, okay, or good depending on the numerical health value.
        if (newHealth.getGeneralHealth() >= 105) {
            HealthTracker.setText("Very Poor");
        }
        else if (newHealth.getGeneralHealth() >= 70) {
            HealthTracker.setText("Poor");
        }
        else if (newHealth.getGeneralHealth() >= 35) {
            HealthTracker.setText("Okay");
        }
        else {
            HealthTracker.setText("Good");
        }
    }

    // Everything that happens upon clicking the back button is held within this class.
    private void configureBackButtonLS() {

        Button backButtonLS = (Button) findViewById(R.id.NextDayButtonLocation);
        backButtonLS.setOnClickListener(new View.OnClickListener() {

            /**
             * Upon clicking the "backButtonLS" button, all objects are passed back to the LocationPage page by transforming them into serializable values.
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

                Intent intent = new Intent(LocationStatus.this, LocationPage.class);

                intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake).putExtra("NewDateAndDistance", newDateAndDistance);
                setContentView(R.layout.activity_location_status);
                startActivity(new Intent(LocationStatus.this, LocationPage.class));
                startActivity(intent);}
        });
    }
}

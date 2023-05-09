package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * The PaceAndRationsPage class contains buttons that allow you to change the pace in which your party is moving at and
 * the rations in which your party members consume.
 * @filename OregonTrailMasonandHolden
 * @author Holden Cubberley & Mason Muether
 * @date 5/9/2023
 */
public class PaceAndRationsPage extends AppCompatActivity {

    // Initialization of public values.
    public RandomEvents randomEvents;
    public Entity Hattie;
    public Entity Charles;
    public Entity Augusta;
    public Entity Ben;
    public Entity Jake;
    public Wagon storeWagon;
    public DateAndDistance dateAndDistance;
    public Weather newWeather;
    public GeneralHealth newHealth;
    private int rationsNumber = 0;
    private int paceNumber = 0;

    public PaceAndRationsPage(){}

    // Package with all values that this class intakes from serializable values (more for completeness).
    public PaceAndRationsPage(Weather weather, GeneralHealth health, DateAndDistance dateAndDistance, RandomEvents randomEvents, Entity newHattie, Entity newCharles, Entity newAugusta, Entity newBen, Entity newJake, Wagon wagon){
        this.Hattie = newHattie;
        this.Charles = newCharles;
        this.Augusta = newAugusta;
        this.Ben = newBen;
        this.Jake = newJake;
        this.storeWagon = wagon;
        this.randomEvents = randomEvents;
        this.dateAndDistance = dateAndDistance;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pace_and_rations_page);

        // Pulling the serialized values from the previous class.
        Hattie = (Entity) getIntent().getSerializableExtra("NewHattie");
        Charles = (Entity) getIntent().getSerializableExtra("NewCharles");
        Augusta = (Entity) getIntent().getSerializableExtra("NewAugusta");
        Ben = (Entity) getIntent().getSerializableExtra("NewBen");
        Jake = (Entity) getIntent().getSerializableExtra("NewJake");
        storeWagon = (Wagon) getIntent().getSerializableExtra("NewWagon");
        randomEvents = (RandomEvents) getIntent().getSerializableExtra("NewRandomEvents");
        dateAndDistance = (DateAndDistance) getIntent().getSerializableExtra("NewDateAndDistance");
        newHealth = (GeneralHealth) getIntent().getSerializableExtra("NewGeneralHealth");
        newWeather = (Weather) getIntent().getSerializableExtra("NewWeather");

        // Configuring the button classes.
        configurePaceUpButton();
        configurePaceDownButton();
        configureRationsUpButton();
        configureRationsDownButton();
        configureBackButton();

        // Sets the pace number and ration number equal to the current pace and ration consumtion.
        paceNumber = dateAndDistance.pace;
        rationsNumber = storeWagon.getRations();

        // Sets the text values equal to their corresponding values.
        TextView rationsValue = findViewById(R.id.rationsValue);
        TextView paceValue = findViewById(R.id.paceValue);
        paceValue.setText(String.valueOf(paceNumber));
        rationsValue.setText(String.valueOf(rationsNumber));


    }

    // Everything that happens upon clicking the back button is held within this class.
    private void configureBackButton() {

        Button backButton = (Button) findViewById(R.id.backButtonPAR);
        backButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Upon clicking the "backButton" button all objects are passed to the dailyEvents page by transforming them into serializable values.
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                // Pulling the serialized values from the previous class.
                RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.tongueBroke, randomEvents.wheelBroke, randomEvents.axelBroke, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                Wagon newWagon = new Wagon(storeWagon.people, storeWagon.money, storeWagon.oxen, storeWagon.food, storeWagon.clothes, storeWagon.tongues, storeWagon.axles, storeWagon.wheels, storeWagon.rations, storeWagon.brokenTongue, storeWagon.brokenWheel, storeWagon.brokenAxel, storeWagon.repairTongue, storeWagon.repairWheel, storeWagon.repairAxel);
                Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                Intent intent = new Intent(PaceAndRationsPage.this, LocationPage.class);

                intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                setContentView(R.layout.activity_location_page);
                startActivity(new Intent(PaceAndRationsPage.this, LocationPage.class));
                startActivity(intent);
            }
        });
    }

    // Everything that happens upon clicking the pace up button is held within this class.
    private void configurePaceUpButton() {

        Button paceUp = findViewById(R.id.paceUpButton);
        TextView paceValue = findViewById(R.id.paceValue);

        /**
         * Upon clicking the "paceUp" button, the pace number is increased by one, and the pace within the DateAndDistance object is changed to that value.
         * @param v The view that was clicked.
         */
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

    // Everything that happens upon clicking the pace up button is held within this class.
    private void configurePaceDownButton() {

        Button paceUp = findViewById(R.id.paceDownButton);
        TextView paceValue = findViewById(R.id.paceValue);

        /**
         * Upon clicking the "paceDown" button, the pace number is decreased by one, and the pace within the DateAndDistance object is changed to that value.
         * @param v The view that was clicked.
         */
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

    // Everything that happens upon clicking the pace up button is held within this class.
    private void configureRationsUpButton() {

        Button paceUp = findViewById(R.id.rationsUpButton);
        TextView rationsValue = findViewById(R.id.rationsValue);

        /**
         * Upon clicking the "rationsUp" button, the rations number is increased by one, and the rations within the Wagon object are changed.
         * @param v The view that was clicked.
         */
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

    // Everything that happens upon clicking the pace up button is held within this class.
    private void configureRationsDownButton() {

        Button paceUp = findViewById(R.id.rationsDownButton);
        TextView rationsValue = findViewById(R.id.rationsValue);

        /**
         * Upon clicking the "rationsDown" button, the rations number is decreased by one, and the rations within the Wagon object are changed.
         * @param v The view that was clicked.
         */
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
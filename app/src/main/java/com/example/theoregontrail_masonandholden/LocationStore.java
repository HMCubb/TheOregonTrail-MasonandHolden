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
 * The LocationStore class holds and generates all the buttons and values that allow the user to buy and sell goods for their wagon.
 * @filename OregonTrailMasonandHolden
 * @author Holden Cubberley & Mason Muether
 * @date 5/9/2023
 */
public class LocationStore extends AppCompatActivity {

    // Initializing all the public and private values used within and outside of this class.
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

    public LocationStore(){}

    // Package with all values that this class intakes from serializable values (more for completeness).
    public LocationStore(Weather weather, GeneralHealth health, DateAndDistance dateAndDistance, RandomEvents randomEvents, Entity newHattie, Entity newCharles, Entity newAugusta, Entity newBen, Entity newJake, Wagon wagon){
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
     * All of the buttons and text values are also established and filled.
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_store);

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

        // Initializing the button classes.
        configureFoodUpButton();
        configureFoodDownButton();
        configureClothesUpButton();
        configureClothesDownButton();
        configureTonguesUpButton();
        configureTonguesDownButton();
        configureAxlesUpButton();
        configureAxlesDownButton();
        configureWheelsUpButton();
        configureWheelsDownButton();
        configureOxenUpButton();
        configureOxenDownButton();
        configureBackButton();

        // Initializing the text view fields.
        TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
        TextView foodAmount = findViewById(R.id.foodAmountLocation);
        TextView clothesAmount = findViewById(R.id.clothesAmountLocation);
        TextView tonguesAmount = findViewById(R.id.tonguesAmountLocation);
        TextView axlesAmount = findViewById(R.id.axlesAmountLocation);
        TextView wheelsAmount = findViewById(R.id.wheelsAmountLocation);
        TextView oxenAmount = findViewById(R.id.oxenAmountLocation);

        // Filling the text view fields with their corresponding values.
        ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
        oxenAmount.setText(String.valueOf(storeWagon.getOxen()));
        foodAmount.setText(String.valueOf(storeWagon.getFood()));
        clothesAmount.setText(String.valueOf(storeWagon.getClothes()));
        tonguesAmount.setText(String.valueOf(storeWagon.getTongues()));
        axlesAmount.setText(String.valueOf(storeWagon.getAxles()));
        wheelsAmount.setText(String.valueOf(storeWagon.getWheels()));
        oxenAmount.setText(String.valueOf(storeWagon.getOxen()));
    }

    // Everything that happens upon clicking the back button is held within this class.
    private void configureBackButton() {

        Button backButton = (Button) findViewById(R.id.backButtonLocation);
        backButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Upon clicking the "backButton" button, all objects are passed to the LocationPage page by transforming them into serializable values.
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.tongueBroke, randomEvents.wheelBroke, randomEvents.axelBroke, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                Wagon newWagon = new Wagon(storeWagon.people, storeWagon.money, storeWagon.oxen, storeWagon.food, storeWagon.clothes, storeWagon.tongues, storeWagon.axles, storeWagon.wheels, storeWagon.rations, storeWagon.brokenTongue, storeWagon.brokenWheel, storeWagon.brokenAxel, storeWagon.repairTongue, storeWagon.repairWheel, storeWagon.repairAxel);
                Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                Intent intent = new Intent(LocationStore.this, LocationPage.class);

                intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                setContentView(R.layout.activity_location_page);
                startActivity(new Intent(LocationStore.this, LocationPage.class));
                startActivity(intent);
            }
        });
    }

    // Everything that happens upon clicking the food up button is held within this class.
    private void configureFoodUpButton() {

        Button foodUp = findViewById(R.id.foodUpLocation);
        TextView foodAmount = findViewById(R.id.foodAmountLocation);

        /**
         * Upon clicking the "foodUp" button, the food value is increased, and the owned money is decreased (purchasing food).
         * The display text for the food value, owed money, and owned money are all changed accordingly.
         * @param v The view that was clicked.
         */
        foodUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // If the user has greater than or equal to four dollars, they can buy food.
                if (storeWagon.getMoney() >= 4.00) {
                    storeWagon.buyFood();
                    storeWagon.spendMoney(4.00);
                    foodAmount.setText(String.valueOf(storeWagon.getFood()));
                }
                TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                TextView moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }
    // Everything that happens upon clicking the food down button is held within this class.
    private void configureFoodDownButton() {

        Button foodDown = findViewById(R.id.foodDownLocation);
        TextView foodAmount = findViewById(R.id.foodAmountLocation);

        /**
         * Upon clicking the "foodDown" button, the food value is decreased, and the owned money is increased (selling food).
         * The display text for the food value, owed money, and owned money are all changed accordingly.
         * @param v The view that was clicked.
         */
        foodDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // If the user has greater than or equal to 20 food, they can sell food.
                if (storeWagon.getFood() >= 20.00) {
                    storeWagon.sellFood();
                    storeWagon.returnMoney(4.00);
                    foodAmount.setText(String.valueOf(storeWagon.getFood()));
                }
                TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                TextView moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    // Everything that happens upon clicking the food down button is held within this class.
    private void configureClothesUpButton() {

        Button clothesUp = findViewById(R.id.clothesUpLocation);
        TextView clothesAmount = findViewById(R.id.clothesAmountLocation);

        /**
         * Upon clicking the "clothesUp" button, the clothes value is increased, and the owned money is decreased (buying food).
         * The display text for the clothes value, owed money, and owned money are all changed accordingly.
         * @param v The view that was clicked.
         */
        clothesUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // If the user has greater than or equal to ten dollars, they can buy clothes.
                if (storeWagon.getMoney() >= 10.00) {
                    storeWagon.buyClothes();
                    storeWagon.spendMoney(10.00);
                    clothesAmount.setText(String.valueOf(storeWagon.getClothes()));
                }
                TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                TextView moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    // Everything that happens upon clicking the clothes down button is held within this class.
    private void configureClothesDownButton() {

        Button clothesDown = findViewById(R.id.clothesDownLocation);
        TextView clothesAmount = findViewById(R.id.clothesAmountLocation);

        /**
         * Upon clicking the "clothesDown" button, the clothes value is decreased, and the owned money is increased (selling clothes).
         * The display text for the clothes value, owed money, and owned money are all changed accordingly.
         * @param v The view that was clicked.
         */
        clothesDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // If the user has greater than or equal to one clothes, they can sell clothes.
                if (storeWagon.getClothes() >= 1) {
                    storeWagon.sellClothes();
                    storeWagon.returnMoney(10.00);
                    clothesAmount.setText(String.valueOf(storeWagon.getClothes()));
                }
                TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                TextView moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    // Everything that happens upon clicking the tongues up button is held within this class.
    private void configureTonguesUpButton() {

        Button tonguesUp = findViewById(R.id.tonguesUpLocation);
        TextView tonguesAmount = findViewById(R.id.tonguesAmountLocation);

        /**
         * Upon clicking the "tonguesUp" button, the tongues value is increased, and the owned money is decreased (buying tongues).
         * The display text for the tongues value, owed money, and owned money are all changed accordingly.
         * @param v The view that was clicked.
         */
        tonguesUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // If the user has greater than or equal to ten dollars, they can buy tongues.
                if (storeWagon.getMoney() >= 10.00) {
                    storeWagon.buyTongues();
                    storeWagon.spendMoney(10.00);
                    tonguesAmount.setText(String.valueOf(storeWagon.getTongues()));
                }
                TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                TextView moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    // Everything that happens upon clicking the tongues down button is held within this class.
    private void configureTonguesDownButton() {

        Button tonguesDown = findViewById(R.id.tonguesDownLocation);
        TextView tonguesAmount = findViewById(R.id.tonguesAmountLocation);
        /**
         * Upon clicking the "tonguesDown" button, the tongues value is decreased, and the owned money is increased (selling tongues).
         * The display text for the tongues value, owed money, and owned money are all changed accordingly.
         * @param v The view that was clicked.
         */
        tonguesDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // If the user has greater than or equal to one tongues, they can sell tongues.
                if (storeWagon.getTongues() >= 1) {
                    storeWagon.sellTongues();
                    storeWagon.returnMoney(10.00);
                    tonguesAmount.setText(String.valueOf(storeWagon.getTongues()));
                }
                TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                TextView moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    // Everything that happens upon clicking the axles up button is held within this class.
    private void configureAxlesUpButton() {

        Button axlesUp = findViewById(R.id.axlesUpLocation);
        TextView axlesAmount = findViewById(R.id.axlesAmountLocation);

        /**
         * Upon clicking the "axlesUp" button, the axles value is increased, and the owned money is decreased (buying axles).
         * The display text for the axles value, owed money, and owned money are all changed accordingly.
         * @param v The view that was clicked.
         */
        axlesUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // If the user has greater than or equal to ten dollars, they can buy axles.
                if (storeWagon.getMoney() >= 10.00) {
                    storeWagon.buyAxles();
                    storeWagon.spendMoney(10.00);
                    axlesAmount.setText(String.valueOf(storeWagon.getAxles()));
                }
                TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                TextView moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    // Everything that happens upon clicking the axles down button is held within this class.
    private void configureAxlesDownButton() {

        Button axlesDown = findViewById(R.id.axlesDownLocation);
        TextView axlesAmount = findViewById(R.id.axlesAmountLocation);

        /**
         * Upon clicking the "axlesDown" button, the axles value is decreased, and the owned money is increased (selling axles).
         * The display text for the axles value, owed money, and owned money are all changed accordingly.
         * @param v The view that was clicked.
         */
        axlesDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // If the user has greater than or equal to one axles, they can sell axles.
                if (storeWagon.getAxles() >= 1) {
                    storeWagon.sellAxles();
                    storeWagon.returnMoney(10.00);
                    axlesAmount.setText(String.valueOf(storeWagon.getAxles()));
                }
                TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                TextView moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    // Everything that happens upon clicking the wheels up button is held within this class.
    private void configureWheelsUpButton() {

        Button wheelsUp = findViewById(R.id.wheelsUpLocation);
        TextView wheelsAmount = findViewById(R.id.wheelsAmountLocation);

        /**
         * Upon clicking the "wheelsUp" button, the wheels value is increased, and the owned money is decreased (buying wheels).
         * The display text for the wheels value, owed money, and owned money are all changed accordingly.
         * @param v The view that was clicked.
         */
        wheelsUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // If the user has greater than or equal to ten dollars, they can buy wheels.
                if (storeWagon.getMoney() >= 10.00) {
                    storeWagon.buyWheels();
                    storeWagon.spendMoney(10.00);
                    wheelsAmount.setText(String.valueOf(storeWagon.getWheels()));
                }
                TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                TextView moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    // Everything that happens upon clicking the wheels down button is held within this class.
    private void configureWheelsDownButton() {

        Button wheelsDown = findViewById(R.id.wheelsDownLocation);
        TextView wheelsAmount = findViewById(R.id.wheelsAmountLocation);

        /**
         * Upon clicking the "wheelsDown" button, the wheels value is decreased, and the owned money is increased (selling wheels).
         * The display text for the wheels value, owed money, and owned money are all changed accordingly.
         * @param v The view that was clicked.
         */
        wheelsDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // If the user has greater than or equal to one wheels, they can sell wheels.
                if (storeWagon.getWheels() >= 1) {
                    storeWagon.sellWheels();
                    storeWagon.returnMoney(10.00);
                    wheelsAmount.setText(String.valueOf(storeWagon.getWheels()));
                }
                TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                TextView moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    // Everything that happens upon clicking the oxen up button is held within this class.
    private void configureOxenUpButton() {

        Button oxenUp = findViewById(R.id.oxenUpLocation);
        TextView oxenAmount = findViewById(R.id.oxenAmountLocation);

        /**
         * Upon clicking the "oxenUp" button, the oxen value is increased, and the owned money is decreased (buying oxen).
         * The display text for the oxen value, owed money, and owned money are all changed accordingly.
         * @param v The view that was clicked.
         */
        oxenUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // If the user has greater than or equal to forty dollars, they can buy oxen.
                if (storeWagon.getMoney() >= 40.00) {
                    storeWagon.buyOxen();
                    storeWagon.spendMoney(40.00);
                    oxenAmount.setText(String.valueOf(storeWagon.getOxen()));
                }
                TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                TextView moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    // Everything that happens upon clicking the oxen down button is held within this class.
    private void configureOxenDownButton() {

        Button oxenDown = findViewById(R.id.oxenDownLocation);
        TextView oxenAmount = findViewById(R.id.oxenAmountLocation);

        /**
         * Upon clicking the "oxenDown" button, the oxen value is decreased, and the owned money is increased (selling oxen).
         * The display text for the oxen value, owed money, and owned money are all changed accordingly.
         * @param v The view that was clicked.
         */
        oxenDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                // If the user has greater than or equal to one oxen, they can sell oxen.
                if (storeWagon.getOxen() >= 1) {
                    storeWagon.sellOxen();
                    storeWagon.returnMoney(40.00);
                    oxenAmount.setText(String.valueOf(storeWagon.getOxen()));
                }
                TextView ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                TextView moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

}



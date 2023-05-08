package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;
import java.util.Random;

public class LocationStore extends AppCompatActivity {

    public RandomEvents randomEvents;
    public Entity Hattie;
    public Entity Charles;
    public Entity Augusta;
    public Entity Ben;
    public Entity Jake;
    public Wagon storeWagon;
    public DateAndDistance dateAndDistance;

    public LocationStore(){}

    public LocationStore(DateAndDistance dateAndDistance, RandomEvents randomEvents, Entity newHattie, Entity newCharles, Entity newAugusta, Entity newBen, Entity newJake, Wagon wagon){
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
        setContentView(R.layout.activity_location_store);

        Hattie = (Entity) getIntent().getSerializableExtra("NewHattie");
        Charles = (Entity) getIntent().getSerializableExtra("NewCharles");
        Augusta = (Entity) getIntent().getSerializableExtra("NewAugusta");
        Ben = (Entity) getIntent().getSerializableExtra("NewBen");
        Jake = (Entity) getIntent().getSerializableExtra("NewJake");
        storeWagon = (Wagon) getIntent().getSerializableExtra("NewWagon");
        randomEvents = (RandomEvents) getIntent().getSerializableExtra("NewRandomEvents");
        dateAndDistance = (DateAndDistance) getIntent().getSerializableExtra("NewDateAndDistance");

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

        EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
        EditText foodAmount = findViewById(R.id.foodAmountLocation);
        EditText clothesAmount = findViewById(R.id.clothesAmountLocation);
        EditText tonguesAmount = findViewById(R.id.tonguesAmountLocation);
        EditText axlesAmount = findViewById(R.id.axlesAmountLocation);
        EditText wheelsAmount = findViewById(R.id.wheelsAmountLocation);
        EditText oxenAmount = findViewById(R.id.oxenAmountLocation);

        ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
        oxenAmount.setText(String.valueOf(storeWagon.getOxen()));
        foodAmount.setText(String.valueOf(storeWagon.getFood()));
        clothesAmount.setText(String.valueOf(storeWagon.getClothes()));
        tonguesAmount.setText(String.valueOf(storeWagon.getTongues()));
        axlesAmount.setText(String.valueOf(storeWagon.getAxles()));
        wheelsAmount.setText(String.valueOf(storeWagon.getWheels()));
        oxenAmount.setText(String.valueOf(storeWagon.getOxen()));
    }

    private void configureBackButton() {

        Button continueButton = (Button) findViewById(R.id.backButtonLocation);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.tongueBroke, randomEvents.wheelBroke, randomEvents.axelBroke, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                Wagon newWagon = new Wagon(storeWagon.people, storeWagon.money, storeWagon.oxen, storeWagon.food, storeWagon.clothes, storeWagon.tongues, storeWagon.axles, storeWagon.wheels, storeWagon.rations, storeWagon.brokenTongue, storeWagon.brokenWheel, storeWagon.brokenAxel, storeWagon.repairTongue, storeWagon.repairWheel, storeWagon.repairAxel);
                Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);


                Intent intent = new Intent(LocationStore.this, LocationPage.class);

                intent.putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                setContentView(R.layout.activity_location_page);
                startActivity(new Intent(LocationStore.this, LocationPage.class));
                startActivity(intent);
            }
        });
    }

    private void configureFoodUpButton() {

        Button foodUp = findViewById(R.id.foodUpLocation);
        EditText foodAmount = findViewById(R.id.foodAmountLocation);
        foodUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getMoney() >= 4.00) {
                    storeWagon.buyFood();
                    storeWagon.spendMoney(4.00);
                    foodAmount.setText(String.valueOf(storeWagon.getFood()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureFoodDownButton() {

        Button foodDown = findViewById(R.id.foodDownLocation);
        EditText foodAmount = findViewById(R.id.foodAmountLocation);
        foodDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getFood() >= 20.00) {
                    storeWagon.sellFood();
                    storeWagon.returnMoney(4.00);
                    foodAmount.setText(String.valueOf(storeWagon.getFood()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureClothesUpButton() {

        Button clothesUp = findViewById(R.id.clothesUpLocation);
        EditText clothesAmount = findViewById(R.id.clothesAmountLocation);
        clothesUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getMoney() >= 10.00) {
                    storeWagon.buyClothes();
                    storeWagon.spendMoney(10.00);
                    clothesAmount.setText(String.valueOf(storeWagon.getClothes()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureClothesDownButton() {

        Button clothesDown = findViewById(R.id.clothesDownLocation);
        EditText clothesAmount = findViewById(R.id.clothesAmountLocation);
        clothesDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getClothes() >= 1) {
                    storeWagon.sellClothes();
                    storeWagon.returnMoney(10.00);
                    clothesAmount.setText(String.valueOf(storeWagon.getClothes()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureTonguesUpButton() {

        Button tonguesUp = findViewById(R.id.tonguesUpLocation);
        EditText tonguesAmount = findViewById(R.id.tonguesAmountLocation);
        tonguesUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getMoney() >= 10.00) {
                    storeWagon.buyTongues();
                    storeWagon.spendMoney(10.00);
                    tonguesAmount.setText(String.valueOf(storeWagon.getTongues()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureTonguesDownButton() {

        Button tonguesDown = findViewById(R.id.tonguesDownLocation);
        EditText tonguesAmount = findViewById(R.id.tonguesAmountLocation);
        tonguesDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getTongues() >= 1) {
                    storeWagon.sellTongues();
                    storeWagon.returnMoney(10.00);
                    tonguesAmount.setText(String.valueOf(storeWagon.getTongues()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureAxlesUpButton() {

        Button axlesUp = findViewById(R.id.axlesUpLocation);
        EditText axlesAmount = findViewById(R.id.axlesAmountLocation);
        axlesUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getMoney() >= 10.00) {
                    storeWagon.buyAxles();
                    storeWagon.spendMoney(10.00);
                    axlesAmount.setText(String.valueOf(storeWagon.getAxles()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureAxlesDownButton() {

        Button axlesDown = findViewById(R.id.axlesDownLocation);
        EditText axlesAmount = findViewById(R.id.axlesAmountLocation);
        axlesDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getAxles() >= 1) {
                    storeWagon.sellAxles();
                    storeWagon.returnMoney(10.00);
                    axlesAmount.setText(String.valueOf(storeWagon.getAxles()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureWheelsUpButton() {

        Button wheelsUp = findViewById(R.id.wheelsUpLocation);
        EditText wheelsAmount = findViewById(R.id.wheelsAmountLocation);
        wheelsUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getMoney() >= 10.00) {
                    storeWagon.buyWheels();
                    storeWagon.spendMoney(10.00);
                    wheelsAmount.setText(String.valueOf(storeWagon.getWheels()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureWheelsDownButton() {

        Button wheelsDown = findViewById(R.id.wheelsDownLocation);
        EditText wheelsAmount = findViewById(R.id.wheelsAmountLocation);
        wheelsDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getWheels() >= 1) {
                    storeWagon.sellWheels();
                    storeWagon.returnMoney(10.00);
                    wheelsAmount.setText(String.valueOf(storeWagon.getWheels()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureOxenUpButton() {

        Button oxenUp = findViewById(R.id.oxenUpLocation);
        EditText oxenAmount = findViewById(R.id.oxenAmountLocation);
        oxenUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getMoney() >= 40.00) {
                    storeWagon.buyOxen();
                    storeWagon.spendMoney(40.00);
                    oxenAmount.setText(String.valueOf(storeWagon.getOxen()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureOxenDownButton() {

        Button oxenDown = findViewById(R.id.oxenDownLocation);
        EditText oxenAmount = findViewById(R.id.oxenAmountLocation);
        oxenDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getOxen() >= 1) {
                    storeWagon.sellOxen();
                    storeWagon.returnMoney(40.00);
                    oxenAmount.setText(String.valueOf(storeWagon.getOxen()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

}



package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class Store extends AppCompatActivity {


    public Entity Hattie;
    public Entity Charles;
    public Entity Augusta;
    public Entity Ben;
    public Entity Jake;
    public Wagon storeWagon;
    public DateAndDistance dateAndDistance;
    public Store(){}
    public Store(DateAndDistance dateAndDistance, Entity newHattie, Entity newCharles, Entity newAugusta, Entity newBen, Entity newJake, Wagon wagon){

        this.dateAndDistance = dateAndDistance;
        this.Hattie = newHattie;
        this.Charles = newCharles;
        this.Augusta = newAugusta;
        this.Ben = newBen;
        this.Jake = newJake;
        this.storeWagon = wagon;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        storeWagon = (Wagon) getIntent().getSerializableExtra("NewWagon");
        Hattie = (Entity) getIntent().getSerializableExtra("NewHattie");
        Charles = (Entity) getIntent().getSerializableExtra("NewCharles");
        Augusta = (Entity) getIntent().getSerializableExtra("NewAugusta");
        Ben = (Entity) getIntent().getSerializableExtra("NewBen");
        Jake = (Entity) getIntent().getSerializableExtra("NewJake");
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
        configureContinueButton();
    }

    private void configureContinueButton() {

        Button continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Wagon newWagon = new Wagon(storeWagon.people, storeWagon.money, storeWagon.oxen, storeWagon.food, storeWagon.clothes, storeWagon.tongues, storeWagon.axles, storeWagon.wheels);
                Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                Intent intent = new Intent(Store.this, DailyStatus.class);

                intent.putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                setContentView(R.layout.activity_daily_status);
                startActivity(new Intent(Store.this, DailyStatus.class));
                startActivity(intent);
            }
        });
    }

    private void configureFoodUpButton() {

        Button foodUp = findViewById(R.id.foodUp);
        EditText foodAmount = findViewById(R.id.foodAmount);
        foodUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getMoney() >= 2.00) {
                    storeWagon.buyFood();
                    storeWagon.spendMoney(2.00);
                    foodAmount.setText(String.valueOf(storeWagon.getFood()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureFoodDownButton() {

        Button foodDown = findViewById(R.id.foodDown);
        EditText foodAmount = findViewById(R.id.foodAmount);
        foodDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getFood() >= 10.00) {
                    storeWagon.sellFood();
                    storeWagon.returnMoney(2.00);
                    foodAmount.setText(String.valueOf(storeWagon.getFood()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureClothesUpButton() {

        Button clothesUp = findViewById(R.id.clothesUp);
        EditText clothesAmount = findViewById(R.id.clothesAmount);
        clothesUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getMoney() >= 10.00) {
                    storeWagon.buyClothes();
                    storeWagon.spendMoney(10.00);
                    clothesAmount.setText(String.valueOf(storeWagon.getClothes()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureClothesDownButton() {

        Button clothesDown = findViewById(R.id.clothesDown);
        EditText clothesAmount = findViewById(R.id.clothesAmount);
        clothesDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getClothes() >= 1) {
                    storeWagon.sellClothes();
                    storeWagon.returnMoney(10.00);
                    clothesAmount.setText(String.valueOf(storeWagon.getClothes()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureTonguesUpButton() {

        Button tonguesUp = findViewById(R.id.tonguesUp);
        EditText tonguesAmount = findViewById(R.id.tonguesAmount);
        tonguesUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getMoney() >= 10.00) {
                    storeWagon.buyTongues();
                    storeWagon.spendMoney(10.00);
                    tonguesAmount.setText(String.valueOf(storeWagon.getTongues()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureTonguesDownButton() {

        Button tonguesDown = findViewById(R.id.tonguesDown);
        EditText tonguesAmount = findViewById(R.id.tonguesAmount);
        tonguesDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getTongues() >= 1) {
                    storeWagon.sellTongues();
                    storeWagon.returnMoney(10.00);
                    tonguesAmount.setText(String.valueOf(storeWagon.getTongues()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureAxlesUpButton() {

        Button axlesUp = findViewById(R.id.axlesUp);
        EditText axlesAmount = findViewById(R.id.axlesAmount);
        axlesUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getMoney() >= 10.00) {
                    storeWagon.buyAxles();
                    storeWagon.spendMoney(10.00);
                    axlesAmount.setText(String.valueOf(storeWagon.getAxles()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureAxlesDownButton() {

        Button axlesDown = findViewById(R.id.axlesDown);
        EditText axlesAmount = findViewById(R.id.axlesAmount);
        axlesDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getAxles() >= 1) {
                    storeWagon.sellAxles();
                    storeWagon.returnMoney(10.00);
                    axlesAmount.setText(String.valueOf(storeWagon.getAxles()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureWheelsUpButton() {

        Button wheelsUp = findViewById(R.id.wheelsUp);
        EditText wheelsAmount = findViewById(R.id.wheelsAmount);
        wheelsUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getMoney() >= 10.00) {
                    storeWagon.buyWheels();
                    storeWagon.spendMoney(10.00);
                    wheelsAmount.setText(String.valueOf(storeWagon.getWheels()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureWheelsDownButton() {

        Button wheelsDown = findViewById(R.id.wheelsDown);
        EditText wheelsAmount = findViewById(R.id.wheelsAmount);
        wheelsDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getWheels() >= 1) {
                    storeWagon.sellWheels();
                    storeWagon.returnMoney(10.00);
                    wheelsAmount.setText(String.valueOf(storeWagon.getWheels()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }
    
    private void configureOxenUpButton() {

        Button oxenUp = findViewById(R.id.oxenUp);
        EditText oxenAmount = findViewById(R.id.oxenAmount);
        oxenUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getMoney() >= 40.00) {
                    storeWagon.buyOxen();
                    storeWagon.spendMoney(40.00);
                    oxenAmount.setText(String.valueOf(storeWagon.getOxen()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

    private void configureOxenDownButton() {

        Button oxenDown = findViewById(R.id.oxenDown);
        EditText oxenAmount = findViewById(R.id.oxenAmount);
        oxenDown.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                if (storeWagon.getOxen() >= 1) {
                    storeWagon.sellOxen();
                    storeWagon.returnMoney(40.00);
                    oxenAmount.setText(String.valueOf(storeWagon.getOxen()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", storeWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", storeWagon.moneySpent)));
            }
        });
    }

}


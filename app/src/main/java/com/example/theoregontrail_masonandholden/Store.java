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

    public Wagon myWagon = new Wagon(5, 850.00, 0, 0, 0, 0, 0, 0);

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

        Hattie = (Entity) getIntent().getSerializableExtra("NewHattie");
        Charles = (Entity) getIntent().getSerializableExtra("NewCharles");
        Augusta = (Entity) getIntent().getSerializableExtra("NewAugusta");
        Ben = (Entity) getIntent().getSerializableExtra("NewBen");
        Jake = (Entity) getIntent().getSerializableExtra("NewJake");
        storeWagon = (Wagon) getIntent().getSerializableExtra("NewWagon");
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

        Button continueButton = (Button) findViewById(R.id.backButtonLocation);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Wagon storeWagon = new Wagon(myWagon.people, myWagon.money, myWagon.oxen, myWagon.food, myWagon.clothes, myWagon.tongues, myWagon.axles, myWagon.wheels);

                Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                DateAndDistance newDateAndDistance = new DateAndDistance();

                Intent intent = new Intent(Store.this, DailyStatus.class);

                intent.putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", storeWagon).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                setContentView(R.layout.activity_daily_status);
                startActivity(new Intent(Store.this, DailyStatus.class));
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

                if (myWagon.getMoney() >= 2.00) {
                    myWagon.buyFood();
                    myWagon.spendMoney(2.00);
                    foodAmount.setText(String.valueOf(myWagon.getFood()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getFood() >= 10.00) {
                    myWagon.sellFood();
                    myWagon.returnMoney(2.00);
                    foodAmount.setText(String.valueOf(myWagon.getFood()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getMoney() >= 10.00) {
                    myWagon.buyClothes();
                    myWagon.spendMoney(10.00);
                    clothesAmount.setText(String.valueOf(myWagon.getClothes()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getClothes() >= 1) {
                    myWagon.sellClothes();
                    myWagon.returnMoney(10.00);
                    clothesAmount.setText(String.valueOf(myWagon.getClothes()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getMoney() >= 10.00) {
                    myWagon.buyTongues();
                    myWagon.spendMoney(10.00);
                    tonguesAmount.setText(String.valueOf(myWagon.getTongues()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getTongues() >= 1) {
                    myWagon.sellTongues();
                    myWagon.returnMoney(10.00);
                    tonguesAmount.setText(String.valueOf(myWagon.getTongues()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getMoney() >= 10.00) {
                    myWagon.buyAxles();
                    myWagon.spendMoney(10.00);
                    axlesAmount.setText(String.valueOf(myWagon.getAxles()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getAxles() >= 1) {
                    myWagon.sellAxles();
                    myWagon.returnMoney(10.00);
                    axlesAmount.setText(String.valueOf(myWagon.getAxles()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getMoney() >= 10.00) {
                    myWagon.buyWheels();
                    myWagon.spendMoney(10.00);
                    wheelsAmount.setText(String.valueOf(myWagon.getWheels()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getWheels() >= 1) {
                    myWagon.sellWheels();
                    myWagon.returnMoney(10.00);
                    wheelsAmount.setText(String.valueOf(myWagon.getWheels()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getMoney() >= 40.00) {
                    myWagon.buyOxen();
                    myWagon.spendMoney(40.00);
                    oxenAmount.setText(String.valueOf(myWagon.getOxen()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getOxen() >= 1) {
                    myWagon.sellOxen();
                    myWagon.returnMoney(40.00);
                    oxenAmount.setText(String.valueOf(myWagon.getOxen()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmountLocation);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmountLocation);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
            }
        });
    }

}


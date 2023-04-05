package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Store extends AppCompatActivity {

    public Wagon myWagon = new Wagon(5, 850.00, 0, 0, 0, 0, 0, 0);

//    final Button tonguesUp = findViewById(R.id.tonguesUp);
//    final Button tonguesDown = findViewById(R.id.tonguesDown);
//    final Button axlesUp = findViewById(R.id.axlesUp);
//    final Button axlesDown = findViewById(R.id.axlesDown);
//    final Button wheelsUp = findViewById(R.id.wheelsUp);
//    final Button wheelsDown = findViewById(R.id.wheelsDown);
//    final Button oxenUp = findViewById(R.id.oxenUp);
//    final Button oxenDown = findViewById(R.id.oxenDown);
//    final EditText tonguesAmount = findViewById(R.id.tonguesAmount);
//    final EditText axlesAmount = findViewById(R.id.axlesAmount);
//    final EditText wheelsAmount = findViewById(R.id.wheelsAmount);
//    final EditText oxenAmount = findViewById(R.id.oxenAmount);
//    final EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
//    final TextView foodText = findViewById(R.id.foodText);
//    final TextView clothesText = findViewById(R.id.clothesText);
//    final TextView tonguesText = findViewById(R.id.tonguesText);
//    final TextView axlesText = findViewById(R.id.axlesText);
//    final TextView wheelsText = findViewById(R.id.wheelsText);
//    final TextView oxenText = findViewById(R.id.oxenText);
//    final TextView yourMoneyText = findViewById(R.id.yourMoneyText);
//    final TextView moneyOwedText = findViewById(R.id.moneyOwedText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);


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

                Wagon wagon = new Wagon(myWagon.people, myWagon.money, myWagon.oxen, myWagon.food, myWagon.clothes, myWagon.tongues, myWagon.axles, myWagon.wheels);
                DailyStatus dailyStatus = new DailyStatus();
                dailyStatus.setWagon(wagon);

                startActivity(new Intent(Store.this, DailyStatus.class));
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

                if (myWagon.getMoney() >= 2.00) {
                    myWagon.buyFood();
                    myWagon.spendMoney(2.00);
                    foodAmount.setText(String.valueOf(myWagon.getFood()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getFood() >= 10.00) {
                    myWagon.sellFood();
                    myWagon.returnMoney(2.00);
                    foodAmount.setText(String.valueOf(myWagon.getFood()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getMoney() >= 10.00) {
                    myWagon.buyClothes();
                    myWagon.spendMoney(10.00);
                    clothesAmount.setText(String.valueOf(myWagon.getClothes()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getClothes() >= 1) {
                    myWagon.sellClothes();
                    myWagon.returnMoney(10.00);
                    clothesAmount.setText(String.valueOf(myWagon.getClothes()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getMoney() >= 10.00) {
                    myWagon.buyTongues();
                    myWagon.spendMoney(10.00);
                    tonguesAmount.setText(String.valueOf(myWagon.getTongues()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getTongues() >= 1) {
                    myWagon.sellTongues();
                    myWagon.returnMoney(10.00);
                    tonguesAmount.setText(String.valueOf(myWagon.getTongues()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getMoney() >= 10.00) {
                    myWagon.buyAxles();
                    myWagon.spendMoney(10.00);
                    axlesAmount.setText(String.valueOf(myWagon.getAxles()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getAxles() >= 1) {
                    myWagon.sellAxles();
                    myWagon.returnMoney(10.00);
                    axlesAmount.setText(String.valueOf(myWagon.getAxles()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getMoney() >= 10.00) {
                    myWagon.buyWheels();
                    myWagon.spendMoney(10.00);
                    wheelsAmount.setText(String.valueOf(myWagon.getWheels()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getWheels() >= 1) {
                    myWagon.sellWheels();
                    myWagon.returnMoney(10.00);
                    wheelsAmount.setText(String.valueOf(myWagon.getWheels()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getMoney() >= 10.00) {
                    myWagon.buyOxen();
                    myWagon.spendMoney(10.00);
                    oxenAmount.setText(String.valueOf(myWagon.getOxen()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
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

                if (myWagon.getOxen() >= 1) {
                    myWagon.sellOxen();
                    myWagon.returnMoney(10.00);
                    oxenAmount.setText(String.valueOf(myWagon.getOxen()));
                }
                EditText ownedMoney = findViewById(R.id.yourMoneyAmount);
                ownedMoney.setText(String.valueOf(String.format("%.2f", myWagon.getMoney())));
                EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
                moneyOwed.setText(String.valueOf(String.format("%.2f", myWagon.moneySpent)));
            }
        });
    }


}


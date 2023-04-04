package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Store extends AppCompatActivity {

    public Wagon myWagon = new Wagon(5, 850.00, 0, 0, 0, 0, 0, 0);
    final Button foodUp = findViewById(R.id.foodUp);
    final Button foodDown = findViewById(R.id.foodDown);
    final Button clothesUp = findViewById(R.id.clothesUp);
    final Button clothesDown = findViewById(R.id.clothesDown);
    final Button tonguesUp = findViewById(R.id.tonguesUp);
    final Button tonguesDown = findViewById(R.id.tonguesDown);
    final Button axlesUp = findViewById(R.id.axlesUp);
    final Button axlesDown = findViewById(R.id.axlesDown);
    final Button wheelsUp = findViewById(R.id.wheelsUp);
    final Button wheelsDown = findViewById(R.id.wheelsDown);
    final Button oxenUp = findViewById(R.id.oxenUp);
    final Button oxenDown = findViewById(R.id.oxenDown);
    final EditText foodAmount = findViewById(R.id.foodAmount);
    final EditText clothesAmount = findViewById(R.id.clothesAmount);
    final EditText tonguesAmount = findViewById(R.id.tonguesAmount);
    final EditText axlesAmount = findViewById(R.id.axlesAmount);
    final EditText wheelsAmount = findViewById(R.id.wheelsAmount);
    final EditText oxenAmount = findViewById(R.id.oxenAmount);
    final EditText moneyOwed = findViewById(R.id.moneyOwedAmount);
    final TextView foodText = findViewById(R.id.foodText);
    final TextView clothesText = findViewById(R.id.clothesText);
    final TextView tonguesText = findViewById(R.id.tonguesText);
    final TextView axlesText = findViewById(R.id.axlesText);
    final TextView wheelsText = findViewById(R.id.wheelsText);
    final TextView oxenText = findViewById(R.id.oxenText);
    final TextView yourMoneyText = findViewById(R.id.yourMoneyText);
    final TextView moneyOwedText = findViewById(R.id.moneyOwedText);

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
    }

    private void configureFoodUpButton() {

        Button foodUpButton = (Button) findViewById(R.id.foodUp);
        foodUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (myWagon.getMoney() >= 2.00) {
                    myWagon.buyFood();
                    myWagon.spendMoney(2.00);
                    foodAmount.setText(myWagon.getFood());
                }

            }
        });
    }

    private void configureFoodDownButton() {

        Button foodDownButton = (Button) findViewById(R.id.foodDown);
        foodDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (myWagon.getFood() >= 10.00) {
                    myWagon.sellFood();
                    myWagon.returnMoney(2.00);
                    foodAmount.setText(myWagon.getFood());
                }

            }
        });
    }

    private void configureClothesUpButton() {

        Button clothesUpButton = (Button) findViewById(R.id.clothesUp);
        clothesUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (myWagon.getMoney() >= 10.00) {
                    myWagon.buyClothes();
                    myWagon.spendMoney(10.00);
                    foodAmount.setText(myWagon.getClothes());
                }

            }
        });
    }

    private void configureClothesDownButton() {

        Button clothesDownButton = (Button) findViewById(R.id.clothesDown);
        clothesDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (myWagon.getFood() >= 10.00) {
                    myWagon.sellFood();
                    myWagon.returnMoney(2.00);
                    foodAmount.setText(myWagon.getFood());
                }

            }
        });
    }
}


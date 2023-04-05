package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DailyStatus extends AppCompatActivity {

    Wagon wagon;

    Wagon theWagon = new Wagon(10, 20, 30, 40, 50, 60, 70, 80);
    Weather weather = new Weather();
    DateAndDistance dateAndDistance = new DateAndDistance();
    GeneralHealth health = new GeneralHealth();

    public void setWagon(Wagon wagon){
        this.wagon = wagon;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_status);

        final Button NextDayButton = findViewById(R.id.NextDayButton);
        final TextView PeopleCount = findViewById(R.id.PeopleCount);
        final TextView MoneyCount = findViewById(R.id.MoneyCount);
        final TextView FoodCount = findViewById(R.id.FoodCount);
        final TextView OxenCount = findViewById(R.id.OxenCount);
        final TextView ClothesCount = findViewById(R.id.ClothesCount);
        final TextView TonguesCount = findViewById(R.id.TonguesCount);
        final TextView AxlesCount = findViewById(R.id.AxlesCount);
        final TextView WheelsCount = findViewById(R.id.WheelsCount);
        final TextView DayTracker = findViewById(R.id.DayTracker);
        final TextView DistanceTracker = findViewById(R.id.DistanceTracker);
        final TextView HealthTracker = findViewById(R.id.HealthTracker);
        final TextView TemperatureTracker = findViewById(R.id.TemperatureTracker);

        NextDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                PeopleCount.setText(String.valueOf(theWagon.getPeople()));
                MoneyCount.setText(String.valueOf(theWagon.getMoney()));
                FoodCount.setText(String.valueOf(theWagon.getFood()));
                OxenCount.setText(String.valueOf(theWagon.getOxen()));
                ClothesCount.setText(String.valueOf(theWagon.getClothes()));
                TonguesCount.setText(String.valueOf(theWagon.getTongues()));
                AxlesCount.setText(String.valueOf(theWagon.getAxles()));
                WheelsCount.setText(String.valueOf(theWagon.getWheels()));
                HealthTracker.setText(String.valueOf(health.getGeneralHealth()));
                DistanceTracker.setText(String.valueOf(dateAndDistance.getDistanceTraveled()));
                DayTracker.setText(String.valueOf(dateAndDistance.getCurrentDate()));
                TemperatureTracker.setText(String.valueOf(weather.getTemperature()));

            }
        });
    }

}
package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Random;

public class DailyStatus extends AppCompatActivity {

    public Wagon wagon;
    Weather weather = new Weather();
    DateAndDistance dateAndDistance = new DateAndDistance();
    GeneralHealth health = new GeneralHealth();
    RandomEvents randomEvents = new RandomEvents(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, 0);

    public DailyStatus(){}
    public DailyStatus(Wagon wagon){
        this.wagon = wagon;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_status);

        wagon = (Wagon) getIntent().getSerializableExtra("NewWagon");

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

        PeopleCount.setText(String.valueOf(wagon.getPeople()));
        MoneyCount.setText(String.valueOf(String.format("%.2f", wagon.getMoney())));
        FoodCount.setText(String.valueOf(wagon.getFood()));
        OxenCount.setText(String.valueOf(wagon.getOxen()));
        ClothesCount.setText(String.valueOf(wagon.getClothes()));
        TonguesCount.setText(String.valueOf(wagon.getTongues()));
        AxlesCount.setText(String.valueOf(wagon.getAxles()));
        WheelsCount.setText(String.valueOf(wagon.getWheels()));
        HealthTracker.setText(String.valueOf(health.getGeneralHealth()));
        DistanceTracker.setText(String.valueOf(dateAndDistance.getDistanceTraveled()));
        DayTracker.setText(String.valueOf(dateAndDistance.getCurrentDate()));
        TemperatureTracker.setText(String.valueOf(weather.getTemperature()));




        NextDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                weather.temperatureDaily();
                weather.rainfallDaily();
                health.decrementHealth();
                randomEvents.randomFruit(dateAndDistance.getMonth());
                randomEvents.randomBadGrass(weather.getRainfall());
                randomEvents.randomLostMember();
                if (randomEvents.fruit){
                    wagon.gainFood(20);
                }
                if (randomEvents.lostMember) {
                    dateAndDistance.addDays(randomEvents.randomDaysLost(5));
                }

                RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.daysLost, randomEvents.foodLost);

                dailyEvents dailyEvents = new dailyEvents();

                Intent intent = new Intent(DailyStatus.this, dailyEvents.class);
                intent.putExtra("NewRandomEvents", newRandomEvents);
                startActivity(intent);

            }
        });
    }

}
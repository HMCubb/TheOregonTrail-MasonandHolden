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
    public Entity Hattie;
    public Entity Charles;
    public Entity Augusta;
    public Entity Ben;
    public Entity Jake;

    Weather weather = new Weather();
    DateAndDistance dateAndDistance = new DateAndDistance();
    GeneralHealth health = new GeneralHealth();
    RandomEvents randomEvents = new RandomEvents(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, 0, 0, 0, 0,0);

    public DailyStatus(){}
    public DailyStatus(Wagon wagon, Entity newHattie, Entity newCharles, Entity newAugusta, Entity newBen, Entity newJake){
        this.wagon = wagon;
        this.Hattie = newHattie;
        this.Charles = newCharles;
        this.Augusta = newAugusta;
        this.Ben = newBen;
        this.Jake = newJake;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_status);

        wagon = (Wagon) getIntent().getSerializableExtra("NewWagon");
        Hattie = (Entity) getIntent().getSerializableExtra("NewHattie");
        Charles = (Entity) getIntent().getSerializableExtra("NewCharles");
        Augusta = (Entity) getIntent().getSerializableExtra("NewAugusta");
        Ben = (Entity) getIntent().getSerializableExtra("NewBen");
        Jake = (Entity) getIntent().getSerializableExtra("NewJake");

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
                randomEvents.randomOxenWander();
                randomEvents.randomAbandonedWagon();
                randomEvents.randomFire();
                randomEvents.randomThief();
                randomEvents.randomBlockedTrail(dateAndDistance.getDistanceTraveled());
                randomEvents.randomLoseTrail();
                randomEvents.randomRoughTrail();

                if (!randomEvents.blockedTrail && !randomEvents.lostMember && !randomEvents.loseTrail) {
                    dateAndDistance.dailyMotion();
                }

                if (randomEvents.fruit){
                    wagon.gainFood(20);
                }
                if (randomEvents.lostMember) {
                    randomEvents.setDaysLost(randomEvents.randomDaysLost(5));
                    dateAndDistance.addDays(randomEvents.getDaysLost());
                }
                if (randomEvents.oxenWandered && !randomEvents.lostMember) {
                    randomEvents.setDaysLost(randomEvents.randomDaysLost(3));
                    dateAndDistance.addDays(randomEvents.getDaysLost());
                }
                if (randomEvents.abandonedWagon) {
                    randomEvents.setFoodLost(randomEvents.randomFoodLost(wagon.getFood() / 5));
                    randomEvents.setWheelsLost(randomEvents.randomOtherLost(1));
                    randomEvents.setAxlesLost(randomEvents.randomOtherLost(1));
                    randomEvents.setTonguesLost(randomEvents.randomOtherLost(1));
                    randomEvents.setClothesLost(randomEvents.randomOtherLost(wagon.getClothes() / 3));

                    wagon.setClothes(wagon.clothes + randomEvents.getClothesLost());
                    wagon.setAxles(wagon.axles + randomEvents.getAxlesLost());
                    wagon.setWheels(wagon.wheels + randomEvents.getWheelsLost());
                    wagon.setTongues(wagon.tongues + randomEvents.getTonguesLost());
                    wagon.setFood(wagon.food + randomEvents.getFoodLost());
                }

                if (randomEvents.fire && !randomEvents.abandonedWagon && !randomEvents.thief) {
                    randomEvents.setFoodLost(randomEvents.randomFoodLost(wagon.getFood() / 2));
                    randomEvents.setWheelsLost(randomEvents.randomOtherLost(1));
                    randomEvents.setAxlesLost(randomEvents.randomOtherLost(1));
                    randomEvents.setTonguesLost(randomEvents.randomOtherLost(1));
                    randomEvents.setClothesLost(randomEvents.randomOtherLost(wagon.getClothes() / 2));

                    wagon.setClothes(wagon.clothes - randomEvents.getClothesLost());
                    wagon.setAxles(wagon.axles - randomEvents.getAxlesLost());
                    wagon.setWheels(wagon.wheels - randomEvents.getWheelsLost());
                    wagon.setTongues(wagon.tongues - randomEvents.getTonguesLost());
                    wagon.setFood(wagon.food - randomEvents.getFoodLost());
                }

                if (randomEvents.thief && !randomEvents.abandonedWagon) {
                    randomEvents.setFoodLost(randomEvents.randomFoodLost(wagon.getFood() / 10));
                    randomEvents.setClothesLost(randomEvents.randomOtherLost(wagon.getClothes() / 3));

                    wagon.setClothes(wagon.clothes - randomEvents.getClothesLost());
                    wagon.setFood(wagon.food - randomEvents.getFoodLost());
                }

                if (randomEvents.blockedTrail && !randomEvents.loseTrail) {
                    dateAndDistance.addDays(2);
                }

                if (randomEvents.loseTrail) {
                    dateAndDistance.addDays(1);
                }

                if (randomEvents.roughTrail) {
                    health.addHealth(10);
                }




                RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost);
                Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);

                Intent intent = new Intent(DailyStatus.this, dailyEvents.class);

                intent.putExtra("NewRandomEvents", newRandomEvents).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                setContentView(R.layout.activity_daily_status);
                startActivity(new Intent(DailyStatus.this, dailyEvents.class));
                startActivity(intent);
            }
        });
    }

}
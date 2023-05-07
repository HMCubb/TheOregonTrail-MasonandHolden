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
    public DateAndDistance dateAndDistance;

    Weather weather = new Weather();
    GeneralHealth health = new GeneralHealth();
    RandomEvents randomEvents = new RandomEvents(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, 0, 0, 0, 0,0, 0);

    public DailyStatus(){}
    public DailyStatus(DateAndDistance dateAndDistance, Wagon wagon, Entity newHattie, Entity newCharles, Entity newAugusta, Entity newBen, Entity newJake){

        this.wagon = wagon;
        this.Hattie = newHattie;
        this.Charles = newCharles;
        this.Augusta = newAugusta;
        this.Ben = newBen;
        this.Jake = newJake;
        this.dateAndDistance = dateAndDistance;
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
        dateAndDistance = (DateAndDistance) getIntent().getSerializableExtra("NewDateAndDistance");

        configureNextDayButton();

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
    }

    private void configureNextDayButton() {

        Button nextDayButton = (Button) findViewById(R.id.NextDayButton);
        nextDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean alive = false;
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
                randomEvents.randomSnakebite();
                randomEvents.randomInjury();
                randomEvents.randomOxenDamage(dateAndDistance.getDistanceTraveled(), randomEvents.badGrass);
                randomEvents.randomHail(weather.getTemperature());
                randomEvents.randomFog(weather.getTemperature());
                randomEvents.randomBlizzard(weather.getTemperature());
                randomEvents.randomLowWater(weather.getRainfall());
                randomEvents.randomBadWater(weather.getRainfall());
                randomEvents.randomDisease(health.getGeneralHealth());
                health.weatherHealth(weather.getTemperature(), wagon.getClothes(), wagon.getPeople());

                while (!alive) {
                    int person = randomEvents.randomChooseMember(5);
                    if (person == 1) {
                        if (!Hattie.dead) {
                            alive = true;
                            randomEvents.setMemberLost(1);
                            randomEvents.randomHealedDisease(Hattie.sick);
                            randomEvents.randomHealedInjury(Hattie.injured);
                        }
                    }
                    else if (person == 2) {
                        if (!Charles.dead) {
                            alive = true;
                            randomEvents.setMemberLost(2);
                            randomEvents.randomHealedDisease(Charles.sick);
                            randomEvents.randomHealedInjury(Charles.injured);
                        }
                    }
                    else if (person == 3) {
                        if (!Augusta.dead) {
                            alive = true;
                            randomEvents.setMemberLost(3);
                            randomEvents.randomHealedDisease(Augusta.sick);
                            randomEvents.randomHealedInjury(Augusta.injured);
                        }
                    }
                    else if (person == 4) {
                        if (!Ben.dead) {
                            alive = true;
                            randomEvents.setMemberLost(4);
                            randomEvents.randomHealedDisease(Ben.sick);
                            randomEvents.randomHealedInjury(Ben.injured);
                        }
                    }
                    else {
                        if (!Jake.dead) {
                            alive = true;
                            randomEvents.setMemberLost(5);
                            randomEvents.randomHealedDisease(Jake.sick);
                            randomEvents.randomHealedInjury(Jake.injured);
                        }
                    }
                }

                health.addHealth((dateAndDistance.milesPerDay / 5) - 2);

                if (!randomEvents.blockedTrail && !randomEvents.lostMember && !randomEvents.loseTrail && !randomEvents.fog) {
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

                if (randomEvents.fog) {
                    dateAndDistance.addDays(1);
                }

                if (randomEvents.roughTrail) {
                    health.addHealth(10);
                }

                if (randomEvents.snakeBite || randomEvents.injury) {
                    if (randomEvents.getMemberLost() == 1) {
                        if (Hattie.injured) {
                            Hattie.dead = true;
                            wagon.removePerson();
                        }
                        else {
                            Hattie.injured = true;
                            health.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 2) {
                        if (Charles.injured) {
                            Charles.dead = true;
                            wagon.removePerson();
                        }
                        else {
                            Charles.injured = true;
                            health.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 3) {
                        if (Augusta.injured) {
                            Augusta.dead = true;
                            wagon.removePerson();
                        }
                        else {
                            Augusta.injured = true;
                            health.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 4) {
                        if (Ben.injured) {
                            Ben.dead = true;
                            wagon.removePerson();
                        }
                        else {
                            Ben.injured = true;
                            health.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 5) {
                        if (Jake.injured) {
                            Jake.dead = true;
                            wagon.removePerson();
                        }
                        else {
                            Jake.injured = true;
                            health.addHealth(20);
                        }
                    }
                }

                if (randomEvents.disease) {
                    if (randomEvents.getMemberLost() == 1) {
                        if (Hattie.sick) {
                            Hattie.dead = true;
                            wagon.removePerson();
                        }
                        else {
                            Hattie.sick = true;
                            health.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 2) {
                        if (Charles.sick) {
                            Charles.dead = true;
                            wagon.removePerson();
                        }
                        else {
                            Charles.sick = true;
                            health.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 3) {
                        if (Augusta.sick) {
                            Augusta.dead = true;
                            wagon.removePerson();
                        }
                        else {
                            Augusta.sick = true;
                            health.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 4) {
                        if (Ben.sick) {
                            Ben.dead = true;
                            wagon.removePerson();
                        }
                        else {
                            Ben.sick = true;
                            health.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 5) {
                        if (Jake.sick) {
                            Jake.dead = true;
                            wagon.removePerson();
                        }
                        else {
                            Jake.sick = true;
                            health.addHealth(20);
                        }
                    }
                }

                if (randomEvents.oxenDamage) {
                    wagon.loseOx();
                }

                if (randomEvents.hail) {
                    health.addHealth(7);
                }

                if (randomEvents.blizzard) {
                    health.addHealth(14);
                }

                if (randomEvents.badWater) {
                    health.addHealth(20);
                }

                if (randomEvents.lowWater) {
                    health.addHealth(10);
                }

                if (randomEvents.healedDisease && !randomEvents.snakeBite && !randomEvents.injury && !randomEvents.disease) {
                    if (randomEvents.getMemberLost() == 1) {
                        Hattie.sick = false;
                    }
                    else if (randomEvents.getMemberLost() == 2) {
                        Charles.sick = false;
                    }
                    else if (randomEvents.getMemberLost() == 3) {
                        Augusta.sick = false;
                    }
                    else if (randomEvents.getMemberLost() == 4) {
                        Ben.sick = false;
                    }
                    else  {
                        Jake.sick = false;
                    }
                }

                if (randomEvents.healedInjury && !randomEvents.snakeBite && !randomEvents.injury && !randomEvents.disease) {
                    if (randomEvents.getMemberLost() == 1) {
                        Hattie.injured = false;
                    }
                    else if (randomEvents.getMemberLost() == 2) {
                        Charles.injured = false;
                    }
                    else if (randomEvents.getMemberLost() == 3) {
                        Augusta.injured = false;
                    }
                    else if (randomEvents.getMemberLost() == 4) {
                        Ben.injured = false;
                    }
                    else  {
                        Jake.injured = false;
                    }
                }

                dateAndDistance.locationCheck();
                dateAndDistance.location();

                if (dateAndDistance.locationTicker == 8) {
                    if (dateAndDistance.reachedEnd) {
                        //Display winning screen
                    }
                }
                else if (dateAndDistance.locationTicker == 7) {
                    if (dateAndDistance.beenToTheDalles) {

                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                        Intent intent = new Intent(DailyStatus.this, dailyEvents.class);

                        intent.putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(DailyStatus.this, LocationPage.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 6) {
                    if (dateAndDistance.beenToFortWallaWalla) {

                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                        Intent intent = new Intent(DailyStatus.this, dailyEvents.class);

                        intent.putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(DailyStatus.this, LocationPage.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 5) {
                    if (dateAndDistance.beenToFortBoise) {

                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                        Intent intent = new Intent(DailyStatus.this, dailyEvents.class);

                        intent.putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(DailyStatus.this, LocationPage.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 4) {
                    if (dateAndDistance.beenToFortHall) {

                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                        Intent intent = new Intent(DailyStatus.this, dailyEvents.class);

                        intent.putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(DailyStatus.this, LocationPage.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 3) {
                    if (dateAndDistance.beenToSouthPass) {

                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                        Intent intent = new Intent(DailyStatus.this, dailyEvents.class);

                        intent.putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(DailyStatus.this, LocationPage.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 2) {
                    if (dateAndDistance.beenToIndependenceRock) {

                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                        Intent intent = new Intent(DailyStatus.this, dailyEvents.class);

                        intent.putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(DailyStatus.this, LocationPage.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 1) {
                    if (dateAndDistance.beenToFortLaramie) {

                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                        Intent intent = new Intent(DailyStatus.this, LocationPage.class);

                        intent.putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(DailyStatus.this, LocationPage.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 0) {
                    if (dateAndDistance.beenToKearny) {

                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                        Intent intent = new Intent(DailyStatus.this, LocationPage.class);

                        intent.putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(DailyStatus.this, LocationPage.class));
                        startActivity(intent);
                    }
                    else {
                        RandomEvents newRandomEvents = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);

                        Intent intent = new Intent(DailyStatus.this, dailyEvents.class);

                        intent.putExtra("NewWagon", newWagon).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEvents).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                        setContentView(R.layout.activity_daily_events);
                        startActivity(new Intent(DailyStatus.this, dailyEvents.class));
                        startActivity(intent);
                    }
                }
            }
        });
    }

}
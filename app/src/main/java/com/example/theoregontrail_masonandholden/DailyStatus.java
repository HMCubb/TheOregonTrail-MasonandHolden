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

/**
 * The DailyStatus class rolls all of the random events then passes those newly generated values to the dailyEvents page.
 * @filename OregonTrailMasonandHolden
 * @author Holden Cubberley & Mason Muether
 * @date 5/9/2023
 */
public class DailyStatus extends AppCompatActivity {

    // Public value initialization.
    public Wagon wagon;
    public Entity Hattie;
    public Entity Charles;
    public Entity Augusta;
    public Entity Ben;
    public Entity Jake;
    public DateAndDistance dateAndDistance;

    public Weather newWeather;
    public GeneralHealth newHealth;
    RandomEvents randomEvents = new RandomEvents(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 0, 0, 0, 0, 0,0, 0);

    public DailyStatus(){}

    // Package with all values that this class intakes from serializable values (more for completeness).
    public DailyStatus(Weather weather, GeneralHealth health, DateAndDistance dateAndDistance, Wagon wagon, Entity newHattie, Entity newCharles, Entity newAugusta, Entity newBen, Entity newJake){

        this.wagon = wagon;
        this.Hattie = newHattie;
        this.Charles = newCharles;
        this.Augusta = newAugusta;
        this.Ben = newBen;
        this.Jake = newJake;
        this.dateAndDistance = dateAndDistance;
        this.newHealth = health;
        this.newWeather = weather;
    }

    /**
     * onCreate
     * When the program is initially ran, all of the serializable elements within this method are established.
     * All of the buttons and text values are also initialized and filled with their respective values.
     * The health is also established based on their numerical values.
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_status);

        // Pulling the serialized values from the previous class.
        wagon = (Wagon) getIntent().getSerializableExtra("NewWagon");
        Hattie = (Entity) getIntent().getSerializableExtra("NewHattie");
        Charles = (Entity) getIntent().getSerializableExtra("NewCharles");
        Augusta = (Entity) getIntent().getSerializableExtra("NewAugusta");
        Ben = (Entity) getIntent().getSerializableExtra("NewBen");
        Jake = (Entity) getIntent().getSerializableExtra("NewJake");
        dateAndDistance = (DateAndDistance) getIntent().getSerializableExtra("NewDateAndDistance");
        newHealth = (GeneralHealth) getIntent().getSerializableExtra("NewGeneralHealth");
        newWeather = (Weather) getIntent().getSerializableExtra("NewWeather");

        // Initialization of the nextDay button class.
        configureNextDayButton();

        // Initialization of the buttons and text values displayed on screen.
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

        // Pulling all the values from each object, then setting the corresponding text fields equal to those values.
        dateAndDistance.setPace(dateAndDistance.getPace());
        PeopleCount.setText(String.valueOf(wagon.getPeople()));
        MoneyCount.setText(String.valueOf(String.format("%.2f", wagon.getMoney())));
        FoodCount.setText(String.valueOf(wagon.getFood()));
        OxenCount.setText(String.valueOf(wagon.getOxen()));
        ClothesCount.setText(String.valueOf(wagon.getClothes()));
        TonguesCount.setText(String.valueOf(wagon.getTongues()));
        AxlesCount.setText(String.valueOf(wagon.getAxles()));
        WheelsCount.setText(String.valueOf(wagon.getWheels()));
        DistanceTracker.setText(String.valueOf(dateAndDistance.getDistanceTraveled()));
        DistanceTracker.append(" miles");
        DayTracker.setText(String.valueOf(dateAndDistance.getCurrentDate()));
        TemperatureTracker.setText(String.valueOf(newWeather.getTemperature() + 10));
        TemperatureTracker.append("°F");

        // Establishes the health string as very poor, poor, okay, or good depending on the numerical health value.
        if (newHealth.getGeneralHealth() >= 105) {
            HealthTracker.setText("Very Poor");
        }
        else if (newHealth.getGeneralHealth() >= 70) {
            HealthTracker.setText("Poor");
        }
        else if (newHealth.getGeneralHealth() >= 35) {
            HealthTracker.setText("Okay");
        }
        else {
            HealthTracker.setText("Good");
        }
    }

    // Everything that happens upon clicking the next day button is held within this class.
    private void configureNextDayButton() {

        Button nextDayButton = (Button) findViewById(R.id.NextDayButton);
        nextDayButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Upon clicking the "nextDayButton" button, the weather, health, and random events are generated.
             * Afterwards, all objects are passed to the dailyEvents page by transforming them into serializable values.
             * @param view The view that was clicked.
             */
            @Override
            public void onClick(View view) {

                // Generates the weather, health, and random events.
                boolean alive = false;
                newWeather.temperatureDaily();
                newWeather.rainfallDaily();
                newHealth.decrementHealth();
                randomEvents.randomFruit(dateAndDistance.getMonth());
                randomEvents.randomBadGrass(newWeather.getRainfall());
                randomEvents.randomLostMember();
                randomEvents.randomOxenWander(wagon.getOxen());
                randomEvents.randomAbandonedWagon();
                randomEvents.randomFire();
                randomEvents.randomThief();
                randomEvents.randomBlockedTrail(dateAndDistance.getDistanceTraveled());
                randomEvents.randomLoseTrail();
                randomEvents.randomRoughTrail();
                randomEvents.randomSnakebite();
                randomEvents.randomInjury();
                randomEvents.randomOxenDamage(dateAndDistance.getDistanceTraveled(), randomEvents.badGrass, wagon.getOxen());
                randomEvents.randomHail(newWeather.getTemperature());
                randomEvents.randomFog(newWeather.getTemperature());
                randomEvents.randomBlizzard(newWeather.getTemperature());
                randomEvents.randomLowWater(newWeather.getRainfall());
                randomEvents.randomBadWater(newWeather.getRainfall());
                randomEvents.randomDisease(newHealth.getGeneralHealth());
                randomEvents.randomAxelBroke(wagon.brokenAxel);
                randomEvents.randomTongueBroke(wagon.brokenTongue);
                randomEvents.randomWheelBroke(wagon.brokenWheel);
                newHealth.weatherHealth(newWeather.getTemperature(), wagon.getClothes(), wagon.getPeople());
                newHealth.paceHealth(dateAndDistance.getPace());

                wagon.setRepairTongue(false);
                wagon.setRepairWheel(false);
                wagon.setRepairAxel(false);

                // Determines if people are alive, and changes the alive and dead values based on these determinations.
                while (!alive && (!Hattie.dead || !Charles.dead || !Augusta.dead || !Ben.dead || !Jake.dead)) {
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

                newHealth.addHealth((dateAndDistance.milesPerDay / 5) - 2);
                newHealth.addHealth(4 * (4 - wagon.getRations()));

                if (randomEvents.fruit){
                    wagon.gainFood(randomEvents.randomFoodLost(40));
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
                    randomEvents.setFoodLost(randomEvents.randomFoodLost(75));
                    randomEvents.setWheelsLost(randomEvents.randomOtherLost(1));
                    randomEvents.setAxlesLost(randomEvents.randomOtherLost(1));
                    randomEvents.setTonguesLost(randomEvents.randomOtherLost(1));
                    randomEvents.setClothesLost(randomEvents.randomOtherLost(5));

                    wagon.setClothes(wagon.clothes + randomEvents.getClothesLost());
                    wagon.setAxles(wagon.axles + randomEvents.getAxlesLost());
                    wagon.setWheels(wagon.wheels + randomEvents.getWheelsLost());
                    wagon.setTongues(wagon.tongues + randomEvents.getTonguesLost());
                    wagon.setFood(wagon.food + randomEvents.getFoodLost());
                    wagon.setOxen(wagon.oxen + randomEvents.randomOtherLost(1));
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
                    randomEvents.setFoodLost(randomEvents.randomFoodLost((wagon.getFood() / 10)+ 20));
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
                    newHealth.addHealth(10);
                }

                if (randomEvents.snakeBite || randomEvents.injury) {
                    if (randomEvents.getMemberLost() == 1) {
                        if (Hattie.injured) {
                            Hattie.dead = true;
                            Hattie.injured = false;
                            wagon.removePerson();
                        }
                        else {
                            Hattie.injured = true;
                            newHealth.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 2) {
                        if (Charles.injured) {
                            Charles.dead = true;
                            Charles.injured = false;
                            wagon.removePerson();
                        }
                        else {
                            Charles.injured = true;
                            newHealth.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 3) {
                        if (Augusta.injured) {
                            Augusta.dead = true;
                            Augusta.injured = false;
                            wagon.removePerson();
                        }
                        else {
                            Augusta.injured = true;
                            newHealth.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 4) {
                        if (Ben.injured) {
                            Ben.dead = true;
                            Ben.injured = false;
                            wagon.removePerson();
                        }
                        else {
                            Ben.injured = true;
                            newHealth.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 5) {
                        if (Jake.injured) {
                            Jake.dead = true;
                            Jake.injured = false;
                            wagon.removePerson();
                        }
                        else {
                            Jake.injured = true;
                            newHealth.addHealth(20);
                        }
                    }
                }

                if (randomEvents.disease) {
                    if (randomEvents.getMemberLost() == 1) {
                        if (Hattie.sick) {
                            Hattie.dead = true;
                            Hattie.sick = false;
                            wagon.removePerson();
                        }
                        else {
                            Hattie.sick = true;
                            newHealth.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 2) {
                        if (Charles.sick) {
                            Charles.dead = true;
                            Charles.sick = false;
                            wagon.removePerson();
                        }
                        else {
                            Charles.sick = true;
                            newHealth.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 3) {
                        if (Augusta.sick) {
                            Augusta.dead = true;
                            Augusta.sick = false;
                            wagon.removePerson();
                        }
                        else {
                            Augusta.sick = true;
                            newHealth.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 4) {
                        if (Ben.sick) {
                            Ben.dead = true;
                            Ben.sick = false;
                            wagon.removePerson();
                        }
                        else {
                            Ben.sick = true;
                            newHealth.addHealth(20);
                        }
                    }
                    else if (randomEvents.getMemberLost() == 5) {
                        if (Jake.sick) {
                            Jake.dead = true;
                            Jake.sick = false;
                            wagon.removePerson();
                        }
                        else {
                            Jake.sick = true;
                            newHealth.addHealth(20);
                        }
                    }
                }

                if (randomEvents.oxenDamage) {
                    wagon.loseOx();
                }

                if (randomEvents.hail) {
                    newHealth.addHealth(7);
                }

                if (randomEvents.blizzard) {
                    newHealth.addHealth(14);
                }

                if (randomEvents.badWater) {
                    newHealth.addHealth(20);
                }

                if (randomEvents.lowWater) {
                    newHealth.addHealth(10);
                }

                if (randomEvents.tongueBroke) {
                    if (wagon.getTongues() >= 1) {
                        wagon.setTongues(wagon.getTongues() - 1);
                    }
                    else {
                        dateAndDistance.setWagonDamage(dateAndDistance.getWagonDamage() + 1);
                        wagon.setBrokenTongue(true);
                    }
                }

                if (randomEvents.wheelBroke) {
                    if (wagon.getWheels() >= 1) {
                        wagon.setWheels(wagon.getWheels() - 1);
                    }
                    else {
                        dateAndDistance.setWagonDamage(dateAndDistance.getWagonDamage() + 1);
                        wagon.setBrokenWheel(true);
                    }
                }

                if (randomEvents.axelBroke) {
                    if (wagon.getAxles() >= 1) {
                        wagon.setAxles(wagon.getAxles() - 1);
                    }
                    else {
                        dateAndDistance.setWagonDamage(dateAndDistance.getWagonDamage() + 1);
                        wagon.setBrokenAxel(true);
                    }
                }

                if (wagon.brokenTongue && wagon.tongues > 0) {
                    wagon.setBrokenTongue(false);
                    wagon.setTongues(wagon.getTongues() - 1);
                    dateAndDistance.setWagonDamage(dateAndDistance.getWagonDamage() - 1);
                    wagon.setRepairTongue(true);
                }

                if (wagon.brokenWheel && wagon.wheels > 0) {
                    wagon.setBrokenWheel(false);
                    wagon.setTongues(wagon.getWheels() - 1);
                    dateAndDistance.setWagonDamage(dateAndDistance.getWagonDamage() - 1);
                    wagon.setRepairWheel(true);
                }

                if (wagon.brokenAxel && wagon.axles > 0) {
                    wagon.setBrokenAxel(false);
                    wagon.setAxles(wagon.getAxles() - 1);
                    dateAndDistance.setWagonDamage(dateAndDistance.getWagonDamage() - 1);
                    wagon.setRepairAxel(true);
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

                if (wagon.oxen <= 0) {
                    dateAndDistance.setWagonDamage(dateAndDistance.getWagonDamage() + 4);
                    newHealth.addHealth(20);
                }

                if (!randomEvents.blockedTrail && !randomEvents.lostMember && !randomEvents.loseTrail && !randomEvents.fog && !randomEvents.oxenWandered) {
                    dateAndDistance.dailyMotion();
                }

                if (wagon.oxen <= 0) {
                    dateAndDistance.setWagonDamage(dateAndDistance.getWagonDamage() - 4);
                }

                wagon.loseFood(wagon.rations * wagon.people);

                if (wagon.getFood() <= 0) {
                    newHealth.addHealth(25);
                }

                if (wagon.getFood() <= 0) {
                    wagon.setFood(0);
                }
                if (wagon.getClothes() <= 0) {
                    wagon.setClothes(0);
                }
                if (wagon.getOxen() <= 0) {
                    wagon.setOxen(0);
                }
                if (wagon.getWheels() <= 0) {
                    wagon.setWheels(0);
                }
                if (wagon.getTongues() <= 0) {
                    wagon.setTongues(0);
                }
                if (wagon.getAxles() <= 0) {
                    wagon.setAxles(0);
                }

                // Creates new objects with all values generated in this class, then passes them to the dailyEvents class using serializable.
                RandomEvents randomEventsPass = new RandomEvents(randomEvents.disease, randomEvents.badWater, randomEvents.lowWater, randomEvents.roughTrail, randomEvents.blizzard, randomEvents.fog, randomEvents.hail, randomEvents.oxenDamage, randomEvents.injury, randomEvents.snakeBite, randomEvents.loseTrail, randomEvents.thief, randomEvents.blockedTrail, randomEvents.fire, randomEvents.abandonedWagon, randomEvents.oxenWandered, randomEvents.lostMember, randomEvents.badGrass, randomEvents.fruit, randomEvents.healedDisease, randomEvents.healedInjury, randomEvents.tongueBroke, randomEvents.wheelBroke, randomEvents.axelBroke, randomEvents.daysLost, randomEvents.foodLost, randomEvents.clothesLost, randomEvents.axlesLost, randomEvents.wheelsLost, randomEvents.wheelsLost, randomEvents.memberLost);
                Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                Intent intent = new Intent(DailyStatus.this, dailyEvents.class);

                intent.putExtra("NewRandomEvents", randomEventsPass).putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewWagon", wagon).putExtra("NewDateAndDistance", dateAndDistance).putExtra("NewHattie", Hattie).putExtra("NewCharles", Charles).putExtra("NewAugusta", Augusta).putExtra("NewBen", Ben).putExtra("NewJake", Jake);

                setContentView(R.layout.activity_daily_events);
                startActivity(new Intent(DailyStatus.this, dailyEvents.class));
                startActivity(intent);
                }
        });
    }

}
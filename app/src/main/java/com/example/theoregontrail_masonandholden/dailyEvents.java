package com.example.theoregontrail_masonandholden;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;
import android.media.AudioFocusRequest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView;

import java.util.Date;

/**
 * The dailyEvents class displays the randomly generated values for each day in a way
 * that users can understand.
 * @filename OregonTrailMasonandHolden
 * @author Holden Cubberley & Mason Muether
 * @date 5/9/2023
 */
public class dailyEvents extends AppCompatActivity {

    // Public value initialization.
    public RandomEvents newRandomEvents;
    public Entity Hattie;
    public Entity Charles;
    public Entity Augusta;
    public Entity Ben;
    public Entity Jake;
    public DateAndDistance dateAndDistance;
    public Wagon wagon;
    public Weather newWeather;
    public GeneralHealth newHealth;

    public dailyEvents(){}

    // Package with all values that this class intakes from serializable values (more for completeness).
    public dailyEvents(Weather weather, GeneralHealth health, Wagon wagon, DateAndDistance dateAndDistance, RandomEvents newRandomEvents, Entity newHattie, Entity newCharles, Entity newAugusta, Entity newBen, Entity newJake){
        this.dateAndDistance = dateAndDistance;
        this.newRandomEvents = newRandomEvents;
        this.Hattie = newHattie;
        this.Charles = newCharles;
        this.Augusta = newAugusta;
        this.Ben = newBen;
        this.Jake = newJake;
        this.wagon = wagon;
        this.newWeather = weather;
        this.newHealth = health;
    }

    /**
     * onCreate
     * When the program is initially ran, all of the serializable elements within this method are established.
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_events);

        // Pulling the serialized values from the previous class.
        newRandomEvents = (RandomEvents) getIntent().getSerializableExtra("NewRandomEvents");
        Hattie = (Entity) getIntent().getSerializableExtra("NewHattie");
        Charles = (Entity) getIntent().getSerializableExtra("NewCharles");
        Augusta = (Entity) getIntent().getSerializableExtra("NewAugusta");
        Ben = (Entity) getIntent().getSerializableExtra("NewBen");
        Jake = (Entity) getIntent().getSerializableExtra("NewJake");
        dateAndDistance = (DateAndDistance) getIntent().getSerializableExtra("NewDateAndDistance");
        wagon = (Wagon) getIntent().getSerializableExtra("NewWagon");
        newHealth = (GeneralHealth) getIntent().getSerializableExtra("NewGeneralHealth");
        newWeather = (Weather) getIntent().getSerializableExtra("NewWeather");

        TextView eventText = findViewById(R.id.eventText);
        eventText.setText("Day " + (dateAndDistance.getDay() + ((dateAndDistance.getMonth() - 4) * 30)));

        // The rest of the onCreate class determines what will be printed for the user to see.
        if (!newRandomEvents.blockedTrail && !newRandomEvents.lostMember && !newRandomEvents.loseTrail && !newRandomEvents.fog && !newRandomEvents.oxenWandered) {
            if (wagon.getOxen() > 0) {
                eventText.append("\nYou travelled " + (dateAndDistance.milesPerDay / dateAndDistance.wagonDamage) + " miles.");
            }
            else {
                eventText.append("\nYou travelled " + (dateAndDistance.milesPerDay / (dateAndDistance.wagonDamage + 4)) + " miles.");
            }
        }
        if (newRandomEvents.fruit){
            eventText.append("\nYou found fruit, gain some food.");
        }
        if (newRandomEvents.lostMember) {
            if (newRandomEvents.getMemberLost() == 1) {
                eventText.append("\nHattie got lost, lose " + newRandomEvents.getDaysLost() + " days.");
            }
            else if (newRandomEvents.getMemberLost() == 2) {
                eventText.append("\nCharles got lost, lose " + newRandomEvents.getDaysLost() + " days.");
            }
            else if (newRandomEvents.getMemberLost() == 3) {
                eventText.append("\nAugusta got lost, lose " + newRandomEvents.getDaysLost() + " days.");
            }
            else if (newRandomEvents.getMemberLost() == 4) {
                eventText.append("\nBen got lost, lose " + newRandomEvents.getDaysLost() + " days.");
            }
            else{
                eventText.append("\nJake got lost, lose " + newRandomEvents.getDaysLost() + " days.");
            }
        }
        if (newRandomEvents.oxenWandered && !newRandomEvents.lostMember) {
            eventText.append("\nSome oxen wandered off, lose " + newRandomEvents.getDaysLost() + " days.");
        }
        if (newRandomEvents.abandonedWagon) {
            eventText.append("\nYou found an abandoned wagon, gain some supplies.");
        }
        if (newRandomEvents.fire && !newRandomEvents.abandonedWagon && !newRandomEvents.thief) {
            eventText.append("\nThe wagon caught fire, lose some supplies.");
        }
        if (newRandomEvents.thief && !newRandomEvents.abandonedWagon) {
            eventText.append("\nA thief came in the night, lose some supplies.");
        }
        if (newRandomEvents.blockedTrail && !newRandomEvents.loseTrail) {
            eventText.append("\nTrail is blocked, lose 2 days.");
        }
        if (newRandomEvents.loseTrail) {
            eventText.append("\nYou lost track of the trail, lose 1 day.");
        }
        if (newRandomEvents.fog) {
            eventText.append("\nThere was thick fog, lose 1 day.");
        }
        if (newRandomEvents.roughTrail) {
            eventText.append("\nThe trail was rough, the party is exhausted.");
        }
        
        if (newRandomEvents.snakeBite) {
            if (newRandomEvents.getMemberLost() == 1) {
                if (!Hattie.injured) {
                    eventText.append("\nHattie was bitten by a snake, and has died.");
                }
                else {
                    eventText.append("\nHattie was bitten by a snake, and is injured.");
                }
            }
            else if (newRandomEvents.getMemberLost() == 2) {
                if (!Charles.injured) {
                    eventText.append("\nCharles was bitten by a snake, and has died.");
                }
                else {
                    eventText.append("\nCharles was bitten by a snake, and is injured.");
                }
            }
            else if (newRandomEvents.getMemberLost() == 3) {
                if (!Augusta.injured) {
                    eventText.append("\nAugusta was bitten by a snake, and has died.");
                }
                else {
                    eventText.append("\nAugusta was bitten by a snake, and is injured.");
                }
            }
            else if (newRandomEvents.getMemberLost() == 4) {
                if (!Ben.injured) {
                    eventText.append("\nBen was bitten by a snake, and has died.");
                }
                else {
                    eventText.append("\nBen was bitten by a snake, and is injured.");
                }
            }
            else if (newRandomEvents.getMemberLost() == 5) {
                if (!Jake.injured) {
                    eventText.append("\nJake was bitten by a snake, and has died.");
                }
                else {
                    eventText.append("\nJake was bitten by a snake, and is injured.");
                }
            }
        }

        if (newRandomEvents.injury) {
            if (newRandomEvents.getMemberLost() == 1) {
                if (!Hattie.injured) {
                    eventText.append("\nHattie was injured, and has died.");
                }
                else {
                    eventText.append("\nHattie was injured.");
                }
            }
            else if (newRandomEvents.getMemberLost() == 2) {
                if (!Charles.injured) {
                    eventText.append("\nCharles was injured, and has died.");
                }
                else {
                    eventText.append("\nCharles was injured.");
                }
            }
            else if (newRandomEvents.getMemberLost() == 3) {
                if (!Augusta.injured) {
                    eventText.append("\nAugusta was injured, and has died.");
                }
                else {
                    eventText.append("\nAugusta was injured.");
                }
            }
            else if (newRandomEvents.getMemberLost() == 4) {
                if (!Ben.injured) {
                    eventText.append("\nBen was injured, and has died.");
                }
                else {
                    eventText.append("\nBen was injured.");
                }
            }
            else if (newRandomEvents.getMemberLost() == 5) {
                if (!Jake.injured) {
                    eventText.append("\nJake was injured, and has died.");
                }
                else {
                    eventText.append("\nJake was injured.");
                }
            }
        }

        if (newRandomEvents.disease) {
            if (newRandomEvents.getMemberLost() == 1) {
                if (!Hattie.sick) {
                    eventText.append("\nHattie has died of her illness.");
                }
                else {
                    eventText.append("\nHattie is sick.");
                }
            }
            else if (newRandomEvents.getMemberLost() == 2) {
                if (!Charles.sick) {
                    eventText.append("\nCharles has died of his illness.");
                }
                else {
                    eventText.append("\nCharles is sick.");
                }
            }
            else if (newRandomEvents.getMemberLost() == 3) {
                if (!Augusta.sick) {
                    eventText.append("\nAugusta has died of her illness.");
                }
                else {
                    eventText.append("\nAugusta is sick.");
                }
            }
            else if (newRandomEvents.getMemberLost() == 4) {
                if (!Ben.sick) {
                    eventText.append("\nBen has died of his illness.");
                }
                else {
                    eventText.append("\nBen is sick.");
                }
            }
            else if (newRandomEvents.getMemberLost() == 5) {
                if (!Jake.sick) {
                    eventText.append("\nJake has died of his illness.");
                }
                else {
                    eventText.append("\nJake is sick.");
                }
            }
        }
        if (newRandomEvents.badGrass) {
            eventText.append("\nThe grass is poor quality.");
        }
        if (newRandomEvents.oxenDamage) {
            eventText.append("\nOne of the oxen got sick, and has died.");
        }
        if (newRandomEvents.hail) {
            eventText.append("\nA hail storm has occurred, the party is chilly.");
        }
        if (newRandomEvents.blizzard) {
            eventText.append("\nA blizzard has occurred, the party is freezing.");
        }
        if (newRandomEvents.badWater) {
            eventText.append("\nThe water is poor quality, the party feels unwell.");
        }
        if (newRandomEvents.lowWater) {
            eventText.append("\nThere was very low water, the party is thirsty.");
        }
        if (newRandomEvents.tongueBroke) {
            if (!wagon.brokenTongue) {
                eventText.append("\nThe wagon's tongue broke, you replace it with a spare.");
            }
            else {
                eventText.append("\nThe wagon's tongue is broken, travel will be much slower.");
            }
        }
        if (newRandomEvents.wheelBroke) {
            if (!wagon.brokenWheel) {
                eventText.append("\nThe wagon's wheel broke, you replace it with a spare.");
            }
            else {
                eventText.append("\nThe wagon's wheel is broken, travel will be much slower.");
            }
        }
        if (newRandomEvents.axelBroke) {
            if (!wagon.brokenAxel) {
                eventText.append("\nThe wagon's axel broke, you replace it with a spare.");
            }
            else {
                eventText.append("\nThe wagon's axel is broken, travel will be much slower.");
            }
        }
        if (wagon.repairTongue) {
            eventText.append("\nYou repair the wagon's tongue.");
        }
        if (wagon.repairWheel) {
            eventText.append("\nYou repair the wagon's wheel.");
        }
        if (wagon.repairAxel) {
            eventText.append("\nYou repair the wagon's axel.");
        }
        if (newRandomEvents.healedDisease && !newRandomEvents.snakeBite && !newRandomEvents.injury && !newRandomEvents.disease) {
            if (newRandomEvents.getMemberLost() == 1) {
                eventText.append("\nHattie is no longer sick.");
            }
            else if (newRandomEvents.getMemberLost() == 2) {
                eventText.append("\nCharles is no longer sick.");
            }
            else if (newRandomEvents.getMemberLost() == 3) {
                eventText.append("\nAugusta is no longer sick.");
            }
            else if (newRandomEvents.getMemberLost() == 4) {
                eventText.append("\nBen is no longer sick.");
            }
            else  {
                eventText.append("\nJake is no longer sick.");
            }
        }
        if (newRandomEvents.healedInjury && !newRandomEvents.snakeBite && !newRandomEvents.injury && !newRandomEvents.disease) {
            if (newRandomEvents.getMemberLost() == 1) {
                eventText.append("\nHattie is no longer injured.");
            }
            else if (newRandomEvents.getMemberLost() == 2) {
                eventText.append("\nCharles is no longer injured.");
            }
            else if (newRandomEvents.getMemberLost() == 3) {
                eventText.append("\nAugusta is no longer injured.");
            }
            else if (newRandomEvents.getMemberLost() == 4) {
                eventText.append("\nBen is no longer injured.");
            }
            else  {
                eventText.append("\nJake is no longer injured.");
            }
        }
        if (wagon.getOxen() <= 0) {
            eventText.append("\nYou have no oxen, travelling is extremely brutal");
        }
        if (wagon.getFood() <= 0) {
            eventText.append("\nThere is no more food, everyone is starving.");
        }


        if (Hattie.dead && Charles.dead && Augusta.dead && Ben.dead && Jake.dead) {
            eventText.append("\nEverybody has died, you lose!");
        }

        configureNextButton();
    }

    private void configureNextButton() {

        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Upon clicking the "nextButton" button, the display will switch to either the daily status screen,
             * or the location screen, depending on where the user is compared to the starting distance.
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                // Checks where the user at is comparison to the starting point, then determines what location they are at.
                dateAndDistance.locationCheck();
                dateAndDistance.location();

                // This series of if/else-if/else statements determines where the user goes if all the party members are dead, if they reach a location, are on the normal path, or win.
                if (dateAndDistance.locationTicker == 8) {
                    // If all party members are dead...
                    if (wagon.getPeople() == 0) {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LoseScreen.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        // ...take user to lose screen.
                        setContentView(R.layout.activity_lose_screen);
                        startActivity(new Intent(dailyEvents.this, LoseScreen.class));
                        startActivity(intent);
                    }
                    // If user has reached location (the end)...
                    else if (dateAndDistance.reachedEnd) {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, WinScreen.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        // ...take user to location screen (win screen).
                        setContentView(R.layout.activity_win_screen);
                        startActivity(new Intent(dailyEvents.this, WinScreen.class));
                        startActivity(intent);
                    }
                    // If neither true, continue to the regular path (DailyEvents screen).
                    else {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, DailyStatus.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewWagon", newWagon).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_daily_events);
                        startActivity(new Intent(dailyEvents.this, DailyStatus.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 7) {
                    if (wagon.getPeople() == 0) {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LoseScreen.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_lose_screen);
                        startActivity(new Intent(dailyEvents.this, LoseScreen.class));
                        startActivity(intent);
                    }
                    else if (dateAndDistance.beenToTheDalles) {
                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LocationPage.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(dailyEvents.this, LocationPage.class));
                        startActivity(intent);
                    }
                    else {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, DailyStatus.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewWagon", newWagon).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                        setContentView(R.layout.activity_daily_events);
                        startActivity(new Intent(dailyEvents.this, DailyStatus.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 6) {
                    if (wagon.getPeople() == 0) {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LoseScreen.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_lose_screen);
                        startActivity(new Intent(dailyEvents.this, LoseScreen.class));
                        startActivity(intent);
                    }
                    else if (dateAndDistance.beenToFortWallaWalla) {
                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LocationPage.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(dailyEvents.this, LocationPage.class));
                        startActivity(intent);
                    }
                    else {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, DailyStatus.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewWagon", newWagon).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                        setContentView(R.layout.activity_daily_events);
                        startActivity(new Intent(dailyEvents.this, DailyStatus.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 5) {
                    if (wagon.getPeople() == 0) {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LoseScreen.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_lose_screen);
                        startActivity(new Intent(dailyEvents.this, LoseScreen.class));
                        startActivity(intent);
                    }
                    else if (dateAndDistance.beenToFortBoise) {
                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LocationPage.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(dailyEvents.this, LocationPage.class));
                        startActivity(intent);
                    }
                    else {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, DailyStatus.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewWagon", newWagon).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                        setContentView(R.layout.activity_daily_events);
                        startActivity(new Intent(dailyEvents.this, DailyStatus.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 4) {
                    if (wagon.getPeople() == 0) {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LoseScreen.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_lose_screen);
                        startActivity(new Intent(dailyEvents.this, LoseScreen.class));
                        startActivity(intent);
                    }
                    else if (dateAndDistance.beenToFortHall) {
                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LocationPage.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(dailyEvents.this, LocationPage.class));
                        startActivity(intent);
                    }
                    else {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, DailyStatus.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewWagon", newWagon).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                        setContentView(R.layout.activity_daily_events);
                        startActivity(new Intent(dailyEvents.this, DailyStatus.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 3) {
                    if (wagon.getPeople() == 0) {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LoseScreen.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_lose_screen);
                        startActivity(new Intent(dailyEvents.this, LoseScreen.class));
                        startActivity(intent);
                    }
                    else if (dateAndDistance.beenToSouthPass) {
                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LocationPage.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(dailyEvents.this, LocationPage.class));
                        startActivity(intent);
                    }
                    else {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, DailyStatus.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewWagon", newWagon).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                        setContentView(R.layout.activity_daily_events);
                        startActivity(new Intent(dailyEvents.this, DailyStatus.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 2) {
                    if (wagon.getPeople() == 0) {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LoseScreen.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_lose_screen);
                        startActivity(new Intent(dailyEvents.this, LoseScreen.class));
                        startActivity(intent);
                    }
                    else if (dateAndDistance.beenToIndependenceRock) {
                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LocationPage.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(dailyEvents.this, LocationPage.class));
                        startActivity(intent);
                    }
                    else {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, DailyStatus.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewWagon", newWagon).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                        setContentView(R.layout.activity_daily_events);
                        startActivity(new Intent(dailyEvents.this, DailyStatus.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 1) {
                    if (wagon.getPeople() == 0) {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LoseScreen.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_lose_screen);
                        startActivity(new Intent(dailyEvents.this, LoseScreen.class));
                        startActivity(intent);
                    }
                    else if (dateAndDistance.beenToFortLaramie) {

                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LocationPage.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(dailyEvents.this, LocationPage.class));
                        startActivity(intent);
                    }
                    else {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, DailyStatus.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewWagon", newWagon).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                        setContentView(R.layout.activity_daily_events);
                        startActivity(new Intent(dailyEvents.this, DailyStatus.class));
                        startActivity(intent);
                    }
                }
                else if (dateAndDistance.locationTicker == 0) {
                    if (wagon.getPeople() == 0) {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LoseScreen.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_lose_screen);
                        startActivity(new Intent(dailyEvents.this, LoseScreen.class));
                        startActivity(intent);
                    }
                    else if (dateAndDistance.beenToKearny) {
                        dateAndDistance.tickerUp();
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity(Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity(Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, LocationPage.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewWagon", newWagon).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);
                        setContentView(R.layout.activity_location_page);
                        startActivity(new Intent(dailyEvents.this, LocationPage.class));
                        startActivity(intent);
                    }
                    else {
                        RandomEvents newRandomEventsPass = new RandomEvents(newRandomEvents.disease, newRandomEvents.badWater, newRandomEvents.lowWater, newRandomEvents.roughTrail, newRandomEvents.blizzard, newRandomEvents.fog, newRandomEvents.hail, newRandomEvents.oxenDamage, newRandomEvents.injury, newRandomEvents.snakeBite, newRandomEvents.loseTrail, newRandomEvents.thief, newRandomEvents.blockedTrail, newRandomEvents.fire, newRandomEvents.abandonedWagon, newRandomEvents.oxenWandered, newRandomEvents.lostMember, newRandomEvents.badGrass, newRandomEvents.fruit, newRandomEvents.healedDisease, newRandomEvents.healedInjury, newRandomEvents.tongueBroke, newRandomEvents.wheelBroke, newRandomEvents.axelBroke, newRandomEvents.daysLost, newRandomEvents.foodLost, newRandomEvents.clothesLost, newRandomEvents.axlesLost, newRandomEvents.wheelsLost, newRandomEvents.wheelsLost, newRandomEvents.memberLost);
                        Entity newHattie = new Entity(Hattie.name, Hattie.sick, Hattie.injured, Hattie.dead);
                        Entity newCharles = new Entity (Charles.name, Charles.sick, Charles.injured, Charles.dead);
                        Entity newAugusta = new Entity(Augusta.name, Augusta.sick, Augusta.injured, Augusta.dead);
                        Entity newBen = new Entity (Ben.name, Ben.sick, Ben.injured, Ben.dead);
                        Entity newJake = new Entity(Jake.name, Jake.sick, Jake.injured, Jake.dead);
                        Wagon newWagon = new Wagon(wagon.people, wagon.money, wagon.oxen, wagon.food, wagon.clothes, wagon.tongues, wagon.axles, wagon.wheels, wagon.rations, wagon.brokenTongue, wagon.brokenWheel, wagon.brokenAxel, wagon.repairTongue, wagon.repairWheel, wagon.repairAxel);
                        DateAndDistance newDateAndDistance = new DateAndDistance(dateAndDistance.locationTicker, dateAndDistance.pace, dateAndDistance.distanceFromHome, dateAndDistance.day, dateAndDistance.month, dateAndDistance.year, dateAndDistance.milesPerDay, dateAndDistance.wagonDamage, dateAndDistance.beenToKearny, dateAndDistance.beenToFortLaramie, dateAndDistance.beenToIndependenceRock, dateAndDistance.beenToSouthPass, dateAndDistance.beenToFortHall, dateAndDistance.beenToFortBoise, dateAndDistance.beenToFortWallaWalla, dateAndDistance.beenToTheDalles, dateAndDistance.reachedEnd);
                        GeneralHealth newerHealth = new GeneralHealth(newHealth.GeneralHealth, 0);
                        Weather newerWeather = new Weather(newWeather.temperature, newWeather.rainfall);

                        Intent intent = new Intent(dailyEvents.this, DailyStatus.class);

                        intent.putExtra("NewWeather", newerWeather).putExtra("NewGeneralHealth", newerHealth).putExtra("NewWagon", newWagon).putExtra("NewDateAndDistance", newDateAndDistance).putExtra("NewRandomEvents", newRandomEventsPass).putExtra("NewHattie", newHattie).putExtra("NewCharles", newCharles).putExtra("NewAugusta", newAugusta).putExtra("NewBen", newBen).putExtra("NewJake", newJake);

                        setContentView(R.layout.activity_daily_events);
                        startActivity(new Intent(dailyEvents.this, DailyStatus.class));
                        startActivity(intent);
                    }
            }
        }
    });
    }
}

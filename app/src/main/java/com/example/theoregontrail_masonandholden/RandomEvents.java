package com.example.theoregontrail_masonandholden;

import java.io.Serializable;

public class RandomEvents implements Serializable {

    public boolean disease;
    public boolean badWater;
    public boolean lowWater;
    public boolean roughTrail;
    public boolean blizzard;
    public boolean fog;
    public boolean hail;
    public boolean oxenDamage;
    public boolean injury;
    public boolean snakeBite;
    public boolean loseTrail;
    public boolean thief;
    public boolean blockedTrail;
    public boolean fire;
    public boolean abandonedWagon;
    public boolean oxenWandered;
    public boolean lostMember;
    public boolean badGrass;
    public boolean fruit;
    public int daysLost;
    public int foodLost;



    public RandomEvents(boolean disease, boolean badWater, boolean lowWater, boolean roughTrail, boolean blizzard, boolean fog, boolean hail, boolean oxenDamage, boolean injury, boolean snakeBite, boolean loseTrail, boolean thief, boolean blockedTrail, boolean fire, boolean abandonedWagon, boolean oxenWandered, boolean lostMember, boolean badGrass, boolean fruit, int daysLost, int foodLost)  {
        this.disease = disease;
        this.badWater = badWater;
        this.lowWater = lowWater;
        this.roughTrail = roughTrail;
        this.blizzard = blizzard;
        this.fog = fog;
        this.hail = hail;
        this.oxenDamage = oxenDamage;
        this.injury = injury;
        this.snakeBite = snakeBite;
        this.loseTrail = loseTrail;
        this.thief = thief;
        this.blockedTrail = blockedTrail;
        this.fire = fire;
        this.abandonedWagon = abandonedWagon;
        this.oxenWandered = oxenWandered;
        this.lostMember = lostMember;
        this.badGrass = badGrass;
        this.fruit = fruit;
        this.daysLost = daysLost;
        this.foodLost = foodLost;

    }
    public void randomDisease(double health){
        double standardized = (health / 140) * 40;
        int random = (int) (Math.random() * 100);
        this.disease = random <= standardized;
    }

    public void randomBadWater(int rainfall){
        int random = (int) (Math.random() * 100);
        if (rainfall <= 0) {
            this.badWater = random <= 5;
        }
        else {
            this.badWater = false;
        }
    }

    public void randomLowWater(int rainfall){
        int random = (int) (Math.random() * 100);
        if (rainfall <= 0) {
            this.lowWater = random <= 10;
        }
        else {
            this.lowWater = false;
        }
    }

    public void randomRoughTrail(){
        int random = (int) (Math.random() * 1000);
        this.roughTrail = random <= 25;
    }

    public void randomBlizzard(int temperature){
        int random = (int) (Math.random() * 100);
        if (temperature <= 1) {
            this.blizzard =  random <= 5;
        }
        else {
            this.blizzard = false;
        }
    }

    public void randomFog(int temperature){
        int random = (int) (Math.random() * 100);
        if (temperature >= 4) {
            this.fog = random <= 3;
        }
        else {
            this.fog = false;
        }
    }

    public void randomHail(int temperature){
        int random = (int) (Math.random() * 100);
        if (temperature <= 0) {
            this.hail = random <= 6;
        }
        else {
            this.hail = false;
        }
    }

    public void randomOxenDamage(){
        int random = (int) (Math.random() * 100);
        this.oxenDamage = random <= 2;
    }

    public void randomInjury(){
        int random = (int) (Math.random() * 100);
        this.injury = random <= 2;
    }

    public void randomSnakebite(){
        int random = (int) (Math.random() * 1000);
        this.snakeBite = random <= 7;
    }

    public void randomLoseTrail(){
        int random = (int) (Math.random() * 100);
        this.loseTrail = random <= 2;
    }

    public void randomThief(){
        int random = (int) (Math.random() * 100);
        this.thief = random <= 2;
    }

    public void randomBlockedTrail(){
        int random = (int) (Math.random() * 1000);
        this.blockedTrail = random <= 25;
    }

    public void randomFire(){
        int random = (int) (Math.random() * 100);
        this.fire = random <= 2;
    }

    public void randomAbandonedWagon(){
        int random = (int) (Math.random() * 100);
        this.abandonedWagon = random <= 2;
    }

    public void randomOxenWander(){
        int random = (int) (Math.random() * 100);
        this.oxenWandered = random <= 1;
    }

    public void randomLostMember(){
        int random = (int) (Math.random() * 100);
        this.lostMember = random <= 100;
    }

    public int randomDaysLost(int maximum){
        return (int) (Math.random() * (maximum - 1)) + 1;
    }

    public int randomFoodLost(int maximum){
        return (int) (Math.random() * (maximum - 1)) + 1;
    }

    public void randomBadGrass(int rainfall){
        int random = (int) (Math.random() * 100);
        if (rainfall <= 0) {
            this.badGrass = random <= 10;
        }
        else {
            this.badGrass = false;
        }
    }

    public void randomFruit(int month){
        int random = (int) (Math.random() * 100);
        if (month >= 5 && month <= 9) {
            this.fruit = random <= 4;
        }
        else {
            this.fruit = false;
        }
    }
}

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
    public int clothesLost;
    public int axlesLost;
    public int wheelsLost;
    public int tonguesLost;



    public RandomEvents(boolean disease, boolean badWater, boolean lowWater, boolean roughTrail, boolean blizzard, boolean fog, boolean hail, boolean oxenDamage, boolean injury, boolean snakeBite, boolean loseTrail, boolean thief, boolean blockedTrail, boolean fire, boolean abandonedWagon, boolean oxenWandered, boolean lostMember, boolean badGrass, boolean fruit, int daysLost, int foodLost, int clothesLost, int axlesLost, int wheelsLost, int tonguesLost)  {
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
        this.clothesLost = clothesLost;
        this.axlesLost = axlesLost;
        this.wheelsLost = wheelsLost;
        this.tonguesLost = tonguesLost;

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
        double random = (Math.random() * 1000);
        this.roughTrail = random <= 25;
    }

    public void randomBlizzard(int temperature){
        double random = (Math.random() * 100);
        if (temperature <= 1) {
            this.blizzard =  random <= 5;
        }
        else {
            this.blizzard = false;
        }
    }

    public void randomFog(int temperature){
        double random = (Math.random() * 100);
        if (temperature >= 4) {
            this.fog = random <= 3;
        }
        else {
            this.fog = false;
        }
    }

    public void randomHail(int temperature){
        double random = (Math.random() * 100);
        if (temperature <= 0) {
            this.hail = random <= 6;
        }
        else {
            this.hail = false;
        }
    }

    public void randomOxenDamage(){
        double random = (Math.random() * 100);
        this.oxenDamage = random <= 2;
    }

    public void randomInjury(){
        double random = (Math.random() * 100);
        this.injury = random <= 2;
    }

    public void randomSnakebite(){
        double random = (Math.random() * 1000);
        this.snakeBite = random <= 7;
    }

    public void randomLoseTrail(){
        double random = (Math.random() * 100);
        this.loseTrail = random <= 2;
    }

    public void randomThief(){
        double random = (Math.random() * 100);
        this.thief = random <= 2;
    }

    public void randomBlockedTrail(int distance){
        if (distance > 1000) {
            double random = (Math.random() * 1000);
            this.blockedTrail = random <= 25;
        }
        else {
            this.blockedTrail = false;
        }
    }

    public void randomFire(){
        double random = (Math.random() * 100);
        this.fire = random <= 2;
    }

    public void randomAbandonedWagon(){
        double random = (Math.random() * 100);
        this.abandonedWagon = random <= 2;
    }

    public void randomOxenWander(){
        double random = (Math.random() * 100);
        this.oxenWandered = random <= 1;
    }

    public void randomLostMember(){
        double random = (Math.random() * 100);
        this.lostMember = random <= 100;
    }

    public int randomDaysLost(int maximum){
        return (int) (Math.random() * (maximum - 1)) + 1;
    }

    public int randomFoodLost(int maximum){
        return (int) (Math.random() * (maximum - 1)) + 1;
    }

    public int randomOtherLost(int maximum){
        return (int) (Math.random() * (maximum + 1));
    }

    public void randomBadGrass(int rainfall){
        double random = (Math.random() * 100);
        if (rainfall <= 0) {
            this.badGrass = random <= 10;
        }
        else {
            this.badGrass = false;
        }
    }

    public void randomFruit(int month){
        double random = (Math.random() * 100);
        if (month >= 5 && month <= 9) {
            this.fruit = random <= 4;
        }
        else {
            this.fruit = false;
        }
    }

    public void setDaysLost(int daysLost) {
        this.daysLost = daysLost;
    }

    public void setFoodLost(int foodLost) {
        this.foodLost = foodLost;
    }

    public int getDaysLost() {
        return daysLost;
    }

    public int getFoodLost() {
        return foodLost;
    }

    public int getClothesLost() {
        return clothesLost;
    }

    public void setClothesLost(int clothesLost) {
        this.clothesLost = clothesLost;
    }

    public int getAxlesLost() {
        return axlesLost;
    }

    public void setAxlesLost(int axlesLost) {
        this.axlesLost = axlesLost;
    }

    public int getWheelsLost() {
        return wheelsLost;
    }

    public void setWheelsLost(int wheelsLost) {
        this.wheelsLost = wheelsLost;
    }

    public int getTonguesLost() {
        return tonguesLost;
    }

    public void setTonguesLost(int tonguesLost) {
        this.tonguesLost = tonguesLost;
    }
}

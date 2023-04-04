package com.example.theoregontrail_masonandholden;

public class RandomEvents {

    public double randomValue;

    public RandomEvents() {
        this.randomValue = 0;
    }

    public boolean randomDisease(double health){
        double standardized = (health / 140) * 40;
        int random = (int) (Math.random() * 100);
        return random <= standardized;
    }

    public boolean randomBadWater(int rainfall){
        int random = (int) (Math.random() * 100);
        if (rainfall <= 0) {
            return random <= 5;
        }
        return false;
    }

    public boolean randomLowWater(int rainfall){
        int random = (int) (Math.random() * 100);
        if (rainfall <= 0) {
            return random <= 10;
        }
        return false;
    }

    public boolean randomRoughTrail(){
        int random = (int) (Math.random() * 1000);
        return random <= 25;
    }

    public boolean randomBlizzard(int temperature){
        int random = (int) (Math.random() * 100);
        if (temperature <= 1) {
            return random <= 5;
        }
        else {
            return false;
        }
    }

    public boolean randomFog(int temperature){
        int random = (int) (Math.random() * 100);
        if (temperature >= 4) {
            return random <= 3;
        }
        else {
            return false;
        }
    }

    public boolean randomHail(int temperature){
        int random = (int) (Math.random() * 100);
        if (temperature <= 0) {
            return random <= 6;
        }
        else {
            return false;
        }
    }

    public boolean randomOxenDamage(){
        int random = (int) (Math.random() * 100);
        return random <= 2;
    }

    public boolean randomInjury(){
        int random = (int) (Math.random() * 100);
        return random <= 2;
    }

    public boolean randomSnakebite(){
        int random = (int) (Math.random() * 1000);
        return random <= 7;
    }

    public boolean randomLoseTrail(){
        int random = (int) (Math.random() * 100);
        return random <= 2;
    }

    public boolean randomThief(){
        int random = (int) (Math.random() * 100);
        return random <= 2;
    }

    public boolean randomBlockedTrail(){
        int random = (int) (Math.random() * 1000);
        return random <= 25;
    }

    public boolean randomFire(){
        int random = (int) (Math.random() * 100);
        return random <= 2;
    }

    public boolean randomAbandonedWagon(){
        int random = (int) (Math.random() * 100);
        return random <= 2;
    }

    public boolean randomOxenWander(){
        int random = (int) (Math.random() * 100);
        return random <= 1;
    }

    public boolean randomLostMember(){
        int random = (int) (Math.random() * 100);
        return random <= 1;
    }

    public int randomDaysLost(int maximum){
        return (int) (Math.random() * (maximum - 1)) + 1;
    }

    public int randomFoodLost(int maximum){
        return (int) (Math.random() * (maximum - 1)) + 1;
    }

    public boolean randomBadGrass(int rainfall){
        int random = (int) (Math.random() * 100);
        if (rainfall <= 0) {
            return random <= 10;
        }
        return false;
    }

    public boolean randomFruit(int month){
        int random = (int) (Math.random() * 100);
        if (month >= 5 && month <= 9) {
            return random <= 4;
        }
        else {
            return false;
        }
    }
}

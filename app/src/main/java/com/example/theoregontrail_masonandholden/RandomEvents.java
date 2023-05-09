package com.example.theoregontrail_masonandholden;

import java.io.Serializable;

/**
 * This is the RandomEvents class.
 * This class rolls for all of the random events that can happen during each day.
 * It also holds values for which resources are most recently affected by the events.
 *
 * @author Mason Muether and Holden Cubberley
 * @version 5/9/2023
 */
public class RandomEvents implements Serializable {

    /**
     * Constructors for each of the events and resources.
     * The events are booleans that determine if each event occurs or not.
     * The others are integers denoting the number of the resources affected.
     */
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
    public boolean healedDisease;
    public boolean healedInjury;
    public boolean tongueBroke;
    public boolean wheelBroke;
    public boolean axelBroke;
    public int daysLost;
    public int foodLost;
    public int clothesLost;
    public int axlesLost;
    public int wheelsLost;
    public int tonguesLost;
    public int memberLost;



    public RandomEvents(boolean disease, boolean badWater, boolean lowWater, boolean roughTrail, boolean blizzard, boolean fog, boolean hail, boolean oxenDamage, boolean injury, boolean snakeBite, boolean loseTrail, boolean thief, boolean blockedTrail, boolean fire, boolean abandonedWagon, boolean oxenWandered, boolean lostMember, boolean badGrass, boolean fruit, boolean healedDisease, boolean healedInjury, boolean tongueBroke, boolean wheelBroke, boolean axelBroke, int daysLost, int foodLost, int clothesLost, int axlesLost, int wheelsLost, int tonguesLost, int memberLost)  {
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
        this.healedDisease = healedDisease;
        this.healedInjury = healedInjury;
        this.tongueBroke = tongueBroke;
        this.wheelBroke = wheelBroke;
        this.axelBroke = axelBroke;
        this.daysLost = daysLost;
        this.foodLost = foodLost;
        this.clothesLost = clothesLost;
        this.axlesLost = axlesLost;
        this.wheelsLost = wheelsLost;
        this.tonguesLost = tonguesLost;
        this.memberLost = memberLost;

    }

    /**
     * Randomly decides if a member will get sick or not, based on overall health.
     * Returns true if the event occurs, false otherwise.
     *
     * @param health a number representing the health of the party
     */
    public void randomDisease(double health){
        double standardized = (health / 140) * 40;
        int random = (int) (Math.random() * 100);
        this.disease = random <= standardized;
    }

    /**
     * Randomly decides if water quality is poor that day, based on the rainfall.
     * Returns true if the event occurs, false otherwise.
     *
     * @param rainfall a number representing the daily rainfall
     */
    public void randomBadWater(int rainfall){
        int random = (int) (Math.random() * 100);
        if (rainfall <= 0) {
            this.badWater = random <= 5;
        }
        else {
            this.badWater = false;
        }
    }

    /**
     * Randomly decides if there is low water that day, based on the rainfall.
     * Returns true if the event occurs, false otherwise.
     *
     * @param rainfall a number representing the daily rainfall
     */
    public void randomLowWater(int rainfall){
        int random = (int) (Math.random() * 100);
        if (rainfall <= 2) {
            this.lowWater = random <= 5;
        }
        else {
            this.lowWater = false;
        }
    }

    /**
     * Randomly decides if the trail is rough that day.
     * Returns true if the event occurs, false otherwise.
     */
    public void randomRoughTrail(){
        double random = (Math.random() * 1000);
        this.roughTrail = random <= 25;
    }

    /**
     * Randomly decides if a blizzard occurs that day, based on the temperature.
     * Returns true if the event occurs, false otherwise.
     *
     * @param temperature a number representing the daily temperature
     */
    public void randomBlizzard(int temperature){
        double random = (Math.random() * 100);
        if (temperature <= 12) {
            this.blizzard = random <= 5;
        }
        else {
            this.blizzard = false;
        }
    }

    /**
     * Randomly decides if there is fog that day, based on the temperature.
     * Returns true if the event occurs, false otherwise.
     *
     * @param temperature an integer representing the temperature
     */
    public void randomFog(int temperature){
        double random = (Math.random() * 100);
        if (temperature >= 40) {
            this.fog = random <= 3;
        }
        else {
            this.fog = false;
        }
    }

    /**
     * Randomly decides if there is hail that day, based on the temperature.
     * Returns true if the event occurs, false otherwise.
     *
     * @param temperature an integer representing the temperature
     */
    public void randomHail(int temperature){
        double random = (Math.random() * 100);
        if (temperature <= 9) {
            this.hail = random <= 6;
        }
        else {
            this.hail = false;
        }
    }

    /**
     * Randomly decides if the an oxen dies that day, based on the distance from home, if the grass is bad, and if there are oxen to begin with .
     * Returns true if the event occurs, false otherwise.
     *
     * @param distance an integer representing the miles form home
     * @param badGrass a boolean representing if the grass is bad that day
     * @param oxen an integer representing the number of oxen the party has
     */
    public void randomOxenDamage(int distance, boolean badGrass, int oxen){
        double random = (Math.random() * 100);
        if (oxen > 0) {
            if (distance <= 1200 && !badGrass) {
                this.oxenDamage = random <= 1;
            } else if (!badGrass) {
                this.oxenDamage = random <= 2;
            } else {
                this.oxenDamage = random <= 35;
            }
        }
    }

    /**
     * Randomly decides if a member gets an injury that day.
     * Returns true if the event occurs, false otherwise.
     */
    public void randomInjury(){
        double random = (Math.random() * 100);
        this.injury = random <= 2;
    }

    /**
     * Randomly decides if a snakebite occurs that day.
     * Returns true if the event occurs, false otherwise.
     */
    public void randomSnakebite(){
        double random = (Math.random() * 1000);
        this.snakeBite = random <= 7;
    }

    /**
     * Randomly decides if the trail is lost track of that day.
     * Returns true if the event occurs, false otherwise.
     */
    public void randomLoseTrail(){
        double random = (Math.random() * 100);
        this.loseTrail = random <= 2;
    }

    /**
     * Randomly decides if a thief visits that day.
     * Returns true if the event occurs, false otherwise.
     */
    public void randomThief(){
        double random = (Math.random() * 100);
        this.thief = random <= 2;
    }

    /**
     * Randomly decides if the trail is blocked that day, based on distance from home.
     * Returns true if the event occurs, false otherwise.
     *
     * @param distance a number representing the miles from home
     */
    public void randomBlockedTrail(int distance){
        if (distance > 1200) {
            double random = (Math.random() * 1000);
            this.blockedTrail = random <= 25;
        }
        else {
            this.blockedTrail = false;
        }
    }

    /**
     * Randomly decides if a fire occurs that day.
     * Returns true if the event occurs, false otherwise.
     */
    public void randomFire(){
        double random = (Math.random() * 100);
        this.fire = random <= 2;
    }

    /**
     * Randomly decides if there is an abandoned wagon that day.
     * Returns true if the event occurs, false otherwise.
     */
    public void randomAbandonedWagon(){
        double random = (Math.random() * 100);
        this.abandonedWagon = random <= 2;
    }

    /**
     * Randomly decides if the oxen wander off that day, assuming there are any.
     * Returns true if the event occurs, false otherwise.
     *
     * @param oxen a number representing the number of oxen owned
     */
    public void randomOxenWander(int oxen){
        double random = (Math.random() * 100);
        if (oxen > 0) {
            this.oxenWandered = random <= 1;
        }
    }

    /**
     * Randomly decides if the tongue breaks that day if it is not broken already.
     * Returns true if the event occurs, false otherwise.
     *
     * @param broken a boolean representing if the tongue is already broken
     */
    public void randomTongueBroke(boolean broken){
        if (!broken) {
            double random = (Math.random() * 100);
            this.tongueBroke = random <= 3;
        }
    }

    /**
     * Randomly decides if the wheel breaks that day if it is not broken already.
     * Returns true if the event occurs, false otherwise.
     *
     * @param broken a boolean representing if the wheel is already broken
     */
    public void randomWheelBroke(boolean broken){
        if (!broken) {
            double random = (Math.random() * 100);
            this.wheelBroke = random <= 3;
        }
    }

    /**
     * Randomly decides if the axel breaks that day if it is not broken already.
     * Returns true if the event occurs, false otherwise.
     *
     * @param broken a boolean representing if the axel is already broken
     */
    public void randomAxelBroke(boolean broken){
        if (!broken) {
            double random = (Math.random() * 100);
            this.axelBroke = random <= 3;
        }
    }

    /**
     * Randomly decides if a member gets lost that day.
     * Returns true if the event occurs, false otherwise.
     */
    public void randomLostMember(){
        double random = (Math.random() * 100);
        this.lostMember = random <= 1;
    }

    /**
     * Randomly decides if a person gets over their sickness that day if they are sick.
     * Returns true if the event occurs, false otherwise.
     *
     * @param sick a boolean representing if the person is already sick
     */
    public void randomHealedDisease(boolean sick){
        double random = (Math.random() * 100);
        if (sick) {
            this.healedDisease = random <= 15;
        }
        else {
            this.healedDisease = false;
        }
    }

    /**
     * Randomly decides if a person gets over their injury that day if they are injured.
     * Returns true if the event occurs, false otherwise.
     *
     * @param injured a boolean representing if the person is already injured
     */
    public void randomHealedInjury(boolean injured){
        double random = (Math.random() * 100);
        if (injured) {
            this.healedInjury = random <= 15;
        }
        else {
            this.healedInjury = false;
        }
    }

    /**
     * Randomly decides which member is chosen when applicable.
     * Returns true if the event occurs, false otherwise.
     *
     * @return an integer representing which member is selected
     * @param people an integer representing how many people there are
     */
    public int randomChooseMember(int people){
        double random = (Math.random() * people) + 1;
        return (int) random;
    }

    /**
     * Randomly decides how many days are lost when applicable that day.
     * Returns an integer representing an amount of days.
     */
    public int randomDaysLost(int maximum){
        return (int) (Math.random() * (maximum - 1)) + 1;
    }

    /**
     * Randomly decides how much food is lost when applicable that day.
     * Returns an integer representing an amount of food.
     */
    public int randomFoodLost(int maximum){
        return (int) (Math.random() * (maximum - 1)) + 1;
    }

    /**
     * Randomly decides how many of an object are lost when applicable that day.
     * Returns an integer representing an amount of whatever resource is affected.
     */
    public int randomOtherLost(int maximum){
        return (int) (Math.random() * (maximum + 1));
    }

    /**
     * Randomly decides if the grass is low quality that day, based on the rainfall.
     * Returns true if the event occurs, false otherwise.
     *
     * @param rainfall an integer representing the amount of rainfall that day
     */
    public void randomBadGrass(int rainfall){
        double random = (Math.random() * 100);
        if (rainfall <= 0) {
            this.badGrass = random <= 10;
        }
        else {
            this.badGrass = false;
        }
    }

    /**
     * Randomly decides if the party finds fruit that day, based on the current month.
     * Returns true if the event occurs, false otherwise.
     *
     * @param month an integer representing the month of the year
     */
    public void randomFruit(int month){
        double random = (Math.random() * 100);
        if (month >= 5 && month <= 9) {
            this.fruit = random <= 4;
        }
        else {
            this.fruit = false;
        }
    }

    /**
     * Basic setter for DaysLost
     */
    public void setDaysLost(int daysLost) {
        this.daysLost = daysLost;
    }

    /**
     * Basic setter for FoodLost
     */
    public void setFoodLost(int foodLost) {
        this.foodLost = foodLost;
    }

    /**
     * Basic getter for DaysLost
     *
     * @return an integer representing a number of days.
     */
    public int getDaysLost() {
        return daysLost;
    }

    /**
     * Basic getter for FoodLost
     *
     * @return an integer representing a number of food.
     */
    public int getFoodLost() {
        return foodLost;
    }

    /**
     * Basic getter for ClothesLost
     *
     * @return an integer representing a number of clothes.
     */
    public int getClothesLost() {
        return clothesLost;
    }

    /**
     * Basic setter for ClothesLost
     */
    public void setClothesLost(int clothesLost) {
        this.clothesLost = clothesLost;
    }

    /**
     * Basic getter for AxlesLost
     *
     * @return an integer representing a number of axles.
     */
    public int getAxlesLost() {
        return axlesLost;
    }

    /**
     * Basic setter for AxlesLost
     */
    public void setAxlesLost(int axlesLost) {
        this.axlesLost = axlesLost;
    }

    /**
     * Basic getter for WheelsLost
     *
     * @return an integer representing a number of wheels.
     */
    public int getWheelsLost() {
        return wheelsLost;
    }

    /**
     * Basic setter for WheelsLost
     */
    public void setWheelsLost(int wheelsLost) {
        this.wheelsLost = wheelsLost;
    }

    /**
     * Basic getter for TonguesLost
     *
     * @return an integer representing a number of tongues.
     */
    public int getTonguesLost() {
        return tonguesLost;
    }

    /**
     * Basic setter for TonguesLost
     */
    public void setTonguesLost(int tonguesLost) {
        this.tonguesLost = tonguesLost;
    }

    /**
     * Basic getter for MembersLost
     *
     * @return an integer representing a particular member.
     */
    public int getMemberLost() {
        return memberLost;
    }

    /**
     * Basic setter for MemberLost
     */
    public void setMemberLost(int memberLost) {
        this.memberLost = memberLost;
    }

}

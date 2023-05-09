package com.example.theoregontrail_masonandholden;

import java.io.Serializable;

/**
 * This is the Wagon class.
 * This class holds values for all of the contents of the wagon, including things like money, food, clothes, and more.
 *
 * @author Mason Muether and Holden Cubberley
 * @version 5/9/2023
 */
public class Wagon implements Serializable {

    /**
     * Constructors for the wagon's contents, as well as booleans for if the wagon has been broken or repaired recently.
     * The contents are all represented by integers, and the broken and repair values are booleans.
     */
    public int people;
    public double money;
    public double moneySpent = 0.00;
    public int oxen;
    public int food;
    public int clothes;
    public int tongues;
    public int axles;
    public int wheels;
    public int rations;
    public boolean brokenTongue;
    public boolean brokenWheel;
    public boolean brokenAxel;
    public boolean repairTongue;
    public boolean repairWheel;
    public boolean repairAxel;

    public Wagon(int people, double money, int oxen, int food, int clothes, int tongues, int axles, int wheels, int rations, boolean brokenTongue, boolean brokenWheel, boolean brokenAxel, boolean repairTongue, boolean repairWheel, boolean repairAxel) {
        this.people = people;
        this.money = money;
        this.oxen = oxen;
        this.food = food;
        this.clothes = clothes;
        this.tongues = tongues;
        this.axles = axles;
        this.wheels = wheels;
        this.rations = rations;
        this.brokenTongue = brokenTongue;
        this.brokenWheel = brokenWheel;
        this.brokenAxel = brokenAxel;
        this.repairTongue = repairTongue;
        this.repairWheel = repairWheel;
        this.repairAxel = repairAxel;
    }

    /**
     * Basic getter for people
     *
     * @return an integer representing the number of people
     */
    public int getPeople() {
        return people;
    }

    /**
     * Basic setter for People
     */
    public void setPeople(int people) {
        this.people = people;
    }

    /**
     * Decreases people by 1
     */
    public void removePerson() {
        this.people = this.people - 1;
    }

    /**
     * Basic getter for money
     *
     * @return an integer representing the amount of money
     */
    public double getMoney() { return money; }

    /**
     * Decreases money by a given amount, and increases money spent
     *
     * @param amount a double representing the amount of money spent
     */
    public void spendMoney(double amount){ this.money = this.money - amount; moneySpent = moneySpent + amount;}

    /**
     * Increases money by a given amount, and decreases money spent
     *
     * @param amount a double representing the amount of money to be returned
     */
    public void returnMoney(double amount){ this.money = this.money + amount; moneySpent = moneySpent - amount;}

    /**
     * Basic getter for oxen
     *
     * @return an integer representing the number of oxen
     */
    public int getOxen() {
        return oxen;
    }

    /**
     * Basic setter for Oxen
     */
    public void setOxen(int oxen) {
        this.oxen = oxen;
    }

    /**
     * Increases oxen by 2
     */
    public void buyOxen() {
        this.oxen = this.oxen + 2;
    }

    /**
     * Decreases oxen by 2
     */
    public void sellOxen() {
        this.oxen = this.oxen - 2;
    }

    /**
     * Decreases oxen by 1
     */
    public void loseOx() {
        this.oxen = this.oxen - 1;
    }

    /**
     * Basic getter for food
     *
     * @return an integer representing the amount of food
     */
    public int getFood() {
        return food;
    }

    /**
     * Basic setter for Food
     */
    public void setFood(int food) {
        this.food = food;
    }

    /**
     * Increases food by 20
     */
    public void buyFood() {
        this.food = this.food + 20;
    }

    /**
     * Decreases food by 20
     */
    public void sellFood() {
        this.food = this.food - 20;
    }

    /**
     * Increases food by a given amount
     *
     * @param food an integer representing the amount of food to be gained
     */
    public void gainFood(int food) {
        this.food = this.food + food;
    }

    /**
     * Decreases food by a given amount
     *
     * @param food an integer representing the amount of food to be lost
     */
    public void loseFood(int food) {
        this.food = this.food - food;
    }

    /**
     * Basic getter for clothes
     *
     * @return an integer representing the number of people
     */
    public int getClothes() {
        return clothes;
    }

    /**
     * Basic setter for Clothes
     */
    public void setClothes(int clothes) {
        this.clothes = clothes;
    }

    /**
     * Increases clothes by 1
     */
    public void buyClothes() {
        this.clothes = this.clothes + 1;
    }

    /**
     * Decreases clothes by 1
     */
    public void sellClothes() {
        this.clothes = this.clothes - 1;
    }

    /**
     * Basic getter for tongues
     *
     * @return an integer representing the number of tongues
     */
    public int getTongues() {
        return tongues;
    }

    /**
     * Basic setter for tongues
     */
    public void setTongues(int tongues) {
        this.tongues = tongues;
    }

    /**
     * Increases tongues by 1
     */
    public void buyTongues() {
        this.tongues = this.tongues + 1;
    }

    /**
     * Decreases tongues by 1
     */
    public void sellTongues() {
        this.tongues = this.tongues - 1;
    }

    /**
     * Basic getter for axles
     *
     * @return an integer representing the number of axles
     */
    public int getAxles() {
        return axles;
    }

    /**
     * Basic setter for axles
     */
    public void setAxles(int axles) {
        this.axles = axles;
    }

    /**
     * Increases axles by 1
     */
    public void buyAxles() {
        this.axles = this.axles + 1;
    }

    /**
     * Decreases axles by 1
     */
    public void sellAxles() {
        this.axles = this.axles - 1;
    }

    /**
     * Basic getter for wheels
     *
     * @return an integer representing the number of wheels
     */
    public int getWheels() {
        return wheels;
    }

    /**
     * Basic setter for wheels
     */
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    /**
     * Increases wheels by 1
     */
    public void buyWheels() {
        this.wheels = this.wheels + 1;
    }

    /**
     * Decreases wheels by 1
     */
    public void sellWheels() {
        this.wheels = this.wheels - 1;
    }

    /**
     * Basic setter for if the tongue is broken
     */
    public void setBrokenTongue(boolean brokenTongue) {
        this.brokenTongue = brokenTongue;
    }

    /**
     * Basic setter for if the wheel is broken
     */
    public void setBrokenWheel(boolean brokenWheel) {
        this.brokenWheel = brokenWheel;
    }

    /**
     * Basic setter for if the axel is broken
     */
    public void setBrokenAxel(boolean brokenAxel) {
        this.brokenAxel = brokenAxel;
    }

    /**
     * Basic setter for if the tongue is repaired
     */
    public void setRepairTongue(boolean repairTongue) {
        this.repairTongue = repairTongue;
    }

    /**
     * Basic setter for if the wheel is repaired
     */
    public void setRepairWheel(boolean repairWheel) {
        this.repairWheel = repairWheel;
    }

    /**
     * Basic setter for if the axel is repaired
     */
    public void setRepairAxel(boolean repairAxel) {
        this.repairAxel = repairAxel;
    }

    /**
     * Basic getter for rations
     *
     * @return an integer representing the current rate of food consumption
     */
    public int getRations() {
        return rations;
    }

    /**
     * Decreases rations by 1
     */
    public void rationsDown() {

        rations--;
    }

    /**
     * Increases rations by 1
     */
    public void rationsUp() {

        rations++;
    }
}



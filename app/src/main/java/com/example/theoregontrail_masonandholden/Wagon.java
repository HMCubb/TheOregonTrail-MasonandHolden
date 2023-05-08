package com.example.theoregontrail_masonandholden;

import static java.lang.Math.round;

import java.io.Serializable;

public class Wagon implements Serializable {

    public int people;
    public double money;
    public double moneySpent = 0.00;
    public int oxen;
    public int food;
    public int clothes;
    public int tongues;
    public int axles;
    public int wheels;
    public boolean brokenTongue;
    public boolean brokenWheel;
    public boolean brokenAxel;
    public boolean repairTongue;
    public boolean repairWheel;
    public boolean repairAxel;

    public Wagon(int people, double money, int oxen, int food, int clothes, int tongues, int axles, int wheels, boolean brokenTongue, boolean brokenWheel, boolean brokenAxel, boolean repairTongue, boolean repairWheel, boolean repairAxel) {
        this.people = people;
        this.money = money;
        this.oxen = oxen;
        this.food = food;
        this.clothes = clothes;
        this.tongues = tongues;
        this.axles = axles;
        this.wheels = wheels;
        this.brokenTongue = brokenTongue;
        this.brokenWheel = brokenWheel;
        this.brokenAxel = brokenAxel;
        this.repairTongue = repairTongue;
        this.repairWheel = repairWheel;
        this.repairAxel = repairAxel;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public void removePerson() {
        this.people = this.people - 1;
    }

    public double getMoney() { return money; }

    public void setMoney(double money) {
        this.money = money;
    }

    public void spendMoney(double amount){ this.money = this.money - amount; moneySpent = moneySpent + amount;}

    public void returnMoney(double amount){ this.money = this.money + amount; moneySpent = moneySpent - amount;}

    public int getOxen() {
        return oxen;
    }

    public void setOxen(int oxen) {
        this.oxen = oxen;
    }

    public void buyOxen() {
        this.oxen = this.oxen + 2;
    }

    public void sellOxen() {
        this.oxen = this.oxen - 2;
    }

    public void loseOx() {
        this.oxen = this.oxen - 1;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void buyFood() {
        this.food = this.food + 10;
    }

    public void sellFood() {
        this.food = this.food - 10;
    }

    public void gainFood(int food) {
        this.food = this.food + food;
    }

    public void loseFood(int food) {
        this.food = this.food - food;
    }

    public int getClothes() {
        return clothes;
    }

    public void setClothes(int clothes) {
        this.clothes = clothes;
    }

    public void buyClothes() {
        this.clothes = this.clothes + 1;
    }

    public void sellClothes() {
        this.clothes = this.clothes - 1;
    }

    public int getTongues() {
        return tongues;
    }

    public void setTongues(int tongues) {
        this.tongues = tongues;
    }

    public void buyTongues() {
        this.tongues = this.tongues + 1;
    }

    public void sellTongues() {
        this.tongues = this.tongues - 1;
    }

    public int getAxles() {
        return axles;
    }

    public void setAxles(int axles) {
        this.axles = axles;
    }

    public void buyAxles() {
        this.axles = this.axles + 1;
    }

    public void sellAxles() {
        this.axles = this.axles - 1;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void buyWheels() {
        this.wheels = this.wheels + 1;
    }

    public void sellWheels() {
        this.wheels = this.wheels - 1;
    }

    public void setBrokenTongue(boolean brokenTongue) {
        this.brokenTongue = brokenTongue;
    }

    public void setBrokenWheel(boolean brokenWheel) {
        this.brokenWheel = brokenWheel;
    }

    public void setBrokenAxel(boolean brokenAxel) {
        this.brokenAxel = brokenAxel;
    }

    public void setRepairTongue(boolean repairTongue) {
        this.repairTongue = repairTongue;
    }

    public void setRepairWheel(boolean repairWheel) {
        this.repairWheel = repairWheel;
    }

    public void setRepairAxel(boolean repairAxel) {
        this.repairAxel = repairAxel;
    }
}



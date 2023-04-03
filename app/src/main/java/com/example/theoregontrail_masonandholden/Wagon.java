package com.example.theoregontrail_masonandholden;

public class Wagon {

    public int people;
    public int money;
    public int oxen;
    public int food;
    public int clothes;
    public int tongues;
    public int axles;
    public int wheels;

    public Wagon(int people, int money, int oxen, int food, int clothes, int tongues, int axles, int wheels) {
        this.people = people;
        this.money = money;
        this.oxen = oxen;
        this.food = food;
        this.clothes = clothes;
        this.tongues = tongues;
        this.axles = axles;
        this.wheels = wheels;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public void killPerson() {
        this.people = this.people - 1;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void removeMoney(int amount){
        this.money = this.money - amount;
    }

    public int getOxen() {
        return oxen;
    }

    public void setOxen(int oxen) {
        this.oxen = oxen;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getClothes() {
        return clothes;
    }

    public void setClothes(int clothes) {
        this.clothes = clothes;
    }

    public int getTongues() {
        return tongues;
    }

    public void setTongues(int tongues) {
        this.tongues = tongues;
    }

    public int getAxles() {
        return axles;
    }

    public void setAxles(int axles) {
        this.axles = axles;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}



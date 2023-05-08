package com.example.theoregontrail_masonandholden;

import java.io.Serializable;

public class DateAndDistance implements Serializable {

    public boolean beenToKearny = false;
    public boolean beenToFortLaramie = false;
    public boolean beenToIndependenceRock = false;
    public boolean beenToSouthPass = false;
    public boolean beenToFortHall = false;
    public boolean beenToFortBoise = false;
    public boolean beenToFortWallaWalla = false;
    public boolean beenToTheDalles = false;
    public boolean reachedEnd = false;
    public boolean stop = false;
    public String locationName = "";
    public String paceTitle = "";
    public int distanceFromHome = 0;
    public int day = 1;
    public int month = 0;
    public int year = 0;
    public int pace = 0;
    public int milesPerDay = 20;
    public int wagonDamage = 1;
    private int locationStart = 0;
    final private int fortKearny = 335;
    final private int fortLaramie = 658;
    final private int independenceRock = 859;
    final private int southPass = 944;
    final private int fortHall = 1161;
    final private int fortBoise = 1383;
    final private int fortWallaWalla = 1631;
    final private int theDalles = 1726;
    final private int end = 1857;

    public int locationTicker = 0;

    public DateAndDistance (int distanceFromHome, int day, int month, int year, int milesPerDay, int wagonDamage, boolean kearny, boolean fortLaramie, boolean independence, boolean southPass, boolean fortHall, boolean fortBoise, boolean walla, boolean theDalles, boolean end){

        this.distanceFromHome = distanceFromHome;
        this.day = day;
        this.month = month;
        this.year = year;
        this.milesPerDay = milesPerDay;
        this.wagonDamage = wagonDamage;
        this.beenToKearny = kearny;
        this.beenToFortLaramie = fortLaramie;
        this.beenToIndependenceRock = independence;
        this.beenToSouthPass = southPass;
        this.beenToFortHall = fortHall;
        this.beenToFortBoise = fortBoise;
        this.beenToFortWallaWalla = walla;
        this.beenToTheDalles = theDalles;
        this.reachedEnd = end;
    }

    public String getCurrentDate() {

        day++;
        if (day >=  31) {

            day = day - 30;
            month++;
        }
        year = 1847;

        return month + "/" + day + "/" + year;
    }

    public String getLocationName() {

        return locationName;
    }

    public int getDistanceTraveled() {

        return distanceFromHome;
    }

    public void setPace(int pace) {
        this.pace = pace;
        if (pace == 0) {
            paceTitle = "Resting";
            milesPerDay = 0;
            stop = true;
        }
        else if (pace == 1) {
            paceTitle = "Steady";
            milesPerDay = 20;
            stop = false;
        }
        else if (pace == 2) {
            paceTitle = "Strenuous";
            milesPerDay = 30;
            stop = false;
        }
        else if (pace == 3) {
            paceTitle = "Grueling";
            milesPerDay = 40;
            stop = false;
        }

    }

    public void tickerUp() {

        locationTicker++;
    }

    public void locationCheck() {

        if (!beenToKearny) {
            if (distanceFromHome > fortKearny) {
                distanceFromHome = fortKearny;
            }
        }
        if (!beenToFortLaramie) {
            if (distanceFromHome > fortLaramie) {
                distanceFromHome = fortLaramie;
            }
        }
        if (!beenToIndependenceRock) {
            if (distanceFromHome > independenceRock) {
                distanceFromHome = independenceRock;
            }
        }
        if (!beenToSouthPass) {
            if (distanceFromHome > southPass) {
                distanceFromHome = southPass;
            }
        }
        if (!beenToFortHall) {
            if (distanceFromHome > fortHall) {
                distanceFromHome = fortHall;
            }
        }
        if (!beenToFortBoise) {
            if (distanceFromHome > fortBoise) {
                distanceFromHome = fortBoise;
            }
        }
        if (!beenToFortWallaWalla) {
            if (distanceFromHome > fortWallaWalla) {
                distanceFromHome = fortWallaWalla;
            }
        }
        if (!beenToTheDalles) {
            if (distanceFromHome > theDalles) {
                distanceFromHome = theDalles;
            }
        }
        if (!reachedEnd) {
            if (distanceFromHome > end) {
                distanceFromHome = end;
            }
        }

    }
    public void location() {

        if (distanceFromHome == locationStart) {
            locationName = "Independence, Missouri";
            stop = true;
        }
        else if (distanceFromHome < fortKearny && distanceFromHome > locationStart) {
            locationName = "The Trail";
            stop = false;
        }
        else if (distanceFromHome == fortKearny) {
            locationName = "Fort Kearny, Nebraska";
            beenToKearny = true;
            stop = true;
        }
        else if (distanceFromHome < fortLaramie && distanceFromHome > fortKearny) {
            locationName = "The Trail";
            stop = false;
        }
        else if (distanceFromHome == fortLaramie) {
            locationName = "Fort Laramie";
            beenToFortLaramie = true;
            stop = true;
        }
        else if (distanceFromHome < independenceRock && distanceFromHome > fortLaramie) {
            locationName = "The Trail";
            stop = false;
        }
        else if (distanceFromHome == independenceRock) {
            locationName = "Independence Rock";
            beenToIndependenceRock = true;
            stop = true;
        }
        else if (distanceFromHome < southPass && distanceFromHome > independenceRock) {
            locationName = "The Trail";
            stop = false;
        }
        else if (distanceFromHome == southPass) {
            locationName = "South Pass";
            beenToSouthPass = true;
            stop = true;
        }
        else if (distanceFromHome < fortHall && distanceFromHome > southPass) {
            locationName = "The Trail";
            stop = false;
        }
        else if (distanceFromHome == fortHall) {
            locationName = "Fort Hall";
            beenToFortHall = true;
            stop = true;
        }
        else if (distanceFromHome < fortBoise && distanceFromHome > fortHall) {
            locationName = "The Trail";
            stop = false;
        }
        else if (distanceFromHome == fortBoise) {
            locationName = "Fort Boise";
            beenToFortBoise = true;
            stop = true;
        }
        else if (distanceFromHome < fortWallaWalla && distanceFromHome > fortBoise) {
            locationName = "The Trail";
            stop = false;
        }
        else if (distanceFromHome == fortWallaWalla) {
            locationName = "Fort Walla Walla";
            beenToFortWallaWalla = true;
            stop = true;
        }
        else if (distanceFromHome < theDalles && distanceFromHome > fortWallaWalla) {
            locationName = "The Trail";
            stop = false;
        }
        else if (distanceFromHome == theDalles) {
            locationName = "The Dalles";
            beenToTheDalles = true;
            stop = true;
        }
        else if (distanceFromHome < end && distanceFromHome > theDalles) {
            locationName = "The Trail";
            stop = false;
        }
        else if (distanceFromHome == end) {
            locationName = "Ash Hollow, Nebraska";
            reachedEnd = true;
            stop = true;
        }
    }

    public void dailyMotion() {
        distanceFromHome = distanceFromHome + (milesPerDay/wagonDamage);
    }

    public int getMonth() {
        return month;
    }

    public void addDays(int days) {
        day = day + days;
    }

    public int getDay() {
        return day;
    }

    public int getWagonDamage() {
        return wagonDamage;
    }

    public void setWagonDamage(int wagonDamage) {
        this.wagonDamage = wagonDamage;
    }
}

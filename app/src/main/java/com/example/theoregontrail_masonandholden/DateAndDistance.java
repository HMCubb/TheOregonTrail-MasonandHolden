package com.example.theoregontrail_masonandholden;

import java.io.Serializable;

/**
 * The DateAndDistance class holds all the values regarding distance and date (as you can tell by the name).
 * @filename OregonTrailMasonandHolden
 * @author Holden Cubberley & Mason Muether
 * @date 5/9/2023
 */
public class DateAndDistance implements Serializable {

    // Initializing all the public and private values used within and outside of this class.
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

    /**
     * DateAndDistance
     * Constructor
     * Creates and holds all values relating to date and distance.
     */
    public DateAndDistance (int locationTicker, int pace, int distanceFromHome, int day, int month, int year, int milesPerDay, int wagonDamage, boolean kearny, boolean fortLaramie, boolean independence, boolean southPass, boolean fortHall, boolean fortBoise, boolean walla, boolean theDalles, boolean end){

        this.pace = pace;
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
        this.locationTicker = locationTicker;
    }

    /**
     * getCurrentDate
     * Bumps the day value up by one upon call.
     * Generates a string value containing the day, year, and month.
     * @return String : returns the date separated by /s (ex: 1/1/2001)
     */
    public String getCurrentDate() {

        day++;
        if (day >=  31) {

            day = day - 30;
            month++;
        }
        year = 1847;

        return month + "/" + day + "/" + year;
    }

    /**
     * getDate
     * Generates a string value containing the day, year, and month.
     * @return String : returns the date separated by /s (ex: 1/1/2001)
     */
    public String getDate() {

        if (day >=  31) {

            day = day - 30;
            month++;
        }
        year = 1847;

        return month + "/" + day + "/" + year;
    }

    /**
     * getDistanceTraveled
     * Returns the distance traveled thus far.
     * @return int : returns the distanceFromHome value
     */
    public int getDistanceTraveled() {

        return distanceFromHome;
    }

    /**
     * setPace
     * Takes the pace and uses it to determine the pace title, the miles the user will travel per day, and whether the wagon is stopped or not.
     * @param pace : the value from 0-3 which determine the pace the user will travel at.
     * @return int : returns the distanceFromHome value
     */
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

    /**
     * tickerUp
     * void function
     * Bumps the location ticker value up by one every time the user reaches a new location.
     */
    public void tickerUp() {

        locationTicker++;
    }

    /**
     * paceUp
     * void function
     * Bumps the pace value up by one every time this function is called.
     */
    public void paceUp() {

        pace++;
    }

    /**
     * paceDown
     * void function
     * Bumps the pace value down by one every time this function is called.
     */
    public void paceDown() {

        pace--;
    }


    /**
     * locationCheck
     * void function
     * A series of nested if statements that checks if a user has been to a specific location, if false then it checks if the distance from home
     * value is larger than that of the location value, if true, then the distance from home value is set to the value of the location.
     * This keeps the user from going past the location.
     */
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

    /**
     * location
     * void function
     * Checks where the user is in comparison to the start value, location values, and end values then changes the location name, been to booleans, and stop values.
     */
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

    /**
     * dailyMotion
     * void function
     * Sets the distance from home equal to itself plus the daily mileage divided by the wagon damage.
     */
    public void dailyMotion() {
        distanceFromHome = distanceFromHome + (milesPerDay/wagonDamage);
    }

    /**
     * getMonth
     * @return int : returns the month value.
     */
    public int getMonth() {
        return month;
    }

    /**
     * addDays
     * void function
     * Sets the day value equal to itself plus the days parameter.
     * @param days : amount of days that will be added.
     */
    public void addDays(int days) {
        day = day + days;
    }

    /**
     * getDay
     * @return int : returns the day value.
     */
    public int getDay() {
        return day;
    }

    /**
     * getWagonDamage
     * @return int : returns the wagonDamage value.
     */
    public int getWagonDamage() {
        return wagonDamage;
    }

    /**
     * setWagonDamage
     * void function
     * Sets the classes wagon damage equal to the passed wagon damage parameter.
     * @param wagonDamage : value that the wagon damage will be set to.
     */
    public void setWagonDamage(int wagonDamage) {
        this.wagonDamage = wagonDamage;
    }

    /**
     * getPage
     * @return int : returns the pace value.
     */
    public int getPace() {
        return pace;
    }
}

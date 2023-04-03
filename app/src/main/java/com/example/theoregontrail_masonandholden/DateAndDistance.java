package com.example.theoregontrail_masonandholden;

public class DateAndDistance {

    private boolean beenToKearny = false;
    private boolean reachedEnd = false;
    public boolean stop = false;
    public String locationName = "";
    public String paceTitle = "";
    public int distanceFromHome = 0;
    public int day = 1;
    public int month = 0;
    public int year = 0;
    public int pace = 0;
    public int milesPerDay = 0;
    private int locationStart = 0;
    private int midStop = 335;
    private int end = 510;

    public DateAndDistance (){

        distanceFromHome = 0;
        day = 0;
        month = 0;
        year = 0;
        beenToKearny = false;
        reachedEnd = false;
    }

    public String getCurrentDate() {

        month = 4;
        if (day ==  31) {

            day = 1;
            month++;
        }
        year = 1847;

        String date = month + "/" + day + "/" + year;
        return date;
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

    public void locationCheck() {

        if (beenToKearny == false) {
            if (distanceFromHome > midStop) {
                distanceFromHome = midStop;
            }
        }
        if (reachedEnd == false) {
            if (distanceFromHome > end) {
                distanceFromHome = end;
            }
        }

    }
    public void location() {

        if (distanceFromHome == locationStart) {
            locationName = "Independence, Missouri";
            pace = 0;
        }
        else if (distanceFromHome < midStop && distanceFromHome > locationStart) {
            locationName = "The Trail";
            stop = false;
        }
        else if (distanceFromHome == midStop) {
            locationName = "Fort Kearny, Nebraska";
            beenToKearny = true;
            pace = 0;
        }
        else if (distanceFromHome > midStop && distanceFromHome < end) {
            locationName = "The Trail";
            stop = false;
        }
        else if (distanceFromHome == end) {
            locationName = "Ash Hollow, Nebraska";
            reachedEnd = true;
            pace = 0;
        }
    }


}

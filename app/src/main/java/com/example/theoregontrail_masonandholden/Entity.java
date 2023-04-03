
package com.example.theoregontrail_masonandholden;


public class Entity {

    public boolean sick = false;
    public boolean injured = false;
    public String name = "";
    private int hattieNumber = 1;
    private int charlesNumber = 2;
    private int augustaNumber = 3;
    private int benNumber = 4;
    private int jakeNumber = 5;

    public Entity(int nameNumber) {

        if (nameNumber == hattieNumber) {
            name = "Hattie";
        }
        else if (nameNumber == charlesNumber) {
            name = "Charles";
        }
        else if (nameNumber == augustaNumber) {
            name = "Augusta";
        }
        else if (nameNumber == benNumber) {
            name = "Ben";
        }
        else {
            name = "Jake";
        }

        sick = false;
        injured = false;
    }


    public void setSick() {

        sick = true;
    }

    public void injured() {

        injured = true;
    }

    public void setHealthy() {

        sick = false;
        injured = false;
    }


}

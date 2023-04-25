
package com.example.theoregontrail_masonandholden;


import java.io.Serializable;

public class Entity implements Serializable {

    public boolean sick = false;
    public boolean injured = false;
    public boolean dead = false;

    public String name = "";

    public Entity(String name, boolean sick, boolean injured, boolean dead) {

        this.name = name;
        this.sick = sick;
        this.injured = injured;
        this.dead = dead;
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

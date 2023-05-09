package com.example.theoregontrail_masonandholden;

import java.io.Serializable;

/**
 * This is the GeneralHealth class.
 * This class holds a value that represents the party's overall health.
 *
 * @author Mason Muether and Holden Cubberley
 * @version 5/9/2023
 */
public class GeneralHealth implements Serializable {

    /**
     * Constructor for the health value.
     * The value is a double so that it can be calculated with precision.
     * The one value is only used for testing purposes, and can primarily be ignored.
     */
    public double GeneralHealth;
    public int one;

    public GeneralHealth(double generalHealth, int one) {
        this.GeneralHealth = generalHealth;
        this.one = one;
    }


    /**
     * Decreases the health value by 10% each day
     */
    public void decrementHealth(){
        double decrement = this.GeneralHealth * 0.10;
        this.GeneralHealth = this.GeneralHealth - decrement;
    }

    /**
     * Basic getter for GeneralHealth
     *
     * @return a double representing the health of the party
     */
    public double getGeneralHealth() {
        return this.GeneralHealth;
    }

    /**
     * Increases health by a given amount
     *
     * @param increment an integer representing the how much health should be added
     */
    public void addHealth(int increment) {
        this.GeneralHealth = this.GeneralHealth + increment;
    }

    /**
     * Increases the party's health, based on weather, clothing, and number of members
     *
     * @param weather an integer representing the current temperature
     * @param clothing an integer representing an amount of clothing
     * @param memberCount an integer representing number of current members
     */
    public void weatherHealth(int weather, int clothing, int memberCount){
        if (weather == 5){
            this.GeneralHealth = this.GeneralHealth + 2;
        }
        else if (weather == 4){
            this.GeneralHealth = this.GeneralHealth + 1;
        }
        else if (weather == 1){
            if (clothing >= memberCount){
                this.GeneralHealth = this.GeneralHealth + 1;
            }
            else {
                this.GeneralHealth = this.GeneralHealth + 2;
            }
        }
        else if (weather == 0){
            if (clothing >= (memberCount * 3)){
                this.GeneralHealth = this.GeneralHealth + 1;
            }
            else if (clothing >= (memberCount * 2)){
                this.GeneralHealth = this.GeneralHealth + 2;
            }
            else if (clothing >= memberCount){
                this.GeneralHealth = this.GeneralHealth + 3;
            }
            else {
                this.GeneralHealth = this.GeneralHealth + 4;
            }
        }
    }

    /**
     * Increases the party's health, based on the pace
     *
     * @param pace an integer representing the party's current pace
     */
    public void paceHealth(int pace){
        if (pace == 0){
        }
        else if (pace == 1){
            this.GeneralHealth = this.GeneralHealth + 2;
        }
        else if (pace == 2){
            this.GeneralHealth = this.GeneralHealth + 4;
        }
        else if (pace == 3){
            this.GeneralHealth = this.GeneralHealth + 6;
        }
    }

}

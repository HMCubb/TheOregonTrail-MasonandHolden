package com.example.theoregontrail_masonandholden;

import java.io.Serializable;

public class GeneralHealth implements Serializable {

    public double GeneralHealth;
    public int one;

    public GeneralHealth(double generalHealth, int one) {
        this.GeneralHealth = generalHealth;
        this.one = one;
    }


    public void decrementHealth(){
        double decrement = this.GeneralHealth * 0.1;
        this.GeneralHealth = this.GeneralHealth - decrement;
    }

    public double getGeneralHealth() {
        return this.GeneralHealth;
    }

    public void setGeneralHealth(double generalHealth) {
        this.GeneralHealth = generalHealth;
    }

    public void addHealth(int increment) {
        this.GeneralHealth = this.GeneralHealth + increment;
    }

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

    public boolean paceHealth(int pace){
        if (pace == 0){
            return true;
        }
        else if (pace == 1){
            this.GeneralHealth = this.GeneralHealth + 2;
            return true;
        }
        else if (pace == 2){
            this.GeneralHealth = this.GeneralHealth + 4;
            return true;
        }
        else if (pace == 3){
            this.GeneralHealth = this.GeneralHealth + 6;
            return true;
        }
        return false;
    }

    public boolean sickHealth(int sickNumber){
        this.GeneralHealth = this.GeneralHealth + sickNumber;
        return true;
    }

    public boolean injuryHealth(int injuryNumber){
        this.GeneralHealth = this.GeneralHealth + injuryNumber;
        return true;
    }


}

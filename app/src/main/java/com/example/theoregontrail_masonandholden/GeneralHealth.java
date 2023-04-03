package com.example.theoregontrail_masonandholden;

public class GeneralHealth {

    public double GeneralHealth;

    public GeneralHealth() {this.GeneralHealth = 0;}


    public boolean decrementHealth(){
        double decrement = this.GeneralHealth * 0.1;
        this.GeneralHealth = this.GeneralHealth - decrement;
        return true;
    }

    public double getGeneralHealth() {
        return this.GeneralHealth;
    }

    public void setGeneralHealth(double generalHealth) {
        this.GeneralHealth = generalHealth;
    }

    public void addHealth(double increment) {
        this.GeneralHealth = this.GeneralHealth + increment;
    }

    public boolean weatherHealth(int weather, int clothing, int memberCount){
        if (weather == 5){
            this.GeneralHealth = this.GeneralHealth + 2;
            return true;
        }
        else if (weather == 4){
            this.GeneralHealth = this.GeneralHealth + 1;
            return true;
        }
        else if (weather == 3){
            return true;
        }
        else if (weather == 2){
            return true;
        }
        else if (weather == 1){
            if (clothing >= (memberCount * 2)){
                return true;
            }
            else if (clothing >= memberCount){
                this.GeneralHealth = this.GeneralHealth + 1;
                return true;
            }
            else {
                this.GeneralHealth = this.GeneralHealth + 2;
                return true;
            }
        }
        else if (weather == 0){
            if (clothing >= (memberCount * 4)){
                return true;
            }
            else if (clothing >= (memberCount * 3)){
                this.GeneralHealth = this.GeneralHealth + 1;
                return true;
            }
            else if (clothing >= (memberCount * 2)){
                this.GeneralHealth = this.GeneralHealth + 2;
                return true;
            }
            else if (clothing >= memberCount){
                this.GeneralHealth = this.GeneralHealth + 3;
                return true;
            }
            else {
                this.GeneralHealth = this.GeneralHealth + 4;
                return true;
            }
        }
        return false;
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

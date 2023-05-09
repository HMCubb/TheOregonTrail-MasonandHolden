package com.example.theoregontrail_masonandholden;

import java.io.Serializable;

/**
 * This is the Weather class.
 * This class holds data on the temperature and rainfall for a given day.
 *
 * @author Mason Muether and Holden Cubberley
 * @version 5/9/2023
 */
public class Weather implements Serializable {

    /**
     * Constructors for temperature and rainfall.
     * both are positive integers. Temperature goes up to 100, and rainfall goes up to 10.
     */
    public int temperature;
    public int rainfall;

    public Weather(int temperature, int rainfall) {
        this.temperature = temperature;
        this.rainfall = rainfall;
    }

    /**
     * Basic getter for Temperature
     *
     * @return an integer from 0 to 100 representing the temperature.
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Basic setter for Temperature
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    /**
     * Basic getter for Rainfall
     *
     * @return an integer from 0 to 10 representing the Rainfall.
     */
    public int getRainfall() {
        return rainfall;
    }

    /**
     * Randomizes the value of Temperature to a new value between 0 and 100.
     */
    public void temperatureDaily(){
        this.temperature = (int) (Math.random() * 100);
    }

    /**
     * Randomizes the value of Rainfall to a new value between 0 and 10.
     */
    public void rainfallDaily(){
        this.rainfall = (int) (Math.random() * 10);
    }

}

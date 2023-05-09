package com.example.theoregontrail_masonandholden;

import java.io.Serializable;

public class Weather implements Serializable {

    public int temperature;
    public int rainfall;

    public Weather(int temperature, int rainfall) {
        this.temperature = temperature;
        this.rainfall = rainfall;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getRainfall() {
        return rainfall;
    }

    public void setRainfall(int rainfall) {
        this.rainfall = rainfall;
    }

    public void temperatureDaily(){
        this.temperature = (int) (Math.random() * 100);
    }

    public void rainfallDaily(){
        this.rainfall = (int) (Math.random() * 10);
    }

}

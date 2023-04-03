package com.example.theoregontrail_masonandholden;

public class Weather {

    public int temperature;
    public int rainfall;

    public Weather() {
        this.temperature = 0;
        this.rainfall = 0;
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
        this.temperature = (int) (Math.random() * 5);
    }

    public void rainfallDaily(){
        this.rainfall = (int) (Math.random() * 10);
    }

}

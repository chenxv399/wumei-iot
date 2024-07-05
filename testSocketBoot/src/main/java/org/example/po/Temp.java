package org.example.po;

public class Temp {
    String time;
    Double temp;

    public Temp() {
    }

    public Temp(String time, Double temp) {
        this.time = time;
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
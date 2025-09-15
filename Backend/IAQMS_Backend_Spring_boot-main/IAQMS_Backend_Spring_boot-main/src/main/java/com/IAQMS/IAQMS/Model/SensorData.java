package com.IAQMS.IAQMS.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "iaq_data") //table name in iaqms db
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double ppm;
    private String timestamp;

    private double temperature;
    private double humidity;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPpm() {
        return ppm;
    }

    public void setPpm(double ppm) {
        this.ppm = ppm;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }

    public double getTemperature(){
        return temperature;
    }

    public void setHumidity(double humidity){
        this.humidity = humidity;
    }

    public double getHumidity(){
        return humidity;
    }

    @Override
    public String toString() {
        return "PPM: " + ppm + ", Time: " + timestamp + "Temperature :" + temperature + "°C, Humidity :" + humidity + "%";
    }
}

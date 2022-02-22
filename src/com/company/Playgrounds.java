package com.company;

import java.util.ArrayList;

public class Playgrounds {

    String name;
    boolean isAvailable,isBooked;
    int pricePerHour, availableHours;

    public ArrayList<String> Ratings = new ArrayList<>();

    public Playgrounds(String name, int pricePerHour, int availableHours){
        this.name=name;
        this.pricePerHour=pricePerHour;
        this.availableHours=availableHours;
        isAvailable=false;
        isBooked=false;
    }


    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
    public int getPricePerHour() {
        return pricePerHour;
    }

    public boolean isAvailable(){
        return isAvailable;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public ArrayList<String> getRate(){
        return Ratings;
    }
    public void setRatings(String rate){
        Ratings.add(rate);
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setAvailableHours(int availableHours) {
        this.availableHours = availableHours;
    }

    public int getAvailableHours() {
        return availableHours;
    }

    @Override
    public String toString() {
        return "[" +
                "NAME = '" + name + '\'' +
                ", isAVAILABLE = " + isAvailable +
                ", isBOOKED = " + isBooked +
                ", PRICE PER HOUR = " + pricePerHour +
                ", AVAILABLE HOURS = " + availableHours +
                ']';
    }
}

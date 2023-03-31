package com.example.java_fx;

public class TourPlan {
    public String destination;
    public double price;

    public TourPlan(String destination, double price){
        setDestination (destination);
        setPrice (price);
    }

    public String getDestination(){
        return destination;
    }

    public double getPrice(){
        return price;
    }

    public void setDestination(String value){
        destination = value;
    }

    public void setPrice(double value){
        price = value;
    }
}

package com.example.demo.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class TourPlan {
    private SimpleStringProperty destination;
    private SimpleDoubleProperty price;

    public TourPlan(String destination, double price){
        this.destination = new SimpleStringProperty(destination);
        this.price = new SimpleDoubleProperty(price);
    }

    public String getDestination(){
        return destination.get ();
    }
    public double getPrice(){
        return price.get ();
    }

    public void setDestination(String value){
        destination.set (value);
    }
    public void setPrice(double value){
        price.set (value);
    }

    @Override
    public String toString() {
        return destination.get () + " " + price.get () + "$";
    }
}

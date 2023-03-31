package com.example.demo.model;

public class PrivilegedPlan {
    private String destination;

    public PrivilegedPlan(String destination){
        setDestination (destination);
    }

    public String getDestination(){
        return destination;
    }
    public void setDestination(String value){
        destination = value;
    }

    @Override
    public String toString() {
        return destination;
    }
}

package com.example.demo.model.data;

import com.example.demo.model.PrivilegedPlan;
import com.example.demo.model.TourPlan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.IntStream;

public class Storage {
    private static ObservableList<TourPlan> tours = FXCollections.observableArrayList();
    private static ObservableList<PrivilegedPlan> privilegedTours = FXCollections.observableArrayList();

    public static ObservableList<TourPlan> getTours(){
        return tours;
    }

    public static void insertTour(TourPlan tour){
        tours.add (tour);
    }

    public static void deleteTourByDestination(String destination){
        var tour = tours.stream().filter (x -> x.getDestination ().equals (destination));
        tours.remove (tour);
    }

    public static void updateTour(TourPlan tour) {
        int index = IntStream.range(0, tours.size())
                .filter(userInd-> tours.get(userInd).getDestination ().equals(tour.getDestination ()))
                .findFirst()
                .getAsInt();

        tours.set (index, tour);
    }

    public static ObservableList<PrivilegedPlan> getPrivilegedTours(){
        return privilegedTours;
    }

    public static void setPrivilegedTours(ObservableList<PrivilegedPlan> tours){
        privilegedTours = tours;
    }

    public static void initialize() {
        tours.add(new TourPlan("Barcelona", 1000.00));
        tours.add(new TourPlan("Paris", 1500.00));
        tours.add(new TourPlan("Warsaw", 800.00));
        tours.add(new TourPlan ("Oslo", 2000.00));
    }
}

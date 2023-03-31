package DataAccess;

import Models.PrivilegedPlan;
import Models.TourPlan;

import java.util.ArrayList;
import java.util.List;

public final class Data {
    private static List<TourPlan> tours = new ArrayList<> ();
    private static List<PrivilegedPlan> privilegedTours = new ArrayList<> ();

    public static List<TourPlan> getTours(){
        return tours;
    }

    public static void insertTour(TourPlan tour){
        tours.add (tour);
    }

    public static List<PrivilegedPlan> getPrivilegedTours(){
        return privilegedTours;
    }

    public static void setPrivilegedTours(List<PrivilegedPlan> tours){
        privilegedTours = tours;
    }

    public static void initialize(){
        tours.add(new TourPlan("Barcelona", 1000.00));
        tours.add(new TourPlan("Paris", 1500.00));
        tours.add(new TourPlan("Warsaw", 800.00));
        tours.add(new TourPlan("Oslo", 2000.00));
    }
}

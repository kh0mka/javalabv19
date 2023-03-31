package storage;

import com.example.java_fx.TourPlan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TourPlanStorage {
    private static final List<TourPlan> tourPlans = new ArrayList<> (){
        {
            add (new TourPlan ("Washington", 5000));
            add (new TourPlan ("Mogilev", 60));
            add (new TourPlan ("Paris", 350));
            add (new TourPlan ("Berlin", 305));
            add (new TourPlan ("Warsaw", 280));
        }
    };
    public static void insertTour(TourPlan tour){
        tourPlans.add (tour);
    }
    public static List<TourPlan> getTours(){
        return tourPlans;
    }

    public static List<TourPlan> getToursSortedByPrice(){
        var orderedTours = tourPlans.stream ()
                .sorted (Comparator.comparingDouble (TourPlan::getPrice))
                .collect(Collectors.toList());

        return orderedTours;
    }

    public static List<TourPlan> getToursSortedByPriceDesc(){
        var orderedTours = tourPlans.stream ()
                .sorted (Comparator.comparingDouble (TourPlan::getPrice).reversed ())
                .collect(Collectors.toList());

        return orderedTours;
    }

    public static List<TourPlan> getToursFilteredByPrice(double price){
        var filteredTours = tourPlans.stream ()
                .filter (x -> x.price >= price)
                .collect(Collectors.toList());

        return filteredTours;
    }
    public static boolean editTour(TourPlan tour){
        int index = IntStream.range(0, tourPlans.size())
                .filter(i -> tourPlans.get(i).destination.equals (tour.destination))
                .findFirst()
                .orElse(-1);

        if(index == -1) return  false;
        tourPlans.set (index, tour);

        return true;
    }

    public static boolean deleteTour(String destination) {
        var plans = tourPlans.stream ().filter (x -> x.getDestination () == destination).collect(Collectors.toList());
        if(plans.isEmpty ()) return false;

        tourPlans.removeAll (plans);

        return true;
    }

}

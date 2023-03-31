package Operations;

import DataAccess.Data;
import Models.TourPlan;
import Operations.Abstractions.Operation;

import java.util.Comparator;

public class OrderToursByPriceOperation implements Operation {
    private final Enums.Operation operation = Enums.Operation.ORDER_BY_PRICE;
    @Override
    public boolean isApplicable(Enums.Operation operation) {
        return this.operation.equals (operation);
    }

    @Override
    public void process() {
        Thread processingThread = new Thread (new OrderingToursByPriceRunnable ());
        processingThread.start ();
    }
}

class OrderingToursByPriceRunnable implements Runnable {
    @Override
    public void run() {
        var tours = Data.getTours ();
            System.out.println ("Plans sorted in ascending order:");
            tours.stream ()
                    .sorted (Comparator.comparingDouble (TourPlan::getPrice))
                    .forEach (System.out::println);
    }
}


package Operations;

import DataAccess.Data;
import Models.TourPlan;
import Operations.Abstractions.Operation;

import java.util.Comparator;

public class OrderToursByPriceDescOperation implements Operation {
    private final Enums.Operation operation = Enums.Operation.ORDER_BY_PRICE_DESC;
    @Override
    public boolean isApplicable(Enums.Operation operation) {
        return this.operation.equals (operation);
    }

    @Override
    public void process() {
        Thread processingThread = new Thread (new OrderingToursByPriceDescRunnable ());
        processingThread.start ();
    }
}

class OrderingToursByPriceDescRunnable implements Runnable {

    @Override
    public void run() {
        var tours = Data.getTours ();
            System.out.println ("Plans sorted in descending order:");
            tours.stream ()
                    .sorted (Comparator.comparingDouble (TourPlan::getPrice).reversed ())
                    .forEach (System.out::println);
    }
}


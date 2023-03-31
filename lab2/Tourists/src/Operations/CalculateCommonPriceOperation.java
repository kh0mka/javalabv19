package Operations;

import DataAccess.Data;
import Models.TourPlan;
import Operations.Abstractions.Operation;

public class CalculateCommonPriceOperation implements Operation {
    private final Enums.Operation operation = Enums.Operation.CALCULATE_COMMON_PRICE;
    @Override
    public boolean isApplicable(Enums.Operation operation) {
        return this.operation.equals (operation);
    }

    @Override
    public void process() {
        var tours = Data.getTours ();
        double commonPrice = tours.stream()
                .mapToDouble(TourPlan::getPrice)
                .sum();
        System.out.println("Common price of all tours: " + commonPrice);
    }
}

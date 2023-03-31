package Operations;

import DataAccess.Data;
import Models.TourPlan;
import Operations.Abstractions.Operation;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterToursByDestinationOperation implements Operation {
    private final Enums.Operation operation = Enums.Operation.FILTER_BY_DESTINATION;
    @Override
    public boolean isApplicable(Enums.Operation operation) {
        return this.operation.equals (operation);
    }

    @Override
    public void process() {
        var tours = Data.getTours ();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the destination to filter by: ");
        String filterDestination = scanner.nextLine();

        List<TourPlan> filteredTours = tours.stream()
                .filter(t -> t.getDestination().equals(filterDestination))
                .collect(Collectors.toList());

        filteredTours.forEach(t -> System.out.println(t.toString()));
    }
}

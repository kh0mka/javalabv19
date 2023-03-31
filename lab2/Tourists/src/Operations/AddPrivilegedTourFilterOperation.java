package Operations;

import DataAccess.Data;
import Models.PrivilegedPlan;
import Models.TourPlan;
import Operations.Abstractions.Operation;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddPrivilegedTourFilterOperation implements Operation {
    private final Enums.Operation operation = Enums.Operation.ADD_FILTER_FOR_PRIVILEGED;
    @Override
    public boolean isApplicable(Enums.Operation operation) {
        return this.operation.equals (operation);
    }

    @Override
    public void process() {
        var tours = Data.getTours ();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the price to filter by: ");
        double price = scanner.nextDouble ();

        List<TourPlan> filteredTours = tours.stream()
                .filter(t -> t.getPrice () <= price)
                .collect(Collectors.toList());

        Data.setPrivilegedTours (tours.stream ()
                .filter(i -> !filteredTours.contains(i))
                .map (x -> new PrivilegedPlan (x.getDestination ()))
                .collect(Collectors.toList()));

        System.out.print("\nAdded these tours to privileged: \n");
        Data.getPrivilegedTours ().forEach(t -> System.out.println(t.toString()));
    }
}

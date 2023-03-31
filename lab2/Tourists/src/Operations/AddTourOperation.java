package Operations;

import DataAccess.Data;
import Models.TourPlan;
import Operations.Abstractions.Operation;

import java.util.Scanner;

public class AddTourOperation implements Operation {
    private final Enums.Operation operation = Enums.Operation.ADD_TOUR;
    @Override
    public boolean isApplicable(Enums.Operation operation) {
        return this.operation.equals (operation);
    }

    @Override
    public void process() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter the price: ");
        double price = scanner.nextDouble();

        TourPlan tour = new TourPlan (destination, price);
        Data.insertTour (tour);
        System.out.println("Tour added successfully!");
    }
}

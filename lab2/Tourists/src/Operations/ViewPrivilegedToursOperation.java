package Operations;

import DataAccess.Data;
import Operations.Abstractions.Operation;

public class ViewPrivilegedToursOperation implements Operation {
    private final Enums.Operation operation = Enums.Operation.VIEW_PRIVILEGED_TOURS;
    @Override
    public boolean isApplicable(Enums.Operation operation) {
        return this.operation.equals (operation);
    }

    @Override
    public void process() {
        var tours = Data.getPrivilegedTours ();
        if(tours.isEmpty ()){
            System.out.println ("You don't have any privileged plans.");
            return;
        }
        System.out.println ("Privileged plan:\n");
        tours.forEach (System.out::println);
    }
}

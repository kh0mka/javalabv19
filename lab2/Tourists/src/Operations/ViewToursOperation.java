package Operations;

import DataAccess.Data;
import Operations.Abstractions.Operation;

public class ViewToursOperation implements Operation {
    private final Enums.Operation operation = Enums.Operation.VIEW_TOURS;
    @Override
    public boolean isApplicable(Enums.Operation operation) {
        return this.operation.equals (operation);
    }

    @Override
    public void process() {
        var tours = Data.getTours ();
        tours.forEach(t -> System.out.println(t.toString()));
    }
}

package Operations.Initialization;

import Operations.*;
import Operations.Abstractions.Operation;

import java.util.List;

public class OperationInitializer {
    public static final void initialize(List<Operation> operations) {
        operations.add (new AddTourOperation ());
        operations.add (new ViewToursOperation ());
        operations.add (new CalculateCommonPriceOperation ());
        operations.add (new FilterToursByDestinationOperation ());
        operations.add (new OrderToursByPriceOperation ());
        operations.add (new OrderToursByPriceDescOperation ());
        operations.add (new AddPrivilegedTourFilterOperation ());
        operations.add (new ViewPrivilegedToursOperation ());
        operations.add (new QuitOptionOperation ());
        operations.add (new UnknownOptionOperation ());
    }
}

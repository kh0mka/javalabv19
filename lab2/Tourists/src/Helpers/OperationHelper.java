package Helpers;

import Enums.Operation;
import Operations.Initialization.OperationInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class OperationHelper {
    private final Scanner scanner;
    private List<Operations.Abstractions.Operation> operations = new ArrayList<> ();

    public OperationHelper(){
        scanner = new Scanner (System.in);
        OperationInitializer.initialize (operations);
    }

    public Operation readOperationTypeFromConsole() {
        int option = scanner.nextInt();
        Enums.Operation operationType = Enums.Operation.fromValue (option);

        return operationType;
    }

    public Operations.Abstractions.Operation getOperation(Enums.Operation operationType){
        var operation = operations.stream ().filter (x-> x.isApplicable (operationType)).findFirst ();
        return operation.get ();
    }
}

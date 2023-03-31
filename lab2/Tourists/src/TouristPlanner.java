import DataAccess.Data;
import Helpers.OperationHelper;
import Operations.Abstractions.Operation;

public class TouristPlanner {
    private final OperationHelper operationHelper;
    public TouristPlanner() {
        Data.initialize ();
        operationHelper = new OperationHelper ();
    }

    public void start() {
        while (true) {
            printMenu ();
            try{
                Operation operation = getChosenOperation ();

                operation.process ();
            }
           catch (Exception e) {
               System.out.println (e.getMessage ());
           }
        }
    }

    private void printMenu()
    {
        System.out.print(Constants.MENU);
    }
    private Operation getChosenOperation(){
        Enums.Operation operationType = operationHelper.readOperationTypeFromConsole ();
        Operation operation = operationHelper.getOperation (operationType);

        return operation;
    }
}

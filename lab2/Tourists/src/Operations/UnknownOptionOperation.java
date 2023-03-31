package Operations;

import Operations.Abstractions.Operation;

public class UnknownOptionOperation implements Operation {
    private final Enums.Operation operation = Enums.Operation.UNKNOWN;
    @Override
    public boolean isApplicable(Enums.Operation operation) {
        return this.operation.equals (operation);
    }

    @Override
    public void process() {
        System.out.println("Invalid operation. Please choose again.");
    }
}

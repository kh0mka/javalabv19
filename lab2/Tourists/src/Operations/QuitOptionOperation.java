package Operations;

import Operations.Abstractions.Operation;

import static java.lang.System.exit;

public class QuitOptionOperation implements Operation {
    private final Enums.Operation operation = Enums.Operation.QUIT;

    @Override
    public boolean isApplicable(Enums.Operation operation) {
        return this.operation.equals (operation);
    }

    @Override
    public void process() {
        exit(0);
    }
}

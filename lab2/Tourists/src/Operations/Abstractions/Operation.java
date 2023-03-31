package Operations.Abstractions;

public interface Operation {
    boolean isApplicable(Enums.Operation operation);
    void process();
}

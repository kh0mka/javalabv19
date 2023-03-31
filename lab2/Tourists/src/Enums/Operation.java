package Enums;

public enum Operation {
    ADD_TOUR(1),
    VIEW_TOURS(2),
    CALCULATE_COMMON_PRICE(3),
    FILTER_BY_DESTINATION(4),
    ORDER_BY_PRICE(5),
    ORDER_BY_PRICE_DESC(6),
    ADD_FILTER_FOR_PRIVILEGED(7),
    VIEW_PRIVILEGED_TOURS(8),
    QUIT(9),
    UNKNOWN (10);

    private int value;

    private Operation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Operation fromValue(int value) {
        for (Operation operation : Operation.values()) {
            if (operation.getValue() == value) {
                return operation;
            }
        }
       return Operation.UNKNOWN;
    }
}

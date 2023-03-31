package UI.Components.ContentStartegies;

import Abstractions.UI.Components.Strategies.ComponentContentStrategy;

public class FaultContentStrategy extends ComponentContentStrategy {

    private final String message;

    public FaultContentStrategy(String message) {
        this.message = message;
    }

    @Override
    public String getContentAsString() {
        return message;
    }
}

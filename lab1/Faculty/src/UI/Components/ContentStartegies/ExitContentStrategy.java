package UI.Components.ContentStartegies;

import Abstractions.UI.Components.Strategies.ComponentContentStrategy;

public class ExitContentStrategy extends ComponentContentStrategy {
    @Override
    public String getContentAsString() {
        return "\nBye-bye...\n";
    }
}

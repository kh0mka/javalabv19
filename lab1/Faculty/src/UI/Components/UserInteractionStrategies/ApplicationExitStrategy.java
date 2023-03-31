package UI.Components.UserInteractionStrategies;

import Abstractions.UI.Base.Displayer;
import Abstractions.UI.Components.Strategies.ComponentUserInteractionStrategy;

import static java.lang.System.exit;

public class ApplicationExitStrategy extends ComponentUserInteractionStrategy {
    public ApplicationExitStrategy(Displayer displayer) {
        super (displayer);
    }

    @Override
    public void interact() {
        exit(0);
    }
}

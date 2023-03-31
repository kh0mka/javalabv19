package UI.Components;

import Abstractions.UI.Components.ComponentBase;
import Abstractions.UI.Components.Strategies.ComponentContentStrategy;
import Abstractions.UI.Base.Displayer;

public class DefaultComponent extends ComponentBase {
    public DefaultComponent(ComponentContentStrategy contentStrategy, Displayer displayer) {
        super (contentStrategy, displayer);
    }
}

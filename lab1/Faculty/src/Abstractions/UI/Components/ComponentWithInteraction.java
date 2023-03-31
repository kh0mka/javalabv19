package Abstractions.UI.Components;

import Abstractions.UI.Components.Strategies.ComponentContentStrategy;
import Abstractions.UI.Components.Strategies.ComponentUserInteractionStrategy;
import Abstractions.UI.Base.Displayer;

public abstract class ComponentWithInteraction extends ComponentBase {
    protected final ComponentUserInteractionStrategy interactionStrategy;
    protected ComponentWithInteraction(ComponentContentStrategy contentStrategy, Displayer displayer, ComponentUserInteractionStrategy interactionStrategy) {
        super (contentStrategy, displayer);
        this.interactionStrategy = interactionStrategy;
    }
}

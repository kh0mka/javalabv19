package UI.Components;

import Abstractions.UI.Components.ComponentWithInteraction;
import Abstractions.UI.Components.Strategies.ComponentContentStrategy;
import Abstractions.UI.Components.Strategies.ComponentUserInteractionStrategy;
import Abstractions.UI.Base.Displayer;

public class InteractionComponent extends ComponentWithInteraction {
    public InteractionComponent(ComponentContentStrategy displayStrategy, Displayer displayer, ComponentUserInteractionStrategy interactionStrategy) {
        super (displayStrategy, displayer, interactionStrategy);
    }
    @Override
    public void Show() {
        super.Show ();

        interactionStrategy.interact ();
    }
}

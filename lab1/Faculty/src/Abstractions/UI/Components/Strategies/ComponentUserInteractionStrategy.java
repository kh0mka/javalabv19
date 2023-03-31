package Abstractions.UI.Components.Strategies;

import Abstractions.UI.Base.Displayer;

public abstract class ComponentUserInteractionStrategy {

    protected final Displayer displayer;
    protected ComponentUserInteractionStrategy(Displayer displayer) {
        this.displayer = displayer;
    }

    public abstract void interact();
}

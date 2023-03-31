package Abstractions.UI.Components;

import Abstractions.UI.Components.Strategies.ComponentContentStrategy;
import Abstractions.UI.Base.Displayer;

public abstract class ComponentBase {

    protected final ComponentContentStrategy contentStrategy;
    protected final Displayer displayer;

    protected ComponentBase(ComponentContentStrategy contentStrategy, Displayer displayer) {
        this.contentStrategy = contentStrategy;
        this.displayer = displayer;
    }
    public void Show() {
        var content = contentStrategy.getContentAsString ();
        displayer.Display (content);
    }
}

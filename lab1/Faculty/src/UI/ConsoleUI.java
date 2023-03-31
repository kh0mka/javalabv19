package UI;

import Abstractions.UI.Base.Displayer;
import Abstractions.UI.Components.ComponentBase;
import UI.Components.ContentStartegies.FaultContentStrategy;
import UI.Components.DefaultComponent;

import java.util.Map;

public class ConsoleUI implements Abstractions.UI.ConsoleUI {
    private final Map<Integer, ComponentBase> components;
    private final Displayer displayer;

    public ConsoleUI(Map<Integer, ComponentBase> components, Displayer displayer) {
        this.components = components;
        this.displayer = displayer;
    }
    @Override
    public void showComponent(ComponentBase component) {
        component.Show ();
    }

    @Override
    public void showComponent(Integer componentNumber) {
        var component = components.getOrDefault (componentNumber, new DefaultComponent (new FaultContentStrategy ("\nThere is no option...\n"), displayer));

        component.Show ();
    }
    @Override
    public void showFaultComponent(String exceptionMessage) {
        showComponent (new DefaultComponent (new FaultContentStrategy (exceptionMessage), displayer));
    }
}

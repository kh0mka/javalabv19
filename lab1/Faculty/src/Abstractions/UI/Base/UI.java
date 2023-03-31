package Abstractions.UI.Base;

import Abstractions.UI.Components.ComponentBase;

import java.util.HashMap;
import java.util.Map;

public interface UI {
    void showComponent(ComponentBase component);
    void showComponent(Integer componentNumber);
    void showFaultComponent(String exceptionMessage);
}

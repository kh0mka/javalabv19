package UI.Displayers;

import Abstractions.UI.Base.Displayer;

public class ConsoleDisplayer implements Displayer<String> {
    @Override
    public void Display(String info) {
        System.out.print (info);
    }
}

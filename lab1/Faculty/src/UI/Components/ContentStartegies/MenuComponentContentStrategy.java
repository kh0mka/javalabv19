package UI.Components.ContentStartegies;

import Abstractions.UI.Components.Strategies.ComponentContentStrategy;

public class MenuComponentContentStrategy extends ComponentContentStrategy {
    @Override
    public String getContentAsString() {
        return ("\nChoose one option: \n " +
                "1.Show students\n " +
                "2.Show courses\n " +
                "3.Show teachers\n " +
                "4.Enroll student on course\n " +
                "5.Start learning!\n " +
                "6.Go to archive\n " +
                "7.Estimate students' results\n " +
                "8.Exit...\n" +
                "Your option: ");
    }
}

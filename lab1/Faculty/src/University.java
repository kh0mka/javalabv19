import Abstractions.UI.Base.UI;
import Parameters.UIParameters;
import Parameters.UniversityParameters;

import java.util.Scanner;

public final class University {
    private final UI UI;
    private final Scanner scanner = new Scanner (System.in);
    public University()
    {
        UI = AppInitializer.InitializeAppWithUI ();
    }

    public void Start(){
        UI.showComponent (UIParameters.CoursesStartedComponentNumber);

        while (UniversityParameters.AmountOfStudiesInDaysLeft > 0) {
            UI.showComponent (UIParameters.MenuComponentNumber);
            try {
                var optionNumber = scanner.nextInt ();
                UI.showComponent (optionNumber);

                UniversityParameters.AmountOfStudiesInDaysLeft--;
            }
            catch (Exception e){
                UI.showFaultComponent (e.getMessage ());
            }
        }
    }
}

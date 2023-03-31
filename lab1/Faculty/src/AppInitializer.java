import Abstractions.DataAccess.Archive;
import Abstractions.DataAccess.Repositories.CourseRepository;
import Abstractions.DataAccess.Repositories.MarkRepository;
import Abstractions.DataAccess.Repositories.StudentRepository;
import Abstractions.DataAccess.Repositories.TeacherRepository;
import Abstractions.UI.Base.Displayer;
import Abstractions.UI.Base.UI;
import Abstractions.UI.Components.ComponentBase;
import Abstractions.UI.Components.Strategies.ComponentContentStrategy;
import Abstractions.UI.Components.Strategies.ComponentUserInteractionStrategy;
import DataAccess.Initialization.DataInitializer;
import DataAccess.Storages.FileStorage;
import Parameters.UIParameters;
import UI.Components.ContentStartegies.*;
import UI.Components.DefaultComponent;
import UI.Components.InteractionComponent;
import UI.Components.UserInteractionStrategies.ApplicationExitStrategy;
import UI.Components.UserInteractionStrategies.StudentEnrollmentStrategy;
import UI.Components.UserInteractionStrategies.StudentEstimationStrategy;
import UI.Displayers.ConsoleDisplayer;
import Validators.CourseValidator;
import Validators.MarkValidator;
import Validators.StudentValidator;
import Validators.TeacherValidator;
import UI.ConsoleUI;

import java.util.HashMap;
import java.util.Map;

public final class AppInitializer {
    public static UI InitializeAppWithUI(){
        FileStorage storage = new FileStorage ();
        Displayer displayer = new ConsoleDisplayer ();
        var courseValidator = new CourseValidator ();
        var teacherValidator = new TeacherValidator ();
        var markValidator = new MarkValidator ();
        var studentValidator = new StudentValidator ();

        TeacherRepository teacherRepository = new DataAccess.Repositories.TeacherRepository (storage);
        StudentRepository studentRepository = new DataAccess.Repositories.StudentRepository (storage);
        MarkRepository markRepository = new DataAccess.Repositories.MarkRepository (storage);
        CourseRepository courseRepository = new DataAccess.Repositories.CourseRepository (storage);
        Archive archive = new DataAccess.Archive (markRepository);
        DataInitializer initializer = new DataInitializer (courseRepository, teacherRepository, studentRepository, storage);
        initializer.SeedData ();

        ComponentContentStrategy archiveContentStrategy = new ArchiveContentStrategy (archive);
        ComponentContentStrategy coursesContentStrategy = new CoursesContentStrategy (courseRepository);
        ComponentContentStrategy coursesStartedContentStrategy = new CoursesStartedContentStrategy (teacherRepository);
        ComponentContentStrategy enrollmentContentStrategy = new EnrollmentContentStrategy (studentRepository, courseRepository);
        ComponentContentStrategy exitContentStrategy = new ExitContentStrategy ();
        ComponentContentStrategy learningContentStrategy = new LearningContentStrategy (studentRepository);
        ComponentContentStrategy studentsContentStrategy = new StudentsContentStrategy (studentRepository);
        ComponentContentStrategy teachersContentStrategy = new TeachersContentStrategy (teacherRepository);
        ComponentContentStrategy studentEstimationContentStrategy = new StudentsEstimationContentStrategy (studentRepository, teacherRepository);

        ComponentUserInteractionStrategy studentEnrollmentStrategy = new StudentEnrollmentStrategy (displayer, courseRepository, studentRepository, courseValidator, studentValidator);
        ComponentUserInteractionStrategy studentEstimationStrategy = new StudentEstimationStrategy (displayer, archive, studentRepository, teacherRepository, teacherValidator, studentValidator, markValidator);
        ComponentUserInteractionStrategy appExitStrategy = new ApplicationExitStrategy (displayer);

        Map<Integer, ComponentBase> components = new HashMap<> (){{
            put (UIParameters.MenuComponentNumber, new DefaultComponent (new MenuComponentContentStrategy (), displayer));
            put (UIParameters.StudentsComponentNumber, new DefaultComponent (studentsContentStrategy, displayer));
            put (UIParameters.CoursesComponentNumber, new DefaultComponent (coursesContentStrategy, displayer));
            put (UIParameters.TeachersComponentNumber, new DefaultComponent (teachersContentStrategy, displayer));
            put (UIParameters.EnrollmentComponentNumber, new InteractionComponent (enrollmentContentStrategy, displayer, studentEnrollmentStrategy));
            put (UIParameters.LearningComponentNumber, new DefaultComponent (learningContentStrategy, displayer));
            put (UIParameters.ArchiveComponentNumber, new DefaultComponent (archiveContentStrategy, displayer));
            put (UIParameters.EstimationComponentNumber, new InteractionComponent (studentEstimationContentStrategy, displayer, studentEstimationStrategy));
            put (UIParameters.ExitComponentNumber, new InteractionComponent (exitContentStrategy, displayer, appExitStrategy));
            put (UIParameters.CoursesStartedComponentNumber, new DefaultComponent (coursesStartedContentStrategy, displayer));
        }};

        return new ConsoleUI (components, displayer);
    }
}

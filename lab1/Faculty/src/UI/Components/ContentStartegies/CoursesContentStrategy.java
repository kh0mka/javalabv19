package UI.Components.ContentStartegies;

import Abstractions.DataAccess.Repositories.CourseRepository;
import Abstractions.UI.Components.Strategies.ComponentContentStrategy;

public class CoursesContentStrategy extends ComponentContentStrategy {

    private final CourseRepository courseRepository;

    public CoursesContentStrategy(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public String getContentAsString() {
        var courses = courseRepository.getAll ();

        if(courses.isEmpty () || courses == null)
            return "\nSorry, there aren't any courses...\n";

        var stringBuilder = new StringBuilder ();

        courses.forEach (course -> {
            stringBuilder.append (" CourseId: " + course.getId () );
            stringBuilder.append (" Name: " + course.getName ());
            stringBuilder.append ("\n");
        });

        return stringBuilder.toString ();
    }
}

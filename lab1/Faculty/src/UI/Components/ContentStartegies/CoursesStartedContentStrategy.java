package UI.Components.ContentStartegies;

import Abstractions.DataAccess.Repositories.TeacherRepository;
import Abstractions.UI.Components.Strategies.ComponentContentStrategy;

public class CoursesStartedContentStrategy extends ComponentContentStrategy {
    private final TeacherRepository teacherRepository;

    public CoursesStartedContentStrategy(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    @Override
    public String getContentAsString() {
        var teachers = teacherRepository.getAll ();

        if(teachers.isEmpty () || teachers == null)
            return "\nSorry, there aren't any teachers...\n";

        var stringBuilder = new StringBuilder ();

        teachers.forEach (teacher -> {
            stringBuilder.append ("Teacher ");
            stringBuilder.append (teacher.getName ());
            stringBuilder.append (" invites students for the course: ");
            stringBuilder.append (teacher.getCourse ().getName ());
            stringBuilder.append ("\n");
        });

        return stringBuilder.toString ();
    }
}

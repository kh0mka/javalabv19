package UI.Components.ContentStartegies;

import Abstractions.DataAccess.Repositories.TeacherRepository;
import Abstractions.UI.Components.Strategies.ComponentContentStrategy;

public class TeachersContentStrategy extends ComponentContentStrategy {
    private final TeacherRepository teacherRepository;

    public TeachersContentStrategy(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public String getContentAsString() {
        var teachers = teacherRepository.getAll ();

        if (teachers.isEmpty () || teachers == null)
            return "\nSorry, there aren't any students...\n";

        var stringBuilder = new StringBuilder ();

        teachers.forEach (teacher -> {
            stringBuilder.append (" TeacherId: " + teacher.getId ());
            stringBuilder.append (" Name: " + teacher.getName ());
            stringBuilder.append ("\n");
        });

        return stringBuilder.toString ();
    }
}

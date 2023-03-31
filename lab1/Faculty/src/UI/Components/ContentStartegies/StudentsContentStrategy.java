package UI.Components.ContentStartegies;

import Abstractions.DataAccess.Repositories.StudentRepository;
import Abstractions.UI.Components.Strategies.ComponentContentStrategy;

public class StudentsContentStrategy extends ComponentContentStrategy {

    private final StudentRepository studentRepository;

    public StudentsContentStrategy(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String getContentAsString() {
        var students = studentRepository.getAll ();

        if(students.isEmpty () || students == null)
            return "Sorry, there aren't any students...";

        var stringBuilder = new StringBuilder ();

        students.forEach (student -> {
            stringBuilder.append (" StudentId: " + student.getId () );
            stringBuilder.append (" Name: " + student.getName ());
            stringBuilder.append ("\n");
        });

        return stringBuilder.toString ();
    }
}

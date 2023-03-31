package UI.Components.ContentStartegies;

import Abstractions.DataAccess.Repositories.StudentRepository;
import Abstractions.UI.Components.Strategies.ComponentContentStrategy;

public class LearningContentStrategy extends ComponentContentStrategy {
    private final StudentRepository studentRepository;

    public LearningContentStrategy(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String getContentAsString() {
        var students = studentRepository.getAll ();

        if(students.isEmpty () || students == null)
            return "Sorry... No students left.";

        var stringBuilder = new StringBuilder ();

        students.forEach (student -> {
            stringBuilder.append (student.getName ());
            stringBuilder.append (" is learning courses: \n");

            var courses = student.getCourses ();

            if(courses.isEmpty ()) stringBuilder.append ("\nThis student does not have course...\n\n");
            else {
                courses.forEach (course -> {
                    stringBuilder.append ("  " + course.getName () + "\n");
                });
            }
        });

        return stringBuilder.toString ();
    }
}

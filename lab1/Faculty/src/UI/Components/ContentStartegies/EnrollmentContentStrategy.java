package UI.Components.ContentStartegies;

import Abstractions.DataAccess.Repositories.CourseRepository;
import Abstractions.DataAccess.Repositories.StudentRepository;
import Abstractions.UI.Components.Strategies.ComponentContentStrategy;

public class EnrollmentContentStrategy extends ComponentContentStrategy {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentContentStrategy(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public String getContentAsString() {
        var courses = courseRepository.getAll ();
        var students = studentRepository.getAll ();

        if(students == null || courses == null || students.isEmpty () || courses.isEmpty ())
            return "\nSorry, but there aren't any courses or students...\n";

        var stringBuilder = new StringBuilder ("The list of available courses: \n");
        courses.forEach (course -> {
            stringBuilder.append (" Name: " + course.getName ());
            stringBuilder.append (" Id: "+ course.getId ());
            stringBuilder.append ("\n");
        });

        stringBuilder.append ("\n The list of students you can enroll:\n");
        students.forEach (student -> {
            stringBuilder.append (" Name: " + student.getName ());
            stringBuilder.append (" Id: "+ student.getId ());
            stringBuilder.append ("\n");
        });

        return stringBuilder.toString ();
    }
}

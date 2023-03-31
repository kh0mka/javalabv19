package UI.Components.ContentStartegies;

import Abstractions.DataAccess.Repositories.StudentRepository;
import Abstractions.DataAccess.Repositories.TeacherRepository;
import Abstractions.UI.Components.Strategies.ComponentContentStrategy;
import Entities.Course;

public class StudentsEstimationContentStrategy extends ComponentContentStrategy {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public StudentsEstimationContentStrategy(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public String getContentAsString() {
        var students = studentRepository.getStudentsWithCourses ();

        if (students.isEmpty ()) return "There are no students with courses";

        var stringBuilder = new StringBuilder ("Students with their courses:\n");

        students.forEach (student -> {
            stringBuilder.append ("\nStudent\nID: ");
            stringBuilder.append (student.getId ());
            stringBuilder.append ("\nName: ");
            stringBuilder.append (student.getName ());

            var courses = student.getCourses ();
            for (Course course : courses) {
                var teacher = teacherRepository.getByCourseId (course.getId ());
                if (teacher.isEmpty ()) {
                    stringBuilder.append ("\nThere is no teacher for course" + course.getId () + "\n");
                    continue;
                }

                stringBuilder.append ("\n Courses he passed: ");
                stringBuilder.append ("\n  ID: ");
                stringBuilder.append (course.getId ());
                stringBuilder.append ("\n  Name: ");
                stringBuilder.append (course.getName ());
                stringBuilder.append ("\n  TeacherID: ");
                stringBuilder.append (teacher.get ().getId ());
                stringBuilder.append ("\n  Teacher name: ");
                stringBuilder.append (teacher.get ().getName ());
                stringBuilder.append ("\n");
            }
        });

        return stringBuilder.toString ();
    }
}

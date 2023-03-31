package UI.Components.UserInteractionStrategies;

import Abstractions.DataAccess.Repositories.CourseRepository;
import Abstractions.DataAccess.Repositories.StudentRepository;
import Abstractions.UI.Components.Strategies.ComponentUserInteractionStrategy;
import Abstractions.UI.Base.Displayer;
import Infrastructure.Exceptions.DomainException;
import Infrastructure.Exceptions.EntityNotFoundException;
import Validators.CourseValidator;
import Validators.StudentValidator;

import java.util.Scanner;
import java.util.UUID;

public class StudentEnrollmentStrategy extends ComponentUserInteractionStrategy {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    private final CourseValidator courseValidator;
    private final StudentValidator studentValidator;

    public StudentEnrollmentStrategy(Displayer displayer, CourseRepository courseRepository, StudentRepository studentRepository, CourseValidator courseValidator, StudentValidator studentValidator) {
        super (displayer);
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.courseValidator = courseValidator;
        this.studentValidator = studentValidator;
    }

    @Override
    public void interact() {
        displayer.Display ("Enter student's ID you want to enroll: \n");

        try {
            var studentId = readIdFromConsole ();
            var student = studentRepository.getById (studentId);

             studentValidator.validate(student);

            displayer.Display ("\nEnter course ID you want to enroll student: \n");

            var courseId =  readIdFromConsole ();
            var course = courseRepository.getById (courseId);

            courseValidator.validate (course, student);

            student.get().addCourse (course.get ());

            studentRepository.update (student.get ());
        } catch (EntityNotFoundException | DomainException e) {
            displayer.Display (e.getMessage ());
        }
    }

    private UUID readIdFromConsole() {
        var scanner = new Scanner (System.in);
        var studentIdString = scanner.nextLine ();
        var studentId = UUID.fromString (studentIdString.replaceAll("\\s+",""));

        return studentId;
    }
}

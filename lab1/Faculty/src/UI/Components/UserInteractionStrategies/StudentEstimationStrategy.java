package UI.Components.UserInteractionStrategies;

import Abstractions.DataAccess.Repositories.StudentRepository;
import Abstractions.DataAccess.Repositories.TeacherRepository;
import Abstractions.DataAccess.Archive;
import Abstractions.UI.Components.Strategies.ComponentUserInteractionStrategy;
import Abstractions.UI.Base.Displayer;
import Entities.Mark;
import Infrastructure.Exceptions.EntityNotFoundException;
import Validators.MarkValidator;
import Validators.StudentValidator;
import Validators.TeacherValidator;

import java.util.Scanner;
import java.util.UUID;

public class StudentEstimationStrategy extends ComponentUserInteractionStrategy {
    private final Archive archive;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    private final TeacherValidator teacherValidator;
    private final StudentValidator studentValidator;
    private final MarkValidator markValidator;

    public StudentEstimationStrategy(Displayer displayer, Archive archive, StudentRepository studentRepository, TeacherRepository teacherRepository, TeacherValidator teacherValidator, StudentValidator studentValidator, MarkValidator markValidator) {
        super (displayer);
        this.archive = archive;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.teacherValidator = teacherValidator;
        this.studentValidator = studentValidator;
        this.markValidator = markValidator;
    }

    @Override
    public void interact() {
        displayer.Display ("\nEnter student's ID you want to estimate: \n");

        try{
            var studentId = readIdFromConsole ();
            var student = studentRepository.getById (studentId);

            studentValidator.validate (student);

            displayer.Display ("\nEnter teacher ID you want to take as estimator: \n");

            var teacherId = readIdFromConsole ();
            var teacher = teacherRepository.getById (teacherId);
            var courseId = teacher.get ().getCourse ().getId ();

            teacherValidator.validate (teacher);

            displayer.Display ("\nEnter mark from 1 to 10 \n");
            var mark = markValidator.validate(new Scanner(System.in).nextInt ());

            archive.marks ().insert (new Mark (mark, teacherId, studentId, courseId));
        }
        catch (EntityNotFoundException e) {
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

package Validators;

import Abstractions.Validators.Base.Validator;
import Entities.Course;
import Entities.Student;
import Infrastructure.Exceptions.DomainException;
import Infrastructure.Exceptions.EntityNotFoundException;

import java.util.Optional;

public class CourseValidator extends Validator<Course> {
    public void validate(Optional<Course> course, Optional<Student> student) throws EntityNotFoundException, DomainException {
        if (course.isEmpty ()) {
            throw new EntityNotFoundException ("\nCourse with such ID doesn't exist.\n");
        }

        if (student.get ().getCourses ().contains (course)) {
            throw new DomainException ("\nStudent already learnt this course.\n");
        }
    }
}

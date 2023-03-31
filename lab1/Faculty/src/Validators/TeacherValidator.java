package Validators;

import Abstractions.Validators.Base.Validator;
import Entities.Teacher;
import Infrastructure.Exceptions.EntityNotFoundException;

import java.util.Optional;

public class TeacherValidator extends Validator<Teacher> {
    @Override
    public void validate(Optional<Teacher> entity) throws EntityNotFoundException {
        super.validate (entity);
        if(entity.get().getCourse () == null) {
            throw new EntityNotFoundException ("\nTeacher doesn't have course.\n");
        }
    }
}

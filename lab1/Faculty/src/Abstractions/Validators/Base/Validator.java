package Abstractions.Validators.Base;

import Abstractions.Entities.BaseEntity;
import Infrastructure.Exceptions.EntityNotFoundException;

import java.util.Optional;

public abstract class Validator<T extends BaseEntity> {
    public void validate(Optional<T> entity) throws EntityNotFoundException {
        if (entity.isEmpty ()) throw new EntityNotFoundException ("Entity doesn't exits.");
    }
}

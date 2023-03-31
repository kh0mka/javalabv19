package Abstractions.DataAccess.Repositories;

import Entities.Teacher;

import java.util.Optional;
import java.util.UUID;

public interface TeacherRepository extends IGenericRepository<Teacher> {
    Optional<Teacher> getByCourseId(UUID courseId);
}

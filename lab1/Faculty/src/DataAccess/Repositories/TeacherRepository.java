package DataAccess.Repositories;

import Abstractions.DataAccess.Repositories.GenericRepository;
import Abstractions.DataAccess.Storage.Storage;
import Entities.Teacher;

import java.util.Optional;
import java.util.UUID;

public class TeacherRepository extends GenericRepository<Teacher> implements Abstractions.DataAccess.Repositories.TeacherRepository {
    public TeacherRepository(Storage storage) {
        super (storage, "Courses");
    }

    @Override
    public Optional<Teacher> getByCourseId(UUID courseId) {
        return collection.stream().filter(teacher -> teacher.getCourse ().getId ().equals (courseId) ).findFirst ();
    }
}

package DataAccess.Repositories;

import Abstractions.DataAccess.Repositories.GenericRepository;
import Abstractions.DataAccess.Storage.Storage;
import Entities.Course;

public class CourseRepository extends GenericRepository<Course> implements Abstractions.DataAccess.Repositories.CourseRepository {
    public CourseRepository(Storage storage) {
        super (storage, "Courses");
    }
}

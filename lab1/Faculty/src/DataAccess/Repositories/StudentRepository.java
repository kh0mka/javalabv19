package DataAccess.Repositories;

import Abstractions.DataAccess.Repositories.GenericRepository;
import Abstractions.DataAccess.Storage.Storage;
import Entities.Student;

import java.util.List;

public class StudentRepository extends GenericRepository<Student> implements Abstractions.DataAccess.Repositories.StudentRepository {
    public StudentRepository(Storage storage) {
        super (storage, "Courses");
    }

    public List<Student> getStudentsWithCourses() {
        return collection.stream().filter(student -> !student.getCourses ().isEmpty ()).toList();
    }
}

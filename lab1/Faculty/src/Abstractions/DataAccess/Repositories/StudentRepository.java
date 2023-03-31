package Abstractions.DataAccess.Repositories;

import Entities.Student;

import java.util.List;

public interface StudentRepository extends IGenericRepository<Student> {
    List<Student> getStudentsWithCourses();
}

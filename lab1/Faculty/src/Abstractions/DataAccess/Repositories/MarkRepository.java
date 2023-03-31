package Abstractions.DataAccess.Repositories;

import Entities.Mark;

import java.util.List;
import java.util.UUID;

public interface MarkRepository extends IGenericRepository<Mark> {
    List<Mark> getByStudentId(UUID studentId);
    List<Integer> getStudentMarksForCourse(UUID studentId, UUID courseId);
}

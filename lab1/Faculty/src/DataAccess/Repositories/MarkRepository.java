package DataAccess.Repositories;

import Abstractions.DataAccess.Repositories.GenericRepository;
import Abstractions.DataAccess.Storage.Storage;
import Entities.Mark;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MarkRepository extends GenericRepository<Mark> implements Abstractions.DataAccess.Repositories.MarkRepository {
    public MarkRepository(Storage storage) {
        super (storage, "Courses");
    }
    public List<Mark> getByStudentId(UUID studentId) {
        return collection.stream().filter(mark -> mark.getStudentId().equals (studentId)).toList();
    }
    public List<Integer> getStudentMarksForCourse(UUID studentId, UUID courseId) {
        return collection.stream().filter(mark -> mark.getStudentId().equals (studentId) && mark.getCourseId().equals (courseId) )
                .map(x->x.getMark()).collect(Collectors.toList());
    }
}

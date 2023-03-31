package Entities;

import Abstractions.Entities.BaseEntity;

import java.util.UUID;

public class Mark extends BaseEntity {
    private UUID studentId;
    private UUID courseId;
    private UUID teacherId;
    private int mark;

    public Mark(int mark, UUID teacherId, UUID studentId, UUID courseId){
        super();

        this.mark = mark;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.courseId = courseId;
    }

    public UUID getStudentId()
    {
        return studentId;
    }

    public UUID getTeacherId()
    {
        return teacherId;
    }

    public UUID getCourseId()
    {
        return courseId;
    }

    public int getMark()
    {
        return mark;
    }

    @Override
    public String toString() {
        return "Mark " + getId ();
    }
}

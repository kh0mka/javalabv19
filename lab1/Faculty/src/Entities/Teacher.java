package Entities;

import Abstractions.Entities.BaseEntity;

public class Teacher extends BaseEntity {
    private String name;
    private Course course;

    public Teacher(String name, Course course)
    {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }
    public Course getCourse() { return course;  }

    @Override
    public String toString() {
        return "Teacher " + getId ();
    }
}

package Entities;

import Abstractions.Entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class Student extends BaseEntity {
    private String name;
    private List<Course> courses = new ArrayList<> ();

    public Student(String name)
    {
        super();
        this.name = name;
    }
    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add (course);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student " + getId ();
    }
}

package Entities;

import Abstractions.Entities.BaseEntity;

import java.util.List;
import java.util.UUID;

public class Course extends BaseEntity {
    private String name;

    public Course(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course " + getId ();
    }
}

package DataAccess.Initialization;

import Abstractions.DataAccess.Repositories.CourseRepository;
import Abstractions.DataAccess.Repositories.StudentRepository;
import Abstractions.DataAccess.Repositories.TeacherRepository;
import Abstractions.DataAccess.Storage.Storage;
import Entities.Course;
import Entities.Student;
import Entities.Teacher;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {
    private final CourseRepository coursesRepository;
    private final TeacherRepository teachersRepository;
    private final StudentRepository studentsRepository;

    private final Storage fileStorage;

    public DataInitializer(
            CourseRepository coursesRepository,
            TeacherRepository teachersRepository,
            StudentRepository studentsRepository,
            Storage fileStorage) {
        this.coursesRepository = coursesRepository;
        this.teachersRepository = teachersRepository;
        this.studentsRepository = studentsRepository;
        this.fileStorage = fileStorage;
    }

    private final List<Student> students = new ArrayList () {{
        add(new Student ("Kirill"));
        add(new Student ("Daniil"));
        add(new Student ("Stanislav"));
        add(new Student ("Maxim"));
        add(new Student ("Mateush"));
    }};

    private final List<Course> courses = new ArrayList () {{
        add(new Course("Microcontrollers"));
        add(new Course("Programming"));
        add(new Course("Networking"));
    }};

    private final List<Teacher> teachers = new ArrayList () {{
        add(new Teacher ("Rolich", courses.get(0)));
        add(new Teacher ("Grib", courses.get(1)));
        add(new Teacher ("Feschenko", courses.get(2)));
    }};

    public void SeedData()
    {
        fileStorage.createCollectionFiles (new String[]{"Courses", "Teachers", "Students", "Marks"});

        courses.forEach (course -> {
            coursesRepository.insert (course);
        });

        teachers.forEach (teacher -> {
            teachersRepository.insert (teacher);
        });

        students.forEach (student -> {
            studentsRepository.insert (student);
        });
    }
}


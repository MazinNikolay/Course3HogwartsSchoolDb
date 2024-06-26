package pro.sky.myHomeworks.Course3HogwartsScoolDb.service.interfaces;

import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Faculty;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Student;

import java.util.Collection;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);

    Faculty getFaculty(Long id);

    Faculty updateFaculty(Faculty faculty);

    void deleteFaculty(Long id);

    Collection<Faculty> findByColorOrName(String color, String name);

    Collection<Student> findByFaculty(String name);
}

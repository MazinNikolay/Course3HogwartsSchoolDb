package pro.sky.myHomeworks.Course3HogwartsScoolDb.service.interfaces;

import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);

    Faculty getFaculty(Long id);

    Faculty updateFaculty(Faculty faculty);

    Faculty deleteFaculty(Long id);

    List<Faculty> sortByColor(String color);
}

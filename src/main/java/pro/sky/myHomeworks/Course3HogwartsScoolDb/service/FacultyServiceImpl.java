package pro.sky.myHomeworks.Course3HogwartsScoolDb.service;

import org.springframework.stereotype.Service;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.exceptioms.NotFoundEntityException;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Faculty;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.service.interfaces.FacultyService;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.lowerCase;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final HashMap<Long, Faculty> faculties;
    private static Long counter;

    public FacultyServiceImpl() {
        faculties = new HashMap<>();
        counter = 0L;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        faculties.put(++counter, faculty);
        return faculty;
    }

    @Override
    public Faculty getFaculty(Long id) {
        if (!faculties.containsKey(id)) {
            throw new NotFoundEntityException();
        }
        return faculties.get(id);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        if (!faculties.containsKey(faculty.getId())) {
            throw new NotFoundEntityException();
        }
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    @Override
    public Faculty deleteFaculty(Long id) {
        if (!faculties.containsKey(id)) {
            throw new NotFoundEntityException();
        }
        return faculties.remove(id);
    }

    @Override
    public List<Faculty> sortByColor(String color) {
        String formattedColor = capitalize(lowerCase(color));
        return faculties.values().stream()
                .filter(e -> e.getColor().equals(formattedColor))
                .collect(Collectors.toList());
    }
}


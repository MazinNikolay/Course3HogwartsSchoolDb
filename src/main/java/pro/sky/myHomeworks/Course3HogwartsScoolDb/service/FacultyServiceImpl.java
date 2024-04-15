package pro.sky.myHomeworks.Course3HogwartsScoolDb.service;

import org.springframework.stereotype.Service;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.exceptioms.NotFoundEntityException;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Faculty;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.repository.FacultyRepository;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.service.interfaces.FacultyService;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.lowerCase;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository repository;

    public FacultyServiceImpl(FacultyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return repository.save(faculty);
    }

    @Override
    public Faculty getFaculty(Long id) {
        isEntityExist(id);
        return repository.findById(id).get();
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        isEntityExist(faculty.getId());
        return repository.save(faculty);
    }

    @Override
    public void deleteFaculty(Long id) {
        isEntityExist(id);
        repository.deleteById(id);
    }

    @Override
    public List<Faculty> sortByColor(String color) {
        repository.findAll().stream()
                .forEach(f -> f.setColor(capitalize(lowerCase(f.getColor()))));
        String formattedColor = capitalize(lowerCase(color));
        return repository.findAll().stream()
                .filter(e -> e.getColor().equals(formattedColor))
                .collect(Collectors.toList());
    }

    private void isEntityExist(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundEntityException());
    }
}


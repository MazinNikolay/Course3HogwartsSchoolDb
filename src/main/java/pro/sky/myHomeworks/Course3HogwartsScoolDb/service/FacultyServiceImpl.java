package pro.sky.myHomeworks.Course3HogwartsScoolDb.service;

import org.springframework.stereotype.Service;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.exceptioms.NotFoundEntityException;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Faculty;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Student;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.repository.FacultyRepository;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.service.interfaces.FacultyService;

import java.util.Collection;

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
    public Collection<Faculty> findByColorOrName(String color, String name) {
        return repository.findByColorContainsIgnoreCaseOrNameContainsIgnoreCase(color, name);
    }

    @Override
    public Collection<Student> findByFaculty(String name) {
        return repository.findByNameContainsIgnoreCase(name).getStudents();
    }

    private void isEntityExist(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundEntityException());
    }
}


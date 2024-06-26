package pro.sky.myHomeworks.Course3HogwartsScoolDb.service;

import org.springframework.stereotype.Service;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.exceptioms.NotFoundEntityException;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Faculty;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Student;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.repository.StudentRepository;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.service.interfaces.StudentService;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        isEntityExist(id);
        return repository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        isEntityExist(student.getId());
        return repository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        isEntityExist(id);
        repository.deleteById(id);
    }

    @Override
    public Collection<Student> findByAgeBetween(int val1, int val2) {
        return repository.findByAgeBetween(val1, val2);
    }

    @Override
    public Faculty getStudentFaculty(String student) {
        return repository.findByNameContainsIgnoreCase(student).getFaculty();
    }

    private void isEntityExist(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundEntityException());
    }
}

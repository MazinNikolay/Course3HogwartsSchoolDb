package pro.sky.myHomeworks.Course3HogwartsScoolDb.service;

import org.springframework.stereotype.Service;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.exceptioms.NotFoundEntityException;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Student;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.repository.StudentRepository;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.service.interfaces.StudentService;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Student> sortByAge(int age) {
        return repository.findAll().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }

    private void isEntityExist(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundEntityException());
    }
}

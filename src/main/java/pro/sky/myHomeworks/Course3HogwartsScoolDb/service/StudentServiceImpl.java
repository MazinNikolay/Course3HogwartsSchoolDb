package pro.sky.myHomeworks.Course3HogwartsScoolDb.service;

import org.springframework.stereotype.Service;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.exceptioms.NotFoundEntityException;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Student;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.service.interfaces.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final HashMap<Long, Student> students;
    private static Long counter;

    public StudentServiceImpl() {
        students = new HashMap<>();
        counter = 0L;
    }

    @Override
    public Student createStudent(Student student) {
        students.put(++counter, student);
        return student;
    }

    @Override
    public Student getStudent(Long id) {
        if (!students.containsKey(id)) {
            throw new NotFoundEntityException();
        }
        return students.get(id);
    }

    @Override
    public Student updateStudent(Student student) {
        if (!students.containsKey(student.getId())) {
            throw new NotFoundEntityException();
        }
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public Student deleteStudent(Long id) {
        if (!students.containsKey(id)) {
            throw new NotFoundEntityException();
        }
        return students.remove(id);
    }

    @Override
    public List<Student> sortByAge(int age) {
        return students.values().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }
}

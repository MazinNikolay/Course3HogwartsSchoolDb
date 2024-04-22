package pro.sky.myHomeworks.Course3HogwartsScoolDb.service.interfaces;

import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Faculty;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Student;

import java.util.Collection;

public interface StudentService {
    Student createStudent(Student student);

    Student getStudent(Long id);

    Student updateStudent(Student student);

    void deleteStudent(Long id);

    Collection<Student> findByAgeBetween(int val1, int val2);

    Faculty getStudentFaculty(String student);
}

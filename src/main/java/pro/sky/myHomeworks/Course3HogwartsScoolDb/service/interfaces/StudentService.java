package pro.sky.myHomeworks.Course3HogwartsScoolDb.service.interfaces;

import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    Student getStudent(Long id);

    Student updateStudent(Student student);

    Student deleteStudent(Long id);

    List<Student> sortByAge(int age);
}

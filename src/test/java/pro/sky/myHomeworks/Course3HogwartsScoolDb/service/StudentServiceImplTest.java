package pro.sky.myHomeworks.Course3HogwartsScoolDb.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentServiceImplTest {

    private StudentServiceImpl out;

    @BeforeEach
    void initial() {
        out = new StudentServiceImpl();
        Student student = new Student(1L, "Tolik", 14);
        out.createStudent(student);
    }

    @Test
    void createStudent() {
        Student expected = new Student(1L, "Oleg", 14);
        Student actual = out.createStudent(expected);
        assertEquals(expected, actual);
    }

    @Test
    void getStudent() {
        Student expected = new Student(1L, "Tolik", 14);
        Student actual = out.getStudent(1L);
        assertEquals(expected, actual);
    }

    @Test
    void updateStudent() {
        Student expected = new Student(1L, "Oleg", 14);
        Student actual = out.updateStudent(expected);
        assertEquals(expected, actual);
    }

    @Test
    void deleteStudent() {
        Student expected = new Student(1L, "Tolik", 14);
        Student actual = out.deleteStudent(1L);
        assertEquals(expected, actual);
    }

    @Test
    void sortByAge() {
        Student student1 = new Student(1L, "Tolik", 14);
        Student student2 = new Student(1L, "Oleg", 14);
        Student student3 = new Student(1L, "Stepan", 15);
        List<Student> expected = new ArrayList<>(List.of(student1, student2));
        out.createStudent(student2);
        out.createStudent(student3);
        List<Student> actual = out.sortByAge(14);
        assertEquals(expected, actual);
    }
}
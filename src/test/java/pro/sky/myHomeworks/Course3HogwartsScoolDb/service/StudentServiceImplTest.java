package pro.sky.myHomeworks.Course3HogwartsScoolDb.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Student;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
    private StudentServiceImpl out;

    @Mock
    private StudentRepository repository;

    @BeforeEach
    void initial() {
        out = new StudentServiceImpl(repository);
        Student student = new Student(1L, "Tolik", 14);
        out.createStudent(student);
    }

    @Test
    void createStudent() {
        Student expected = new Student(1L, "Oleg", 14);
        when(repository.save(any())).thenReturn(expected);
        Student actual = out.createStudent(expected);
        assertEquals(expected, actual);
    }

    @Test
    void getStudent() {
        Student expected = new Student(1L, "Tolik", 14);
        when(repository.findById(any())).thenReturn(Optional.of(expected));
        Student actual = out.getStudent(1L);
        assertEquals(expected, actual);
    }

    @Test
    void updateStudent() {
        Student expected = new Student(1L, "Oleg", 14);
        when(repository.findById(any())).thenReturn(Optional.of(expected));
        when(repository.save(any())).thenReturn(expected);
        Student actual = out.updateStudent(expected);
        assertEquals(expected, actual);
    }

    @Test
    void deleteStudent() {
        Student expected = new Student(1L, "Tolik", 14);
        when(repository.findById(any())).thenReturn(Optional.of(expected));
        out.deleteStudent(1L);
        verify(repository).deleteById(any());
    }

    @Test
    void sortByAge() {
        Student student1 = new Student(1L, "Tolik", 14);
        Student student2 = new Student(1L, "Oleg", 14);
        Student student3 = new Student(1L, "Stepan", 15);
        List<Student> expected = new ArrayList<>(List.of(student1, student2));
        when(repository.findAll()).thenReturn(expected);
        List<Student> actual = out.sortByAge(14);
        assertEquals(expected, actual);
    }
}
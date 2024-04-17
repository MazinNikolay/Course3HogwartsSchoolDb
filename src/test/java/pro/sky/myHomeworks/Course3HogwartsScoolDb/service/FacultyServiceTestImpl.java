package pro.sky.myHomeworks.Course3HogwartsScoolDb.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Faculty;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FacultyServiceTestImpl {
    private FacultyServiceImpl out;

    @Mock
    private FacultyRepository repository;

    @BeforeEach
    void initial() {
        out = new FacultyServiceImpl(repository);
        Faculty faculty = new Faculty(1L, "Griffindor", "yellow");
        out.createFaculty(faculty);
    }

    @Test
    void createfaculty() {
        Faculty expected = new Faculty(1L, "Griffindor", "yellow");
        when(repository.save(any())).thenReturn(expected);
        Faculty actual = out.createFaculty(expected);
        assertEquals(expected, actual);
    }

    @Test
    void getfaculty() {
        Faculty expected = new Faculty(1L, "Griffindor", "yellow");
        when(repository.findById(any())).thenReturn(Optional.of(expected));
        Faculty actual = out.getFaculty(1L);
        assertEquals(expected, actual);
    }

    @Test
    void updatefaculty() {
        Faculty expected = new Faculty(1L, "Griffindor", "yellow");
        when(repository.findById(any())).thenReturn(Optional.of(expected));
        when(repository.save(any())).thenReturn(expected);
        Faculty actual = out.updateFaculty(expected);
        assertEquals(expected, actual);
    }

    @Test
    void deletefaculty() {
        Faculty expected = new Faculty(1L, "Griffindor", "yellow");
        when(repository.findById(any())).thenReturn(Optional.of(expected));
        out.deleteFaculty(1L);
        verify(repository).deleteById(any());
    }

    @Test
    void sortByAge() {
        Faculty faculty1 = new Faculty(1L, "Griffindor", "yellow");
        Faculty faculty2 = new Faculty(1L, "Slitherin", "yellow");
        Faculty faculty3 = new Faculty(1L, "Puffenduy", "Green");
        List<Faculty> expected = new ArrayList<>(List.of(faculty1, faculty2));
        when(repository.findAll()).thenReturn(expected);
        List<Faculty> actual = out.sortByColor("yellow");
        assertEquals(expected, actual);
    }
}
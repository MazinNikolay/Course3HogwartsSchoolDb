package pro.sky.myHomeworks.Course3HogwartsScoolDb.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Faculty;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacultyServiceTestImpl {

    private FacultyServiceImpl out;

    @BeforeEach
    void initial() {
        out = new FacultyServiceImpl();
        Faculty faculty = new Faculty(1L, "Griffindor", "yellow");
        out.createFaculty(faculty);
    }

    @Test
    void createfaculty() {
        Faculty expected = new Faculty(1L, "Griffindor", "yellow");
        Faculty actual = out.createFaculty(expected);
        assertEquals(expected, actual);
    }

    @Test
    void getfaculty() {
        Faculty expected = new Faculty(1L, "Griffindor", "yellow");
        Faculty actual = out.getFaculty(1L);
        assertEquals(expected, actual);
    }

    @Test
    void updatefaculty() {
        Faculty expected = new Faculty(1L, "Griffindor", "yellow");
        Faculty actual = out.updateFaculty(expected);
        assertEquals(expected, actual);
    }

    @Test
    void deletefaculty() {
        Faculty expected = new Faculty(1L, "Griffindor", "yellow");
        Faculty actual = out.deleteFaculty(1L);
        assertEquals(expected, actual);
    }

    @Test
    void sortByAge() {
        Faculty faculty1 = new Faculty(1L, "Griffindor", "yellow");
        Faculty faculty2 = new Faculty(1L, "Slitherin", "yellow");
        Faculty faculty3 = new Faculty(1L, "Puffenduy", "Green");
        List<Faculty> expected = new ArrayList<>(List.of(faculty1, faculty2));
        out.createFaculty(faculty2);
        out.createFaculty(faculty3);
        List<Faculty> actual = out.sortByColor("yellow");
        assertEquals(expected, actual);
    }
}
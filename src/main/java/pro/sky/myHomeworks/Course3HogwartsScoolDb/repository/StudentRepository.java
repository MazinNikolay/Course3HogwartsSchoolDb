package pro.sky.myHomeworks.Course3HogwartsScoolDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(int val1, int val2);

    Student findByNameContainsIgnoreCase(String name);
}

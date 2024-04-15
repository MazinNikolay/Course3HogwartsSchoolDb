package pro.sky.myHomeworks.Course3HogwartsScoolDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

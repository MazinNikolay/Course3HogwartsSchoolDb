package pro.sky.myHomeworks.Course3HogwartsScoolDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}

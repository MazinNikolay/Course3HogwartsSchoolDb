package pro.sky.myHomeworks.Course3HogwartsScoolDb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Student;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.service.interfaces.StudentService;

import java.util.List;

@RestController
@RequestMapping("student")
@Tag(name = "API для работы со студентами")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Создание студента")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @GetMapping("{id}")
    @Operation(summary = "Получение студента")
    public Student getStudent(@PathVariable Long id) {
        return service.getStudent(id);
    }

    @PutMapping
    @Operation(summary = "Обновление студента")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удаление студента")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok().body("Успешно удален");
    }

    @GetMapping("/sortedByAge/{age}")
    @Operation(summary = "Получение студентов по возрасту")
    public List<Student> sortedByAge(@PathVariable int age) {
        return service.sortByAge(age);
    }
}

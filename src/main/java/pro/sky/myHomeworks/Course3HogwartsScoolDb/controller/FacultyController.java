package pro.sky.myHomeworks.Course3HogwartsScoolDb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.model.Faculty;
import pro.sky.myHomeworks.Course3HogwartsScoolDb.service.interfaces.FacultyService;

import java.util.List;

@RestController
@RequestMapping("faculty")
@Tag(name = "API для работы с факультетами")
public class FacultyController {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Создание факультета")
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return service.createFaculty(faculty);
    }

    @GetMapping("{id}")
    @Operation(summary = "Получение факультета")
    public Faculty getFaculty(@PathVariable Long id) {
        return service.getFaculty(id);
    }

    @PutMapping
    @Operation(summary = "Обновление факультета")
    public Faculty updatefaculty(@RequestBody Faculty faculty) {
        return service.updateFaculty(faculty);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удаление факультета")
    public Faculty deletefaculty(@PathVariable Long id) {
        return service.deleteFaculty(id);
    }

    @GetMapping("/sortedByColor/{color}")
    @Operation(summary = "Получение факультетов по цвету")
    public List<Faculty> sortedByColor(@PathVariable String color) {
        return service.sortByColor(color);
    }
}

package com.test.Student.contoller;

import com.test.Student.entity.Student;
import com.test.Student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }
}

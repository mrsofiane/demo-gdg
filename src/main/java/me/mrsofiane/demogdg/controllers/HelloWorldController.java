package me.mrsofiane.demogdg.controllers;

import me.mrsofiane.demogdg.entities.Student;
import me.mrsofiane.demogdg.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    private final StudentService studentService;

    public HelloWorldController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET POST PUT PATCH DELETE

    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/students/{id}")
    public void updateStudentById(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudentById(id, student);
    }

    @GetMapping("/students/{email}")
    public Student getStudentByEmail(@PathVariable String email) {

        return studentService.getStudentByEmail(email);

    }

    @GetMapping("/students/byemail")
    public Student getStudentByEmailQuery(@RequestParam String email) {
        return studentService.getStudentByEmail(email);

    }


}

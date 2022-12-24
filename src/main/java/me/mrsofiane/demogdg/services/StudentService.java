package me.mrsofiane.demogdg.services;

import me.mrsofiane.demogdg.entities.Student;
import me.mrsofiane.demogdg.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {

        studentRepository.deleteById(id);
    }


    public void updateStudentById(Long id, Student student) {

        Student currentStudent = studentRepository.findById(id).orElseThrow();

        currentStudent.setFirstName(student.getFirstName());
        currentStudent.setLastName(student.getLastName());
        currentStudent.setEmail(student.getEmail());

        studentRepository.save(currentStudent);


    }

    public Student getStudentByEmail(String email) {

        return studentRepository.jpaGetEmail(email).orElseThrow();
    }
}

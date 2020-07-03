package ru.excome.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.excome.university.domain.Student;
import ru.excome.university.repository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService{
    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Optional<Student> loadStudent(Long studentId) {
        return studentRepo.findById(studentId);
    }

    public List<Student> loadDataTable() {
        return studentRepo.findAll();
    }

    public void addStudent(String firstname, String surname, String patronymic, Integer age){
        Student student = new Student(firstname, surname, patronymic, age);
        studentRepo.save(student);
    }

    public void deleteStudent(Long studentId) {
        try {
            studentRepo.deleteById(studentId);
        }
        catch (Exception ex) {}
    }
}

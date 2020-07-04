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

    public Student loadStudent(Long studentId) {
        return studentRepo.findStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAllStudents();
    }

    public void addStudent(String firstname, String surname, String patronymic, Integer age){
        try {
            Student student = new Student(firstname, surname, patronymic, age);
            studentRepo.save(student);
        }
        catch (Exception ex) {}
    }

    public void deleteStudent(Long studentId) {
        try {
            studentRepo.deleteById(studentId);
        }
        catch (Exception ex) {}
    }

    public void updateStudent(String surname, String firstname, String patronymic, Integer age, Long studentId) {

            studentRepo.updateById(surname, firstname, patronymic, age, studentId);

    }
}

package ru.excome.university.service;

import org.springframework.stereotype.Service;
import ru.excome.university.domain.GroupStud;
import ru.excome.university.domain.Student;
import ru.excome.university.repository.StudentRepo;

import java.util.List;

@Service
public class StudentService{
    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student loadStudent(Long studentId) {
        return studentRepo.findStudentById(studentId);
    }

    public Student getStudentById(Long sutdentId){
        return studentRepo.findStudentById(sutdentId);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAllStudents();
    }

    public void addStudent(String firstname, String surname, String patronymic, Integer age, GroupStud groupStud){
        try {
            Student student = new Student(firstname, surname, patronymic, age, groupStud);
            studentRepo.save(student);
        }catch (Exception ex){}
    }

    public void deleteStudent(Long studentId) {
        try {
            studentRepo.deleteById(studentId);
        }
        catch (Exception ex) {}
    }

    public void updateStudent(String surname, String firstname, String patronymic, Integer age, GroupStud groupStud, Long studentId) {

        studentRepo.updateById(surname, firstname, patronymic, age, groupStud, studentId);

    }
}

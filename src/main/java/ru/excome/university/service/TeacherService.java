package ru.excome.university.service;

import org.springframework.stereotype.Service;
import ru.excome.university.domain.Teacher;
import ru.excome.university.repository.TeacherRepo;

import java.util.List;

@Service
public class TeacherService {
    private TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    public Teacher getTeacherById(Long teacherId) {
            return teacherRepo.findTeacherById(teacherId);
    }

    public void addTeacher(String surname, String firstname, String patronymic, Integer age, String degree){
        try {
            Teacher teacher = new Teacher(surname, firstname, patronymic, age, degree);
            teacherRepo.save(teacher);
        }catch (Exception ex){}
    }

    public void updateTeacherById(String surname, String firstname, String patronymic, Integer age, String degree, Long teacherId){
        try{
            teacherRepo.updateTeacherById(surname, firstname, patronymic, age, degree, teacherId);
        }catch (Exception ex) {}
    }

    public void deleteTeacherByID(Long teacherId) {
        try{
            teacherRepo.deleteById(teacherId);
        }catch (Exception ex) {}
    }
}

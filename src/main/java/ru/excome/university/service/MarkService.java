package ru.excome.university.service;

import org.springframework.stereotype.Service;
import ru.excome.university.domain.Mark;
import ru.excome.university.domain.Student;
import ru.excome.university.domain.Subject;
import ru.excome.university.domain.Teacher;
import ru.excome.university.repository.MarkRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class MarkService {
    private MarkRepo markRepo;
    private StudentService studentService;
    private TeacherService teacherService;
    private SubjectService subjectService;

    public MarkService(MarkRepo markRepo, StudentService studentService, TeacherService teacherService, SubjectService subjectService) {
        this.markRepo = markRepo;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.subjectService = subjectService;
    }

    public List<Mark> getMarksWithSearch(String search){
        return markRepo.findAllBySearch(search);
    }

    public Mark getMarkById(Long markId){
        return markRepo.findMarkById(markId);
    }

    public List<Mark> getAllMarks(){
        return markRepo.findAll();
    }

    public List<Student> getStudents() { return studentService.getAllStudents(); }

    public List<Subject> getSubjects() {
        return subjectService.getAllSubjects();
    }

    public List<Teacher> getTeachers() {
        return teacherService.getAllTeachers();
    }

    public void addMark(Long studentId, Long subjectId, Integer mark, Long teacherId, String work, String date) throws ParseException {
        date = date.substring(8,10) + "/" + date.substring(5,7) + "/" + date.substring(0,4);
        markRepo.save(new Mark(
          studentService.getStudentById(studentId),
          subjectService.getSubjectById(subjectId),
          mark,
          teacherService.getTeacherById(teacherId),
          work,
          new SimpleDateFormat("dd/MM/yyyy").parse(date)
        ));
    }


    public void updateMark(Long studentId, Long subjectId, Integer mark, Long teacherId, String work, String date, Long markId) throws ParseException {
        date = date.substring(8,10) + "/" + date.substring(5,7) + "/" + date.substring(0,4);
        markRepo.updateMarkById(
                studentService.getStudentById(studentId),
                subjectService.getSubjectById(subjectId),
                mark,
                teacherService.getTeacherById(teacherId),
                work,
                new SimpleDateFormat("dd/MM/yyyy").parse(date),
                markId
        );
    }

    public void deleteMarkById(Long markid){
        markRepo.findMarkById(markid);
    }
}

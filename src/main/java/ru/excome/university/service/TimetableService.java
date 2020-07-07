package ru.excome.university.service;

import org.springframework.stereotype.Service;
import ru.excome.university.domain.GroupStud;
import ru.excome.university.domain.Subject;
import ru.excome.university.domain.Teacher;
import ru.excome.university.domain.Timetable;
import ru.excome.university.repository.TimetableRepo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TimetableService {
    private TimetableRepo timetableRepo;
    private GroupStudService groupStudService;
    private SubjectService subjectService;
    private TeacherService teacherService;

    public TimetableService(TimetableRepo timetableRepo, GroupStudService groupStudService, SubjectService subjectService, TeacherService teacherService) {
        this.timetableRepo = timetableRepo;
        this.groupStudService = groupStudService;
        this.subjectService = subjectService;
        this.teacherService = teacherService;
    }

    public List<Subject> getSubjects() {
        return subjectService.getAllSubjects();
    }

    public List<Teacher> getTeachers() {
        return teacherService.getAllTeachers();
    }

    public List<GroupStud> getGroups(){
        return groupStudService.getAllGroups();
    }

    public List<Timetable> getAllTimetable(){
        return timetableRepo.findAll();
    }

    public void addTimetable( Long subjectId, Long teacherId, Long groupId, String room, String datetime) throws ParseException {
 //       try{
            datetime = datetime.substring(8,10) + "/" + datetime.substring(5,7) + "/" + datetime.substring(0,4) + " " + datetime.substring(11);
            Timetable timetable = new Timetable(
                    subjectService.getSubjectById(subjectId),
                    teacherService.getTeacherById(teacherId),
                    groupStudService.getGroupById(groupId),
                    room,
                    new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(datetime)
            );
            timetableRepo.save(timetable);
 //       }catch (Exception ex) {}
    }
}

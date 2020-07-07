package ru.excome.university.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private  GroupStud groupStud;

    private String room;

    @DateTimeFormat(pattern = "dd/mm/yyyy hh:mm")
    private Date datetime;

    public Timetable() {
    }

    public Timetable(Subject subject, Teacher teacher, GroupStud groupStud, String room, Date datetime) {
        this.teacher = teacher;
        this.subject = subject;
        this.groupStud = groupStud;
        this.room = room;
        this.datetime = datetime;
    }

    public String getTeacherName(){
        return teacher.getSurname() + " " + teacher.getFirstname().substring(0, 1) + ". " + teacher.getPatronymic().substring(0,1) + ".";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public GroupStud getGroupStud() {
        return groupStud;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setGroupStud(GroupStud groupStud) {
        this.groupStud = groupStud;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}

package ru.excome.university.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Subject subject;

    private Integer mark;

    @ManyToOne
    private Teacher teacher;

    private String work;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date date;

    public Mark() {
    }

    public String getStudentName(){
        return student.getSurname() + " " + student.getFirstname().substring(0,1) + ". " + student.getPatronymic().substring(0,1) + ".";
    }

    public String getTeacherName(){
        return teacher.getSurname() + " " + teacher.getFirstname().substring(0, 1) + ". " + teacher.getPatronymic().substring(0,1) + ".";
    }

    public Mark(Student student, Subject subject, Integer mark, Teacher teacher, String work, Date datetime) {
        this.student = student;
        this.subject = subject;
        this.mark = mark;
        this.teacher = teacher;
        this.work = work;
        this.date = datetime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date datetime) {
        this.date = datetime;
    }
}

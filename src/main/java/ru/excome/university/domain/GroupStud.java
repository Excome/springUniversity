package ru.excome.university.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class GroupStud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String faculty;
    private String direction;
    private String name;


    public GroupStud() {
    }

    public GroupStud(String faculty, String direction, String name) {
        this.faculty = faculty;
        this.direction = direction;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}

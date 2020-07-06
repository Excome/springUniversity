package ru.excome.university.domain;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;
    private String surname;
    private String patronymic;
    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    private GroupStud groupStud;

    public Student() {}
    public Student(String firstname, String surname, String patronymic, Integer age, GroupStud groupStud) {
        this.firstname = firstname;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.groupStud = groupStud;
    }

    public String getGroupName(){
        return groupStud != null ? groupStud.getName() : "<none>";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}

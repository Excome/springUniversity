package ru.excome.university.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Security
    private String username;
    private String email;
    private String password;
    private boolean active;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "teacher_role", joinColumns = @JoinColumn(name = "teacher_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


    private String surname;
    private String firstname;
    private String patronymic;
    private Integer age;
    private String degree;



    public Teacher() {
    }
    public Teacher(String surname, String firstname, String patronymic, Integer age, String degree) {
        this.surname = surname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.age = age;
        this.degree = degree;
    }


    public Teacher(String username, String email, String password, String surname, String firstname, String patronymic, Integer age, String degree) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.surname = surname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.age = age;
        this.degree = degree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

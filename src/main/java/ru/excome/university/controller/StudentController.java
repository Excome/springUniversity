package ru.excome.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.excome.university.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String student(){
        return "student";
    }

    @PostMapping
    public String addStudent(
            @RequestParam String firstname,
            @RequestParam String surname,
            @RequestParam String patronymic,
            @RequestParam Integer age
    ) {
       studentService.addStudent(firstname, surname, patronymic, age);

        return "student";
    }
}

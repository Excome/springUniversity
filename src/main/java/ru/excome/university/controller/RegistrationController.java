package ru.excome.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.excome.university.domain.Role;
import ru.excome.university.domain.Teacher;
import ru.excome.university.repository.TeacherRepo;
import ru.excome.university.service.TeacherService;

import java.util.Collections;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private TeacherService teacherService;

    public RegistrationController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public String registration(){

        return "registration";
    }

    @PostMapping
    public String addTeacher(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String surname,
            @RequestParam String firstname,
            @RequestParam String patronymic,
            @RequestParam Integer age,
            @RequestParam String degree,
            Model model
    ){
        Teacher teacherFromDb = teacherService.getTeacherByUsername(username);
        if(teacherFromDb != null) {
       //     model.addAttribute("message", "Данный пользователь уже зарегистрирован!");
            return "registration";
        }
        teacherService.addTeacher(username, email, password, surname, firstname, patronymic, age, degree);

        return "redirect:/login";
    }
}

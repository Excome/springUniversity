package ru.excome.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.excome.university.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public String teacher(Model model) {
        model.addAttribute("teachers", teacherService.getAllTeachers());

        return "teacher";
    }

    @GetMapping("{teacher}")
    public String teacherEdit(@PathVariable Long teacher, Model model) {
        model.addAttribute("teacher", teacherService.getTeacherById(teacher));

        return "teacherEdit";
    }

    @PostMapping
    public String addTeacher(
            @RequestParam String surname,
            @RequestParam String firstname,
            @RequestParam String patronymic,
            @RequestParam Integer age,
            @RequestParam String degree
    ){
        teacherService.addTeacher(surname, firstname, patronymic, age, degree);

        return "redirect:/teacher";
    }

    @PostMapping("update")
    public String updateTeacher(
            @RequestParam String surname,
            @RequestParam String firstname,
            @RequestParam String patronymic,
            @RequestParam Integer age,
            @RequestParam String degree,
            @RequestParam Long teacherID

    ){
        teacherService.updateTeacherById(surname, firstname, patronymic, age, degree, teacherID);

        return "redirect:/teacher";
    }

    @PostMapping("delete")
    public String deleteTeaacher(@RequestParam Long teacherId){
        teacherService.deleteTeacherByID(teacherId);

        return "redirect:/teacher";
    }


}

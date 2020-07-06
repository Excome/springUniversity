package ru.excome.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.excome.university.domain.GroupStud;
import ru.excome.university.service.GroupStudService;
import ru.excome.university.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    private GroupStudService groupStudService;

    public StudentController(StudentService studentService, GroupStudService groupStudService) {
        this.studentService = studentService;
        this.groupStudService = groupStudService;
    }

    @GetMapping
    public String student(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("groups", groupStudService.getAllGroups());

        return "student";
    }

    @GetMapping("{student}")
    public String studentEdit(@PathVariable Long student, Model model) {
        model.addAttribute("student", studentService.loadStudent(student));
        model.addAttribute("groups", groupStudService.getAllGroups());

        return "studentEdit";
    }

    @PostMapping
    public String addStudent(
            @RequestParam String firstname,
            @RequestParam String surname,
            @RequestParam String patronymic,
            @RequestParam Integer age,
            @RequestParam Long groupStudId,
            Model model
    ) {
        studentService.addStudent(firstname, surname, patronymic, age, groupStudService.getGroupById(groupStudId));

        return "redirect:/student";
    }

    @PostMapping("delete")
    public String deleteStudent(@RequestParam Long studentId){
        studentService.deleteStudent(studentId);

        return "redirect:/student";
    }

    @PostMapping("update")
    public String updateStudent(@RequestParam String surname,
                                @RequestParam String firstname,
                                @RequestParam String patronymic,
                                @RequestParam Integer age,
                                @RequestParam Long groupStudId,
                                @RequestParam Long studentId) {
        studentService.updateStudent(surname, firstname, patronymic, age, groupStudService.getGroupById(groupStudId), studentId);

        return "redirect:/student";
    }
}

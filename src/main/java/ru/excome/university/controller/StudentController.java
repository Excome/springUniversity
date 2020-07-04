package ru.excome.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.excome.university.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String student(Model model){
        model.addAttribute("students", studentService.getAllStudents());

        return "student";
    }

    @GetMapping("{student}")
    public String studentEdit(@PathVariable Long student, Model model) {
        model.addAttribute("student", studentService.loadStudent(student));

        return "studentEdit";
    }

    @PostMapping
    public String addStudent(
            @RequestParam String firstname,
            @RequestParam String surname,
            @RequestParam String patronymic,
            @RequestParam Integer age,
            Model model
    ) {
        studentService.addStudent(firstname, surname, patronymic, age);
       // model.addAttribute("students", studentService.loadDataTable());

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
                                @RequestParam Long studentId) {
        studentService.updateStudent(surname, firstname, patronymic, age, studentId);

        return "redirect:/student";
    }
}

package ru.excome.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.excome.university.service.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public String subject(Model model){
        model.addAttribute("subjects", subjectService.getAllSubjects());

        return "subject";
    }

    @GetMapping("{subject}")
    public String subjectEdit(@PathVariable Long subject, Model model){
        model.addAttribute("subject", subjectService.getSubjectById(subject));

        return "subjectEdit";
    }

    @PostMapping
    public String addSubject(
            @RequestParam boolean type,
            @RequestParam String name,
            @RequestParam Integer hoursPerWeek
    ){
        subjectService.addSubject(type, name, hoursPerWeek);

        return "redirect:/subject";
    }

    @PostMapping("update")
    public String updateSubject(
            @RequestParam boolean type,
            @RequestParam String name,
            @RequestParam Integer hoursPerWeek,
            @RequestParam Long subjectId
    ){
        subjectService.updateSubjectById(type, name, hoursPerWeek, subjectId);

        return "redirect:/subject";
    }

    @PostMapping("delete")
    public String deleteSubject(@RequestParam Long subjectId){
        subjectService.deleteSubjectByID(subjectId);

        return "redirect:/subject";
    }
}

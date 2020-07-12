package ru.excome.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.excome.university.service.MarkService;

import java.text.ParseException;

@Controller
@RequestMapping("/mark")
public class MarkController {
    private MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping
    public String mark(@RequestParam(required = false, defaultValue = "") String search ,  Model model) {
        if(search != null && !search.isEmpty()){
            model.addAttribute("marks", markService.getMarksWithSearch(search));
        }else{
            model.addAttribute("marks", markService.getAllMarks());
        }
        model.addAttribute("search", search);
        model.addAttribute("students", markService.getStudents());
        model.addAttribute("teachers", markService.getTeachers());
        model.addAttribute("subjects", markService.getSubjects());

        return "mark";
    }

    @GetMapping("{mark}")
    public String markEdit(@PathVariable Long mark, Model model){
        model.addAttribute("mark", markService.getMarkById(mark));
        model.addAttribute("students", markService.getStudents());
        model.addAttribute("teachers", markService.getTeachers());
        model.addAttribute("subjects", markService.getSubjects());
        return "markEdit";
    }

    @PostMapping
    public String addMark(
            @RequestParam Long studentId,
            @RequestParam Long subjectId,
            @RequestParam Integer mark,
            @RequestParam Long teacherId,
            @RequestParam String work,
            @RequestParam String date
    ) throws ParseException {
        markService.addMark(studentId, subjectId, mark, teacherId, work, date);

        return "redirect:/mark";
    }

    @PostMapping("update")
    public String updateMark(
            @RequestParam Long studentId,
            @RequestParam Long subjectId,
            @RequestParam Integer mark,
            @RequestParam Long teacherId,
            @RequestParam String work,
            @RequestParam String date,
            @RequestParam Long markId
    ) throws ParseException {
        markService.updateMark(studentId, subjectId, mark, teacherId, work, date, markId);

        return "redirect:/mark";
    }

    @PostMapping("delete")
    public String deleteMark(@RequestParam Long markId){
        markService.deleteMarkById(markId);

        return "redirect:/mark";
    }
}

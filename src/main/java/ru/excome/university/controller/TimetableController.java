package ru.excome.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.excome.university.service.TimetableService;

import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping("/timetable")
public class TimetableController {
    private TimetableService timetableService;

    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping
    public String timetable(Model model){
        model.addAttribute("timetables", timetableService.getAllTimetable());
        model.addAttribute("subjects", timetableService.getSubjects());
        model.addAttribute("teachers", timetableService.getTeachers());
        model.addAttribute("groups", timetableService.getGroups());

        return "timetable";
    }

    @GetMapping("{timetable}")
    public String timetableEdit(@PathVariable Long timetable, Model model){
        model.addAttribute("timetable", timetableService.getTimetableById(timetable));
        model.addAttribute("subjects", timetableService.getSubjects());
        model.addAttribute("teachers", timetableService.getTeachers());
        model.addAttribute("groups", timetableService.getGroups());
        return "timetableEdit";
    }

    @PostMapping
    public String addTimetable(
        @RequestParam Long subjectId,
        @RequestParam Long teacherId,
        @RequestParam Long groupId,
        @RequestParam String room,
        @RequestParam String datetime
    ) throws ParseException {

        timetableService.addTimetable(subjectId, teacherId, groupId, room, datetime);

        return "redirect:/timetable";
    }

    @PostMapping("update")
    public String updateTimetable(
            @RequestParam Long subjectId,
            @RequestParam Long teacherId,
            @RequestParam Long groupId,
            @RequestParam String room,
            @RequestParam String datetime,
            @RequestParam Long timetableId
    ) throws ParseException {
        timetableService.updateTimetable(subjectId, teacherId, groupId, room, datetime, timetableId);

        return "redirect:/timetable";
    }

    @PostMapping("delete")
    public String deleteTimetable(@RequestParam Long timetableId){
        timetableService.deleteTimetableById(timetableId);

        return "redirect:/timetable";
    }
}

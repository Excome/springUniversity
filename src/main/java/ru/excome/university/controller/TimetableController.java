package ru.excome.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}

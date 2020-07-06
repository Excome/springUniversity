package ru.excome.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.excome.university.service.GroupStudService;

@Controller
@RequestMapping("/group")
public class GroupStudController {
    private GroupStudService groupStudService;

    public GroupStudController(GroupStudService groupStudService) {
        this.groupStudService = groupStudService;
    }

    @GetMapping
    public String groupStud(Model model) {
        model.addAttribute("groups", groupStudService.getAllGroups());

        return "group";
    }

    @GetMapping("{group}")
    public String groupEdit(@PathVariable Long group, Model model) {
        model.addAttribute("group", groupStudService.getGroupById(group));

        return "groupEdit";
    }

    @PostMapping
    public String addGroup(
            @RequestParam String faculty,
            @RequestParam String direction,
            @RequestParam String name
    ) {
        groupStudService.addGroup(faculty,direction,name);

        return "redirect:/group";
    }

    @PostMapping("update")
    public String updateGroup(
            @RequestParam String faculty,
            @RequestParam String direction,
            @RequestParam String name,
            @RequestParam Long groupId
    ){
        groupStudService.updateGroupById(faculty,direction,name,groupId);

        return "redirect:/group";
    }

    @PostMapping("delete")
    public String deleteGroup(@RequestParam Long groupId){
        groupStudService.deleteGroupById(groupId);

        return "redirect:/group";
    }
}

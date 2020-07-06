package ru.excome.university.service;

import org.springframework.stereotype.Service;
import ru.excome.university.domain.GroupStud;
import ru.excome.university.repository.GroupStudRepo;

import java.util.List;

@Service
public class GroupStudService {
    private GroupStudRepo groupStudRepo;

    public GroupStudService(GroupStudRepo groupStudRepo) {
        this.groupStudRepo = groupStudRepo;
    }

    public List<GroupStud> getAllGroups() {
        return groupStudRepo.findAllGroups();
    }

    public GroupStud getGroupById(Long id){
        return groupStudRepo.findGroupStudById(id);
    }

    public void addGroup(String faculty, String direction, String name) {
        try {
            GroupStud groupStud = new GroupStud(faculty, direction, name);
            groupStudRepo.save(groupStud);
        }catch (Exception ex) {}
    }
    
    public void updateGroupById(String faculty, String direction, String name, Long groupId) {
        try{
            groupStudRepo.updateGroupStudById(faculty, direction, name, groupId);
        }catch (Exception ex) {}
        
    }

    public void deleteGroupById(Long groupId) {
       try{
            groupStudRepo.deleteById(groupId);
        }catch (Exception ex) {        }
    }
}


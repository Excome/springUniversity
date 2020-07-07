package ru.excome.university.service;

import org.springframework.stereotype.Service;
import ru.excome.university.domain.Subject;
import ru.excome.university.repository.SubjectRepo;

import java.util.List;

@Service
public class SubjectService {
    private SubjectRepo subjectRepo;

    public SubjectService(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    public List<Subject> getAllSubjects(){
        return subjectRepo.findAll();
    }

    public Subject getSubjectById(Long subjectId){
        return subjectRepo.findSubjectById(subjectId);
    }

    public void addSubject(boolean type, String name, Integer hoursPerWeek){
        subjectRepo.save(new Subject(type, name, hoursPerWeek));
    }

    public void updateSubjectById(boolean type, String name, Integer hoursPerWeek, Long subjectId){
        try{
            subjectRepo.updateSubjectById(type, name, hoursPerWeek, subjectId);
        }catch (Exception ex){}
    }

    public void deleteSubjectByID(Long subjectId) {
        try{
            subjectRepo.deleteById(subjectId);
        }catch (Exception ex){}
    }
}

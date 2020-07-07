package ru.excome.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.excome.university.domain.Subject;

import java.util.List;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
    @Query("select s from Subject s order by s.type, s.name desc")
    List<Subject> findAll();

    Subject findSubjectById(Long subjectId);

    @Modifying
    @Transactional
    @Query("update Subject s set s.type = :t, s.name = :n, s.hoursPerWeek = :h where s.id = :id")
    void updateSubjectById(@Param("t") boolean type, @Param("n") String name,
                           @Param("h") Integer hoursPerWeek, @Param("id") Long id);

    void deleteById(Long subjectID);
}

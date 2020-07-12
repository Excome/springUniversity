package ru.excome.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.excome.university.domain.Mark;
import ru.excome.university.domain.Student;
import ru.excome.university.domain.Subject;
import ru.excome.university.domain.Teacher;

import java.util.Date;
import java.util.List;

@Repository
public interface MarkRepo extends JpaRepository<Mark, Long> {
    @Query("select m from Mark m order by m.date desc ")
    List<Mark> findAll();

    @Query("select m from Mark m " +
            "where m.student.surname like concat('%', :search, '%') " +
            "OR m.student.firstname like concat('%', :search, '%') " +
            "OR m.student.patronymic like concat('%', :search, '%')")
    List<Mark> findAllBySearch(@Param("search") String search);

    Mark findMarkById(Long markId);

    @Modifying
    @Transactional
    @Query("update Mark m set m.student = :student, m.subject = :subject, m.mark = :mark, m.teacher = :teacher, m.work = :work, m.date = :date where m.id = :id")
    void updateMarkById(@Param("student") Student student, @Param("subject")Subject subject, @Param("mark") Integer mark,
                        @Param("teacher")Teacher teacher, @Param("work")String work, @Param("date")Date date, @Param("id")Long markId);

}

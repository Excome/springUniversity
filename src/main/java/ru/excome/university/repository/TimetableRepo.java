package ru.excome.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.excome.university.domain.GroupStud;
import ru.excome.university.domain.Subject;
import ru.excome.university.domain.Teacher;
import ru.excome.university.domain.Timetable;

import java.util.Date;

@Repository
public interface TimetableRepo extends JpaRepository<Timetable, Long> {
    Timetable findTimetableById(Long id);

    @Modifying
    @Transactional
    @Query("update Timetable t set t.subject = :subject, t.teacher = :teacher, t.groupStud = :group, t.room = :room, t.datetime = :datetime where t.id = :id")
    void updateTimeTableByID(@Param("subject")Subject subject, @Param("teacher")Teacher teacher, @Param("group")GroupStud group,
                             @Param("room") String room, @Param("datetime") Date datetime, @Param("id") Long id);
}

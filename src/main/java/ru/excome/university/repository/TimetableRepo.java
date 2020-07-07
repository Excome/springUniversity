package ru.excome.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.excome.university.domain.Timetable;

@Repository
public interface TimetableRepo extends JpaRepository<Timetable, Long> {

}

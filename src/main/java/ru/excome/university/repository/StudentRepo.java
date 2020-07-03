package ru.excome.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.excome.university.domain.Student;

import java.util.Optional;

public interface StudentRepo  extends JpaRepository<Student, Long> {
    Student findById(Long id);
    void deleteById(Long id);

    @Query("update Student s set s.surname =?1, s.firstname = ?2, s.patronymic = ?3, s.age = ?4 where s.id = ?5")
    void updateById(String surname, String firstname, String patronymic, Integer age, Long studentId);


}

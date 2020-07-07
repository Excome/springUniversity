package ru.excome.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.excome.university.domain.Teacher;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    @Query("select t from Teacher t order by t.surname, t.firstname, t.patronymic")
    List<Teacher> findAll();

    Teacher findTeacherById(Long teacherID);

    @Modifying
    @Transactional
    @Query("update Teacher t set t.surname = :sn, t.firstname = :fn, t.patronymic =:p, t.age = :a, t.degree = :d where t.id = :id")
    void updateTeacherById(@Param("sn") String surname, @Param("fn") String firstname, @Param("p") String patronymic,
                           @Param("a") Integer age, @Param("d") String degree, @Param("id") Long teacherId);

    void deleteById(Long teacherId);

}

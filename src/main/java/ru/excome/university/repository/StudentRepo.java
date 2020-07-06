package ru.excome.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.excome.university.domain.GroupStud;
import ru.excome.university.domain.Student;

import java.util.List;


public interface StudentRepo  extends JpaRepository<Student, Long> {
    @Query("select s from Student s order by s.surname, s.firstname, s.patronymic asc")
    List<Student> findAllStudents();

    Student findStudentById(Long id);
    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.surname =:sn, s.firstname = :fn, s.patronymic = :p, s.age = :a, s.groupStud = :stg  where s.id = :studentId")
    void updateById(@Param("sn") String surname, @Param("fn") String firstname,
                    @Param("p") String patronymic, @Param("a") Integer age,
                    @Param("stg") GroupStud groupStudId, @Param("studentId") Long studentId);


}

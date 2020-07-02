package ru.excome.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.excome.university.domain.Student;

import java.util.Optional;

public interface StudentRepo  extends JpaRepository<Student, Long> {
    Optional<Student> findById(Long id);
    void deleteById(Long id);

}

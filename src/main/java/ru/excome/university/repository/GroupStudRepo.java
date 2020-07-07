package ru.excome.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.excome.university.domain.GroupStud;

import java.util.List;

@Repository
public interface GroupStudRepo extends JpaRepository<GroupStud, Long> {
    GroupStud findGroupStudById(Long id);
    GroupStud findGroupStudByName(String name);

    @Query("select g from GroupStud g order by g.faculty, g.direction, g.name")
    List<GroupStud> findAllGroups();

    @Modifying
    @Transactional
    @Query("update GroupStud g set g.faculty = :f, g.direction = :d, g.name = :n where g.id = :id ")
    void updateGroupStudById(@Param("f") String faculty, @Param("d") String direction,
                             @Param("n") String name, @Param("id") Long groupStudId);

    void deleteById(Long groupId);
}

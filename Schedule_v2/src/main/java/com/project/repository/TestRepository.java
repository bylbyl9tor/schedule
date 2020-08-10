package com.project.repository;

import com.project.model.TestScheduleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestScheduleTable, Long> {
    List<TestScheduleTable> findAllByFacultyName(String name);

    List<TestScheduleTable> findAllById(long id);

    void deleteById(long id);
    TestScheduleTable findById(long id);

    List<TestScheduleTable> findAllByFacultyNameAndSpecialtyNameAndGroupNameAndDate(String facultyName,
                                                                             String specialtyName,
                                                                             String groupName,
                                                                             String date);
}
package com.project.service;

import com.project.model.LessonTime;
import com.project.model.Teacher;
import com.project.model.TestScheduleTable;
import com.project.repository.TestRepository;

import java.util.List;

public interface TestService {
    List<TestScheduleTable> findAllByFacultyName(String name);

    List<TestScheduleTable> findAll();

/*
    List<TestScheduleTable> findAllById(long id);
*/
    TestScheduleTable getOne(long id);
    void deleteById(long id);

    TestScheduleTable findById(long id);
    void save(TestScheduleTable testScheduleTable);

    List<TestScheduleTable> findAllByFacultyNameAndSpecialtyNameAndGroupNameAndDate(String facultyName,
                                                                                    String specialtyName,
                                                                                    String groupName,
                                                                                    String date);
}


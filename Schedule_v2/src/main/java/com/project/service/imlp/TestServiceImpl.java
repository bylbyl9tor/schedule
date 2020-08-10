package com.project.service.imlp;

import com.project.model.LessonTime;
import com.project.model.TestScheduleTable;
import com.project.repository.TestRepository;
import com.project.repository.TimeRepository;
import com.project.service.TestService;
import com.project.service.TimeService;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    TestRepository testRepository;

    @Override
    public List<TestScheduleTable> findAll() {
        List<TestScheduleTable> scheds = testRepository.findAll();
        return scheds;
    }

    @Override
    public TestScheduleTable getOne(long id) {
        TestScheduleTable sched = testRepository.getOne(id);
        return sched;
    }

    @Override
    public List<TestScheduleTable> findAllByFacultyName(String facultyName) {
        List<TestScheduleTable> scheds = testRepository.findAllByFacultyName(facultyName);
        return scheds;
    }

    @Override
    public TestScheduleTable findById(long id) {
        TestScheduleTable scheds = testRepository.findById(id);
        return scheds;
    }

    @Override
    public void save(TestScheduleTable testScheduleTable) {
        testRepository.save(testScheduleTable);
    }

    @Override
    public void deleteById(long id){
        testRepository.deleteById(id);
    }

    @Override
    public List<TestScheduleTable> findAllByFacultyNameAndSpecialtyNameAndGroupNameAndDate(String facultyName,
                                                                                           String specialtyName,
                                                                                           String groupName,
                                                                                           String date) {
        List<TestScheduleTable> scheds = testRepository.findAllByFacultyNameAndSpecialtyNameAndGroupNameAndDate(facultyName,
                specialtyName, groupName, date);
        Collections.sort(scheds);
        return scheds;
    }
}

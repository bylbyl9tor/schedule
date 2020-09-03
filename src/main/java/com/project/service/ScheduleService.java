package com.project.service;

import com.project.model.Faculty;
import com.project.model.Group;
import com.project.model.LessonDate;
import com.project.model.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAllByGroup(Group group);

    List<Schedule> findAll();

    Schedule getOne(long id);

    void deleteById(long id);

    Schedule findById(long id);

    void save(Schedule schedule);

    void update(Schedule schedule,long id);

    List<Schedule> findAllByGroupAndDate(Group group, LessonDate date);
}
package com.project.service.imlp;

import com.project.model.Faculty;
import com.project.model.Group;
import com.project.model.LessonDate;
import com.project.model.Schedule;
import com.project.repository.ScheduleRepository;
import com.project.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> findAll() {
        List<Schedule> scheds = scheduleRepository.findAll();
        return scheds;
    }

    @Override
    public Schedule getOne(long id) {
        Schedule sched = scheduleRepository.getOne(id);
        return sched;
    }

    @Override
    public List<Schedule> findAllByGroup(Group group) {
        List<Schedule> scheds = scheduleRepository.findAllByGroup(group);
        return scheds;
    }

    @Override
    public Schedule findById(long id) {
        Schedule scheds = scheduleRepository.findById(id);
        return scheds;
    }

    @Override
    public void save(Schedule testScheduleTable) {
        scheduleRepository.save(testScheduleTable);
    }

    @Override
    public void deleteById(long id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public List<Schedule> findAllByGroupAndDate(Group group, LessonDate lessonDate) {
        List<Schedule> scheds = scheduleRepository.findAllByGroupAndDate(group, lessonDate);
        //Collections.sort(scheds);
        return scheds;
    }
}

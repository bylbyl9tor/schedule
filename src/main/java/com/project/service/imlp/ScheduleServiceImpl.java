package com.project.service.imlp;

import com.project.model.Group;
import com.project.model.LessonDate;
import com.project.model.Schedule;
import com.project.repository.ScheduleRepository;
import com.project.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Iterator;
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
    public void save(Schedule schedule) {
        if (this.checkRow(schedule)) {
            scheduleRepository.save(schedule);
        } else {

        }

    }

    public boolean checkRow(Schedule schedule) {
        Iterator<Schedule> iterator = findAllByGroupAndDate(schedule.getGroup(), schedule.getDate()).iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getLessonTime().equals(schedule.getLessonTime())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void update(Schedule newSchedule, long id) {
        if (this.checkRow(newSchedule)) {
            newSchedule.setId(id);
            scheduleRepository.save(newSchedule);
        }
    }

    @Override
    public void deleteById(long id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public List<Schedule> findAllByGroupAndDate(Group group, LessonDate lessonDate) {
        List<Schedule> scheds = scheduleRepository.findAllByGroupAndDate(group, lessonDate);
        Collections.sort(scheds);
        return scheds;
    }
}

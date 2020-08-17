package com.project.service.imlp;

import com.project.model.LessonTime;
import com.project.repository.TimeRepository;
import com.project.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class TimeServiceImpl implements TimeService {
    @Autowired
    TimeRepository timeRepository;

    @Override
    public List<LessonTime> findAll() {
        List<LessonTime> times = timeRepository.findAll();
        return times;
    }

    @Override
    public LessonTime findByLessonTimeStartAndLessonTimeEnd(String start, String end) {
        return timeRepository.findByLessonTimeStartAndLessonTimeEnd(start, end);
    }
}

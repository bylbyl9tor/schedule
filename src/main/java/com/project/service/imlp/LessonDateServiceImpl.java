package com.project.service.imlp;

import com.project.model.LessonDate;
import com.project.repository.LessonDateRepository;
import com.project.service.LessonDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonDateServiceImpl implements LessonDateService {
    @Autowired
    LessonDateRepository lessonDateRepository;

    @Override
    public LessonDate findByDateName(String date) {
        if (!lessonDateRepository.existsByDateName(date)) {
            lessonDateRepository.save(new LessonDate(date));
        }
        return lessonDateRepository.findByDateName(date);
    }
}

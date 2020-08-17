package com.project.service;

import com.project.model.LessonTime;

import java.sql.Time;

import java.util.List;

public interface TimeService {
    List<LessonTime> findAll();

    LessonTime findByLessonTimeStartAndLessonTimeEnd(String start, String end);
}

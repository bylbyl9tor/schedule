package com.project.service;

import com.project.model.LessonDate;

public interface LessonDateService {
    LessonDate findByDateName(String date);
}

package com.project.service;

import com.project.model.LessonType;

import java.util.List;

public interface LessonTypeService {
    List<LessonType> findAll();

    LessonType findByLessonType(String lessonType);
}

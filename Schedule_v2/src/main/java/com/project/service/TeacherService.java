package com.project.service;

import com.project.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    Teacher findByTeacherName(String teacherName);
}

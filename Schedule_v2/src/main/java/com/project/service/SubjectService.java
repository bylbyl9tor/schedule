package com.project.service;

import com.project.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();

    Subject findBySubjectName(String subjectName);
}

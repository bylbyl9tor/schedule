package com.project.service;

import com.project.model.Specialty;

import java.util.List;

public interface SpecialtyService {
    List<Specialty> findAll();

    List<Specialty> findAllByFaculty_FacultyNameLikeIgnoreCase(String facultyName);
}

package com.project.service.imlp;

import com.project.model.Group;
import com.project.model.Specialty;
import com.project.repository.SpecialtyRepository;
import com.project.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
    @Autowired
    SpecialtyRepository specialtyRepository;

    @Override
    public List<Specialty> findAll() {
        List<Specialty> specialties = specialtyRepository.findAll();
        return specialties;
    }

    @Override
    public List<Specialty> findAllByFaculty_FacultyNameLikeIgnoreCase(String facultyName) {
        List<Specialty> specialties = specialtyRepository.findAllByFaculty_FacultyNameLikeIgnoreCase(facultyName);
        return specialties;
    }
}

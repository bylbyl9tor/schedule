package com.project.service.imlp;

import com.project.model.Classroom;
import com.project.model.Faculty;
import com.project.repository.ClassroomRepository;
import com.project.repository.FacultyRepository;
import com.project.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public List<Faculty> findAll() {
        List<Faculty> facultys = facultyRepository.findAll();
        return facultys;
    }
}

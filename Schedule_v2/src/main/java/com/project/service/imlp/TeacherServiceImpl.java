package com.project.service.imlp;

import com.project.model.Teacher;
import com.project.repository.TeacherRepository;
import com.project.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }
}

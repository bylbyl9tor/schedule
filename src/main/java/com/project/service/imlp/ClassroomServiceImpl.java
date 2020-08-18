package com.project.service.imlp;

import com.project.model.Classroom;
import com.project.repository.ClassroomRepository;
import com.project.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;

    @Override
    public List<Classroom> findAllBy() {
        List<Classroom> classrooms = classroomRepository.findAll();
        return classrooms;
    }

    @Override
    public Classroom findByClassroomNumber(String classroomNumber) {
        return classroomRepository.findByClassroomNumber(classroomNumber);
    }

}

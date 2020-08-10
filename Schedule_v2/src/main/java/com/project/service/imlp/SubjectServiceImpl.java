package com.project.service.imlp;

import com.project.model.Subject;
import com.project.repository.SubjectRepository;
import com.project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects;
    }
}

package com.project.service.imlp;

import com.project.model.Faculty;
import com.project.model.LessonType;
import com.project.repository.FacultyRepository;
import com.project.repository.LessonTypeRepository;
import com.project.service.LessonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonTypeServiceImpl implements LessonTypeService {
    @Autowired
    LessonTypeRepository lessonTypeRepository;

    @Override
    public List<LessonType> findAll() {
        List<LessonType> lessonTypes = lessonTypeRepository.findAll();
        return lessonTypes;
    }

    @Override
    public LessonType findByLessonType(String lessonType) {
        return lessonTypeRepository.findByLessonType(lessonType);
    }
}

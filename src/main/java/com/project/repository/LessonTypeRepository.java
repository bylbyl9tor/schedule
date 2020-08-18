package com.project.repository;

import com.project.model.LessonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonTypeRepository  extends JpaRepository<LessonType,Long> {
    LessonType findByLessonType(String lessonType);
}

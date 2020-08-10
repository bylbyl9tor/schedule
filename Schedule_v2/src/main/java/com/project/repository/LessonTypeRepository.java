package com.project.repository;

import com.project.model.LessonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonTypeRepository  extends JpaRepository<LessonType,Long> {
}

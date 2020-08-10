package com.project.repository;

import com.project.model.LessonTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TimeRepository  extends JpaRepository<LessonTime,Long> {
}
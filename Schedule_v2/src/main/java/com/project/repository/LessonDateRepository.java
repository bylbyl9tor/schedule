package com.project.repository;

import com.project.model.Group;
import com.project.model.LessonDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonDateRepository extends JpaRepository<LessonDate, Long> {
    LessonDate findByDateName(String date);
}

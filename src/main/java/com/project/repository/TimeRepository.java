package com.project.repository;

import com.project.model.LessonTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository  extends JpaRepository<LessonTime,Long> {
    LessonTime findByLessonTimeStartAndLessonTimeEnd(String start,String end);
}
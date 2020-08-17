package com.project.repository;

import com.project.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher,Long> {
    Teacher findByTeacherName(String teacherName);
}

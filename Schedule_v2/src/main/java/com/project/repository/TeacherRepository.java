package com.project.repository;

import com.project.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository  extends JpaRepository<Teacher,Long> {
}

package com.project.repository;

import com.project.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassroomRepository  extends JpaRepository<Classroom,Long> {
}

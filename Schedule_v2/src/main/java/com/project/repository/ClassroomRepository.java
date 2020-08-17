package com.project.repository;

import com.project.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository  extends JpaRepository<Classroom,Long> {
    Classroom findByClassroomNumber(String classroomNumber);
}

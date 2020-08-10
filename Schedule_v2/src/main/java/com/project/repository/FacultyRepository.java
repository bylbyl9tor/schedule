package com.project.repository;

import com.project.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}

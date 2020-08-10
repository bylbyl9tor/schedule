package com.project.repository;

import com.project.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecialtyRepository extends JpaRepository<Specialty,Long> {
    List<Specialty> findAllByFaculty_FacultyNameLikeIgnoreCase(String facultyName);
}

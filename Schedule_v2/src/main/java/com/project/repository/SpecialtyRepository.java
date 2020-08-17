package com.project.repository;

import com.project.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty,Long> {
    List<Specialty> findAllByFaculty_FacultyNameLikeIgnoreCase(String facultyName);
}

package com.project.repository;

import com.project.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}

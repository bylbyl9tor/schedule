package com.project.repository;

import com.project.model.Group;
import com.project.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByGroupName(String groupName);

    List<Group> findAllBySpecialtySpecialtyNameAndSpecialtyFacultyFacultyName(String specialtyName,
                                                                              String facultyName);

    Group findByGroupNameAndSpecialty(String groupName, Specialty specialty);

    Group findByGroupNameAndSpecialtySpecialtyNameAndSpecialtyFacultyFacultyName(String groupName,
                                                                                 String specialtyName,
                                                                                 String facultyName);
}
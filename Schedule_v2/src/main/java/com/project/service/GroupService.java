package com.project.service;

import com.project.model.Group;

import java.util.List;

public interface GroupService {
    Group findByGroupName(String groupName);
    List<Group> findAllBy();
    List<Group> findAllBySpecialtySpecialtyNameAndSpecialtyFacultyFacultyName(String specialtyName, String facultyName);
}

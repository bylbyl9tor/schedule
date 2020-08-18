package com.project.service.imlp;

import com.project.model.Group;
import com.project.model.Specialty;
import com.project.repository.GroupRepository;
import com.project.service.GroupService;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupRepository groupRepository;

    @Override
    public Group findByGroupName(String groupName) {
        Group group = groupRepository.findByGroupName(groupName);
        return group;
    }

    public Group returnGroupObjectByParams(String facultyName, String specialtyName, String groupName) {
        Group returnedObject = groupRepository
                .findByGroupNameAndSpecialtySpecialtyNameAndSpecialtyFacultyFacultyName(groupName, specialtyName, facultyName);
        return returnedObject;
    }

    public Group returnGroupObjectByGroupName(String groupName) {
        return groupRepository.findByGroupName(groupName);
    }

    @Override
    public List<Group> findAllBy() {
        return groupRepository.findAll();
    }

    @Override
    public List<Group> findAllBySpecialtySpecialtyNameAndSpecialtyFacultyFacultyName(String specialtyName, String facultyName) {
        List<Group> groups = groupRepository.findAllBySpecialtySpecialtyNameAndSpecialtyFacultyFacultyName(specialtyName, facultyName);
        return groups;
    }
}

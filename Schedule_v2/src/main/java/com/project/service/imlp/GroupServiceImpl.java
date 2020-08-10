package com.project.service.imlp;

import com.project.model.Group;
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


    public Group findByGroupName(String groupName) {
        Group group = groupRepository.findByGroupName(groupName);
        return group;
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

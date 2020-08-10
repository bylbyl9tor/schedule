package com.project.controllers;

import com.project.model.Faculty;
import com.project.model.Group;
import com.project.model.Specialty;
import com.project.model.TestScheduleTable;
import com.project.repository.TestRepository;
import com.project.service.imlp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    GroupServiceImpl groupService;
    @Autowired
    FacultyServiceImpl facultyService;
    @Autowired
    SpecialtyServiceImpl specialtyService;
    @Autowired
    SubjectServiceImpl subjectService;
    @Autowired
    ClassroomServiceImpl classroomServiceImpl;
    @Autowired
    LessonTypeServiceImpl lessonTypeService;
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    TimeServiceImpl timeService;
    @Autowired
    TestServiceImpl testService;

    @GetMapping("/")
    public String showScheduleForUser(Model model) {
        model.addAttribute("facultyAll", this.facultyService.findAll());
        model.addAttribute("specialtyAll", this.specialtyService.findAll());
        model.addAttribute("groupAll", groupService.findAllBy());
        model.addAttribute("schedule", new TestScheduleTable());
        return "main-user-page";
    }

    @GetMapping("/{faculty}/{specialty}/{group}/{date}")
    public String getPutPage(@PathVariable String faculty,
                             @PathVariable String specialty,
                             @PathVariable String group,
                             @PathVariable String date,
                             Model model) {
        model.addAttribute("rows", testService.findAllByFacultyNameAndSpecialtyNameAndGroupNameAndDate(
                faculty, specialty, group, date));
        /*model.addAttribute("choosenFaculty", faculty);
        model.addAttribute("choosenSpecialty", specialty);
        model.addAttribute("choosenGroup", group);
        model.addAttribute("choosenDate", date);
        model.addAttribute("timeAll", this.timeService.findAll());
        model.addAttribute("subjectAll", this.subjectService.findAll());
        model.addAttribute("teacherAll", this.teacherService.findAll());
        model.addAttribute("classroomAll", this.classroomServiceImpl.findAllBy());
        model.addAttribute("lessonTypeAll", this.lessonTypeService.findAll());
        model.addAttribute("schedule", new TestScheduleTable());*/
        return "table-user";
    }
}

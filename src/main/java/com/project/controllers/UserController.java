package com.project.controllers;

import com.project.model.Group;
import com.project.model.LessonDate;
import com.project.model.LessonTime;
import com.project.model.Schedule;
import com.project.repository.LessonDateRepository;
import com.project.service.LessonDateService;
import com.project.service.imlp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    ScheduleServiceImpl scheduleService;
    @Autowired
    LessonDateService lessonDateService;

    @GetMapping("/")
    public String showScheduleForUser(Model model) {
        model.addAttribute("facultyAll", this.facultyService.findAll());
        model.addAttribute("specialtyAll", this.specialtyService.findAll());
        model.addAttribute("groupAll", groupService.findAllBy());
        model.addAttribute("schedule", new Schedule());
        return "main-user-page";
    }

    @GetMapping("/{faculty}/{specialty}/{group}/{date}")
    public String getPutPage(@PathVariable String faculty,
                             @PathVariable String specialty,
                             @PathVariable String group,
                             @PathVariable String date,
                             Model model) {
        model.addAttribute("rows", scheduleService.findAllByGroupAndDate(groupService.findByGroupName(group), lessonDateService.findByDateName(date)));
        return "table-user";
    }
}

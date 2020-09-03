package com.project.controllers;

import com.project.model.*;
import com.project.repository.*;
import com.project.service.LessonDateService;
import com.project.service.TimeService;
import com.project.service.imlp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Collection;

import static com.project.controllers.EncodingUrl.returnUrl;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    GroupServiceImpl groupService;
    @Autowired
    LessonDateService lessonDateService;
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
    ScheduleServiceImpl scheduleService;
    @Autowired
    TimeServiceImpl timeService;

    @GetMapping("/")
    public String showScheduleForAdmin(Model model) {
        model.addAttribute("facultyAll", this.facultyService.findAll());
        model.addAttribute("specialtyAll", this.specialtyService.findAll());
        model.addAttribute("groupAll", this.groupService.findAllBy());
        model.addAttribute("schedule", new Schedule());
        return "main-admin-page";
    }

    @GetMapping("/{faculty}/{specialty}/{group}/{date}")
    public String getPutPage(@PathVariable String faculty,
                             @PathVariable String specialty,
                             @PathVariable String group,
                             @PathVariable String date,
                             Model model) {
        model.addAttribute("rows", scheduleService.findAllByGroupAndDate(groupService.findByGroupName(group), lessonDateService.findByDateName(date)));
        model.addAttribute("groupList", this.groupService.findByGroupName(group));
        model.addAttribute("dateList", this.lessonDateService.findByDateName(date));
        model.addAttribute("timeAll", this.timeService.findAll());
        model.addAttribute("subjectAll", this.subjectService.findAll());
        model.addAttribute("teacherAll", this.teacherService.findAll());
        model.addAttribute("classroomAll", this.classroomServiceImpl.findAllBy());
        model.addAttribute("lessonTypeAll", this.lessonTypeService.findAll());
        model.addAttribute("schedule", new Schedule());
        return "table-admin";
    }

    @PostMapping("/add")
    public String putMyData(@ModelAttribute("schedule") Schedule schedule) throws UnsupportedEncodingException {
        scheduleService.save(schedule);
        return returnUrl("admin", schedule.getGroup().getSpecialty().getFaculty().getFacultyName(),
                schedule.getGroup().getSpecialty().getSpecialtyName(),
                schedule.getGroup().getGroupName(),
                schedule.getDate().getDateName());
    }

    @GetMapping("/{faculty}/{specialty}/{group}/{date}/edit")
    public String getEditForm(@PathVariable String faculty,
                              @PathVariable String specialty,
                              @PathVariable String group,
                              @PathVariable String date,
                              @RequestParam long id,
                              Model model) {
        model.addAttribute("groupList", this.groupService.findByGroupName(group));
        model.addAttribute("dateList", this.lessonDateService.findByDateName(date));
        model.addAttribute("timeAll", this.timeService.findAll());
        model.addAttribute("subjectAll", this.subjectService.findAll());
        model.addAttribute("teacherAll", this.teacherService.findAll());
        model.addAttribute("classroomAll", this.classroomServiceImpl.findAllBy());
        model.addAttribute("lessonTypeAll", this.lessonTypeService.findAll());
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("rows", scheduleService.findById(id));
        return "edit-form";
    }

    @PostMapping("/{faculty}/{specialty}/{group}/{date}/edit")
    public String edit(@PathVariable String faculty,
                       @PathVariable String specialty,
                       @PathVariable String group,
                       @PathVariable String date,
                       @RequestParam long id,
                       Schedule tst) throws UnsupportedEncodingException {
        scheduleService.update(tst, id);
        return returnUrl("admin", tst.getGroup().getSpecialty().getFaculty().getFacultyName(),
                tst.getGroup().getSpecialty().getSpecialtyName(),
                tst.getGroup().getGroupName(),
                tst.getDate().getDateName());
    }

    @PostMapping("/{faculty}/{specialty}/{group}/{date}/delete")
    public String delete(@PathVariable String faculty,
                         @PathVariable String specialty,
                         @PathVariable String group,
                         @PathVariable String date,
                         @RequestParam long id) throws UnsupportedEncodingException {
        scheduleService.deleteById(id);
        return returnUrl("admin", faculty, specialty, group, date);
    }
}
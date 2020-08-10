package com.project.controllers;

import com.project.repository.*;
import com.project.model.*;
import com.project.service.imlp.ClassroomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstController {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    SpecialtyRepository specialtyRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    ClassroomServiceImpl classroomService;
    @Autowired
    LessonTypeRepository lessonTypeRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    TestRepository testRepository;
    @Autowired
    TimeRepository timeRepository;

/*    @GetMapping("/login")
    public String login() {
        return "login";
    }*/



    /*@PostMapping("/workWithGroup")
    public String workWithGroup(TestScheduleTable tST, Model model) {
        model.addAttribute("rows", testRepository.findAllByFacultyNameAndSpecialtyNameAndGroupName(
                tST.getFacultyName(), tST.getSpecialtyName(), tST.getGroupName()));
        model.addAttribute("time",timeRepository.findAll());
        model.addAttribute("subjectAll", this.subjectRepository.findAllBy());
        model.addAttribute("teacherAll", this.teacherRepository.findAllBy());
        model.addAttribute("classroomAll", this.classroomRepository.findAllBy());
        model.addAttribute("lessonTypeAll", this.lessonTypeRepository.findAllBy());
        model.addAttribute("schedule", new TestScheduleTable());
        model.addAttribute("choosenFaculty",tST.getFacultyName());
        model.addAttribute("choosenSpecialty",tST.getSpecialtyName());
        model.addAttribute("choosenGroup",tST.getGroupName());
        return "index";
    }*/


    @PostMapping("/addRow")
    public String setForm(TestScheduleTable testScheduleTable,ModelMap model) {
/*        Collection<Faculty> facultyAll = this.facultyRepository.findAllBy();
        Collection<Specialty> specialtyAll = this.specialtyRepository.findAllBy();
        Collection<Group> groupAll = this.groupRepository.findAllBy();*//*
        Collection<Subject> subjectAll = this.subjectRepository.findAllBy();
        Collection<Teacher> teacherAll = this.teacherRepository.findAllBy();
        Collection<Classroom> classroomAll = this.classroomRepository.findAllBy();
        Collection<LessonType> lessonTypeAll = this.lessonTypeRepository.findAllBy();

*//*        model.addAttribute("facultyAll", facultyAll);
        model.addAttribute("specialtyAll", specialtyAll);
        model.addAttribute("groupAll", groupAll);*//*
        model.addAttribute("subjectAll", subjectAll);
        model.addAttribute("teacherAll", teacherAll);
        model.addAttribute("classroomAll", classroomAll);
        model.addAttribute("lessonTypeAll", lessonTypeAll);
        model.addAttribute("schedule", new TestScheduleTable());*/
        testRepository.save(testScheduleTable);
        return "redirect:/login";
    }

    /*@PostMapping("/form")
    public String submit(@ModelAttribute("schedule") TestScheduleTable scheduleForm, Model model,
    @RequestParam("facultyAll") Faculty faculty) {
        model.addAttribute("scheduleForm", scheduleForm);

        return "form-result";
    }*/
    @PostMapping("/addrsdsdow")
    public String addRow(TestScheduleTable testScheduleTable, Model model) {
/*        if (result.hasErrors()) {
            return "add-user";
        }*/

        testRepository.save(testScheduleTable);
        model.addAttribute("users", testRepository.findAll());
        return "table-admin";
    }
}
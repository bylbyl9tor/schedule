package com.project.controllers;

import com.project.model.*;
import com.project.repository.*;
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
    TestServiceImpl testService;
    @Autowired
    TimeServiceImpl timeService;

    @GetMapping("/{faculty}/{specialty}/{group}/{date}")
    public String getPutPage(@PathVariable String faculty,
                             @PathVariable String specialty,
                             @PathVariable String group,
                             @PathVariable String date,
                             Model model) {
        model.addAttribute("rows", testService.findAllByFacultyNameAndSpecialtyNameAndGroupNameAndDate(
                faculty, specialty, group, date));
        model.addAttribute("choosenFaculty", faculty);
        model.addAttribute("choosenSpecialty", specialty);
        model.addAttribute("choosenGroup", group);
        model.addAttribute("choosenDate", date);
        model.addAttribute("timeAll", this.timeService.findAll());
        model.addAttribute("subjectAll", this.subjectService.findAll());
        model.addAttribute("teacherAll", this.teacherService.findAll());
        model.addAttribute("classroomAll", this.classroomServiceImpl.findAllBy());
        model.addAttribute("lessonTypeAll", this.lessonTypeService.findAll());
        model.addAttribute("schedule", new TestScheduleTable());
        return "table-admin";
    }

    @GetMapping("/")
    public String showScheduleForAdmin(Model model) {
        Collection<Faculty> facultyAll = this.facultyService.findAll();
        Collection<Specialty> specialtyAll = this.specialtyService.findAll();
        Collection<Group> groupAll = this.groupService.findAllBy();
        model.addAttribute("facultyAll", facultyAll);
        model.addAttribute("specialtyAll", specialtyAll);
        model.addAttribute("groupAll", groupAll);
        model.addAttribute("schedule", new TestScheduleTable());
        return "main-admin-page";
    }

    @PostMapping(value = "/add")
    public String putMyData(TestScheduleTable schedule) throws UnsupportedEncodingException {
        testService.save(schedule);
        return returnUrl("admin",
                schedule.getFacultyName(),
                schedule.getSpecialtyName(),
                schedule.getGroupName(),
                schedule.getDate());
    }

    @GetMapping("/{faculty}/{specialty}/{group}/{date}/edit")
    public String getEditForm(@PathVariable String faculty,
                              @PathVariable String specialty,
                              @PathVariable String group,
                              @PathVariable String date,
                              @RequestParam long id,
                              Model model) {
        model.addAttribute("choosenFaculty", faculty);
        model.addAttribute("choosenSpecialty", specialty);
        model.addAttribute("choosenGroup", group);
        model.addAttribute("choosenDate", date);
        model.addAttribute("timeAll", this.timeService.findAll());
        model.addAttribute("subjectAll", this.subjectService.findAll());
        model.addAttribute("teacherAll", this.teacherService.findAll());
        model.addAttribute("classroomAll", this.classroomServiceImpl.findAllBy());
        model.addAttribute("lessonTypeAll", this.lessonTypeService.findAll());
        model.addAttribute("schedule", new TestScheduleTable());
        TestScheduleTable row = testService.findById(id);
        model.addAttribute("rows", row);
        return "edit-form";
    }

    @PostMapping(value = "/{faculty}/{specialty}/{group}/{date}/edit")
    public String edit(@PathVariable String faculty,
                       @PathVariable String specialty,
                       @PathVariable String group,
                       @PathVariable String date,
                       @RequestParam long id,
                       TestScheduleTable tst) throws UnsupportedEncodingException {
        TestScheduleTable toUpdate = testService.getOne(id);
        toUpdate.setFacultyName(tst.getFacultyName());
        toUpdate.setSpecialtyName(tst.getSpecialtyName());
        toUpdate.setGroupName(tst.getGroupName());
        toUpdate.setSubjectName(tst.getSubjectName());
        toUpdate.setTeacherName(tst.getTeacherName());
        toUpdate.setClassroomName(tst.getClassroomName());
        toUpdate.setDate(tst.getDate());
        toUpdate.setLessonType(tst.getLessonType());
        toUpdate.setTime(tst.getTime());
        testService.save(toUpdate);
        return returnUrl("admin",tst.getFacultyName(),tst.getSpecialtyName(),tst.getGroupName(),tst.getDate());
    }

    @PostMapping("/{faculty}/{specialty}/{group}/{date}/delete")
    public String delete(@PathVariable String faculty,
                         @PathVariable String specialty,
                         @PathVariable String group,
                         @PathVariable String date,
                         @RequestParam long id) throws UnsupportedEncodingException {
        testService.deleteById(id);
        return returnUrl("admin", faculty, specialty, group, date);
    }

    /*@RequestMapping(value = "/json/{faculty}/{specialty}/{group}", method = RequestMethod.GET)
    @ResponseBody
    public List<TestScheduleTable> getMyData(@PathVariable String faculty,
                                             @PathVariable String specialty,
                                             @PathVariable String group) {
        List<TestScheduleTable> scheduleTables = testRepository
                .findAllByFacultyNameAndSpecialtyNameAndGroupNameAndDate(faculty, specialty, group);
        return scheduleTables;
    }*/

    /*    @RequestMapping(value="/editsave/{id}",method = RequestMethod.POST)
        public String editsave(@PathVariable(name="id")long id, Model model){
           testRepository.update(id);
            return "redirect:/viewemp";
        }*/
    /* @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestScheduleTable> putMyData( TestScheduleTable schedule) {
        testRepository.save(schedule);
        URI uriNew = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/login")
                .buildAndExpand().toUri();
        return ResponseEntity.created(uriNew).body(schedule);

    }*/
}

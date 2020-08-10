package com.project.model;

import org.graalvm.compiler.replacements.nodes.CStringConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Comparator;

@Entity
@Table(name = "testscheduletable")
public class TestScheduleTable implements Comparable<TestScheduleTable> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Column(name = "facultyName")
    private String facultyName;
    @NotNull
    @Column(name = "specialty_name")
    private String specialtyName;
    @NotNull
    @Column(name = "group_name")
    private String groupName;
    @NotNull
    @Column(name = "subject_name")
    private String subjectName;
    @NotNull
    @Column(name = "teacher_name")
    private String teacherName;
    @NotNull
    @Column(name = "classroom_name")
    private String classroomName;
    @NotNull
    @Column(name = "lesson_type")
    private String lessonType;
    @NotNull
    @Column(name = "time")
    private String time;
    @NotNull
    @Column(name = "date")
    private String date;

    public TestScheduleTable() {
    }

    public TestScheduleTable(String facultyName, String specialtyName, String groupName) {
        this.facultyName = facultyName;
        this.specialtyName = specialtyName;
        this.groupName = groupName;
    }

    public TestScheduleTable(long id, String facultyName, String specialtyName, String groupName, String subjectName, String teacherName, String classroomName, String lessonType) {
        this.id = id;
        this.facultyName = facultyName;
        this.specialtyName = specialtyName;
        this.groupName = groupName;
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.classroomName = classroomName;
        this.lessonType = lessonType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName1) {
        this.facultyName = facultyName1;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(TestScheduleTable anotherObject) {
        if (this.time == anotherObject.time) {
            return 0;
        } else if (stringСomparison(this.time, anotherObject.time)) {
            return -1;
        } else return 1;
    }

    /*stringСomparison ужен только для compareTo; stringСomparison не использует == т.к. если строки равны то compareTo
        вернёт 0 и stringСomparison не вызовется*/
    public boolean stringСomparison(String str1, String str2) {
        char[] mas1 = str1.toCharArray();
        char[] mas2 = str2.toCharArray();
        for (int i = 0; i < mas1.length; i++) {
            if (mas1[i] == mas2[i]) {
                continue;
            } else if (mas1[i] < mas2[i]) {
                return true;
            }else return false;
        }
        return false;
    }

}

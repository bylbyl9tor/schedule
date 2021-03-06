package com.project.model;

import jdk.internal.loader.AbstractClassLoaderValue;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "schedule_table")
public class Schedule implements Comparable<Schedule> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Schedule() {
    }

    public Schedule(Teacher teacher,Group group, LessonDate date, Subject subject, Classroom classroom, LessonTime lessonTime, LessonType lessonType) {
        this.teacher = teacher;
        this.group = group;
        this.date = date;
        this.subject = subject;
        this.classroom = classroom;
        this.lessonTime = lessonTime;
        this.lessonType = lessonType;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_teacher", nullable = false)//specialty->faculty
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_group", nullable = false)
    private Group group;


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_date", nullable = false)//specialty->faculty
    private LessonDate date;


    public LessonDate getDate() {
        return date;
    }

    public void setDate(LessonDate date) {
        this.date = date;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_subject", nullable = false)
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_classroom")
    private Classroom classroom;

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_time")
    private LessonTime lessonTime;

    public LessonTime getLessonTime() {
        return lessonTime;
    }

    public void setLessonTime(LessonTime lessonTime) {
        this.lessonTime = lessonTime;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_lesson_type", nullable = false)//specialty->faculty
    private LessonType lessonType;

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    @Override
    public int compareTo(Schedule schedule) {
        if (this.lessonTime.getLessonTimeStart() == schedule.lessonTime.getLessonTimeStart()) {
            return 0;
        } else if (stringСomparison(this.lessonTime.getLessonTimeStart(), schedule.lessonTime.getLessonTimeStart())) {
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
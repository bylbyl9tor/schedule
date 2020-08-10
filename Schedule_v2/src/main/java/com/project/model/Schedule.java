package com.project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "schedule_table")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "id_teacher",insertable = false,updatable = false, nullable = false)
    private int idTeacher;
    @Column(name = "id_lesson_type",insertable = false,updatable = false, nullable = false)
    private int idLessonType;
    @Column(name = "id_classroom",insertable = false,updatable = false,nullable = false)
    private int idClassroom;

    public Schedule() {
    }

    public Schedule(int id, int idTeacher, int idLessonType, int idClassroom) {
        this.id = id;
        this.idTeacher = idTeacher;
        this.idLessonType = idLessonType;
        this.idClassroom = idClassroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public int getIdLessonType() {
        return idLessonType;
    }

    public void setIdLessonType(int idLessonType) {
        this.idLessonType = idLessonType;
    }

    public int getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "schedule_group",
            joinColumns = @JoinColumn(name = "id_schedule"),
            inverseJoinColumns = @JoinColumn(name = "id_group")
    )
    private Collection<Group> scheduleGroup;

    public Collection<Group> getScheduleGroup() {
        return scheduleGroup;
    }

    public void setScheduleGroup(Collection<Group> scheduleGroup) {
        this.scheduleGroup = scheduleGroup;
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
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_classroom")//specialty->faculty
    private Classroom classroom;

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
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
}

package com.project.model;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "lesson_type_table")
public class LessonType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "lesson_type", length = 25, nullable = false)
    private String lessonType;

    public LessonType() {
    }

    public LessonType(int id, String lessonType) {
        this.id = id;
        this.lessonType = lessonType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "lessonType")//faculty->specialty
    private Set<Schedule> Schedule;

    public Set<com.project.model.Schedule> getSchedule() {
        return Schedule;
    }

    public void setSchedule(Set<com.project.model.Schedule> schedule) {
        Schedule = schedule;
    }
}

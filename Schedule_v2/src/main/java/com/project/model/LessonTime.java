package com.project.model;

import javax.persistence.*;

@Entity
@Table(name = "lesson_time_table")
public class LessonTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "lesson_start")
    private String lessonTimeStart;
    @Column(name = "lesson_end")
    private String lessonTimeEnd;

    public LessonTime() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessonTimeStart() {
        return lessonTimeStart;
    }

    public void setLessonTimeStart(String lessonTimeStart) {
        this.lessonTimeStart = lessonTimeStart;
    }

    public String getLessonTimeEnd() {
        return lessonTimeEnd;
    }

    public void setLessonTimeEnd(String lessonTimeEnd) {
        this.lessonTimeEnd = lessonTimeEnd;
    }
}

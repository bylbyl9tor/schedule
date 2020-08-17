package com.project.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lesson_time_table")
public class LessonTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "lesson_start")
    private String lessonTimeStart;
    @Column(name = "lesson_end")
    private String lessonTimeEnd;

    public LessonTime() {
    }

    public LessonTime(long id, String lessonTimeStart, String lessonTimeEnd) {
        this.id = id;
        this.lessonTimeStart = lessonTimeStart;
        this.lessonTimeEnd = lessonTimeEnd;
    }

    public void setId(long id) {
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

    public long getId() {
        return id;
    }

    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "lessonTime")
        private Set<Schedule> schedule;

        public Set<Schedule> getSchedule() {
            return schedule;
        }

        public void setSchedule(Set<Schedule> schedule) {
            this.schedule = schedule;
        }*/
}

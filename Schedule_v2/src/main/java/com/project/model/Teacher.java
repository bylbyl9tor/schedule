package com.project.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teacher_table")
public class Teacher {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name = "teacher", length = 50, nullable = false)
    private String teacherName;

    public Teacher() {
    }

    public Teacher(int id, String teacherName) {
        this.id = id;
        this.teacherName = teacherName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher")//faculty->specialty
    private Set<Schedule> schedule;

    public Set<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Schedule> schedule) {
        this.schedule = schedule;
    }
}

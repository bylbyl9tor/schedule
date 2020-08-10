package com.project.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "classroom_table")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "classroom_number", length = 7)
    private String classroomNumber;

    public Classroom() {
    }

    public Classroom(int id, String classroomNumber) {
        this.id = id;
        this.classroomNumber = classroomNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(String classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "classroom")
    private Set<Schedule> schedule;

    public Set<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Schedule> schedule) {
        this.schedule = schedule;
    }
}
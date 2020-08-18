package com.project.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "date_table")
public class LessonDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String dateName;

    public LessonDate() {
    }
    public LessonDate(String dateName) {
        this.dateName=dateName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    public long getId() {
        return id;
    }

    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "date")//faculty->specialty
    private Set<Schedule> schedule;

    public Set<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Schedule> schedule) {
        this.schedule = schedule;
    }*/
}

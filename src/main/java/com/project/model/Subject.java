package com.project.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "subject_name_table")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "subject_name", length = 45, nullable = false)
    private String subjectName;

    public Subject() {
    }

    public Subject(long id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    @ManyToMany(mappedBy = "subjectSpecialty")
    private Collection<Specialty> subjectSpecialty;

    public Collection<Specialty> getSubjectSpecialty() {
        return subjectSpecialty;
    }

    public void setSubjectSpecialty(Collection<Specialty> subjectSpecialty) {
        this.subjectSpecialty = subjectSpecialty;
    }
   /* @OneToMany(fetch = FetchType.EAGER, mappedBy = "subject")
    private Set<Schedule> schedule;

    public Set<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Schedule> schedule) {
        this.schedule = schedule;
    }*/
}

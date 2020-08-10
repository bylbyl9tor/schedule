package com.project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "subject_name_table")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "subject_name", length = 45, nullable = false)
    private String subjectName;

    public Subject() {
    }

    public Subject(int id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}

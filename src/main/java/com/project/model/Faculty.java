package com.project.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "faculty_table")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "faculty_name", length = 45, nullable = false)
    private String facultyName;

    protected Faculty() {
    }

    public Faculty(long id, String facultyName) {
        this.id = id;
        this.facultyName = facultyName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }


    /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "faculty")
    private Set<Specialty> specialty;

    public Set<Specialty> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Set<Specialty> specialty) {
        this.specialty = specialty;
    }*/
}

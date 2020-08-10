package com.project.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "specialty_table")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "specialty_name", length = 45, nullable = false)
    private String specialtyName;

    protected Specialty() {
    }

    public Specialty(int id, int idFaculty, String specialtyName) {
        this.id = id;
        this.specialtyName = specialtyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_faculty", nullable = false)//specialty->faculty
    private Faculty faculty;

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "specialty")//specialty->group
    private Set<Group> group;

    public Set<Group> getGroup() {
        return group;
    }

    public void setGroup(Set<Group> group) {
        this.group = group;
    }
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "specialty_subject",
            joinColumns = @JoinColumn(name = "id_specialty"),
            inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    private Collection<Subject> subjectSpecialty;

    public Collection<Subject> getSubjectSpecialty() {
        return subjectSpecialty;
    }

    public void setSubjectSpecialty(Collection<Subject> subjectSpecialty) {
        this.subjectSpecialty = subjectSpecialty;
    }
}

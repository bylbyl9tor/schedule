package com.project.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "specialty_table")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "specialty_name", length = 45, nullable = false)
    private String specialtyName;

    protected Specialty() {
    }

    public Specialty(long id, String specialtyName, Faculty faculty) {
        this.id = id;
        this.specialtyName = specialtyName;
        this.faculty = faculty;
        this.subjectSpecialty = subjectSpecialty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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


    public Collection<Subject> getSubjectSpecialty() {
        return subjectSpecialty;
    }


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "specialty_subject",
            joinColumns = @JoinColumn(name = "id_specialty"),
            inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    private Collection<Subject> subjectSpecialty;

    public void setSubjectSpecialty(Collection<Subject> subjectSpecialty) {
        this.subjectSpecialty = subjectSpecialty;
    }
/*@OneToMany(fetch = FetchType.EAGER, mappedBy = "specialty")//specialty->group
    private Set<Group> group;

    public Set<Group> getGroup() {
        return group;
    }

    public void setGroup(Set<Group> group) {
        this.group = group;
    }*/

}

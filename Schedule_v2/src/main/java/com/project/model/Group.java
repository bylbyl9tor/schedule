package com.project.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "group_table")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "group_name", nullable = false)
    private String groupName;

    public Group() {
    }

    public Group(long id, String groupName, Specialty specialty) {
        this.id = id;
        this.groupName = groupName;
        this.specialty = specialty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_specialty", nullable = false)//group->specialty
    private Specialty specialty;

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

   /* @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private Set<Schedule> schedule;

    public Set<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Schedule> schedule) {
        this.schedule = schedule;
    }*/

    @Override
    public String toString() {
        return this.getId() + ", " + this.getGroupName()+ ", "+specialty.getSpecialtyName()+", "+specialty.getFaculty().getFacultyName();
    }
}

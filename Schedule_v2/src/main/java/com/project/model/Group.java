package com.project.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "group_table")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "group_name", nullable = false)
    private String groupName;

    protected Group() {
    }

    public Group(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @ManyToMany(mappedBy = "scheduleGroup")
    private Collection<Schedule> scheduleGroup;

    public Collection<Schedule> getScheduleGroup() {
        return scheduleGroup;
    }

    public void setScheduleGroup(Collection<Schedule> scheduleGroup) {
        this.scheduleGroup = scheduleGroup;
    }

    @Override
    public String toString() {
        return this.getId() + ", " + this.getGroupName()+ ", "+specialty.getSpecialtyName()+", "+specialty.getFaculty().getFacultyName();
    }
}

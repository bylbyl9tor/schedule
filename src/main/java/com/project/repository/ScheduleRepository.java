package com.project.repository;

import com.project.model.Group;
import com.project.model.LessonDate;
import com.project.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByGroup(Group group);

    List<Schedule> findAllById(long id);

    void deleteById(long id);

    Schedule save(Schedule schedule);

    Schedule findById(long id);

    List<Schedule> findAllByGroupAndDate(Group group, LessonDate date);
}

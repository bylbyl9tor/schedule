package com.project.repository;

import com.project.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
}

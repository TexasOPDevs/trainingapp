package com.codeup.trainingapp.Repositories;

import com.codeup.trainingapp.models.Needs.Attendance;
import com.codeup.trainingapp.models.Needs.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

    Iterable<Attendance> findByDateAndCourse(Date date, Course course);
}

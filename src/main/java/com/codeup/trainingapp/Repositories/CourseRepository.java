package com.codeup.trainingapp.Repositories;

import com.codeup.trainingapp.models.Needs.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
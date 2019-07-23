package com.codeup.trainingapp.Repositories;

import com.codeup.trainingapp.models.Wants.Gradable_Student;
import org.springframework.data.repository.CrudRepository;

public interface Gradable_StudentRepository extends CrudRepository<Gradable_Student, Long> {
    Iterable<Gradable_Student> findAllByCourse_IdAndGradeIsNull(Long id);
    Iterable<Gradable_Student> findAllByGradable_id(Long id);
}

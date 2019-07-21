package com.codeup.trainingapp.Repositories;

import com.codeup.trainingapp.models.Needs.Student;
import com.codeup.trainingapp.models.Needs.User;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Iterable<Student> findAllByUser_Id(Long id);
    Iterable<Student> findByCourse_IdAndUser_IdAndStatus_Id(Long course, Long user, Long status);
}

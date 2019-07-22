package com.codeup.trainingapp.Repositories;

import com.codeup.trainingapp.models.Wants.Gradable;
import org.springframework.data.repository.CrudRepository;

public interface GradableRepository extends CrudRepository<Gradable, Long> {
    Iterable<Gradable> findAllByCurriculum_Id(Long id);
}

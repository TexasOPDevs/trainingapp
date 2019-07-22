package com.codeup.trainingapp.Repositories;

import com.codeup.trainingapp.models.Needs.Curriculum;
import org.springframework.data.repository.CrudRepository;

public interface CurriculumRepository extends CrudRepository<Curriculum, Long> {
    Iterable<Curriculum> findAllByProvider_Id(Long id);

    Curriculum findByProvider_Name(String name);
}

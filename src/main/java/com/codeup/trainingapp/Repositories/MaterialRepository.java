package com.codeup.trainingapp.Repositories;

import com.codeup.trainingapp.models.Needs.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long> {

}

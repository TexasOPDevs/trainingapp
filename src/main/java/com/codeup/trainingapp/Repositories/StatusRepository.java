package com.codeup.trainingapp.Repositories;

import com.codeup.trainingapp.models.Needs.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long> {
}

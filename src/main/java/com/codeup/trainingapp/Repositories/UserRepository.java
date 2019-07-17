package com.codeup.trainingapp.Repositories;

import com.codeup.trainingapp.models.Needs.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

}

package com.codeup.trainingapp.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;
import java.util.List;

@EntityScan
@Table(name = "user")
public class User {

    @Id
    private Long   id;
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String password;
    @ManyToMany(mappedBy = "role")
    private List<Role> roles;

}

package com.codeup.trainingapp.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns ={@JoinColumn(name = "role_id")},
            inverseJoinColumns ={@JoinColumn(name = "user_id")}
            )
    private List<User> users;
}

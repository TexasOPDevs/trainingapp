package com.codeup.trainingapp.models.Needs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(name = "user_id")
    private Long user_id;

    public Role() {
    }
}

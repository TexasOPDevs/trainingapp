package com.codeup.trainingapp.models.Needs;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String image;

    @OneToOne()
    private User coordinator;

    @ManyToMany(mappedBy = "providers")
    @JsonBackReference
    private List<User> users;

    public Provider() {
    }


}

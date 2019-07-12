package com.codeup.trainingapp.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private User coordinator_id;

    @Column
    private String name;

    @Column
    private String image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @ManyToMany(mappedBy = "providers")
    private List<User> user;



}

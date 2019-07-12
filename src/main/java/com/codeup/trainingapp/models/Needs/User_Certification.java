package com.codeup.trainingapp.models.Needs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "user_certification")
public class User_Certification {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JsonBackReference
    private Curriculum curriculum;

    @Column
    private Boolean credit;

    @ManyToOne
    @JsonManagedReference
    private User user;
}

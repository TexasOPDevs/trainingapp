package com.codeup.trainingapp.models.Needs;

import javax.persistence.*;

@Entity
@Table(name = "user_certification")
public class User_Certification {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Curriculum curriculum;

    @Column
    private Boolean credit;

    @ManyToOne
    private User user;
}

package com.codeup.trainingapp.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;
    @OneToOne
    private Status status;
}

package com.codeup.trainingapp.models.Needs;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "students")
    @JsonBackReference
    private Course course;

    @OneToOne
    private Status status;

//    @OneToMany(mappedBy = "student")
//    private List<Attendance> attendances;


}

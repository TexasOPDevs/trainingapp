package com.codeup.trainingapp.models.Needs;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "a_class_id")
    private Course course;

    @OneToOne
    private Status status;

//    @OneToMany(mappedBy = "student")
//    private List<Attendance> attendances;


}

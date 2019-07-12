package com.codeup.trainingapp.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "class")
public class Class {

    @Id @GeneratedValue
    private Long id;

    private String location;
    private String evaluation_file;
    private Time start_time;
    private Date start_date;
    private Date end_date;

    @ManyToOne
    private Course course;

    @OneToOne
    private Status status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "class")
    private List<Student> students;



}

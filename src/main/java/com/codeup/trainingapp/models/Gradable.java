package com.codeup.trainingapp.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "gradeable")
public class Gradable {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int weight;
    private Date creation_date;
    private Date update_date;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}

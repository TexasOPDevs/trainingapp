package com.codeup.trainingapp.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private Long limit;
    private String description;
    private String learning_objectives;
    private String course_outline;
    private String certification;
    private Date creation_date;
    private Date update_date;


    @OneToOne
    private User coordinator;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_material",
            joinColumns ={@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "material_id")}
    )
    private List<Material> materials;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Gradable> gradables;
}

package com.codeup.trainingapp.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    @ManyToMany(mappedBy = "material")
    private List<Course> courses;
}

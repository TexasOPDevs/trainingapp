package com.codeup.trainingapp.models.Needs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "curriculum")
public class Curriculum {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private Long capacity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String learning_objectives;

    @Column(columnDefinition = "TEXT")
    private String course_outline;

    @Column
    private String certification;

    @Column
    private Date creation_date;

    @Column
    private Date update_date;

    @OneToOne
    private Provider provider;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "curriculum_material",
            joinColumns ={@JoinColumn(name = "curriculum_id")},
            inverseJoinColumns = {@JoinColumn(name = "material_id")}
    )
    @JsonManagedReference
    private List<Material> materials;

    @OneToMany(mappedBy = "curriculum")
    @JsonBackReference
    private List<Course> Courses;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
//    private List<Gradable> gradables;

    public Curriculum() {
    }
}

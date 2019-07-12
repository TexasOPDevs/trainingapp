package com.codeup.trainingapp.models.Needs;

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

    @Column
    private String description;

    @Column
    private String learning_objectives;

    @Column
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
    private List<Material> materials;

    @OneToMany(mappedBy = "curriculum")
    private List<Course> AClasses;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
//    private List<Gradable> gradables;

    public Curriculum() {
    }
}

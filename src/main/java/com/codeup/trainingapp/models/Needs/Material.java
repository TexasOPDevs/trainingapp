package com.codeup.trainingapp.models.Needs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "materials")
    private List<Curriculum> cours;

    public Material() {
    }
}

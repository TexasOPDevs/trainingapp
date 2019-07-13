package com.codeup.trainingapp.models.Needs;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JsonBackReference
    private List<Curriculum> curricula;

    public Material() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Curriculum> getCurricula() {
        return curricula;
    }

    public void setCurricula(List<Curriculum> curricula) {
        this.curricula = curricula;
    }
}

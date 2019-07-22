package com.codeup.trainingapp.models.Needs;

import com.codeup.trainingapp.models.Wants.Gradable;
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

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String learning_objectives;

    @Column
    private Date creationDate;

    @Column
    private Date updateDate;

    @ManyToOne
    @JsonManagedReference
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
    @JsonManagedReference
    private List<Course> courses;

    @OneToMany(mappedBy = "curriculum")
    private List<Gradable> gradables;

    public Curriculum(String name, Long capacity, String description, String learning_objectives, String outline, String certification, Date creationDate, Date updateDate, Provider provider) {
        this.name = name;
        this.description = description;
        this.learning_objectives = learning_objectives;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.provider = provider;
    }

    public Curriculum() {
    }

    public List<Gradable> getGradables() {
        return gradables;
    }

    public void setGradables(List<Gradable> gradables) {
        this.gradables = gradables;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLearning_objectives() {
        return learning_objectives;
    }

    public void setLearning_objectives(String learning_objectives) {
        this.learning_objectives = learning_objectives;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

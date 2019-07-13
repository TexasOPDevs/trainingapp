package com.codeup.trainingapp.models.Needs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonBackReference
    private List<Course> Courses;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
//    private List<Gradable> gradables;

    public Curriculum() {
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

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
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

    public String getCourse_outline() {
        return course_outline;
    }

    public void setCourse_outline(String course_outline) {
        this.course_outline = course_outline;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
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

//    public List<Course> getCourses() {
//        return Courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        Courses = courses;
//    }
}

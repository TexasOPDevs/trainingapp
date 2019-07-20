package com.codeup.trainingapp.models.Wants;

import com.codeup.trainingapp.models.Needs.Curriculum;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "gradeable")
public class Gradable {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private int weight;

    @Column
    private Date creation_date;

    @Column
    private Date update_date;

    @ManyToOne
    private Curriculum curriculum;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gradable")
    private List<Gradable_Student> gradable_students;


    public Gradable() {
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public List<Gradable_Student> getGradable_students() {
        return gradable_students;
    }

    public void setGradable_students(List<Gradable_Student> gradable_students) {
        this.gradable_students = gradable_students;

    }
}

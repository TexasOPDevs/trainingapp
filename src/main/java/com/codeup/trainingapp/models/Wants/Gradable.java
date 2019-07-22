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
    private Date creationDate;

    @Column
    private Date updateDate;

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

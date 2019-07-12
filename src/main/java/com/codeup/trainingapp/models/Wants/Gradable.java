//package com.codeup.trainingapp.models.Wants;
//
//import com.codeup.trainingapp.models.Needs.Curriculum;
//
//import javax.persistence.*;
//import java.sql.Date;
//import java.util.List;
//
//@Entity
//@Table(name = "gradeable")
//public class Gradable {
//
//    @Id @GeneratedValue
//    private Long id;
//
//    private String name;
//    private int weight;
//    private Date creation_date;
//    private Date update_date;
//
//
//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Curriculum course;
//
//    @ManyToMany(mappedBy = "type")
//    private List<Type> types;
//
//    public Gradable() {
//    }
//}

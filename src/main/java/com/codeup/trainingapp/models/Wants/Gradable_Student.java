//package com.codeup.trainingapp.models.Wants;
//
//import com.codeup.trainingapp.models.Needs.Course;
//import com.codeup.trainingapp.models.Needs.User;
//
//import javax.persistence.*;
//import java.sql.Date;
//
//@Entity
//@Table(name = "gradable_student")
//public class Gradable_Student {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//
//    private Long grade;
//
//    private Date posted_at;
//
//    @ManyToOne
//    @JoinColumn(name = "class_id")
//    private Course aClass;
//
//    @ManyToOne
//    @JoinColumn(name = "gradable_id")
//    private Gradable gradable;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    public Gradable_Student() {
//    }
//}

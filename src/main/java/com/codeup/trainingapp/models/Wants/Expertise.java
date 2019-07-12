//package com.codeup.trainingapp.models.Wants;
//
//import com.codeup.trainingapp.models.Needs.Status;
//import com.codeup.trainingapp.models.Needs.User;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "expertise")
//public class Expertise {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String name;
//    private String description;
//
//    @OneToOne
//    private Status status;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "user_expertise",
//            joinColumns ={@JoinColumn(name = "expertise_id")},
//            inverseJoinColumns = {@JoinColumn(name = "user_id")}
//    )
//    private List<User> users;
//
//    public Expertise() {
//    }
//}

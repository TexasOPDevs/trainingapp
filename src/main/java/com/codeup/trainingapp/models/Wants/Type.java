//package com.codeup.trainingapp.models.Wants;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "types")
//public class Type {
//
//    @Id @GeneratedValue
//    private Long id;
//    private String name;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "type_gradable",
//            joinColumns ={@JoinColumn(name = "type_id")},
//            inverseJoinColumns = {@JoinColumn(name = "gradable_id")}
//    )
//    private List<Gradable> gradables;
//
//    public Type() {
//    }
//}

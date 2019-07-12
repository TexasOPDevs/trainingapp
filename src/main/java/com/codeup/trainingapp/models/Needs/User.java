package com.codeup.trainingapp.models.Needs;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    private Long   id;

    @Column
    private String username;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    @JsonIgnore
    private String password;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_provider",
            joinColumns ={@JoinColumn(name = "user_id")},
            inverseJoinColumns ={@JoinColumn(name = "provider_id")}
    )
    @JsonManagedReference
    private List<Provider> providers;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<User_Certification> certifications;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonBackReference
    private List<Attendance> attendances;



//    @ManyToMany(mappedBy = "expertise")
//    private List<Expertise> expertise;

    public User() {
    }
}

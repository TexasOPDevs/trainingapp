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
    @JsonBackReference
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Provider> getProviders() {
//        return providers;
//    }
//
//    public void setProviders(List<Provider> providers) {
//        this.providers = providers;
//    }

    public List<User_Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<User_Certification> certifications) {
        this.certifications = certifications;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }
}
